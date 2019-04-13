package com.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @Date:2019/4/13
 * @Author:lc
 */
@Controller
@RequestMapping("/api")
public class HelloSpringBoot {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello Spring Boot";
    }
}
