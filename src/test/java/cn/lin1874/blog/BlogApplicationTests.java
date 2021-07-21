package cn.lin1874.blog;


import cn.lin1874.blog.mapper.ArticleMapper;
import cn.lin1874.blog.mapper.CategoriesMapper;
import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.service.ArticleService;
import cn.lin1874.blog.utils.EncodeUtils;
import cn.lin1874.blog.vo.ArticleVo;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    CategoriesMapper categoriesMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleService articleService;

    @Test
    public void contextLoads() {
//        String admin = EncodeUtils.md5("admin");
//        System.out.println(admin);
    }
    

}
