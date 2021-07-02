package cn.lin1874.blog.service;


import cn.lin1874.blog.po.Links;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/28 - 22:20
 */

public interface LinksService {

    List<Links> getAllLinks();

    Integer addLinks(Links links);

    Integer deleteLinksById(Integer id);

    Links getLinksById(Integer id);

    Integer updateLinks(Links links);
}
