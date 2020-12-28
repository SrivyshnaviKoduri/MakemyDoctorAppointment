import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;   
  
public class patientpage extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("uname");
        ServletContext sc=getServletContext();
    sc.setAttribute("pname",n);
    out.println("<html>");
    out.print("<body bgcolor=wheat>");  
    out.print("<h1>Welcome "+n+"</h1>");
    out.print("<h2><a href='booking'>Book an Appointment</h2>");
    out.print("<h2><a href='fb'>Give a feedback</h2>");
    out.print("<h2><a href='srch'>Search for a Doctor!</h2>");
    out.print("<h2><a href='app'>View my Appointments</h2>");
    out.print("<h2><a href='capp'>Confirmed Appointments</h2>");
    out.print("<h2><a href='logout'>Logout</h2>");
    out.println("</body>");
    out.println("</html>");
    out.close();  
    }  
  
} 