package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBManager {
	   public static Connection makeConnection()
	   {
	      
			String url="jdbc:mysql://localhost:3306/phoenixking";
			String id="phoenixking";
			String pw="123456";
	      Connection con = null;
	      /*
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String id = "SCOTT";
			String pw = "TIGER";
	        Connection con = null;
	       */
	      try{   
	        Class.forName("com.mysql.cj.jdbc.Driver");
	       //Class.forName("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection(url,id,pw);

	      }catch(ClassNotFoundException e1) {

	      }catch(SQLException e2){
	       System.out.println(e2.getMessage());
	      }
	      return con;
	   }

}
