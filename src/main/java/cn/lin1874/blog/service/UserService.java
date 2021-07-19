package cn.lin1874.blog.service;

import cn.lin1874.blog.po.User;

/**
 * @author lin1874
 * @date 2021/6/22 - 9:40
 */
public interface UserService {
    /**
     * 根据用户账号及密码登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

}
