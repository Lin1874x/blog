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
        if (settingVo.title != null) {
            setting.setTitle(settingVo.title);
        }
        if (settingVo.indexTitle != null) {
            setting.setIndexTitle(settingVo.indexTitle);
        }
        if (settingVo.indexContent != null) {
            setting.setIndexContent(settingVo.indexContent);
        }
        if (settingVo.blogTitle != null) {
            setting.setBlogTitle(settingVo.blogTitle);
        }
        if (settingVo.blogContent != null) {
            setting.setBlogContent(settingVo.blogContent);
        }
        if (settingVo.footer != null) {
            setting.setFooter(settingVo.footer);
        }
        if (settingVo.record != null) {
            setting.setRecord(settingVo.record);
        }
    }
}
