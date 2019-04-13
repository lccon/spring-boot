package com.lc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description: 标注主程序类，说明是一个SpringBoot类
 *
 * @Date:2019/4/13
 * @Author:lc
 */
@SpringBootApplication
public class HelloSpringBootApplication {
    public static void main(String[] args) {
        //spring应用启动起来
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }
}
