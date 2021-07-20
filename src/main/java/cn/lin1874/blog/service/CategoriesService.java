package cn.lin1874.blog.service;

import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.utils.ResultEntity;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 11:23
 */

public interface CategoriesService {
    /**
     * 获取所有分类
     * @return
     */
    List<Categories> getAllCategories();

    /**
     * 修改分类
     * @param categories
     * @return
     */
    Integer updateCategories(Categories categories);

    /**
     * 添加分类
     * @param categories
     * @return
     */
    Integer addCategories(Categories categories);

    /**
     * 删除分类
     * @param id
     * @return
     */
    Integer deleteCategoryById(Integer id);

    /**
     * 根据分类id查询分类
     * @param id
     * @return
     */
    Categories getCategoriesById(Integer id);

    /**
     * 保存categories
     * @param categories
     * @return
     */
    ResultEntity saveCategory(Categories categories);
}
