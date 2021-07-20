package cn.lin1874.blog.service;

import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.vo.ArticleVo;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author lin1874
 * @date 2021/6/22 - 12:19
 */
public interface ArticleService {
    /**
     * 增加文章
     * @param article
     * @return
     */
    Integer addArticle(Article article,HttpSession session);

    /**
     * 通过用户id查询文章且根据修改时间排序
     * @return
     */
//    PageInfo<Article> getArticleVoByUserIdOrderByModifiedTime(Integer pageNum,HttpSession session);

    /**
     * 通过文章id删除文章
     * @param id
     * @return
     */
    Integer deleteArticleById(Integer id);

    /**
     * 通过文章id查询文章
     * @param id
     * @return
     */
    Article getArticleById(Integer id);

    /**
     * 获取所有文章根据修改时间
     * @param pageNum
     * @return
     */
    PageInfo<ArticleVo> getArticleVoOrderByModifiedTime(Integer pageNum);

    /**
     * 获取视图层文章类根据文章id
     * @param articleId
     * @return
     */
    ArticleVo getArticleVoById(Integer articleId);

    /**
     * 修改文章
     * @param article
     * @return
     */
    Integer updateArticle(Article article);

    /**
     * 根据分类id查询文章
     * @param id
     * @return
     */
    Map<String,Object> getArticleByCategoriesId(Integer id);

    Integer addArticleHitsById(Integer id, Integer hits);
}
