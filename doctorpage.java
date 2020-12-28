import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;  
  
public class doctorpage extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("uname");
       System.out.println(n);
       ServletContext sc=getServletContext();
    sc.setAttribute("dname",n);
    out.print("<html>");
    out.print("<body bgcolor=wheat>");  
    out.print("<h1>Welcome "+n+"!</h1>");
    out.print("<h2><a href='profilepage'>Check out your profile here!</h2>");
    out.print("<h2><a href='dfbview'>Patient's Feedback</h2>");
    out.print("<h2><a href='dprview'>Registered Patient Details</h2>");
    out.print("<h2><a href='logout'>Logout</h2>");
    out.print("</body>");
    out.print("</html>");
    out.close();  
    }  
  
} 