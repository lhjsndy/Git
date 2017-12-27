package com.offcn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.offcn.bean.Mail;

public class SimpleMailSend {

	public static void main(String[] args) {
		
		//��ʼ��spring����
		ApplicationContext context = new ClassPathXmlApplicationContext("mail.xml");
		
		//��ȡmailSender�ʼ�������
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");
		//�����ʼ�����ʵ�����
		Mail mail = new Mail();
		mail.setFrom("lhj_941225@163.com");
		mail.setTo("15313876993@163.com");
		mail.setSubject("���ǻ����ʼ�");
		mail.setContent("�ѷ���������,�㿴զ��?");
		
		//�������ı��ʼ�����
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getFrom());
		message.setTo(mail.getTo());
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		
		//�����ʼ�
		mailSender.send(message);
		
		System.out.println("�����ʼ����ͳɹ���");
	}
}
