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
        //文件上传页面
        registry.addViewController("/_admin/to/upload").setViewName("_admin/upload");
        //文章添加页面
        registry.addViewController("/_admin/to/article/publish").setViewName("_admin/article_edit");
        //文章更新页面
        registry.addViewController("/_admin/to/article/update").setViewName("_admin/article_edit");
        //文章管理页面
        registry.addViewController("/_admin/to/article/list").setViewName("_admin/article_list");
        //分类管理页面
        registry.addViewController("/_admin/to/category").setViewName("_admin/category");
        //后台主页页面
        registry.addViewController("/_admin/index").setViewName("_admin/index");
        registry.addViewController("/_admin").setViewName("_admin/index");
        //后台登录页面
        registry.addViewController("/_admin/login").setViewName("_admin/login");
        //友链管理页面
        registry.addViewController("/_admin/to/links").setViewName("_admin/links_list");
        //网站信息设置页面
        registry.addViewController("/_admin/to/setting/edit").setViewName("_admin/setting");
        // About编辑页
        registry.addViewController("/_admin/to/about/edit").setViewName("_admin/about_edit");
        //首页
        registry.addViewController("/").setViewName("site/index");
        //博客首页
        registry.addViewController("/blog").setViewName("site/blog");
        //博客归档页
        registry.addViewController("/blog/archives").setViewName("site/archives");
        //博客分类列表
        registry.addViewController("/blog/categories").setViewName("site/categories");
        //博客文章内容页面
        registry.addViewController("/blog/article").setViewName("site/pages");
        //分类文章汇总页
        registry.addViewController("/blog/category").setViewName("site/article-list");
        //友链
        registry.addViewController("/blog/links").setViewName("site/links");
        //关于页
        registry.addViewController("/blog/about").setViewName("site/about");
    }


}
