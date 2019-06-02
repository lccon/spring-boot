package com.lc.controller;

import com.lc.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.Oneway;

/**
 * Description:
 *
 * @Date:2019/6/1
 * @Author:lc
 */
@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/ticket")
    @ResponseBody
    public String getTicketInfo() {
        return ticketService.getTicketInfo();
    }

}
