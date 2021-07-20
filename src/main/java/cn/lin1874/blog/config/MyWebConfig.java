package cn.lin1874.blog.config;


import cn.lin1874.blog.interceptor.LoginInterceptor;
import cn.lin1874.blog.interceptor.SettingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
                        "/_admin/plugins/**","/_admin/images/**","/_admin/editormd/**");
        registry.addInterceptor(new SettingInterceptor())
                .addPathPatterns("/**");
    }
    // 文件保存在真实目录/upload/下，
    // 访问的时候使用虚路径/upload，比如文件名为1.png，就直接/upload/1.png就ok了。
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:"+System.getProperty("user.dir")+"/upload/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }


}
