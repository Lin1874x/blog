package cn.lin1874.blog.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author lin1874
 * @date 2021/6/22 - 8:59
 */
@ApiModel(value = "关于信息类")
public class About {

    public static Integer id;

    @ApiModelProperty(value = "关于页具体内容")
    public static String text = "这是关于页面，博主啥也没有";

}
