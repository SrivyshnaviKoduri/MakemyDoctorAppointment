import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import  java.time.LocalDate;
import java.text.*;
public class confirmsql extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        List<String> nam=(List<String>)request.getAttribute("names");
        ServletContext sc=getServletContext();
            String name=(String)sc.getAttribute("dname");
        System.out.println("hiii"+nam);
        for(String n:nam)
        {
          System.out.println(n+"for loop");
          String q="update patientsregistered set checked='yes' where time=?";
          PreparedStatement p=con.prepareStatement(q);
          p.setString(1,n);
          p.executeUpdate();
        }
       Statement st=con.createStatement(); //creating statement 
           String query = "select * from patientsregistered where checked='yes'";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();
            System.out.println("executing query");
            while(rs.next())
            {
              System.out.println("name"+rs.getString(1)+"date"+rs.getDate(2)+"time"+rs.getString(3)+"doctorname"+rs.getString(4));
        PreparedStatement ps2=con.prepareStatement(  
        "insert into cpatientsregistered values(?,?,?,?)");  
        ps2.setString(1,rs.getString(1));  
        ps2.setDate(2,rs.getDate(2));
        ps2.setString(3,rs.getString(3));
        ps2.setString(4,rs.getString(4));  
         ps2.executeUpdate();
            } 
            System.out.println(name);
            String q1="delete from patientsregistered where doctorname=?";
         PreparedStatement p= con.prepareStatement(q1);
         p.setString(1,name);
         p.executeUpdate();
          out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h1>Confirmed your Bookings</h1>");
             out.print("<h2><a href='logout'>Logout</h2>");
          out.println("</body>");
          out.println("</html");
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
