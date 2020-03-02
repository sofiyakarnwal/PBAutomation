package bu_pkg;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
//import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;



public class resultEmail {
	
	//String result;
	

	public void sendEmail(StringBuilder message, String testCaseName)
	{
		String userName = "qa119test@gmail.com";
		String pwd = "policy119";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "false");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.user", userName);
	    props.put("mail.smtp.password", pwd);
			    
	   // Session session = Session.getDefaultInstance(props);
		   
		  Session session = Session.getInstance(props, new javax.mail.Authenticator() 
		   {
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication(userName, pwd);
				}
		   });
		   
		   String to = "sofiya@policybazaar.com";
		   String cc= "qa119test@gmail.com , sofiya.karnwal@gmail.com";
		   
		   String from = userName;
		   String subject = testCaseName;
		   
		   Message msg = new MimeMessage(session);
		    try 
		    {
		      msg.setFrom(new InternetAddress(from));
		      msg.setRecipients(Message.RecipientType.TO , InternetAddress.parse(to, false));
		      msg.setRecipients(Message.RecipientType.CC , InternetAddress.parse(cc, false));
		      msg.setSubject(subject);
		      msg.setText(message.toString());
		           
		      Transport.send(msg);
		     
		    }		   
		    catch (AddressException ae) 
		    {	           
	        }
	        catch (MessagingException me)
		    {	 
	        	String excpMsg = me.getMessage();
	        	System.out.println(excpMsg);
	        	if(excpMsg != null) {}
	        	
	        		
	        }
		    catch (Exception excp)
		    {
		    	String excpMsg = excp.getMessage();
		    }
	}



}
