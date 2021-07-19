package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.po.Setting;
import cn.lin1874.blog.service.SettingService;
import cn.lin1874.blog.vo.SettingVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lin1874
 * @date 2021/7/1 - 9:37
 */
@Service
@Transactional
public class SettingServiceImpl implements SettingService {
    @Override
    public void updateSetting(SettingVo settingVo) {
//        if (settingVo.title != null) {
//            Setting.title = settingVo.title;
//        }
//        if (settingVo.indexTitle != null) {
//            Setting.indexTitle = settingVo.indexTitle;
//        }
//        if (settingVo.indexContent != null) {
//            Setting.indexContent = settingVo.indexContent;
//        }
//        if (settingVo.blogTitle != null) {
//            Setting.blogTitle = settingVo.blogTitle;
//        }
//        if (settingVo.blogContent != null) {
//            Setting.blogContent = settingVo.blogContent;
//        }
//        if (settingVo.footer != null) {
//            Setting.footer = settingVo.footer;
//        }
//        if (settingVo.record != null) {
//            Setting.record = settingVo.record;
//        }
    }
}
