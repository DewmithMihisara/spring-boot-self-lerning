package lk.ijse.databaseConnected.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.databaseConnected.dto.UserPasswordDTO;
import lk.ijse.databaseConnected.entity.User;
import lk.ijse.databaseConnected.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("/users/{id}/password")
    public ResponseEntity<User> changePassword(@PathVariable Long id,UserPasswordDTO uPasswordDTO){
        return ResponseEntity.ok().body(userService.changePassword(id, uPasswordDTO));
    }
}
