package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.service.CategoriesService;
import cn.lin1874.blog.utils.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 17:53
 */
@Api(tags = "文章分类模块")
@RestController
public class CategoryController {

    @Autowired
    CategoriesService categoriesService;

    @ApiOperation(value = "获取所有分类信息")
    @GetMapping("/_admin/do/category/list")
    public ResultEntity<List<Categories>> doCategoryList() {
        return new ResultEntity<>(ResultEntity.SUCCESS,null,categoriesService.getAllCategories());
    }

    @ApiOperation(value = "删除分类")
    @GetMapping("/_admin/do/category/delete")
    public ResultEntity doCategoryDelete(@RequestParam("id") Integer id) {
        categoriesService.deleteCategoryById(id);
        return new ResultEntity(ResultEntity.SUCCESS,"删除成功",null);
    }

    @ApiOperation(value = "分类的保存和添加")
    @PostMapping("/_admin/do/category/save")
    public ResultEntity doCategorySave(Categories categories) {
        return categoriesService.saveCategory(categories);
    }

}
