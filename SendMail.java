import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/SendMail"})
public class SendMail {
    public static void send(String to, String sub, 
                         String msg, final String user,final String pass)
    {  
    Properties props = new Properties();
    
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");		
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    Session session = Session.getInstance(props,new javax.mail.Authenticator()
    {
            @Override
  	  protected PasswordAuthentication getPasswordAuthentication() 
  	  {
  	 	 return new PasswordAuthentication(user,pass);
  	  }
   }); 
   try
   {
    MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress(user));
       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
       message.setSubject(sub);
       message.setText(msg);

       Transport.send(message);
    }
    catch(Exception e)
    {
    	 e.printStackTrace();
    }
  }
}
