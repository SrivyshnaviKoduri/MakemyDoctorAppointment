import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*; 
public class doctorprofilepage extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
	     Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        String query = "select * from doctordb where name=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            ServletContext sc=getServletContext();
            String d=(String)sc.getAttribute("dname");
            pstmt.setString(1,d);
            System.out.println(d);
            ResultSet rs=pstmt.executeQuery();
            out.println("<HTML>");
		        out.println("<BODY BGCOLOR=wheat>");
            out.println("<h1>My Profile</h1>");
                out.println("<h2><table style='font-family:'Courier New', Courier, monospace; font-size:80%'><tr><td>Name</td><td>Gender</td><td>Experience</td><td>Specialism</td><td>Hospital Name</h2></tr>");
     
		              while(rs.next()){
                 out.println("<tr><h3>");
                 out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>");
                 out.println("</h3></tr>");
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