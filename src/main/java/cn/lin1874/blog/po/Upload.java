package cn.lin1874.blog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lin1874
 * @date 2021/7/2 - 8:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Upload {
    private Integer id;
    private String fileName;
    private String url;
}
