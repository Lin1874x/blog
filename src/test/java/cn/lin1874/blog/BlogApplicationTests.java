package cn.lin1874.blog;


import cn.lin1874.blog.mapper.ArticleMapper;
import cn.lin1874.blog.mapper.CategoriesMapper;
import cn.lin1874.blog.po.Article;
import cn.lin1874.blog.po.Categories;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    CategoriesMapper categoriesMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void contextLoads() {

    }

}
