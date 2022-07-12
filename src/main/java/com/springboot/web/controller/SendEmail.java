package com.springboot.web.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public static void main(String[] args) {
		String subject = "Opsnece Technologies";
		String from = "rutikthummar15@gmail.com";
		String to = "vasoyam44@gmail.com";
		sendEmail(from,to,subject );
	}

	private static void sendEmail( String from, String to,String subject ) {
		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.auth", true);

		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "oofzivnnylamhvfk");
			}
		});
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(from);
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			String html = "<h1>Welcome.........</h1>";
			msg.setText(html, "UTF-8", "html");
			Transport.send(msg);
			System.out.println("sent success........");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
