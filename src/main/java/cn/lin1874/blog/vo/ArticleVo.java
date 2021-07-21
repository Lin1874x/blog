package cn.lin1874.blog.vo;

import cn.lin1874.blog.po.Article;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("文章展示类")
public class ArticleVo extends Article {

    @ApiModelProperty("作者昵称")
    private String author;

    @ApiModelProperty("标签列表")
    private String[] taglist;

    @ApiModelProperty("分类名称")
    private String category;
}