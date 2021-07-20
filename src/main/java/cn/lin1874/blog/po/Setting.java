package cn.lin1874.blog.po;

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
public class Setting {

    private  String indexTitle = "Lin1874's space";
    private  String indexContent = "Walking on my way!";
    private  String blogTitle = "Lin1874's blog";
    private  String blogContent = "Walking on my way!";
    private  String footer = "©2021 - 2099 By Lin1874";
    private  String record = "闽ICP备2021004032号-1";
    private  String title = "Lin1874's space";
}
