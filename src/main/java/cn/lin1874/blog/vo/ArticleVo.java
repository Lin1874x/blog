package cn.lin1874.blog.vo;

import cn.lin1874.blog.po.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lin1874
 * @date 2021/6/26 - 9:14
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleVo extends Article {
    private String author;
    private String[] taglist;
    private String category;
}