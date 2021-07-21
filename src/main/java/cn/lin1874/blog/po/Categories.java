package cn.lin1874.blog.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lin1874
 * @date 2021/6/22 - 8:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分类信息类")
public class Categories {
    @ApiModelProperty("分类id")
    private Integer id;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("作者id")
    private Integer authorId;
}
