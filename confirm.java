import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import  java.time.LocalDate;
import java.text.*;
public class confirm extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        ServletContext sc=getServletContext();
            String name=(String)sc.getAttribute("name");
            sc.setAttribute("dname",name);
        String nam[]=request.getParameterValues("cb");
        List list = Arrays.asList(nam);
        request.setAttribute("names", list);
        List<String> names=(List<String>)request.getAttribute("cb");
        System.out.println("hiii"+names);
        RequestDispatcher rd = request.getRequestDispatcher("confirmsql");
        rd.forward(request, response);
      }
       catch(Exception e)
       {
       System.out.println(e);
         out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h1>Oops!Got some error:(</h1>");
             out.print("<h2><a href='logout'>Logout</h2>");
          out.println("</body>");
          out.println("</html");
        }

    }  
}  
