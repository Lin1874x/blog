package cn.lin1874.blog.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lin1874
 * @date 2021/6/28 - 22:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("友链信息类")
public class Links {
    @ApiModelProperty("友链id")
    private Integer id;

    @ApiModelProperty("友链名称")
    private String name;

    @ApiModelProperty("友链介绍")
    private String introduce;

    @ApiModelProperty("友链地址")
    private String url;

    @ApiModelProperty("友链图片")
    private String pic;
}
