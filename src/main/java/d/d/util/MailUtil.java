package d.d.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.UUID;

@Component
@Slf4j
public class MailUtil {

	JavaMailSenderImpl sender = new JavaMailSenderImpl();

	{
		// 创建MailSender
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
	}

	//需要开启enable，且只在容器管理的bean内生效。
//	@Scheduled(fixedRate = 10 * 1000)   //毫秒数，每10s一次，第一个没结束，阻塞后面的;fixedDelay,结束后n秒开始下一个；
//	@Scheduled(cron = "*/10 * * * * *")   //每10s一次
	public void send(){
		log.info("邮件构建");   //到发送失败需要20s,之前2s
//		// 创建MailSender
//		JavaMailSenderImpl sender = new JavaMailSenderImpl();
//		sender.setHost("smtp.aliyun.com");
//		// 25常规 465 ssl加密
//		sender.setPort(465);
//		sender.setUsername("bzlllwe@aliyun.com");
//		//手动解密
//		sender.setPassword("wo1227");
//		sender.setProtocol("smtp");
//		sender.setDefaultEncoding("UTF-8");
//		// 加认证机制
//		Properties properties = new Properties();
//		properties.put("mail.smtp.ssl.enable", "true");
//		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.timeout", "5000");
//
//		properties.put("mail.smtp.connectiontimeout", "2000");
//
//		sender.setJavaMailProperties(properties);

		// 创建邮件内容
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom(new InternetAddress("bzlllwe@aliyun.com"));

			helper.setTo("bzlllwe@163.com");
			helper.setSubject(UUID.randomUUID().toString());
			helper.setText(UUID.randomUUID().toString(), true);
			// 发送邮件
			sender.send(message);
		} catch (Exception e) {
			log.warn("阿里云邮件发送-失败");
			return;
		}

		log.info("阿里云邮件发送-成功");
	}

}
