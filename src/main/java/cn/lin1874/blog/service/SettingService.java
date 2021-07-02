package cn.lin1874.blog.service;

import cn.lin1874.blog.po.Setting;
import cn.lin1874.blog.vo.SettingVo;
import org.springframework.stereotype.Service;

/**
 * @author lin1874
 * @date 2021/7/1 - 9:37
 */
public interface SettingService {
    void updateSetting(SettingVo settingVo);
}
