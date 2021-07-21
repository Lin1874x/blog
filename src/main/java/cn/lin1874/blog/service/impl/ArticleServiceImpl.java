package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.exception.DatabaseException;
import cn.lin1874.blog.mapper.ArticleMapper;
import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.po.User;
import cn.lin1874.blog.service.ArticleService;
import cn.lin1874.blog.service.CategoriesService;
import cn.lin1874.blog.vo.ArticleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author lin1874
 * @date 2021/6/22 - 12:20
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CategoriesService categoriesService;

    @Override
    public Integer addArticle(Article article,HttpSession session) {

        User user = (User) session.getAttribute("loginAcct");
        article.setAuthorId(user.getId());
        article.setCreatedTime(new Date());
        article.setModifiedTime(new Date());
        article.setHits(0);
        Integer res = articleMapper.addArticle(article);
        if (res == 0) {
            throw new DatabaseException();
        }
        return res;
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
    public PageInfo<ArticleVo> getArticleVoOrderByModifiedTime(Integer pageNum) {
        final Integer pageSize = 5;
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleVo> articles = articleMapper.getArticleVoOrderByModifiedTime();
        PageInfo<ArticleVo> pageInfo = new PageInfo<>(articles,5);

        List<ArticleVo> list = pageInfo.getList();
        String defaultImgUrl = "/site/images/cover.png";

        list.stream().forEach((articleVo)->{
            if(articleVo.getTitlePic() == null) {
                articleVo.setTitlePic(defaultImgUrl);
            }
            String tags = articleVo.getTags();
            String[] split = tags.split(",");
            articleVo.setTaglist(split);
        });
//        for (ArticleVo articleVo : list) {
//            if(articleVo.getTitlePic() == null) {
//                articleVo.setTitlePic("/site/images/cover.png");
//            }
//            String tags = articleVo.getTags();
//            String[] split = tags.split(",");
//            articleVo.setTaglist(split);
//        }

        return pageInfo;
    }

    @Override
    public ArticleVo getArticleVoById(Integer articleId) {
        ArticleVo article = articleMapper.getArticleVoById(articleId);
        article.setHits(article.getHits() + 1);
        addArticleHitsById(article.getId(),article.getHits());
        String tags = article.getTags();
        String[] split = tags.split(",");
        article.setTaglist(split);
        return article;
    }

    @Override
    public Integer updateArticle(Article article) {
        article.setModifiedTime(new Date());
        return articleMapper.updateArticle(article);
    }

    @Override
    public Map<String,Object> getArticleByCategoriesId(Integer id) {
        List<Article> list = articleMapper.getArticleByCategoriesId(id);
        Categories categories = categoriesService.getCategoriesById(id);
        Map<String,Object> mp = new HashMap<>();
        mp.put("list",list);
        mp.put("categoryName",categories.getName());
        return mp;
    }

    @Override
    public Integer addArticleHitsById(Integer id, Integer hits) {
        return articleMapper.addArticleHitsById(id,hits);
    }
}
