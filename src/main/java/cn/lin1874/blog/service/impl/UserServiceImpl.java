package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.mapper.UserMapper;
import cn.lin1874.blog.po.User;
import cn.lin1874.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 9:40
 */
@Service
@Transactional
public class UserServiceImpl  implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        List<User> userList = userMapper.getUserByUsernameAndPassword(username, password);
        if (userList == null || userList.size() == 0) {
            return null;
        } else {
            return userList.get(0);
        }
    }
}
