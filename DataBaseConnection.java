package emailpack;


import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {

	   public static Connection getConnection() throws SQLException, FileNotFoundException{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailApp", "root", "Apoorva@123");
		    return con;
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex.getMessage());
			return null;
		}
		catch(SQLException ex1)
		{
			System.out.println(ex1.getMessage());
		
		return null;
		}
	}

}

