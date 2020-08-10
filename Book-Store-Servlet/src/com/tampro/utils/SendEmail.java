package com.tampro.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void send(String to, String sub, String msg, final String username, final String password) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			Transport.send(message);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//send("xomrayno5@gmail.com", "xin chào", "hello word", "xomrayno1@gmail.com", "tam01229537538");
	}

}
