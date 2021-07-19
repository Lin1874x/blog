package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.mapper.UploadMapper;
import cn.lin1874.blog.po.Upload;
import cn.lin1874.blog.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Integer addUpload(Upload upload) {
        return uploadMapper.addUpload(upload);
    }

    @Override
    public List<Upload> getAllFile() {
        return uploadMapper.getAllFile();
    }
}
