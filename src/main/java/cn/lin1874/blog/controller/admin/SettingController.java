package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Setting;
import cn.lin1874.blog.service.SettingService;
import cn.lin1874.blog.utils.ResultEntity;
import cn.lin1874.blog.vo.SettingVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lin1874
 * @date 2021/7/1 - 9:28
 */
@RestController
@Api(tags = "网站设置模块")
public class SettingController {

    @Autowired
    SettingService settingService;

    @Autowired
    Setting setting;


    @ApiOperation(value = "获取网站设置信息")
    @GetMapping("/_admin/get/data/setting")
    public ResultEntity<Setting> getAdminSettingData() {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,setting);
    }


    @ApiOperation(value = "更新网站设置信息")
    @PostMapping("/_admin/do/setting/update")
    public ResultEntity<String> doAdminSettingUpdate(@RequestBody SettingVo settingVo) {
        settingService.updateSetting(settingVo);
        return new ResultEntity<>(ResultEntity.SUCCESS,"操作成功",null);
    }


}
