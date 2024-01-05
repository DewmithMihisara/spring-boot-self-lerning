package lk.ijse.databaseConnected.service.impl;

import java.util.List;

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
    public Product createProduct(ProductDTO productdDto) {
        Categories categories=categoryRepository.findById(productdDto.getCategoryId()).orElse(null);

        if (categories == null) {
            Product product = new Product();
            product.setName(productdDto.getName());
            product.setPrice(productdDto.getPrice());
            product.setCategory(categories);
            product.setQtty(productdDto.getQtty());
            return productRepository.save(product);
        }else{
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
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            return productRepository.save(existingProduct);
        }
        return null;
    }
    @Override
    public List<Product> getProductByCategory(Long category) {
        Categories categories=categoryRepository.findById(category).orElse(null);

        if (categories!=null) {
            return productRepository.findByCategory(categories);
        }else{
            return null;
        }
    }
}
