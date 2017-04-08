package com.lobin.base.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Send {
	public static void main(String... strings) {
		final String to = "lobin.tong@hotmail.com";
		final String from = "lobin.tong@hotmail.com";
		String host = "smtp-mail.outlook.com";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		
//		properties.put("mail.smtp.user",to);
		properties.put("mail.debug","true"); 
		properties.put("mail.smtp.starttls.enable","true"); 
		properties.put("mail.smtp.EnableSSL.enable","true");
		//在配置JavaMail的Properties事，不要指定“mail.smtp.socketFactory.class”，因为TLS使用的是普通的Socket。然后指定属性“mail.smtp.starttls.enable”为“true”。
//		properties.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		properties.setProperty("mail.smtp.socketFactory.fallback","false");   
		properties.setProperty("mail.smtp.port","587");
		
		
		Session session = Session.getDefaultInstance(properties,new Authenticator(){
			public PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(from,"*******");
			}
		});

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject("subject");
			msg.setText("text");
			Transport.send(msg);
			System.out.println("send ok");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
