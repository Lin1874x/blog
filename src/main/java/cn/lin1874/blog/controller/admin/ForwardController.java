package cn.lin1874.blog.controller.admin;


import cn.lin1874.blog.po.Upload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * 后台统一的请求转发处理器
 * @author lin1874
 * @date 2021/7/19 - 14:09
 */
@Controller
public class ForwardController {
    /**
     *请求转发
     * 文件上传
     * @return
     */
    @GetMapping("/_admin/to/upload")
    public String toUpload() {
        return "_admin/upload";
    }
    /**
     * 请求转发
     * 文章添加页面
     * @return
     */
    @GetMapping("/_admin/to/article/publish")
    public String toAdminArticleAdd() {
        return "_admin/article_edit";
    }
    /**
     * 请求转发
     * 文章更新页面
     * @return
     */
    @GetMapping("/_admin/to/article/update")
    public String toAdminArticleUpdate() {
        return "_admin/article_edit";
    }
    /**
     * 请求转发
     * 文章管理页面
     * @return
     */
    @GetMapping("/_admin/to/article/list")
    public String toAdminArticle() {
        return "_admin/article_list";
    }
    /**
     * 请求转发
     * 分类管理页面
     * @return
     */
    @GetMapping("/_admin/to/category")
    public String toAdminCategory(){
        return "_admin/category";
    }
    /**
     * 请求转发
     * 后台主页
     * @return
     */
    @GetMapping({"/_admin/index","/_admin"})
    public String toAdminIndex() {
        return "_admin/index";
    }
    /**
     * 请求转发
     * 登录页面
     * @return
     */
    @GetMapping("/_admin/login")
    public String toAdminLogin() {
        return "_admin/login";
    }
    /**
     * 请求转发
     * 友链管理
     * @return
     */
    @GetMapping("/_admin/to/links")
    public String toAdminLinks() {
        return "_admin/links_list";
    }
    /**
     * 请求转发
     * 网站信息设置
     * @return
     */
    @GetMapping("/_admin/to/setting/edit")
    public String toAdminSetting() {
        return "_admin/setting";
    }
    /**
     * 请求转发
     * About编辑页
     * @return
     */
    @GetMapping("/_admin/to/about/edit")
    public String toAdminAbout() {
        return "_admin/about_edit";
    }
}
