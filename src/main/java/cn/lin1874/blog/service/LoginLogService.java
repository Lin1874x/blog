package cn.lin1874.blog.service;

import cn.lin1874.blog.po.LoginLog;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/7/21 - 21:18
 */
public interface LoginLogService {

    void addLoginLog(LoginLog loginLog);

    List<LoginLog> getLoginLogListOrderByTimeLimit5();
}
