package cn.lin1874.blog.controller.blog;

import cn.lin1874.blog.po.About;
import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.po.Links;
import cn.lin1874.blog.service.ArticleService;
import cn.lin1874.blog.service.CategoriesService;
import cn.lin1874.blog.service.LinksService;
import cn.lin1874.blog.utils.ResultEntity;
import cn.lin1874.blog.vo.ArticleVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lin1874
 * @date 2021/6/24 - 8:32
 */
@RestController
public class BlogController {
    @Autowired
    ArticleService articleService;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    LinksService linksService;

    /**
     * 博客首页数据获取
     * @param pageNum
     * @return
     */
    @GetMapping("/blog/get/data")
    public ResultEntity<PageInfo<ArticleVo>> getBlogIndexData(@RequestParam(value = "pn", defaultValue = "1") Integer pageNum) {
        return new ResultEntity<>(ResultEntity.SUCCESS, null, articleService.getArticleVoOrderByModifiedTime(pageNum));
    }

    /**
     * 获取关于信息
     * @return
     */
    @GetMapping("/blog/about/get/data")
    public ResultEntity<String> getAboutData() {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,About.text);
    }

    /**
     * 获取友链信息
     * @return
     */
    @GetMapping("/blog/links/get/data")
    @ResponseBody
    public ResultEntity<List<Links>> toLinksPage() {
        List<Links> links = linksService.getAllLinks();
        return new ResultEntity<>(ResultEntity.SUCCESS,null,links);
    }

    /**
     * 具体分类文章汇总页面
     * @param id
     * @return
     */
    @GetMapping("/blog/categories/list/get/data")
    @ResponseBody
    public ResultEntity<Map<String,Object>> toArticleList(@RequestParam("id") Integer id) {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,articleService.getArticleByCategoriesId(id));
    }

    /**
     * 分类列表
     * @param model
     * @return
     */
    @GetMapping("/blog/categories/get/data")
    @ResponseBody
    public ResultEntity<List<Categories>> toCategoriesPage(Model model) {
        List<Categories> categories = categoriesService.getAllCategories();
        return new ResultEntity<>(ResultEntity.SUCCESS,null,categories);
    }

    /**
     * 归档页数据获取
     * @param pageNum
     * @return
     */
    @GetMapping("/blog/archives/get/data")
    @ResponseBody
    public ResultEntity<PageInfo<ArticleVo>> toArchivesPage(@RequestParam(value = "pn", defaultValue = "1") Integer pageNum) {
        PageInfo<ArticleVo> pageInfo = articleService.getArticleVoOrderByModifiedTime(pageNum);
        return new ResultEntity<>(ResultEntity.SUCCESS,null,pageInfo);
    }


    /**
     * 具体文章页面
     * @param articleId
     * @return
     */
    @GetMapping("/blog/article/get/data")
    @ResponseBody
    public ResultEntity<ArticleVo> toArticlePage(@RequestParam("id") Integer articleId) {
        ArticleVo article = articleService.getArticleVoById(articleId);
        return new ResultEntity<>(ResultEntity.SUCCESS,null,article);
    }
}
