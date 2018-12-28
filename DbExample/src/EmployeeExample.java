import java.sql.*;

public class EmployeeExample {
	public static void main(String args[]){
	try{
	     
	      Class.forName("com.mysql.jdbc.Driver");

	     
	      System.out.println("Connecting to database...");
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Capgemini123");
	      
		     Statement stmt = conn.createStatement();
		     String sql="UPDATE `test`.`employee` SET `name`='gaythri' WHERE `id`='2'";
		     String sql1="INSERT INTO `test`.`employee` (`id`, `name`) VALUES (4, 'Pravalika')";
		    // String sql2="DELETE `test`.`employee` SET  WHERE `id`='4'";
		     stmt.execute(sql);
		     stmt.execute(sql1);
		     //stmt.execute(sql2);
		     ResultSet rs =  stmt.executeQuery("select * from Employee" ); 
		     
		     
		      while(rs.next())
		    	  System.out.println(rs.getInt(1)+" "+rs.getString(2));
		    	  conn.close();
		         }catch(Exception e){
		        	 System.out.println(e);
		         }
	}
		     
	}

