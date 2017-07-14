package contact.service;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class MailService extends Authenticator {
	class MyAuthentication extends Authenticator {
		PasswordAuthentication pa;

		public MyAuthentication() {
			pa = new PasswordAuthentication("contact@ssungkim.com", "bluecat0720!"); //ex) ID:cafe24@cafe24.com PASSWD:1234
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return pa;
		}
	}
	
	public boolean mailSend(String title, String contact, String content){
		String host = "smtp.cafe24.com"; //smtp mail server      
		String from = contact; //sender email address
		String recieve = "contact@ssungkim.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		
		Authenticator auth = new MyAuthentication();
		Session sess = Session.getInstance(props, auth);
		
		try {
			Message msg = new MimeMessage(sess);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(recieve) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(title);
			msg.setSentDate(new Date());
			msg.setText(content);
			
			Transport.send(msg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
