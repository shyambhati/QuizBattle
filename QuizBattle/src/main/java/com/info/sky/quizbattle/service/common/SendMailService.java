package com.info.sky.quizbattle.service.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class SendMailService {
	

	  
 public static boolean sendOtp(String email,String sms) {
	 
		final String user=Config.emaildetails;//change accordingly
		final String password=Config.email_pass;//change accordingly
		
	    boolean flag=false; 
	    String host="smtp.gmail.com";
 
  
  String msg="Dear VEFR INDIA Application user,\n One Time Password to reset  your password. \n "
	 		+ "Your OPT is : "+sms
	 		+ "\nThis OTP is valid for one attempt or 10 mins only. Do not share it with anyone. \n "
	 		+ "In case you have not requested for the OTP, please contact VEFR INDAI TEAM ";
	 
 
   //Get the session object
   Properties props = new Properties();
   props.put("mail.smtp.host",host);
   props.put("mail.smtp.auth", "true");
   props.put("mail.smtp.starttls.enable", "true");
   props.put("mail.smtp.port", "587");
   props.setProperty("mail.smtp.debug", "true");
   
   Session session = Session.getDefaultInstance(props,
    new javax.mail.Authenticator() 
	   {
	      protected PasswordAuthentication getPasswordAuthentication() 
	      {
	    	  return new PasswordAuthentication(user,password);
	      }
	    });

   //Compose the message
    try 
    {
	     MimeMessage message = new MimeMessage(session);
	     message.setFrom(new InternetAddress(user));
	     message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
	     message.setSubject("VEFR INDIA - One Time Password");
	     /*message.setText("This is simple program of sending email ");*/
	     message.setText(msg);
	     
	    //send the message
	     Transport.send(message);
	     flag=true;
	     System.out.println("message sent successfully...");
 
     } 
    catch (MessagingException e) {e.printStackTrace();}
	return flag;
 }
 
 
 
}
