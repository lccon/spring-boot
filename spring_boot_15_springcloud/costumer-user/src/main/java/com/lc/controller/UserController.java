package com.lc.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 *
 * @Date:2019/6/1
 * @Author:lc
 */
@Controller
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/buy")
    @ResponseBody
    public String getTicketInfo(String name) {
        String tictket = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
        return name + "买到了："+tictket;
    }

}
