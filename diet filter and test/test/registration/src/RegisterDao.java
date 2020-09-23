import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

	//private String dburl = "jdbc:mysql://localhost:3306/userdb";
	//private String dbuname = "root";
	//private String dbpassword = "Screwyou1!";
	private String dbdriver = "com.mysql.jdbc.Driver";

	public void loadDriver(String dbDriver) // jdbc driver see line 15
	{
		try {
			Class.forName(dbDriver); // loading the jdbc driver
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userdb?serverTimezone=UTC", "root", "Screwyou1!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con; // establish connection

	}

	public String insert(Member member) {
		loadDriver(dbdriver); // loads database driver
		Connection con = getConnection();
		String result = "data entered successfully";
		String sql = "insert into userdb.member values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, member.getUname());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}

		return result;
	}

}
