package cn.lin1874.blog.vo;

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
public class SettingVo {
    public String indexTitle ;
    public String indexContent ;
    public String blogTitle;
    public String blogContent;
    public String footer;
    public String record;
    public String title;
}
