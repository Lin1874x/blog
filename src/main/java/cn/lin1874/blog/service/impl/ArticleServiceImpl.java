package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.mapper.ArticleMapper;
import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.po.User;
import cn.lin1874.blog.service.ArticleService;
import cn.lin1874.blog.vo.ArticleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 12:20
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Integer addArticle(Article article,HttpSession session) {

        User user = (User) session.getAttribute("loginAcct");
        article.setAuthorId(user.getId());
        article.setCreatedTime(new Date());
        article.setModifiedTime(new Date());
        article.setHits(0);
        return articleMapper.addArticle(article);
    }

//    @Override
//    public PageInfo<Article> getArticleByUserIdOrderByModifiedTime(Integer pageNum, HttpSession session) {
//        final int pageSize = 5;
//        User user = (User) session.getAttribute("loginAcct");
//        if (user == null) throw new RuntimeException();
//        PageHelper.startPage(pageNum,pageSize);
//        List<Article> articles = articleMapper.getArticleByUserIdOrderByModifiedTime(user.getId());
//        PageInfo<Article> pageInfo = new PageInfo<>(articles,5);
//        return pageInfo;
//    }

    @Override
    public Integer deleteArticleById(Integer id) {
        return articleMapper.deleteArticleById(id);
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public PageInfo<ArticleVo> getArticleVoOrderByModifiedTime(Integer pageNum) {
        final Integer pageSize = 5;
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleVo> articles = articleMapper.getArticleVoOrderByModifiedTime();
        PageInfo<ArticleVo> pageInfo = new PageInfo<>(articles,5);
        return pageInfo;
    }

    @Override
    public ArticleVo getArticleVoById(Integer articleId) {
        return articleMapper.getArticleVoById(articleId);
    }

    @Override
    public Integer updateArticle(Article article) {
        article.setModifiedTime(new Date());

        return articleMapper.updateArticle(article);
    }

    @Override
    public List<Article> getArticleByCategoriesId(Integer id) {
        return articleMapper.getArticleByCategoriesId(id);
    }

    @Override
    public Integer addArticleHitsById(Integer id, Integer hits) {
        return articleMapper.addArticleHitsById(id,hits);
    }
}
