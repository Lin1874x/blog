package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.User;
import cn.lin1874.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author lin1874
 * @date 2021/6/22 - 9:04
 */
@Controller
public class IndexController {

    @GetMapping("/_admin/tmp-page")
    public String toTmpPage() {
        return "_admin/tmp-page";
    }

    @GetMapping({"/_admin/index","/_admin"})
    public String toAdminIndex() {
        return "_admin/index.html";
    }


}
