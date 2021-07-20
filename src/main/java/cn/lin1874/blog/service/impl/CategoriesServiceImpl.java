package cn.lin1874.blog.service.impl;

import cn.lin1874.blog.mapper.CategoriesMapper;
import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.service.CategoriesService;
import cn.lin1874.blog.utils.ResultEntity;
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
//        try {
            return categoriesMapper.updateCategories(categories);
//        } catch (Exception e) {
//            throw new Exception("分类名已存在");
//        }
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

    @Override
    public ResultEntity saveCategory(Categories categories) {
        if (categories.getId() == null) {
            addCategories(categories);
            return new ResultEntity(ResultEntity.SUCCESS,"添加成功",null);
        } else {
            updateCategories(categories);
            return new ResultEntity(ResultEntity.SUCCESS,"更新成功",null);
        }
    }


}
