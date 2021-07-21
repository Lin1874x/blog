package cn.lin1874.blog.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("文章信息类")
public class Article {

    @ApiModelProperty("文章id")
    private Integer id;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章标题图片")
    private String titlePic;

    @ApiModelProperty("文章创建时间")
    private Date createdTime;

    @ApiModelProperty("文章修改时间")
    private Date modifiedTime;

    @ApiModelProperty("文章内容")
    private String content;

    @ApiModelProperty("作者id")
    private Integer authorId;

    @ApiModelProperty("文章标签")
    private String tags;

    @ApiModelProperty("文章分类id")
    private Integer categories;

    @ApiModelProperty("文章状态id")
    private Integer status;// 0 ：草稿 ； 1 ： 发布

    @ApiModelProperty("文章访问量")
    private Integer hits;

    @ApiModelProperty("文章简介")
    private String shortContent;
}
