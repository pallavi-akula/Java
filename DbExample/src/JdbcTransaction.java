import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;  
class JDBCTransaction{  
public static void main(String args[])throws Exception{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Capgemini123");  
con.setAutoCommit(false);  
Statement stmt=con.createStatement();  
stmt.executeUpdate("insert into Employee values(19,'pallavi'");
stmt.executeUpdate("insert into Employee values(18,'Gayathri'");  
con.commit();  
con.close();  
}
}  