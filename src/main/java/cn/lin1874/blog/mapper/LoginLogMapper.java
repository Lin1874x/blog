package cn.lin1874.blog.mapper;

import cn.lin1874.blog.po.LoginLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/7/21 - 21:15
 */
@Mapper
public interface LoginLogMapper {

    void addLoginLog(LoginLog loginLog);

    List<LoginLog> getLoginLogListOrderByTimeLimit5();
}
