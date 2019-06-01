package com.lc.user.service.Impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lc.ticket.service.TickerService;
import com.lc.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/6/1
 * @Author:lc
 */
@Service
public class UserServiceImpl implements UserService {

    @Reference
    TickerService tickerService;

    public String getTickerInfo() {
        String tickerInfo = tickerService.getTickerInfo();
        return "买到票了：" + tickerInfo;
    }

}
