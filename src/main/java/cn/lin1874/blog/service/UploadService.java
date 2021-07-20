package cn.lin1874.blog.service;

import cn.lin1874.blog.po.Upload;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/7/2 - 8:49
 */

public interface UploadService {

    Integer addUpload(MultipartFile file);

    List<Upload> getAllFile();

}
