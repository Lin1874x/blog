package cn.lin1874.blog.controller.blog;

import cn.lin1874.blog.po.About;
import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.po.Links;
import cn.lin1874.blog.service.ArticleService;
import cn.lin1874.blog.service.CategoriesService;
import cn.lin1874.blog.service.LinksService;
import cn.lin1874.blog.vo.ArticleVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/24 - 8:32
 */
@Controller
public class BlogController {
    @Autowired
    ArticleService articleService;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    LinksService linksService;

    @GetMapping("/blog/about")
    public String toAboutPage(Model model) {
        model.addAttribute("text", About.text);
        return "site/about";
    }
    @GetMapping("/blog/links")
    public String toLinksPage(Model model) {
        List<Links> links = linksService.getAllLinks();
        model.addAttribute("links",links);
        return "site/links";
    }
    @GetMapping("/blog/tags")
    public String toTagsPage() {
        return "site/tags";
    }

    @GetMapping("/blog/categories/{id}")
    public String toArticleList(@PathVariable("id") Integer id,
                                Model model) {
        List<Article> articles = articleService.getArticleByCategoriesId(id);
        Categories categories = categoriesService.getCategoriesById(id);
        model.addAttribute("categoriesName",categories.getName());
        model.addAttribute("articles",articles);
        return "site/article-list";
    }


    @GetMapping("/blog/categories")
    public String toCategoriesPage(Model model) {
        List<Categories> categories = categoriesService.getAllCategories();
        model.addAttribute("categories",categories);
        return "site/categories";
    }
    @GetMapping("/blog/archives")
    public String toArchivesPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                 Model model) {
        PageInfo<ArticleVo> pageInfo = articleService.getArticleVoOrderByModifiedTime(pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "site/archives";
    }

    @RequestMapping("/blog")
    public String toBlogIndexPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                  Model model) {
        PageInfo<ArticleVo> pageInfo = articleService.getArticleVoOrderByModifiedTime(pageNum, pageSize);
        List<ArticleVo> list = pageInfo.getList();
        for (ArticleVo articleVo : list) {
            if(articleVo.getTitlePic() == null) {
                articleVo.setTitlePic("/site/images/cover.png");
            }
            String tags = articleVo.getTags();
            String[] split = tags.split(",");
            articleVo.setTaglist(split);
        }
        model.addAttribute("pageInfo", pageInfo);
        return "site/blog";
    }

    @GetMapping("/blog/article/{articleId}")
    public String toArticlePage(@PathVariable("articleId") Integer articleId,
                                Model model) {
        ArticleVo article = articleService.getArticleVoById(articleId);
        article.setHits(article.getHits() + 1);
        articleService.addArticleHitsById(article.getId(),article.getHits());
        String tags = article.getTags();
        String[] split = tags.split(",");
        article.setTaglist(split);

        model.addAttribute("article", article);
        return "site/pages";
    }
}
