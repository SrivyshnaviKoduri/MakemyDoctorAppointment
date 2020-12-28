import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*; 
public class search extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
	              Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
                out.println("<html>");
                out.println("<body bgcolor=wheat>");
                out.println("<h1>Enter Doctor name need for your consultance:)</h1>");
                out.println("<form action='srchs' method=''>");
                out.println("<h2>Doctor Name</h2><input type='text' name='name'><br></br>");
                out.println("<input type='submit' value='Search'>");
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
