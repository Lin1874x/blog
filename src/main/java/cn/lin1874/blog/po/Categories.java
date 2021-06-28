package cn.lin1874.blog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lin1874
 * @date 2021/6/22 - 8:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
    private Integer id;
    private String name;
    private Integer authorId;
}
