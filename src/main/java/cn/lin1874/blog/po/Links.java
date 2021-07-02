package cn.lin1874.blog.po;

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
public class Links {
    private Integer id;
    private String name;
    private String introduce;
    private String url;
    private String pic;
}
