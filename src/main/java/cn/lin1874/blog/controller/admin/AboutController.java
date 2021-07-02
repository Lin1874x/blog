package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.About;
import cn.lin1874.blog.vo.AboutVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author lin1874
 * @date 2021/7/1 - 10:38
 */
@Controller
public class AboutController {
    @GetMapping("/_admin/to/about/edit")
    public String toAboutEdit(Model model) {
        model.addAttribute("text",About.text);
        return "_admin/about_edit";
    }
    @PostMapping("/_admin/do/about/update")
    public String doAboutUpdate(AboutVo aboutVo) {
        if (aboutVo.getText() != null) {
            About.text = aboutVo.getText();
        }
        return "redirect:/_admin/to/about/edit";
    }
}
