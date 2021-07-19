package cn.lin1874.blog.mapper;

import cn.lin1874.blog.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 9:44
 */
@Mapper
public interface UserMapper {
    List<User> getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User getUserByUsername(String s);
}
