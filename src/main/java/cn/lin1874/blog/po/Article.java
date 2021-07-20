package cn.lin1874.blog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lin1874
 * @date 2021/6/22 - 8:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Integer id;
    private String title;
    private String titlePic;

    private Date createdTime;
    private Date modifiedTime;

    private String content;
    private Integer authorId;

    private String tags;
    private Integer categories;
    private Integer status;// 0 ：草稿 ； 1 ： 发布
    private Integer hits;

    private String shortContent;
}
