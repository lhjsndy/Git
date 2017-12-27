package com.offcn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.offcn.bean.Mail;

public class SimpleMailSend {

	public static void main(String[] args) {
		
		//初始化spring环境
		ApplicationContext context = new ClassPathXmlApplicationContext("mail.xml");
		
		//获取mailSender邮件发送类
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		//创建邮件发送实体对象
		Mail mail = new Mail();
		mail.setFrom("lhj_941225@163.com");
		mail.setTo("15313876993@163.com");
		mail.setSubject("这是婚恋邮件");
		mail.setContent("把凤姐许配给你,你看咋样?");
		
		//创建简单文本邮件对象
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getFrom());
		message.setTo(mail.getTo());
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		
		//发送邮件
		mailSender.send(message);
		
		System.out.println("测试邮件发送成功！");
	}
}
