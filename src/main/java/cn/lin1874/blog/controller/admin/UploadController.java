package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Upload;
import cn.lin1874.blog.service.UploadService;
import cn.lin1874.blog.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lin1874
 * @date 2021/7/2 - 8:33
 */
@RestController
public class UploadController {
    @Autowired
    UploadService uploadService;

    /**
     * 获取已上传的文件信息
     * @return
     */
    @GetMapping("/_admin/get/upload/data")
    public ResultEntity<List<Upload>> getAdminUploadData() {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,uploadService.getAllFile());
    }

    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/_admin/do/upload")
    public ResultEntity upload(@RequestParam("file") MultipartFile file) {
        uploadService.addUpload(file);
        return new ResultEntity<>(ResultEntity.SUCCESS,"上传成功",null);
    }
}
