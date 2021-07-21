package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.service.UserService;
import cn.lin1874.blog.utils.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author lin1874
 * @date 2021/6/22 - 10:47
 */
@Api(tags = "用户模块")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/_admin/do/login")
    public ResultEntity doAdminLogin(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     HttpSession session) {
        return userService.login(username,password,session);
    }

    @ApiOperation(value = "用户注销")
    @GetMapping("/_admin/do/logout")
    public ResultEntity doAdminLogout(HttpSession session) {
        session.invalidate();
        return new ResultEntity(ResultEntity.SUCCESS,null,null);
    }
}
