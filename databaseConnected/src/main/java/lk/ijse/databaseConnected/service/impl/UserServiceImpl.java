package lk.ijse.databaseConnected.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.ijse.databaseConnected.dto.UserPasswordDTO;
import lk.ijse.databaseConnected.entity.User;
import lk.ijse.databaseConnected.repository.UserRepository;
import lk.ijse.databaseConnected.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

  
    public User changePassword(Long id, UserPasswordDTO userPasswordDTO) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setPassword(userPasswordDTO.getPassword());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
