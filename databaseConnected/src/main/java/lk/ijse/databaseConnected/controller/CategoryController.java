package lk.ijse.databaseConnected.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.databaseConnected.entity.Categories;
import lk.ijse.databaseConnected.service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/categorys")
    public List<Categories> getAllCategorys(){
        return categoryService.getAllCategorys();
    }

    @PostMapping("/categorys")
    public Categories createCategory(@RequestBody Categories category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/categorys/{id}")
    public Categories getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/categorys/{id}")
    public Categories updateCategory(@PathVariable Long id,@RequestBody Categories category){
        return categoryService.updateCategory(id, category);
    }
}
