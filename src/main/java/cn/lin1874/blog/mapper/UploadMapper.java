package cn.lin1874.blog.mapper;

import cn.lin1874.blog.po.Upload;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/7/2 - 8:50
 */
@Mapper
public interface UploadMapper {
    Integer addUpload(Upload upload);

    List<Upload> getAllFile();
}
