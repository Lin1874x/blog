package cn.lin1874.blog.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author lin1874
 * @date 2021/6/30 - 8:24
 */
@Component
@Data
@ApiModel("网站设置信息类")
public class Setting {

    @ApiModelProperty("首页标题")
    private  String indexTitle = "Lin1874's space";

    @ApiModelProperty("首页标语")
    private  String indexContent = "Walking on my way!";

    @ApiModelProperty("博客首页标题")
    private  String blogTitle = "Lin1874's blog";

    @ApiModelProperty("博客首页标语")
    private  String blogContent = "Walking on my way!";

    @ApiModelProperty("页脚信息")
    private  String footer = "©2021 - 2099 By Lin1874";

    @ApiModelProperty("备案信息")
    private  String record = "闽ICP备2021004032号-1";

    @ApiModelProperty("网站标题")
    private  String title = "Lin1874's space";
}
