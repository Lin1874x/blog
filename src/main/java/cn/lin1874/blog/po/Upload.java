package cn.lin1874.blog.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lin1874
 * @date 2021/7/2 - 8:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("文件上传信息类")
public class Upload {

    @ApiModelProperty("文件id")
    private Integer id;

    @ApiModelProperty("文件名称")
    private String fileName;

    @ApiModelProperty("文件访问地址")
    private String url;
}
