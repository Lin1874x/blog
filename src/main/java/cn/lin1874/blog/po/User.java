package cn.lin1874.blog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lin1874
 * @date 2021/6/22 - 8:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
}
