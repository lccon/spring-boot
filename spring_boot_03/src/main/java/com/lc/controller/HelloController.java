package com.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @Date:2019/4/17
 * @Author:lc
 */
@Controller
@RequestMapping("/api")
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        String aa = "33";
        String content = aa.substring(0, aa.length() - 2);
        System.out.println(content);
        return content;
    }

}
