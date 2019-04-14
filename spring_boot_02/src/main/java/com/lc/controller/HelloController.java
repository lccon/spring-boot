package com.lc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @Date:2019/4/14
 * @Author:lc
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @Value("${person.name}")
    private String name;

    @RequestMapping("/hello")
    public String hello() {
        return "hello "+name;
    }
}
