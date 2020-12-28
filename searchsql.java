import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*;
import java.text.*; 
public class searchsql extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        String query = "select * from doctordb where name=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            String d=request.getParameter("name");
            pstmt.setString(1,d);
            System.out.println(d);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
              out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h2><marquee>Book an Appointment with your Doctor!</marquee></h2>");
           out.println("<h1>YAYYY!Doctor Available!!!!:)</h1>");
                   out.print("<h2><a href='logout'>Logout</h2>");
          out.println("</body>");
          out.println("</html");
             
            }
            else
            {
              out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h2><marquee>Try our other expert Doctors!</marquee></h2>");
           out.println("<h1>!!Sorry:(We don't have a registered doctor!!</h1>");
           
          out.println("</body>");
          out.println("</html");
             
            }
       pstmt.close();
      }
       catch(Exception e)
        { out.println(e);
        }

    }  
}  
