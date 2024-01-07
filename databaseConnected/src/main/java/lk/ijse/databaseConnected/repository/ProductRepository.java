package lk.ijse.databaseConnected.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.ijse.databaseConnected.entity.Categories;
import lk.ijse.databaseConnected.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findProductsByCategory(@Param("category") Categories category);
}
