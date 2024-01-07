package lk.ijse.databaseConnected.service.impl;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.databaseConnected.dto.ProductDTO;
import lk.ijse.databaseConnected.entity.Categories;
import lk.ijse.databaseConnected.entity.Product;
import lk.ijse.databaseConnected.repository.CategoryRepository;
import lk.ijse.databaseConnected.repository.ProductRepository;
import lk.ijse.databaseConnected.service.ProductService;
@Service
public class ProducrServiceImpl implements ProductService{
     @Autowired
    private ProductRepository productRepository;

    @Autowired 
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Categories category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);

        if(category != null) {
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setQtty(productDTO.getQtty());
            product.setCategory(category);
            
            return productRepository.save(product);
        } else {
            return null;
        }

        
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if(existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQtty(product.getQtty());
            
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getProductsByCategory(Long id) {
        Categories category = categoryRepository.findById(id).orElse(null);

        if(category != null) {
            return productRepository.findProductsByCategory(category);
        } else {
            return null;
        }
    }
}
