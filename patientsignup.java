import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class patientsignup extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("uname");
    String a1=request.getParameter("age");
    int a=Integer.parseInt(a1);
    String p=request.getParameter("pwd");
    String h=request.getParameter("hr"); 
          
    if(patientsignupsql.insert(n,p,a,h)){
        RequestDispatcher rd=request.getRequestDispatcher("plogin.html");
        rd.forward(request,response);  
    }  
    else{ 
        out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h2><marquee>Sorry:(</marquee></h2>");
                    out.print("<h2>Oops!!! Something went wrong.<br>Try Signingup again:)</h2>");  
          out.println("</body>");
          out.println("</html"); 

        RequestDispatcher rd=request.getRequestDispatcher("psignup.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  