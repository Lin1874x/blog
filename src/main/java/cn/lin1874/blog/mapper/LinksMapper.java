package cn.lin1874.blog.mapper;

import cn.lin1874.blog.po.Links;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/28 - 22:21
 */
@Mapper
public interface LinksMapper {
    List<Links> getAllLinks();

    Integer addLinks(Links links);

    Integer deleteLinksById(Integer id);

    Links getLinksById(Integer id);

    Integer updateLinks(Links links);
}
