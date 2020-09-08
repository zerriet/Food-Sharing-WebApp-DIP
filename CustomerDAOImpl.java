import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAOImpl implements CustomerDAO {

	static Connection con;
	static PreparedStatement ps;

	public int insertCustomer(Customer c) {   //a method to put from frontend data to database

		int status = 0;
		try {                                  
			con = MyConnectionProvider.getConnection();                           
			ps = con.prepareStatement("insert into customer values(?,?,?)");  // putting data in sql
			ps.setString(1, c.getUsername());                                // before putting into sql, must put user data from frontend to customer object in servlet
			ps.setString(2, c.getPassword());								//and then call from here using customer object call and push to database
			ps.setString(3, c.getName());
			status = ps.executeUpdate();    //if want to put data, always update
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}

	public Customer getCustomer(String userid, String pass) {   //a method to call data from database

		Customer c = new Customer();
		try {
			con = MyConnectionProvider.getConnection();
			ps = con.prepareStatement("select * from customer where username=? and password=?");  //prepare statement to just call all data containing username and password
			ps.setString(1, userid);  //input
			ps.setString(2, pass);       

			ResultSet rs = ps.executeQuery();  //call from database
			while (rs.next()) {                   		
				c.setUsername(rs.getString(1));
				c.setPassword(rs.getString(2));
				c.setName(rs.getString(3));            
				//get data from database then put into the customer object
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return c;
	}
}
