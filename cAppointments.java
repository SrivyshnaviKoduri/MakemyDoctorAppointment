import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*; 
public class cAppointments extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        String query = "select * from cpatientsregistered where name=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            ServletContext sc=getServletContext();
            String p=(String)sc.getAttribute("pname");
            pstmt.setString(1,p);
            System.out.println(p);
                ResultSet rs=pstmt.executeQuery();
                out.println("<html>");
        out.println("<BODY BGCOLOR=wheat>");
    out.println("<h1> My Appointments </h1>");
                out.println("<table style='font-family:'Courier New', Courier, monospace; font-size:80%'><h2><tr><td>Doctor Name</td><td>Date</td><td>Time</td></h2></tr>");
     
        while(rs.next()){
                 out.println("<tr>");
                 out.println("<td>"+rs.getString(4)+"</td><td>"+rs.getDate(2)+"</td><td>"+rs.getString(3)+"</td>");
                 out.println("</tr>");
                  }
                out.println("</table>");
                   out.print("<h2><a href='logout'>Logout</h2>");
        out.println("</BODY>");
        out.println("</HTML>");
                rs.close(); 
                pstmt.close();
                out.close();  
      }
       catch(Exception e)
        { out.println(e);
        }

    }  
} 