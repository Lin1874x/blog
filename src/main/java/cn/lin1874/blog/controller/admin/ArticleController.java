package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.po.User;
import cn.lin1874.blog.service.ArticleService;
import cn.lin1874.blog.service.CategoriesService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 11:02
 */
@Controller
public class ArticleController {

    @Autowired
    CategoriesService categoriesService;
    @Autowired
    ArticleService articleService;

    @PostMapping("/_admin/do/article/update")
    public String doArticleUpdate(Article article,
                                  @RequestParam("pageNum") Integer pageNum) {

        article.setModifiedTime(new Date());
        articleService.updateArticle(article);
        return "redirect:/_admin/to/article/list?pageNum=" + pageNum;
    }

    @GetMapping("/_admin/to/article/update")
    public String toArticleUpdate(@RequestParam("id") Integer id,
                                  @RequestParam("pageNum") Integer pageNum,
                                  Model model) {
        Article article = articleService.getArticleById(id);
        List<Categories> allCategories = categoriesService.getAllCategories();

        model.addAttribute("categories",allCategories);
        model.addAttribute("article",article);
        model.addAttribute("pageNum",pageNum);

        return "_admin/article_update";
    }



    @GetMapping("/_admin/do/article/delete")
    public String doArticleDelete(@RequestParam("id") Integer id,
                                  @RequestParam("pageNum") Integer pageNum) {
        articleService.deleteArticleById(id);
        return "redirect:/_admin/to/article/list?pageNum=" + pageNum;
    }

    @GetMapping("/_admin/to/article/list")
    public String toArticleList(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize,
                                Model model, HttpSession session) {
        User login_user = (User) session.getAttribute("login_user");
        PageInfo<Article> articles =
                articleService.getArticleByUserIdOrderByModifiedTime(login_user.getId(),pageNum,pageSize);
        model.addAttribute("articles",articles);
        return "_admin/article_list";
    }



    @GetMapping("/_admin/to/publish")
    public String toArticlePublish(Model model) {
        List<Categories> allCategories = categoriesService.getAllCategories();
        model.addAttribute("categories",allCategories);
        return "_admin/article_edit";
    }

    @PostMapping("/_admin/article/save")
    public String saveArticle(Article article, HttpSession session) {
        User login_user = (User) session.getAttribute("login_user");

        article.setCreatedTime(new Date());
        article.setModifiedTime(new Date());
        article.setAuthorId(login_user.getId());
        article.setHits(0);

        articleService.addArticle(article);

        return "redirect:/_admin/to/article/list";
    }

}
