package lk.ijse.databaseConnected.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.databaseConnected.dto.ProductDTO;
import lk.ijse.databaseConnected.entity.Product;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(ProductDTO productDTO);
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    List<Product> getProductsByCategory(Long id);
}
