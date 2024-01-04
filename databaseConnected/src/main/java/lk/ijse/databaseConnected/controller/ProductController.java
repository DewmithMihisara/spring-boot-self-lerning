package lk.ijse.databaseConnected.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.databaseConnected.entity.Product;
import lk.ijse.databaseConnected.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/products/{id}")
    public Product updateProduct(@RequestBody Long id,@PathVariable Product product){
        return productService.updateProduct(id, product);
    }
}
