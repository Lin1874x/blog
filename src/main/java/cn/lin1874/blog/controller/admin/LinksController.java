package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Links;
import cn.lin1874.blog.service.LinksService;
import cn.lin1874.blog.utils.ResultEntity;
import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "友链模块")
public class LinksController {

    @Autowired
    LinksService linksService;

    @ApiOperation(value = "获取友链列表")
    @GetMapping("/_admin/get/links/list")
    public ResultEntity<List<Links>> getLinksList() {
        return new ResultEntity<>(ResultEntity.SUCCESS,null, linksService.getAllLinks());
    }

    @ApiOperation(value = "更新友链信息")
    @PostMapping("/_admin/do/links/update")
    public ResultEntity doLinksUpdate(@RequestBody Links links) {
        linksService.updateLinks(links);
        return new ResultEntity(ResultEntity.SUCCESS,"修改成功",null);
    }


    @ApiOperation(value = "获取友链信息")
    @GetMapping("/_admin/get/links/update")
    public ResultEntity<Links> getLinksForUpdate(@RequestParam("id") Integer id) {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,linksService.getLinksById(id));
    }


    @ApiOperation(value = "添加友链")
    @PostMapping("/_admin/do/links/add")
    public ResultEntity<String> doLinksSave(@RequestBody Links links) {
        linksService.addLinks(links);
        return new ResultEntity<>(ResultEntity.SUCCESS,"添加成功",null);
    }

    @ApiOperation(value = "删除友链")
    @GetMapping("/_admin/do/links/delete")
    public ResultEntity doLinksDelete(@RequestParam("id") Integer id) {
        linksService.deleteLinksById(id);
        return new ResultEntity<>(ResultEntity.SUCCESS,"删除成功",null);
    }



}
