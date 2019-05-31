package com.lc.service.Impl;

import com.lc.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Date:2019/5/31
 * @Author:lc
 */
@Service
public class AsyncServiceImpl implements AsyncService{

    @Async
    @Override
    public void getConentInfo() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步处理");
    }
}
