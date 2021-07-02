package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Setting;
import cn.lin1874.blog.service.SettingService;
import cn.lin1874.blog.vo.SettingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lin1874
 * @date 2021/7/1 - 9:28
 */
@Controller
public class SettingController {

    @Autowired
    SettingService settingService;

    @RequestMapping("/_admin/do/setting/update")
    public String doAdminSettingUpdate(SettingVo settingVo) {
        settingService.updateSetting(settingVo);
        return "redirect:/_admin/to/setting";
    }

    @RequestMapping("/_admin/to/setting")
    public String toAdminSetting() {
        return "_admin/setting";
    }
}
