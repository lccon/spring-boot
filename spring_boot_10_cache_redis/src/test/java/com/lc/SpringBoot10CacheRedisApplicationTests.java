package com.lc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot10CacheRedisApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

    @Autowired
	private RedisTemplate<Object, Object> serRedisTemplate;

	@Test
	public void contextLoads() {
		//redisTemplate.opsForValue().append("hello1", "lisi11");
		//stringRedisTemplate.opsForValue().set("123", "123");
        //serRedisTemplate.opsForValue().append("hard", "奋斗");
        /*byte[] serByte = (byte[])serRedisTemplate.opsForValue().get("hard");
        System.out.println(serByte);*/
    }

}
