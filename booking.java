import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*; 
public class booking extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        Statement st=con.createStatement();	//creating statement	
 
       ResultSet rs=st.executeQuery("select name from doctordb");	//executing statement	
                out.println("<HTML>");
		out.println("<BODY BGCOLOR=wheat>");
                  out.println("<br></br>");
                out.println("</table>");
                out.println("<form action='booked' method=''>");
                out.println("<h3>Your Name</h3><input type='text' name='uname'><br>");
                out.println("<h3>Date-of-Appointment</h3><input type='date' name='doapp'><br>");
                out.println("<h3>Time</h3><input type='text' name='time'><br>");
                out.println("<label for='Doctor'><h3>Choose your Doctor:</h3></label>");
                      out.println("<select id='dn' name='dname'>");
                      while(rs.next())
                      {
                        String i=rs.getString(1);
                        out.println("<option value="+i+">"+i+"</option>");
                      }
                 out.println("</select>");
                out.println("<input type='submit' value='submit'>");
                out.println("</form>");
                //RequestDispatcher rd=request.getRequestDispatcher("booked");
                //rd.forward(request,response);  
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
