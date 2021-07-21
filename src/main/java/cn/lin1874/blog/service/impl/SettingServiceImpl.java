package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.po.Setting;
import cn.lin1874.blog.service.SettingService;
import cn.lin1874.blog.vo.SettingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lin1874
 * @date 2021/7/1 - 9:37
 */
@Service
@Transactional
public class SettingServiceImpl implements SettingService {
    @Autowired
    Setting setting;
    @Override
    public void updateSetting(SettingVo settingVo) {
        if (settingVo.getTitle() != null) {
            setting.setTitle(settingVo.getTitle());
        }
        if (settingVo.getIndexTitle() != null) {
            setting.setIndexTitle(settingVo.getIndexTitle());
        }
        if (settingVo.getIndexContent() != null) {
            setting.setIndexContent(settingVo.getIndexContent());
        }
        if (settingVo.getBlogTitle() != null) {
            setting.setBlogTitle(settingVo.getBlogTitle());
        }
        if (settingVo.getBlogContent() != null) {
            setting.setBlogContent(settingVo.getBlogContent());
        }
        if (settingVo.getFooter() != null) {
            setting.setFooter(settingVo.getFooter());
        }
        if (settingVo.getRecord() != null) {
            setting.setRecord(settingVo.getRecord());
        }
    }
}
