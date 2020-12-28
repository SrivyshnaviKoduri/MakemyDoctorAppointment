import java.sql.*;  
  
public class patientsignupsql {  
public static boolean insert(String name,String pass,Integer age,String health){  
boolean status=false;  
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","lallu"); 
PreparedStatement ps1=con.prepareStatement(  
"insert into patient values(?,?)");  
ps1.setString(1,name);  
ps1.setString(2,pass); 
System.out.println(name+" "+pass); 
ps1.executeUpdate(); 
      
PreparedStatement ps2=con.prepareStatement(  
"insert into patientdb values(?,?,?,?)");  
ps2.setString(1,name);  
ps2.setString(2,pass);
ps2.setInt(3,age);
ps2.setString(4,health);  
System.out.println(name+" "+pass+" "+age+" "+health); 
ps2.executeUpdate();
status=true;
return status;
 }catch(Exception e){System.out.println(e);
 return status; }  
 
}  
}  