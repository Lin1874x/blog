/* global Fluid */

/**
 * Modify by https://blog.skk.moe/post/hello-darkmode-my-old-friend/
 */
(function(window, document) {
  var rootElement = document.documentElement;
  var colorSchemaStorageKey = 'Fluid_Color_Scheme';
  var colorSchemaMediaQueryKey = '--color-mode';
  var userColorSchemaAttributeName = 'data-user-color-scheme';
  var defaultColorSchemaAttributeName = 'data-default-color-scheme';
  var colorToggleButtonName = 'color-toggle-btn';
  var colorToggleIconName = 'color-toggle-icon';

  function setLS(k, v) {
    try {
      localStorage.setItem(k, v);
    } catch (e) {}
  }

  function removeLS(k) {
    try {
      localStorage.removeItem(k);
    } catch (e) {}
  }

  function getLS(k) {
    try {
      return localStorage.getItem(k);
    } catch (e) {
      return null;
    }
  }

  function getSchemaFromHTML() {
    var res = rootElement.getAttribute(defaultColorSchemaAttributeName);
    if (typeof res === 'string') {
      return res.replace(/["'\s]/g, '');
    }
    return null;
  }

  function getSchemaFromCSSMediaQuery() {
    var res = getComputedStyle(rootElement).getPropertyValue(
      colorSchemaMediaQueryKey
    );
    if (typeof res === 'string') {
      return res.replace(/["'\s]/g, '');
    }
    return null;
  }

  function resetSchemaAttributeAndLS() {
    rootElement.setAttribute(userColorSchemaAttributeName, getDefaultColorSchema());
    removeLS(colorSchemaStorageKey);
  }

  var validColorSchemaKeys = {
    dark : true,
    light: true
  };

  function getDefaultColorSchema() {
    // 鍙栭粯璁ゅ瓧娈电殑鍊�
    var schema = getSchemaFromHTML();
    // 濡傛灉鏄庣‘鎸囧畾浜� schema 鍒欒繑鍥�
    if (validColorSchemaKeys[schema]) {
      return schema;
    }
    // 榛樿浼樺厛鎸� prefers-color-scheme
    schema = getSchemaFromCSSMediaQuery();
    if (validColorSchemaKeys[schema]) {
      return schema;
    }
    // 鍚﹀垯鎸夋湰鍦版椂闂存槸鍚﹀ぇ浜� 18 鐐规垨鍑屾櫒 0 ~ 6 鐐�
    var hours = new Date().getHours();
    if (hours >= 18 || (hours >= 0 && hours <= 6)) {
      return 'dark';
    }
    return 'light';
  }

  function applyCustomColorSchemaSettings(schema) {
    // 鎺ュ彈浠庛€屽紑鍏炽€嶅浼犳潵鐨勬ā寮忥紝鎴栬€呬粠 localStorage 璇诲彇锛屽惁鍒欐寜榛樿璁剧疆鍊�
    var current = schema || getLS(colorSchemaStorageKey) || getDefaultColorSchema();

    if (current === getDefaultColorSchema()) {
      // 褰撶敤鎴峰垏鎹㈢殑鏄剧ず妯″紡鍜岄粯璁ゆā寮忕浉鍚屾椂锛屽垯鎭㈠涓鸿嚜鍔ㄦā寮�
      resetSchemaAttributeAndLS();
    } else if (validColorSchemaKeys[current]) {
      rootElement.setAttribute(
        userColorSchemaAttributeName,
        current
      );
    } else {
      // 鐗规畩鎯呭喌閲嶇疆
      resetSchemaAttributeAndLS();
      return;
    }

    // 鏍规嵁褰撳墠妯″紡璁剧疆鍥炬爣
    setButtonIcon(current);

    // 璁剧疆鍏朵粬搴旂敤
    setApplications(current);
  }

  var invertColorSchemaObj = {
    dark : 'light',
    light: 'dark'
  };

  function toggleCustomColorSchema() {
    var currentSetting = getLS(colorSchemaStorageKey);

    if (validColorSchemaKeys[currentSetting]) {
      // 浠� localStorage 涓鍙栨ā寮忥紝骞跺彇鐩稿弽鐨勬ā寮�
      currentSetting = invertColorSchemaObj[currentSetting];
    } else if (currentSetting === null) {
      // 褰� localStorage 涓病鏈夌浉鍏冲€硷紝鎴栬€� localStorage 鎶涗簡 Error
      // 鍏堟寜鐓ф寜閽殑鐘舵€佽繘琛屽垏鎹�
      var iconElement = document.getElementById(colorToggleIconName);
      if (iconElement) {
        currentSetting = iconElement.getAttribute('data');
      }
      if (!iconElement || !validColorSchemaKeys[currentSetting]) {
        // 褰� localStorage 涓病鏈夌浉鍏冲€硷紝鎴栬€� localStorage 鎶涗簡 Error锛屽垯璇诲彇榛樿鍊煎苟鍒囨崲鍒扮浉鍙嶇殑妯″紡
        currentSetting = invertColorSchemaObj[getSchemaFromCSSMediaQuery()];
      }
    } else {
      return;
    }
    // 灏嗙浉鍙嶇殑妯″紡鍐欏叆 localStorage
    setLS(colorSchemaStorageKey, currentSetting);

    return currentSetting;
  }

  function setButtonIcon(schema) {
    if (validColorSchemaKeys[schema]) {
      // 鍒囨崲鍥炬爣
      var icon = 'icon-dark';
      if (schema) {
        icon = 'icon-' + invertColorSchemaObj[schema];
      }
      var iconElement = document.getElementById(colorToggleIconName);
      if (iconElement) {
        iconElement.setAttribute(
          'class',
          'iconfont ' + icon
        );
        iconElement.setAttribute(
          'data',
          invertColorSchemaObj[schema]
        );
      } else {
        // 濡傛灉鍥炬爣涓嶅瓨鍦ㄥ垯璇存槑鍥炬爣杩樻病鍔犺浇鍑烘潵锛岀瓑鍒伴〉闈㈠叏閮ㄥ姞杞藉啀灏濊瘯鍒囨崲
        Fluid.utils.waitElementLoaded(colorToggleIconName, function() {
          var iconElement = document.getElementById(colorToggleIconName);
          if (iconElement) {
            iconElement.setAttribute(
              'class',
              'iconfont ' + icon
            );
            iconElement.setAttribute(
              'data',
              invertColorSchemaObj[schema]
            );
          }
        });
      }
    }
  }

  function setApplications(schema) {
    // 璁剧疆 remark42 璇勮涓婚
    if (window.REMARK42) {
      window.REMARK42.changeTheme(schema);
    }

    // 璁剧疆 cusdis 璇勮涓婚
    if (window.CUSDIS) {
      window.CUSDIS.setTheme(schema);
    }

    // 璁剧疆 utterances 璇勮涓婚
    var utterances = document.querySelector('iframe');
    if (utterances) {
      var theme = window.UtterancesThemeLight;
      if (schema === 'dark') {
        theme = window.UtterancesThemeDark;
      }
      const message = {
        type : 'set-theme',
        theme: theme
      };
      utterances.contentWindow.postMessage(message, 'https://utteranc.es');
    }
  }

  // 褰撻〉闈㈠姞杞芥椂锛屽皢鏄剧ず妯″紡璁剧疆涓� localStorage 涓嚜瀹氫箟鐨勫€硷紙濡傛灉鏈夌殑璇濓級
  applyCustomColorSchemaSettings();

  Fluid.utils.waitElementLoaded(colorToggleButtonName, function() {
    applyCustomColorSchemaSettings();
    var button = document.getElementById(colorToggleButtonName);
    if (button) {
      // 褰撶敤鎴风偣鍑诲垏鎹㈡寜閽椂锛岃幏寰楁柊鐨勬樉绀烘ā寮忋€佸啓鍏� localStorage銆佸苟鍦ㄩ〉闈笂鐢熸晥
      button.addEventListener('click', () => {
        applyCustomColorSchemaSettings(toggleCustomColorSchema());
      });
    }
  });
})(window, document);