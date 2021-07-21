package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.po.User;
import cn.lin1874.blog.service.ArticleService;
import cn.lin1874.blog.service.CategoriesService;
import cn.lin1874.blog.utils.ResultEntity;
import cn.lin1874.blog.vo.ArticleVo;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 11:02
 */
@Api(tags = "博客文章模块")
@RestController
public class ArticleController {

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    ArticleService articleService;


    @ApiOperation(value = "文章添加")
    @PostMapping("/_admin/do/article/add")
    public ResultEntity addArticle(Article article, HttpSession session) {
        articleService.addArticle(article,session);
        return new ResultEntity(ResultEntity.SUCCESS,"添加成功",null);
    }


    @ApiOperation(value = "获取文章列表")
    @GetMapping("/_admin/get/article/list")
    public ResultEntity<PageInfo<ArticleVo>> getArticleList(@RequestParam(value = "pn", defaultValue = "1") Integer pageNum) {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,articleService.getArticleVoOrderByModifiedTime(pageNum));
    }

    @ApiOperation(value = "获取文章信息")
    @GetMapping("/_admin/get/articlevo/data")
    public ResultEntity<ArticleVo> getArticleVoById(@RequestParam("id") Integer id) {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,articleService.getArticleVoById(id));
    }


    @ApiOperation(value = "更新文章信息")
    @PostMapping("/_admin/do/article/update")
    public ResultEntity doArticleUpdate(Article article) {
        articleService.updateArticle(article);
        return new ResultEntity(ResultEntity.SUCCESS,"更新成功",null);
    }


    @ApiOperation(value = "删除文章")
    @GetMapping("/_admin/do/article/delete")
    public ResultEntity doArticleDelete(@RequestParam("id") Integer id) {
        articleService.deleteArticleById(id);
        return new ResultEntity(ResultEntity.SUCCESS,"删除成功",null);
    }

}
