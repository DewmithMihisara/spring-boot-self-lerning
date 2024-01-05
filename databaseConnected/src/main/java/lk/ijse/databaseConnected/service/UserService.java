package lk.ijse.databaseConnected.service;

import java.util.List;
import org.springframework.stereotype.Service;

import lk.ijse.databaseConnected.dto.UserPasswordDTO;
import lk.ijse.databaseConnected.entity.User;

@Service
public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(Long id);
    User changePassword(Long id,UserPasswordDTO userPasswordDTO);
}
