package cn.lin1874.blog.service;

import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.vo.ArticleVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 12:19
 */
public interface ArticleService {

    Integer addArticle(Article article);

    PageInfo<Article> getArticleByUserIdOrderByModifiedTime(Integer id, Integer pageNum, Integer pageSize);

    Integer deleteArticleById(Integer id);

    Article getArticleById(Integer id);

    PageInfo<ArticleVo> getArticleVoOrderByModifiedTime(Integer pageNum, Integer pageSize);

    ArticleVo getArticleVoById(Integer articleId);

    Integer updateArticle(Article article);

    List<Article> getArticleByCategoriesId(Integer id);
}
