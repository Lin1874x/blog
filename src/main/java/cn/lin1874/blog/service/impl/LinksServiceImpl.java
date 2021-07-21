package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.mapper.LinksMapper;
import cn.lin1874.blog.po.Links;
import cn.lin1874.blog.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/28 - 22:21
 */
@Service
@Transactional
public class LinksServiceImpl implements LinksService {

    @Autowired
    LinksMapper linksMapper;

    @Override
    public List<Links> getAllLinks() {
        List<Links> links = linksMapper.getAllLinks();
        links.stream().forEach((link) -> {
            if (link.getPic() == null || link.getPic().equals("")) {
                link.setPic("/site/assets/default-avatar.png");
            }
        });
//        for (Links link : links) {
//            if (link.getPic() == null || link.getPic().equals("")) {
//                link.setPic("/site/assets/default-avatar.png");
//            }
//        }
        return links;
    }

    @Override
    public Integer addLinks(Links links) {
        return linksMapper.addLinks(links);
    }

    @Override
    public Integer deleteLinksById(Integer id) {
        return linksMapper.deleteLinksById(id);
    }

    @Override
    public Links getLinksById(Integer id) {
        return linksMapper.getLinksById(id);
    }

    @Override
    public Integer updateLinks(Links links) {
        return linksMapper.updateLinks(links);
    }
}
