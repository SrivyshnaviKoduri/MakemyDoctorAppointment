import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*;
import java.time.format.DateTimeFormatter;
import  java.time.LocalDate;
import java.text.*;
public class booked extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        Statement st=con.createStatement(); //creating statement 
        String n=request.getParameter("uname");
        String s = request.getParameter("doapp"); 
        System.out.println(s);
        java.util.Date d1=new SimpleDateFormat("yyyy-mm-dd").parse(s); 
        java.sql.Date d=new java.sql.Date(d1.getTime());
        String t=request.getParameter("time");
        String doc=request.getParameter("dname");
        PreparedStatement ps2=con.prepareStatement(  
          "insert into patientsregistered values(?,?,?,?,'no')");  
        ps2.setString(1,n);  
        ps2.setDate(2,d);
        ps2.setString(3,t);
        ps2.setString(4,doc);  
        System.out.println(n+" "+" "+t+" "+doc); 
          ps2.executeUpdate();
           PreparedStatement ps1=con.prepareStatement(  
          "insert into registered values(?,?,?,?,'no')");  
        ps1.setString(1,n);  
        ps1.setDate(2,d);
        ps1.setString(3,t);
        ps1.setString(4,doc);  
        System.out.println(n+" "+" "+t+" "+doc); 
          ps1.executeUpdate();
          out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h2><marquee>Booking Succesfull:)</marquee></h1>");
          out.println("<h1>Be on time in the Hospital</h1>");
             out.print("<h2><a href='logout'>Logout</h2>");
          out.println("</body>");
          out.println("</html");
      }
       catch(Exception e)

        { System.out.println(e); 
          out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h2><marquee>Booking Unsuccessfull:(</marquee></h1>");
          out.println("<h1>Trying signing in once again!</h1>");
             out.print("<h2><a href='logout'>Logout</h2>");
          out.println("</body>");
          out.println("</html");
        }

    }  
}  
