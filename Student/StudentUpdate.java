package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentUpdate {
		public static void main(String[] args) {
			String url = "jdbc:mysql://localhost:3306/javabatch";
			String username = "root";
			String password = "root";
			String sql = "UPDATE student SET name='SHIVAM', email='shivam@mail.com' WHERE ID = 5" ;
			Connection connection = null;
		
			//STEP 1: LOAD/REGISTER THE DRIVER 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//STEP 2: ESTABLISH CONNECTION 
				connection = DriverManager.getConnection(url, username, password);
				
				//STEP 3: ESTABLISH STATEMENT
				Statement statement = connection.createStatement();
				
				//STEP 4: EXECUTE STATEMENT
				int a = statement.executeUpdate(sql);
				
				if(a>0) {
					System.out.println("UPDATED");
					
				}else {
					System.out.println("NOT UPDATED");
					
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