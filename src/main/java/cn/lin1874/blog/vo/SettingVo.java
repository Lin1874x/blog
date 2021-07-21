package cn.lin1874.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lin1874
 * @date 2021/7/1 - 9:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("设置展示类")
public class SettingVo {
    @ApiModelProperty("首页标题")
    private  String indexTitle;

    @ApiModelProperty("首页标语")
    private  String indexContent;

    @ApiModelProperty("博客首页标题")
    private  String blogTitle;

    @ApiModelProperty("博客首页标语")
    private  String blogContent;

    @ApiModelProperty("页脚信息")
    private  String footer;

    @ApiModelProperty("备案信息")
    private  String record;

    @ApiModelProperty("网站标题")
    private  String title;

}
