package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.mapper.UploadMapper;
import cn.lin1874.blog.po.Upload;
import cn.lin1874.blog.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author lin1874
 * @date 2021/7/2 - 8:49
 */
@Service
@Transactional
public class UploadServiceImpl implements UploadService {

    @Autowired
    UploadMapper uploadMapper;
    @Override
    public Integer addUpload(MultipartFile file) {
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
            uploadMapper.addUpload(new Upload(null,fileName,url));
            msg = "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public List<Upload> getAllFile() {
        return uploadMapper.getAllFile();
    }
}
