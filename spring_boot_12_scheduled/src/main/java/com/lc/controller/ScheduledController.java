package com.lc.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 *
 * @Date:2019/5/27
 * @Author:lc
 */
@Component
public class ScheduledController {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    // 每三秒执行一次
    @Scheduled(fixedDelay = 3000)
    public void test() {
        System.out.println(sdf.format(new Date()));
    }

    //第一次延迟1秒执行，当执行完后3秒再执行
    @Scheduled(initialDelay = 2000, fixedDelay = 3000)
    public void timerInit() {
        System.out.println("init : " + sdf.format(new Date()));
    }

    // 每天的11:10执行
    //@Scheduled(cron = "00 38 19 * * ?")
    //@Scheduled(cron = "0 * * * * *") //每分钟执行一次
    @Scheduled(cron = "0/5 * * 3 * ?") //每个月的第三天每五秒执行一次，星期与天冲突用？代替
    public void test2() {
        System.out.println("current time" + sdf.format(new Date()));
    }
}
