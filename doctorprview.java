 import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*; 
public class doctorprview extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        String query = "select * from patientsregistered where doctorname=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            ServletContext sc=getServletContext();
            String d=(String)sc.getAttribute("dname");
            sc.setAttribute("name",d);
            pstmt.setString(1,d);
            System.out.println(d);
                ResultSet rs=pstmt.executeQuery();
                out.println("<html>");
		out.println("<BODY BGCOLOR=wheat>");
    out.println("<h1> Registered patients for "+d+"</h1>");
                out.println("<table style='font-family:'Courier New', Courier, monospace; font-size:80%'><h2><tr><td>Name</td><td>Date</td><td>Time</td></h2></tr>");
    out.print("<form action='./confirm' method='post'>");
    out.println("<table>");
    while(rs.next()){
                 out.println("<tr>");
                 out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getDate(2)+"</td><td>"+rs.getString(3)+"</td><td><input type='checkbox' name='cb' value="+rs.getString(3)+">confirm</td><td><input type='checkbox'>cancel</td>");
                out.println("</tr>");
               }
               out.println("</table>");
          out.print("<input type='submit' value='Confirm'>");
                out.print("</form>");
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