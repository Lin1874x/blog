package cn.lin1874.blog.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lin1874
 * @date 2021/7/21 - 21:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginLog {
    private Integer id;
    private String ip;
    private Date operTime;
    private String operDesc;
    private String operResult;
}
