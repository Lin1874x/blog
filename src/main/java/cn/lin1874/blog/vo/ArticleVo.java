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
    /**
     * 作者名字
     */
    private String author;
    /**
     * 标签列表
     */
    private String[] taglist;
    /**
     * 目录名字
     */
    private String category;
}