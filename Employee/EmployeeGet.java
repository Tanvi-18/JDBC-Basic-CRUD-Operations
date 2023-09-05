package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeGet {
		public static void main(String[] args) {
			String url = "jdbc:mysql://localhost:3306/javabatch";
			String username = "root";
			String password = "root";
			String sql = "SELECT * FROM employee WHERE ID=1" ;
			Connection connection = null;
			
			//STEP 1: LOAD/REGISTER THE DRIVER 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//STEP 2: ESTABLISH CONNECTION 
				connection = DriverManager.getConnection(url, username, password);
				
				//STEP 3: ESTABLISH STATEMENT
				Statement statement = connection.createStatement();
				
				//STEP 4: EXECUTE STATEMENT
				ResultSet resultSet = statement.executeQuery(sql);
				
				while(resultSet.next()) {
					System.out.print(resultSet.getInt(1)+" "+"| ");
					System.out.print(resultSet.getString(2)+" "+"| ");
					System.out.println(resultSet.getString(3)+" "+"| ");
					System.out.println("===========================");
				}			            	
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			} 
			finally {
				
				//STEP 5: CLOSE CONNECTION
				try {
					connection.close();
					System.out.println("All Good");
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
				
	}
}