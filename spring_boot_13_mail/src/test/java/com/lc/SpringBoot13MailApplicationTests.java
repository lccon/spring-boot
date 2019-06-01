package com.lc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("qq")
public class SpringBoot13MailApplicationTests {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String userName;

	@Test
	public void testSendSimple() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(userName);
		message.setTo("1193429990@qq.com");
		message.setSubject("标题");
		message.setText("内容");
		javaMailSender.send(message);
	}

	@Test
	public void testSendByName() {
		MimeMessage mineMessage = null;
		try {
			mineMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mineMessage, true);
			helper.setFrom(new InternetAddress(userName, "阿聪", "UTF-8"));
			helper.setTo("1193429990@qq.com");
			helper.setSubject("标题：生态");
			StringBuilder sb = new StringBuilder();
			sb.append("<h1>内容1</h1>").append("<h2>内容2</h2>").append("<h3>内容3</h3>")
					.append("<h4>内容4</h4>").append("<h5>内容5</h5>").append("<h6>内容6</h6>");
			helper.setText(sb.toString(), true);
			/*helper.addAttachment("hello.jpg", new File("C:\\Users\\n-335\\Pictures\\Camera Roll\\QQ图片20180706170106.jpg"));
			helper.addAttachment("hi.jpg", new File("C:\\Users\\n-335\\Pictures\\Camera Roll\\鸡.jpg"));*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		javaMailSender.send(mineMessage);
	}

}
