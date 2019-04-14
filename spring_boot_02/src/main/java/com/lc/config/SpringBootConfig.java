package com.lc.config;

import com.lc.service.BootService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:指明当前类是一个配置类；就是替代spring的xml配置文件
 *
 * @Date:2019/4/14
 * @Author:lc
 */
@Configuration
public class SpringBootConfig {

    // 将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public BootService bootService() {
        return new BootService();
    }

}
