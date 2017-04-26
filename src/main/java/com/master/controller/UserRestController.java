package com.master.controller;

import com.master.user.IUserService;
import com.master.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mr.Cheng on 2017/4/26 0026.
 */
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    IUserService userService;

    @RequestMapping("")
    public List<User> all() {

        return userService.findAll();
    }
}