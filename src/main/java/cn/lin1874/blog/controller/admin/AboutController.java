package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.About;
import cn.lin1874.blog.utils.ResultEntity;
import cn.lin1874.blog.vo.AboutVo;
import org.springframework.web.bind.annotation.*;

/**
 * @author lin1874
 * @date 2021/7/1 - 10:38
 */
@RestController
public class AboutController {
    /**
     * 获取关于页的信息
     * @return
     */
    @GetMapping("/_admin/get/data/about")
    public ResultEntity<String> getAboutData() {
        return new ResultEntity<>(ResultEntity.SUCCESS,"操作成功",About.text);
    }


    /**
     * 更新关于页
     * @param aboutVo
     * @return
     */
    @PostMapping("/_admin/do/about/update")
    public ResultEntity<String> doAboutUpdate(@RequestBody AboutVo aboutVo) {
        About.text = aboutVo.getText();
        return new ResultEntity<>(ResultEntity.SUCCESS,"操作成功",About.text);
    }
}
