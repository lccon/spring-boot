package com.lc.ticket.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lc.ticket.service.TickerService;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Date:2019/6/1
 * @Author:lc
 */
@Component
@Service
public class TickerServiceImpl implements TickerService {

    @Override
    public String getTickerInfo() {
        return "<<何以为家>>";
    }
}
