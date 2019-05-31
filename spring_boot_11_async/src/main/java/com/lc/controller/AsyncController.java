package com.lc.controller;

import com.lc.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @Date:2019/5/31
 * @Author:lc
 */
@Controller
@RequestMapping("/api")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        asyncService.getConentInfo();
        return "HelloWorld";
    }
}
