package com.example.producer.web.rest;

import com.example.producer.domain.User;
import com.example.producer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springboot
 * @description: 用于系统接口有效测试
 * @author: liujc
 * @create: 2018-06-13 16:58
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public void createUser(@RequestBody User user) {
        System.out.println(userService.save(user));
    }

    @GetMapping("/add-user")
    public void addUser( User user) {
        System.out.println(userService.save(user));
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello world!";
    }

    @GetMapping("/")
    public String welcomeSpringBoot() {
        return "welcome spring boot!";
    }

    @Autowired
    private Environment environment;

    @Value("${spring.application.name}")
    String bar;

    @GetMapping("/config")
    public String getConfigInfo() {
        System.out.println(bar);
        return environment.getProperty("spring.application.name");
    }
}
