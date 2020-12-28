import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*; 
public class adminpatientdetailsview extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        Statement st=con.createStatement();	//creating statement	
 
       ResultSet rs=st.executeQuery("select * from patientdb");	//executing statement	
                out.println("<HTML>");
		out.println("<BODY BGCOLOR=wheat>");
    out.println("<h1>Patients registered form our site..</h1>");
                out.println("<table style='font-family:'Courier New', Courier, monospace; font-size:80%'><tr><td>PatientName</td><td>Age</td><td>Health Review</td></tr>");
                
		while(rs.next()){
                 out.println("<tr>");
                 out.println("<td>"+rs.getString(1)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td>");
                 out.println("</tr>");
                  }
                out.println("</table>");
                out.print("<h2><a href='logout'>Logout</h2>");
		out.println("</BODY>");
		out.println("</HTML>");
                rs.close(); 
                st.close();
                out.close();  
      }
       catch(Exception e)
        { out.println(e);
        }

    }  
}  
