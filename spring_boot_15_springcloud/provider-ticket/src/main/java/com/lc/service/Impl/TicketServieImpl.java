package com.lc.service.Impl;

import com.lc.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/6/1
 * @Author:lc
 */
@Service("ticketService")
public class TicketServieImpl implements TicketService {

    @Override
    public String getTicketInfo() {
        System.out.println("8530");
        return "7号房的礼物";
    }

}
