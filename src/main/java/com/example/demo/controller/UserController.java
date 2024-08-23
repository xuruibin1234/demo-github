package com.example.demo.controller;

import com.example.demo.common.enums.UserErrorEnums;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.UserDto;
import com.example.demo.service.IUserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuruibin
 * @since 2024-08-22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/updateUserById")
    public UserDto updateUserById(@RequestBody User user) {
        UserDto result = userService.updateUserById(user);
        return result;
    }

    @GetMapping("/demo")
    public void handle(
            @RequestHeader("Accept-Encoding") String encoding,
            @RequestHeader("Keep-Alive") long keepAlive) {
        System.out.println(encoding);
        System.out.println(keepAlive);
        //...
    }
}
