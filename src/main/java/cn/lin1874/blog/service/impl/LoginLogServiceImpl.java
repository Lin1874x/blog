package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.mapper.LoginLogMapper;
import cn.lin1874.blog.po.LoginLog;
import cn.lin1874.blog.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/7/21 - 21:19
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    LoginLogMapper loginLogMapper;

    @Override
    public void addLoginLog(LoginLog loginLog) {
        loginLogMapper.addLoginLog(loginLog);
    }

    @Override
    public List<LoginLog> getLoginLogListOrderByTimeLimit5() {
        return loginLogMapper.getLoginLogListOrderByTimeLimit5();
    }
}
