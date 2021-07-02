package cn.lin1874.blog.interceptor;

import cn.lin1874.blog.po.Setting;
import cn.lin1874.blog.po.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lin1874
 * @date 2021/6/30 - 18:15
 */
public class SettingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.getSession().setAttribute("setting",new Setting());
        return true;
    }
}
