package lk.ijse.databaseConnected.repository;

import lk.ijse.databaseConnected.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long>{
    
}
