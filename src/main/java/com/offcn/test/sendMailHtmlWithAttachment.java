package com.offcn.test;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.offcn.bean.Mail;

public class sendMailHtmlWithAttachment {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("mail.xml");

		JavaMailSenderImpl mailSender = (JavaMailSenderImpl) context.getBean("mailSender");

		Mail mail = new Mail();
		mail.setFrom("lhj_941225@163.com");
		mail.setTo("15313876993@163.com");
		mail.setSubject("���ǻ����ʼ�");
		mail.setContent("�ѷ���������,�㿴զ��?");

		// �������������ʼ����ݶ���
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());
		helper.setSubject(mail.getSubject());
		helper.setText(
				"<html><META http-equiv=Content-Type content='text/html; charset=GBK'><body>" + "<img src='cid:Coupon'>"
						+ "<h4>" + "���Դ�������Html�ʼ�" + " says...</h4>" + "<i>" + "��������2" + "</i>" + "</body></html>",
				true);

		// �����������������λ��λ��java-->resourcesĿ¼)���ɸ�����Ҫ��ӻ��޸�
		ClassPathResource image = new ClassPathResource("c.jpg");
		helper.addAttachment("c.jpg", image);

		// �����ʼ�
		mailSender.send(message);

		System.out.println("�����ʼ����ͳɹ���");
	}

}
