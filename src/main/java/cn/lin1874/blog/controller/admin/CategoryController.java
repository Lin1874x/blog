package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.service.CategoriesService;
import cn.lin1874.blog.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 17:53
 */
@RestController
public class CategoryController {

    @Autowired
    CategoriesService categoriesService;

    /**
     * 获取所有分类信息
     * @return
     */
    @GetMapping("/_admin/do/category/list")
    public ResultEntity<List<Categories>> doCategoryList() {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,categoriesService.getAllCategories());
    }

    /**
     * 分类删除
     * @param id
     * @return
     */
    @GetMapping("/_admin/do/category/delete")
    public ResultEntity doCategoryDelete(@RequestParam("id") Integer id) {
        categoriesService.deleteCategoryById(id);
        return new ResultEntity(ResultEntity.SUCCESS,"删除成功",null);
    }

    /**
     * 分类保存
     * @param categories
     * @return
     */
    @PostMapping("/_admin/do/category/save")
    public ResultEntity doCategorySave(Categories categories) {
        return categoriesService.saveCategory(categories);
    }

}
