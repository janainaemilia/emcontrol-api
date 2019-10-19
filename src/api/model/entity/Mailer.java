package api.model.entity;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	
	public String sendMail(String email) {
		
		final String username = "teaam.inside@gmail.com";
		final String password = "314159265";
		
	    Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");	
		prop.put("mail.smtp.auth", "true");  
		prop.put("mail.smtp.port", "465");  // ou 587
		prop.put("mail.smtp.starttls.enable", "true");  
		prop.put("mail.smtp.socketFactory.port", "465");  // ou 587
		prop.put("mail.smtp.socketFactory.fallback", "false");  
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.debug", "true");		
		
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
	 	 
	    session.setDebug(true);
	 
	    try {
	    	
	    	int randomNumber = (int) Math.floor(Math.random() * 9999) + 1;
	    	String newPass = "AFGR" + randomNumber;
	    	
	    	Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("teaam.inside@gmail.com"));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(email)
	            );
	            
	            message.setSubject("EMControl - Recuperação de Senha");
	            
	            String content = "Uma senha previsória foi gerada para você: " + newPass
                		+ "\n\n Ao logar no sistema, recomendamos que altere sua senha.";	 
	            
	            message.setContent(content, "text/plain; charset=UTF-8");
	            
	            Transport.send(message);
	            
	            return newPass;
	     } catch (MessagingException e) {
	    	 System.out.println(e.getMessage());
	    	 return null;   
	     }
	  }
}
