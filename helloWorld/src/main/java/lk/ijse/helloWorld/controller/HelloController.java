package lk.ijse.helloWorld.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello") // http://localhost:8080/hello
    public String sayHello(){
        return "Hello Spring Boot";
    }
    @GetMapping("/write") // http://localhost:8080/write
    public String write(){
        return "Hello Spring Boot write";
    }
    @PostMapping("/hello") // http://localhost:8080/hello
    public String sayHello2(){
        return "Hello Spring Boot post";
    }
    @DeleteMapping("/hello") // http://localhost:8080/hello
    public String sayHello3(){
        return "Hello Spring Boot delete";
    }
}
