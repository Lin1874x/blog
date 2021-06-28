package cn.lin1874.blog.mapper;

import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 12:21
 */
@Mapper
public interface ArticleMapper {

    Integer addArticle(Article article);

    List<Article> getArticleByUserIdOrderByModifiedTime(@Param("authorId") Integer id);

    Integer deleteArticleById(@Param("id") Integer id);

    Article getArticleById(@Param("id")Integer id);

    List<ArticleVo> getArticleVoOrderByModifiedTime();

    ArticleVo getArticleVoById(@Param("id")Integer articleId);

    Integer updateArticle(Article article);

    List<Article> getArticleByCategoriesId(@Param("categories") Integer id);
}
