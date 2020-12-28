import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*; 
public class feedback extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                  Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
                     String query = "select * from patientsregistered where name=?";
                     PreparedStatement pstmt = con.prepareStatement(query);
                     ServletContext sc=getServletContext();
                    String p=(String)sc.getAttribute("pname");
                    pstmt.setString(1,p);
               System.out.println(p);
                ResultSet rs=pstmt.executeQuery();
                out.println("<html>");
                out.println("<body bgcolor=wheat>");
                out.println("<form action='fbs' method=''>");
                out.println("<h3>Feedback</h3><input type='textarea' name='fb'><br></br>");
                out.println("<h3>Your Name</h3><input type='text' name='name'><br></br>");
                out.println("<label for='Doctor'><h3>Choose your Doctor:</h3></label>");
                out.println("<select id='dn' name='dname'>");
                      while(rs.next())
                      {
                        String i=rs.getString(4);
                        out.println("<option value="+i+">"+i+"</option>");
                      }
                      out.println("</select>");
                out.println("<input type='submit' value='submit'>");
                out.println("</form>");
                   out.print("<h2><a href='logout'>Logout</h2>");
                out.println("</BODY>");
                out.println("</html>");
                out.close();  
      }
       catch(Exception e)
        { out.println(e);
        }

    }  
}  
