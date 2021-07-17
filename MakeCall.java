import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

public class MakeCall extends HttpServlet {
    
    public static final String ACCOUNT_SID = "Add Accound SID here";
    public static final String AUTH_TOKEN = "Add Token here";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, URISyntaxException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            String from = "+18646252400";
            String to = "+91750******";

            Call call;
            call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
                    new URI("http://demo.twilio.com/docs/voice.xml")).create();
        System.out.println(call.getSid());
        }
    }
}
