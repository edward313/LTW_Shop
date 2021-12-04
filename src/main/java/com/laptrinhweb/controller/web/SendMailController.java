package com.laptrinhweb.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/send-mail"})
public class SendMailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String username = "lagiaphong.2001phong@gmail.com";
		final String password = "lagiaphong";
		Properties props = new Properties();
		/*props.put("mail.transport.protocol", "smtp");
		
        
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");*/
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable", "true");   
		//props.setProperty("mail.smtp.host", "smtp.gmail.com");
		//props.setProperty("mail.user", username);
		//props.setProperty("mail.password", password);
		//props.put("mail.smtp.host", "smtp.gmail.com");
		
		//props.put("mail.smtp.auth", "false");
		//props.setProperty("mail.smtp.ssl.enable", "true");
		//props.setProperty("mail.transport.protocol", "smtps");
        
     
        
        
        //props.put("mail.debug", "true");
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() { 
			  return new PasswordAuthentication(username, password); } 
		});
		//Session session = Session.getDefaultInstance(props);
		 
        session.setDebug(true);
		String emailTo = "19119208@student.hcmute.edu.vn";
		String emailSubject = "WELCOME TO MY DEMO SEND EMAIL";
		String emailContent = "DAY LA EMAIL CONTENT NHE";
		try {
			Message message = new MimeMessage(session);
	        message.setSubject(emailSubject);
	        message.setText(emailContent);
	        message.setFrom(new InternetAddress(username));
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));			
			Transport.send(message); 
			System.out.println("DONE");
			 
		}catch (Exception e) { 
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
