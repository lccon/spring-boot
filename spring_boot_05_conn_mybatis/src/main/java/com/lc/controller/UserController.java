package com.lc.controller;

import com.lc.domain.User;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @Date:2019/5/7
 * @Author:lc
 */
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public User addUser(User user) {
        return userService.addUser(user);
    }

}
