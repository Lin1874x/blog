package cn.lin1874.blog.service;

import cn.lin1874.blog.po.Categories;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 11:23
 */

public interface CategoriesService {

    List<Categories> getAllCategories();

    Integer updateCategories(Categories categories);

    Integer addCategories(Categories categories);

    Integer deleteCategoryById(Integer id);

    Categories getCategoriesById(Integer id);
}
