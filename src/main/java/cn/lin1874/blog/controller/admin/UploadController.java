package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Upload;
import cn.lin1874.blog.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lin1874
 * @date 2021/7/2 - 8:33
 */
@Controller
public class UploadController {
    @Autowired
    UploadService uploadService;
    @GetMapping("/_admin/to/upload")
    public String toUpload(Model model) {
        List<Upload> list = uploadService.getAllFile();
        model.addAttribute("list",list);
        return "_admin/upload";
    }
    @PostMapping("/_admin/do/upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         Model model) {
        String msg = "上传失败";
        if (file.isEmpty()) {
            msg = "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = System.getProperty("user.dir")+"/upload/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            String url = "/upload/" + fileName;
            uploadService.addUpload(new Upload(null,fileName,url));
            msg = "上传成功";
            return "redirect:/_admin/to/upload";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/_admin/to/upload";
        }
    }
}
