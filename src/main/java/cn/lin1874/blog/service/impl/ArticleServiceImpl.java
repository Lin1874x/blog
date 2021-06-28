package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.mapper.ArticleMapper;
import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.service.ArticleService;
import cn.lin1874.blog.vo.ArticleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 12:20
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Override
    public Integer addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public PageInfo<Article> getArticleByUserIdOrderByModifiedTime(Integer id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleMapper.getArticleByUserIdOrderByModifiedTime(id);
        PageInfo<Article> pageInfo = new PageInfo<>(articles,5);
        return pageInfo;
    }

    @Override
    public Integer deleteArticleById(Integer id) {
        return articleMapper.deleteArticleById(id);
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public PageInfo<ArticleVo> getArticleVoOrderByModifiedTime(Integer pageNum, Integer pageSize) {
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
        return articleMapper.updateArticle(article);
    }

    @Override
    public List<Article> getArticleByCategoriesId(Integer id) {
        return articleMapper.getArticleByCategoriesId(id);
    }
}
