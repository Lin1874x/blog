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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "博客前端模块")
@RestController
public class BlogController {

    @Autowired
    ArticleService articleService;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    LinksService linksService;


    @ApiOperation(value = "获取文章首页数据")
    @GetMapping("/blog/get/data")
    public ResultEntity<PageInfo<ArticleVo>> getBlogIndexData(@RequestParam(value = "pn", defaultValue = "1") Integer pageNum) {
        return new ResultEntity<>(ResultEntity.SUCCESS, null, articleService.getArticleVoOrderByModifiedTime(pageNum));
    }

    @ApiOperation(value = "获取关于页数据")
    @GetMapping("/blog/about/get/data")
    public ResultEntity<String> getAboutData() {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,About.text);
    }

    @ApiOperation(value = "获取友链列表数据")
    @GetMapping("/blog/links/get/data")
    public ResultEntity<List<Links>> toLinksPage() {
        List<Links> links = linksService.getAllLinks();
        return new ResultEntity<>(ResultEntity.SUCCESS,null,links);
    }

    @ApiOperation(value = "获取具体分类问文章列表数据")
    @GetMapping("/blog/categories/list/get/data")
    public ResultEntity<Map<String,Object>> toArticleList(@RequestParam("id") Integer id) {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,articleService.getArticleByCategoriesId(id));
    }

    @ApiOperation(value = "获取分类列表数据")
    @GetMapping("/blog/categories/get/data")
    public ResultEntity<List<Categories>> toCategoriesPage(Model model) {
        List<Categories> categories = categoriesService.getAllCategories();
        return new ResultEntity<>(ResultEntity.SUCCESS,null,categories);
    }

    @ApiOperation(value = "获取归档页数据")
    @GetMapping("/blog/archives/get/data")
    public ResultEntity<PageInfo<ArticleVo>> toArchivesPage(@RequestParam(value = "pn", defaultValue = "1") Integer pageNum) {
        PageInfo<ArticleVo> pageInfo = articleService.getArticleVoOrderByModifiedTime(pageNum);
        return new ResultEntity<>(ResultEntity.SUCCESS,null,pageInfo);
    }

    @ApiOperation(value = "获取具体文章数据")
    @GetMapping("/blog/article/get/data")
    public ResultEntity<ArticleVo> toArticlePage(@RequestParam("id") Integer articleId) {
        ArticleVo article = articleService.getArticleVoById(articleId);
        return new ResultEntity<>(ResultEntity.SUCCESS,null,article);
    }
}
