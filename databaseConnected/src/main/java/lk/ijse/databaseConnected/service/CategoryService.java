package lk.ijse.databaseConnected.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.databaseConnected.entity.Categories;

@Service
public interface CategoryService {
    List<Categories> getAllCategorys();
    Categories createCategory(Categories category);
    Categories getCategoryById(Long id);
    Categories updateCategory(Long id,Categories category);
    
}
