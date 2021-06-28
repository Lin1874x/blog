package cn.lin1874.blog.mapper;

import cn.lin1874.blog.po.Categories;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 11:24
 */
@Mapper
public interface CategoriesMapper {
    List<Categories> getAllCategories();

    Integer addCategories(Categories categories);

    Integer updateCategories(Categories categories);

    Integer deleteCategoryById(@Param("id") Integer id);

    Categories getCategoriesById(Integer id);
}
