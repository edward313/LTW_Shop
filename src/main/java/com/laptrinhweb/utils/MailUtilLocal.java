package com.laptrinhweb.utils;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtilLocal {
	public static boolean sendMail(String host, String port,
	        final String email,final String password, String toAddress,
	        String subject, String message) throws MessagingException,AddressException {
	       
	        // 1 - get a mail session
	        Properties props = new Properties();
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", port);
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        
	        Authenticator auth = new Authenticator() {
	        	public PasswordAuthentication getPasswordAuthentication() { 
	  			  return new PasswordAuthentication(email, password); 
	        	}
	        };	        
	        Session session = Session.getInstance(props,auth);
	        
	        Message msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(email));
	        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
	        msg.setRecipients(Message.RecipientType.TO, toAddresses);
	        msg.setSubject(subject);
	        msg.setSentDate(new Date());
	        msg.setText(message);
	        try {
	        	Transport.send(msg);
	        }catch (Exception e) {
				return false;
			}
	        
	        return true;
	    }
	public static String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
	}
}
