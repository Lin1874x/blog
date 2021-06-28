package cn.lin1874.blog.config;


import cn.lin1874.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/11 - 15:15
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/_admin/**")
                .excludePathPatterns("/_admin/login","/_admin/do/login")
                .excludePathPatterns("/_admin/css/**","/_admin/js/**","/_admin/images/**",
                        "/_admin/plugins/**","/_admin/images/**");
    }
}
