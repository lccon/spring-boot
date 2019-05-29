package com.lc.config;

import com.lc.domain.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * Description:
 *
 * @Date:2019/5/28
 * @Author:lc
 */

@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Department> serRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Department> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Department> ser = new Jackson2JsonRedisSerializer<Department>(Department.class);
        template.setDefaultSerializer(ser);
        return template;
    }


}
