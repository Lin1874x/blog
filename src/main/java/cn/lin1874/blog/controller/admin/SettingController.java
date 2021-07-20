package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Setting;
import cn.lin1874.blog.service.SettingService;
import cn.lin1874.blog.utils.ResultEntity;
import cn.lin1874.blog.vo.SettingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lin1874
 * @date 2021/7/1 - 9:28
 */
@RestController
public class SettingController {

    @Autowired
    SettingService settingService;
    @Autowired
    Setting setting;

    /**
     * 获取设置数据
     * @return
     */
    @GetMapping("/_admin/get/data/setting")
    public ResultEntity<Setting> getAdminSettingData() {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,setting);
    }

    /**
     * 更新设置数据
     * @param settingVo
     * @return
     */
    @PostMapping("/_admin/do/setting/update")
    public ResultEntity<String> doAdminSettingUpdate(@RequestBody SettingVo settingVo) {
        settingService.updateSetting(settingVo);
        return new ResultEntity<>(ResultEntity.SUCCESS,"操作成功",null);
    }


}
