package com.lc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ApplicationTests {

	@Autowired
    ApplicationContext ioc;

	@Test
	public void contextLoads() {
        boolean bootService = ioc.containsBean("bootService");
        System.out.println(bootService);
    }

}
