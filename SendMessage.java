import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SendMessage extends HttpServlet {
    
    public static final String ACCOUNT_SID = "SID from twillio";
    public static final String AUTH_TOKEN = "Token from twilio";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+9198*****"),
new com.twilio.type.PhoneNumber("+186********"),
                "HEllO! Thanks For Running My Code.")
            .create();
            System.out.println(message.getSid());
        }
    }
}
