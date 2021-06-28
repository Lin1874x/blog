/* global CONFIG */

(function(window, document) {
  // 鏌ヨ瀛樺偍鐨勮褰�
  function getRecord(Counter, target) {
    return new Promise(function(resolve, reject) {
      Counter('get', '/classes/Counter?where=' + encodeURIComponent(JSON.stringify({ target })))
        .then(resp => resp.json())
        .then(({ results, code, error }) => {
          if (code === 401) {
            throw error;
          }
          if (results && results.length > 0) {
            var record = results[0];
            resolve(record);
          } else {
            Counter('post', '/classes/Counter', { target, time: 0 })
              .then(resp => resp.json())
              .then((record, error) => {
                if (error) {
                  throw error;
                }
                resolve(record);
              }).catch(error => {
              // eslint-disable-next-line no-console
                console.error('Failed to create', error);
                reject(error);
              });
          }
        }).catch((error) => {
        // eslint-disable-next-line no-console
          console.error('LeanCloud Counter Error:', error);
          reject(error);
        });
    });
  }

  // 鍙戣捣鑷璇锋眰
  function increment(Counter, incrArr) {
    return new Promise(function(resolve, reject) {
      Counter('post', '/batch', {
        'requests': incrArr
      }).then((res) => {
        res = res.json();
        if (res.error) {
          throw res.error;
        }
        resolve(res);
      }).catch((error) => {
        // eslint-disable-next-line no-console
        console.error('Failed to save visitor count', error);
        reject(error);
      });
    });
  }

  // 鏋勫缓鑷璇锋眰浣�
  function buildIncrement(objectId) {
    return {
      'method': 'PUT',
      'path'  : `/1.1/classes/Counter/${objectId}`,
      'body'  : {
        'time': {
          '__op'  : 'Increment',
          'amount': 1
        }
      }
    };
  }

  // 鏍￠獙鏄惁涓烘湁鏁堢殑 UV
  function validUV() {
    var key = 'LeanCloud_UV_Flag';
    var flag = localStorage.getItem(key);
    if (flag) {
      // 璺濈鏍囪灏忎簬 24 灏忔椂鍒欎笉璁′负 UV
      if (new Date().getTime() - parseInt(flag, 10) <= 86400000) {
        return false;
      }
    }
    localStorage.setItem(key, new Date().getTime().toString());
    return true;
  }

  function addCount(Counter) {
    var enableIncr = CONFIG.web_analytics.enable === true;
    var getterArr = [];
    var incrArr = [];

    // 璇锋眰 PV 骞惰嚜澧�
    var pvCtn = document.querySelector('#leancloud-site-pv-container');
    if (pvCtn) {
      var pvGetter = getRecord(Counter, 'site-pv').then((record) => {
        enableIncr && incrArr.push(buildIncrement(record.objectId));
        var ele = document.querySelector('#leancloud-site-pv');
        if (ele) {
          ele.innerText = record.time + 1;
          if (pvCtn) {
            pvCtn.style.display = 'inline';
          }
        }
      });
      getterArr.push(pvGetter);
    }

    // 璇锋眰 UV 骞惰嚜澧�
    var uvCtn = document.querySelector('#leancloud-site-uv-container');
    if (uvCtn) {
      var uvGetter = getRecord(Counter, 'site-uv').then((record) => {
        var vuv = validUV();
        vuv && enableIncr && incrArr.push(buildIncrement(record.objectId));
        var ele = document.querySelector('#leancloud-site-uv');
        if (ele) {
          ele.innerText = record.time + (vuv ? 1 : 0);
          if (uvCtn) {
            uvCtn.style.display = 'inline';
          }
        }
      });
      getterArr.push(uvGetter);
    }

    // 濡傛灉鏈夐〉闈㈡祻瑙堟暟鑺傜偣锛屽垯璇锋眰娴忚鏁板苟鑷
    var viewCtn = document.querySelector('#leancloud-page-views-container');
    if (viewCtn) {
      var target = decodeURI(window.location.pathname.replace(/(?<!\/)\/*(index.html)*$/, '/'));
      var viewGetter = getRecord(Counter, target).then((record) => {
        enableIncr && incrArr.push(buildIncrement(record.objectId));
        if (viewCtn) {
          var ele = document.querySelector('#leancloud-page-views');
          if (ele) {
            ele.innerText = (record.time || 0) + 1;
            viewCtn.style.display = 'inline';
          }
        }
      });
      getterArr.push(viewGetter);
    }

    // 濡傛灉鍚姩璁℃暟鑷锛屾壒閲忓彂璧疯嚜澧炶姹�
    if (enableIncr) {
      Promise.all(getterArr).then(() => {
        incrArr.length > 0 && increment(Counter, incrArr);
      });
    }
  }

  var appId = CONFIG.web_analytics.leancloud.app_id;
  var appKey = CONFIG.web_analytics.leancloud.app_key;
  var serverUrl = CONFIG.web_analytics.leancloud.server_url;

  function fetchData(api_server) {
    var Counter = (method, url, data) => {
      return fetch(`${api_server}/1.1${url}`, {
        method,
        headers: {
          'X-LC-Id'     : appId,
          'X-LC-Key'    : appKey,
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });
    };

    addCount(Counter);
  }

  var apiServer = appId.slice(-9) !== '-MdYXbMMI' ? serverUrl : `https://${appId.slice(0, 8).toLowerCase()}.api.lncldglobal.com`;

  if (apiServer) {
    fetchData(apiServer);
  } else {
    fetch('https://app-router.leancloud.cn/2/route?appId=' + appId)
      .then(resp => resp.json())
      .then((data) => {
        if (data.api_server) {
          fetchData('https://' + data.api_server);
        }
      });
  }
})(window, document);