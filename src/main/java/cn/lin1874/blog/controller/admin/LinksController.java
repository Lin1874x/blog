package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Links;
import cn.lin1874.blog.service.LinksService;
import cn.lin1874.blog.utils.ResultEntity;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/28 - 22:18
 */
@RestController
public class LinksController {

    @Autowired
    LinksService linksService;

    /**
     * 获取友链数据
     * @return
     */
    @GetMapping("/_admin/get/links/list")
    public ResultEntity<List<Links>> getLinksList() {
        return new ResultEntity<>(ResultEntity.SUCCESS,null, linksService.getAllLinks());
    }

    /**
     * 修改友链
     * @param links
     * @return
     */
    @PostMapping("/_admin/do/links/update")
    public ResultEntity doLinksUpdate(@RequestBody Links links) {
        System.out.println(links);
        linksService.updateLinks(links);
        return new ResultEntity(ResultEntity.SUCCESS,"修改成功",null);
    }


    /**
     * 根据友链id返回友链信息用于修改
     * @param id
     * @return
     */
    @GetMapping("/_admin/get/links/update")
    public ResultEntity<Links> toLinksUpdate(@RequestParam("id") Integer id) {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,linksService.getLinksById(id));
    }


    /**
     * 添加友链
     * @param links
     * @return
     */
    @PostMapping("/_admin/do/links/add")
    public ResultEntity<String> doLinksSave(@RequestBody Links links) {
        System.out.println(links);
        linksService.addLinks(links);
        return new ResultEntity<>(ResultEntity.SUCCESS,"添加成功",null);
    }

    /**
     * 根据id删除友链
     * @param id
     * @return
     */
    @GetMapping("/_admin/do/links/delete")
    public ResultEntity doLinksDelete(@RequestParam("id") Integer id) {
        linksService.deleteLinksById(id);
        return new ResultEntity<>(ResultEntity.SUCCESS,"删除成功",null);
    }



}
