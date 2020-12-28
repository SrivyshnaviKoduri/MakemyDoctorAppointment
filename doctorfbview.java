import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*; 
public class doctorfbview extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
	       Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");	
            String query = "select * from feedback where name=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            ServletContext sc=getServletContext();
            String d=(String)sc.getAttribute("dname");
            pstmt.setString(1,d);
            System.out.println(d);
              ResultSet rs=pstmt.executeQuery();	//executing statement	
                out.println("<HTML>");
		            out.println("<BODY BGCOLOR=wheat>");
                out.println("<h2>"+d+"'s Feedback</h2>");
                out.println("<table style='font-family:'Courier New', Courier, monospace; font-size:80%'><tr><td><h2>Feedback</h2></td><td><h2>PatientName</h2></td></tr>");
                
		while(rs.next()){
                 out.println("<tr>");
                 out.println("<h3><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></h3>");
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
