package lk.ijse.databaseConnected.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.databaseConnected.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
