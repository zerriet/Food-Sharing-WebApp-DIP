package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	
	public static void main(String[] args) throws SQLException {
		//String url = "jdbc:mysql://localhost:3306/University";
		//String uname = "root";
		/*String password = "Screwyou1!";*/
		String query = "select * from EngineeringStudents where PassOutYear = 2018";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/University?serverTimezone=UTC", "root", "Screwyou1!");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				String UniversityData = " ";
				for (int i = 1; i <= 6; i++) {
					UniversityData += result.getString(i) + ":";
				}
				System.out.println(UniversityData);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
