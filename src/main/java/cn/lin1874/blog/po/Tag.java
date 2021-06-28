package cn.lin1874.blog.po;

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
public class Tag {
    private Integer id;
    private String name;
    private Integer authorId;
}
