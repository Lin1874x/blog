package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.User;
import cn.lin1874.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author lin1874
 * @date 2021/6/22 - 9:53
 */
@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/_admin/login")
    public String toAdminLogin() {
        return "_admin/login";
    }

    @PostMapping("/_admin/do/login")
    public String doAdminLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model,
                               HttpSession session) {
        User user = userService.login(username,password);
        if (user != null) {
            session.setAttribute("login_user",user);
            return "redirect:/_admin/index";
        }
        model.addAttribute("msg","账号或密码错误");
        return "_admin/login";
    }
    @GetMapping("/_admin/do/logout")
    public String doAdminLogout(HttpSession session) {
        session.invalidate();
        return "_admin/login";
    }
}
