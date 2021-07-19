package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.mapper.CategoriesMapper;
import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 11:23
 */
@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoriesMapper categoriesMapper;

    @Override
    @Transactional
    public List<Categories> getAllCategories() {
        return categoriesMapper.getAllCategories();
    }

    @Override
    public Integer updateCategories(Categories categories) {
        return categoriesMapper.updateCategories(categories);
    }

    @Override
    public Integer addCategories(Categories categories) {
        return categoriesMapper.addCategories(categories);
    }

    @Override
    public Integer deleteCategoryById(Integer id) {
        return categoriesMapper.deleteCategoryById(id);
    }

    @Override
    public Categories getCategoriesById(Integer id) {
        return categoriesMapper.getCategoriesById(id);
    }


}
