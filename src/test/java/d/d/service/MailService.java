package d.d.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.UUID;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MailService {

	@Test
	public void test() throws MessagingException {

		for (int i = 95; i < 1000; i++) {

			// 创建MailSender
			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			sender.setHost("smtp.aliyun.com");
			// 25常规 465 ssl加密
			sender.setPort(465);
			sender.setUsername("bzlllwe@aliyun.com");
			//手动解密
			sender.setPassword("wo1227");
			sender.setProtocol("smtp");
			sender.setDefaultEncoding("UTF-8");
			// 加认证机制
			Properties properties = new Properties();
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.timeout", "5000");

			properties.put("mail.smtp.connectiontimeout", "2000");

			sender.setJavaMailProperties(properties);

			// 创建邮件内容
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(new InternetAddress("bzlllwe@aliyun.com"));

			helper.setTo("bzlllwe@163.com");
			helper.setSubject(UUID.randomUUID().toString());
			helper.setText(UUID.randomUUID().toString(), true);
			// 发送邮件
			sender.send(message);

			System.out.println("阿里云邮件成功发送数目：" + i);

		}


	}
}
