package com.offcn.test;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.offcn.bean.Mail;

public class sendMailWithAttachment {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("mail.xml");

		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");

		Mail mail = new Mail();
		mail.setFrom("lhj_941225@163.com");
		mail.setTo("15313876993@163.com");
		mail.setSubject("这是婚恋邮件");
		mail.setContent("把凤姐许配给你,你看咋样?");

		// 创建带附件的邮件内容对象
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());
		helper.setText(mail.getContent());

		// 添加两个附件（附件位置位于java-->resources目录)，可根据需要添加或修改
		ClassPathResource image = new ClassPathResource("c.jpg");
		helper.addAttachment("c.jpg", image);

		// 发送邮件
		mailSender.send(message);

		System.out.println("测试邮件发送成功！");
	}
}
