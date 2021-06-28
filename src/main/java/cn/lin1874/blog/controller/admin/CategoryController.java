package cn.lin1874.blog.controller.admin;

import cn.lin1874.blog.po.Categories;
import cn.lin1874.blog.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lin1874
 * @date 2021/6/22 - 17:53
 */
@Controller
public class CategoryController {

    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/_admin/do/category/delete")
    public String doCategoryDelete(@RequestParam("id") Integer id) {
        categoriesService.deleteCategoryById(id);
        return "redirect:/_admin/to/category";
    }

    @PostMapping("/_admin/do/category/save")
    public String doCategoryUpdate(Categories categories) {
        if (categories.getId() == null) {
            categoriesService.addCategories(categories);
        } else {
            categoriesService.updateCategories(categories);
        }
        return "redirect:/_admin/to/category";
    }

    @GetMapping("/_admin/to/category")
    public String toAdminCategory(Model model){
        List<Categories> allCategories = categoriesService.getAllCategories();
        model.addAttribute("categories",allCategories);
        return "_admin/category";
    }
}
