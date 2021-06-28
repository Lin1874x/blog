package cn.lin1874.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lin1874
 * @date 2021/6/22 - 10:47
 */
@Controller
public class UserController {
    @GetMapping("/_admin/to/user/setting")
    public String toAdminUserSetting() {
        return "_admin/user-setting";
    }
}
