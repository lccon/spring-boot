package com.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @Date:2019/4/19
 * @Author:lc
 */
@Controller
@RequestMapping("/api")
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
