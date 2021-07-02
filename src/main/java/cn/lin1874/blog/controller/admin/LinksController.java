package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Links;
import cn.lin1874.blog.service.LinksService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/28 - 22:18
 */
@Controller
public class LinksController {

    @Autowired
    LinksService linksService;
    @PostMapping("/_admin/do/links/update")
    public String doLinksUpdate(Links links) {
        linksService.updateLinks(links);
        return "redirect:/_admin/to/links";
    }
    @GetMapping("/_admin/to/links/update")
    public String toLinksUpdate(@RequestParam("id") Integer id,
                                Model model) {
        Links link = linksService.getLinksById(id);
        model.addAttribute("link",link);
        return "_admin/links_update";
    }
    @PostMapping("/_admin/do/links/save")
    public String doLinksSave(Links links) {
        linksService.addLinks(links);
        return "redirect:/_admin/to/links";
    }
    @GetMapping("/_admin/do/links/delete")
    public String doLinksDelete(@RequestParam("id") Integer id) {
        linksService.deleteLinksById(id);
        return "redirect:/_admin/to/links";
    }

    @GetMapping("/_admin/to/links/add")
    public String toLinksAddPage() {
        return "_admin/links_add";
    }

    @GetMapping("/_admin/to/links")
    public String toLinksListPage(Model model) {
        List<Links> linksList = linksService.getAllLinks();
        model.addAttribute("links", linksList);
        return "_admin/links_list";
    }


}
