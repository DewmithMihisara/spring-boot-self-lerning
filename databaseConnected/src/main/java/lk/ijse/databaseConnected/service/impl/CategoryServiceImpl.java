package lk.ijse.databaseConnected.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.databaseConnected.repository.CategoryRepository;
import lk.ijse.databaseConnected.service.CategoryService;
import lk.ijse.databaseConnected.entity.Categories;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Categories> getAllCategorys() {
        return categoryRepository.findAll();
    }

    @Override
    public Categories createCategory(Categories category) {
        return categoryRepository.save(category);
    }

    @Override
    public Categories getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Categories updateCategory(Long id, Categories category) {
        Categories existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }
    
}
