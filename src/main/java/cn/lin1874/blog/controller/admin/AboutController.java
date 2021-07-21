package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.About;
import cn.lin1874.blog.utils.ResultEntity;
import cn.lin1874.blog.vo.AboutVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author lin1874
 * @date 2021/7/1 - 10:38
 */
@Api(tags = "关于页模块")
@RestController
public class AboutController {

    @ApiOperation(value = "获取关于页信息")
    @GetMapping("/_admin/get/data/about")
    public ResultEntity<String> getAboutData() {
        return new ResultEntity<>(ResultEntity.SUCCESS,"操作成功",About.text);
    }


    @ApiOperation(value = "更新关于页信息")
    @PostMapping("/_admin/do/about/update")
    public ResultEntity<String> doAboutUpdate(@RequestBody AboutVo aboutVo) {
        About.text = aboutVo.getText();
        return new ResultEntity<>(ResultEntity.SUCCESS,"操作成功",About.text);
    }
}
