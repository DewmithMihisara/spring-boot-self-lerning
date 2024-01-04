package lk.ijse.databaseConnected.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.databaseConnected.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
