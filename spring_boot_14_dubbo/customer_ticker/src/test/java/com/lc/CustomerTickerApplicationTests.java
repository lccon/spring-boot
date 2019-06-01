package com.lc;

import com.lc.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTickerApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		String tickerInfo = userService.getTickerInfo();
		System.out.println(tickerInfo);
	}

}
