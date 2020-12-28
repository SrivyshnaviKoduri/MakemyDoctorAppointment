import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class adminloginvalidate extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("uname");  
    String p=request.getParameter("pwd"); 
          
    if(adminloginsql.validate(n, p)){  
        RequestDispatcher rd=request.getRequestDispatcher("adminp");  
        rd.forward(request,response);  
    }  
    else{  
        out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h2><marquee>Sorry! Invalid Credentials</marquee></h2>");
           out.println("<h1>!!Try signing in again!!</h1>");
          out.println("</body>");
          out.println("</html");  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  