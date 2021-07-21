package cn.lin1874.blog.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lin1874
 * @date 2021/6/22 - 9:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("标签信息类")
public class Tag {

    @ApiModelProperty("标签id")
    private Integer id;

    @ApiModelProperty("标签名称")
    private String name;

    @ApiModelProperty("作者id")
    private Integer authorId;
}
