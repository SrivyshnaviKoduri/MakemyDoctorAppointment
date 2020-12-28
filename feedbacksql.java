import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*;
import java.text.*; 
public class feedbacksql extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        String query = "insert into feedback values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            String d=request.getParameter("dname");
            String f=request.getParameter("fb");
            String n=request.getParameter("name");
            pstmt.setString(1,d);
            pstmt.setString(2,f);
             pstmt.setString(3,n);
            System.out.println(d);
            pstmt.executeQuery();
               out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h2><marquee>Feedback Successfull!</marquee></h2>");
           out.println("<h1>Thank you for your time:)</h1>");
              out.print("<h2><a href='logout'>Logout</h2>");
          out.println("</body>");
          out.println("</html");
       pstmt.close();
       out.close();
      }
       catch(Exception e)
        {
          System.out.println(e);
         out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h2><marquee>Sorry:(</marquee></h2>");
          out.println("<h1>A problem encountered at our side</h1>");
             out.print("<h2><a href='logout'>Logout</h2>");
          out.println("</body>");
          out.println("</html");
        }

    }
    }    
