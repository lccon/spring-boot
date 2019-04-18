package com.lc;

import org.apache.juli.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03ApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {

       /* logger.trace("1");
        logger.debug("2");
        logger.info("3");
        logger.warn("4");
        logger.error("5");*/

    }

}
