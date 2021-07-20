package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.mapper.UserMapper;
import cn.lin1874.blog.po.User;
import cn.lin1874.blog.service.UserService;
import cn.lin1874.blog.utils.EncodeUtils;
import cn.lin1874.blog.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
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
    public ResultEntity login(String username, String password, HttpSession session) {
        String encoded = EncodeUtils.md5(password);
        User user = userMapper.getUserByUsernameAndPassword(username, encoded);
        if (user == null) {
            return new ResultEntity(ResultEntity.FAILED,"用户名或密码错误",null);
        } else {
            session.setAttribute("loginAcct",user);
            return new ResultEntity(ResultEntity.SUCCESS,null,null);
        }
    }
}
