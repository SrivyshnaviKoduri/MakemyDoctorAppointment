import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class adminpage extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("uname"); 
    out.print("<html>");
    out.print("<body bgcolor=wheat>"); 
    out.print("<h1>Welcome "+n+"</h1>");
    out.print("<h2> Hey Admin! Hope you are doing well:)</h2>");
    out.print("<h3><a href='adminpv'>Check out Patient Details....here!</h3>");
    out.print("<h3><a href='admindv'>Check out Doctor Details.....here!</h3>");
    out.print("<h3><a href='logout'>Logout</h3>");
    out.print("</body>");
    out.print("</html>");
    out.close();  
    }  
  
} 