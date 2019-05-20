package com.lc.controller;

import com.lc.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @Date:2019/5/20
 * @Author:lc
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        String sayHello = helloService.sayHello("阿聪");
        return sayHello;
    }
}
