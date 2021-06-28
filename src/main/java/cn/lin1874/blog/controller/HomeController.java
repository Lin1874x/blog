package cn.lin1874.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lin1874
 * @date 2021/6/24 - 8:12
 */
@Controller
public class HomeController {
    @RequestMapping({"/","/index"})
    public String toIndex() {
        return "site/index";
    }
}
