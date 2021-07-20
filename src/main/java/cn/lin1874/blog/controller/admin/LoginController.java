package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.User;
import cn.lin1874.blog.service.UserService;
import cn.lin1874.blog.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author lin1874
 * @date 2021/6/22 - 9:53
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping("/_admin/do/login")
    public ResultEntity doAdminLogin(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     HttpSession session) {
        return userService.login(username,password,session);
    }

    /**
     * 用户注销
     * @param session
     * @return
     */
    @GetMapping("/_admin/do/logout")
    public ResultEntity doAdminLogout(HttpSession session) {
        session.invalidate();
        return new ResultEntity(ResultEntity.SUCCESS,null,null);
    }
}
