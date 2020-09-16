import java.sql.*;


public class MyConnectionProvider {

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";   //setting driver name
	// private static final String URL = "jdbc:mysql://localhost:3306/appdb";
	// local machine
	private static final String URL = "jdbc:mysql://localhost:3306/recipeproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static {
		try {
			Class.forName(DRIVER_NAME).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Establish connection

	/**
	 * Establish connection
	 * 
	 * @return Connection object
	 * @throws SQLException throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		//System.out.println(DriverManager.getDriver("jdbc:mysql://localhost:3306/recipeproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC").toString());

		return DriverManager.getConnection(URL, "root", "root");
		//setting connection, with schema =recipeproject, username=root, password=root
	}

	// Close connection

	/**
	 * Close connection
	 * 
	 * @param conn Connection object
	 * @param stmt Statement object
	 * @param rs   ResultSet object
	 */
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
