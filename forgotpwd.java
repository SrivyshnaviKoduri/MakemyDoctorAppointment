import java.io.*;  
import javax.servlet.*;
import javax.servlet.http.*; 
import java.sql.*;
import java.text.*; 
public class forgotpwd extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe","system","lallu");
        String query = "update admin set pwd=? where name=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            String d=request.getParameter("name");
	           String p=request.getParameter("pwd");
            pstmt.setString(1,p);
            pstmt.setString(2,d);
            System.out.println(d);
            ResultSet rs=pstmt.executeQuery();
            
              out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h2><marquee>Password Updated Successfully</marquee></h2>");
		int i=1;
if(i==1)
{
    RequestDispatcher rd=request.getRequestDispatcher("admin.html");  
        rd.include(request,response);  
}

          out.println("</body>");
          out.println("</html");
             
             
            
       pstmt.close();
      }
       catch(Exception e)
        { 
     out.println("<html>");
          out.println("<body bgcolor=wheat>");
          out.println("<h2>Error in Updating!Kindly go back to login page:)</h2>");

          out.println("</body>");
          out.println("</html");
        }

    }  
}  
