package cn.lin1874.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lin1874
 * @date 2021/7/1 - 11:28
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("关于页展示类")
public class AboutVo {

    @ApiModelProperty("关于内容")
    String text;

}
