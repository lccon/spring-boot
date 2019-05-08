package com.lc;

import com.lc.domain.User;
import com.lc.service.UserService;
import com.lc.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot05ConnSqlApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setId(UUIDUtil.getUUID());
		user.setUserName("张三");
		user.setPassWord("123");
		userService.addUser(user);
	}

}
