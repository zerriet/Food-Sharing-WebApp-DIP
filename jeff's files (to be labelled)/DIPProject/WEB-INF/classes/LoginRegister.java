import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/LoginRegister")
public class LoginRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con;
	static PreparedStatement ps;
	public LoginRegisterServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDAOImpl cd = new CustomerDAOImpl();
		String userName = request.getParameter("username");
		String password = request.getParameter("password1");
		String name = request.getParameter("name");
		String submitType = request.getParameter("submit");
		Customer c = cd.getCustomer(userName, password);               
		//if (submitType.equals("login") && userName.equals(c.getName()) && password.equals(c.getPassword()))
		if (submitType.equals("login") && c!=null && c.getName()!=null) {  //if the user clicks the login button & fill the correct login info
			/*
			request.setAttribute("message", c.getUsername());                                                     //from database, it will go to new page called welcome.jsp
			HttpSession session=request.getSession();  //create a session 
			session.setAttribute("customer",c);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			*/
			
			response.setContentType("text/html"); 
            PrintWriter out = response.getWriter();  
            //out.print("Welcome " + userName); 
            HttpSession session = request.getSession();
            session.setAttribute("uname", userName); 
            //out.print("<a href='welcome.jsp'>visit</a>");
            request.setAttribute("message", c.getUsername());
            request.getRequestDispatcher("homePage.jsp").forward(request, response);
            out.close();

		} else if (submitType.equals("register")) {       //if user click register button,
			c.setName(name);      //it will store the data u put from frontend to customer object
			c.setPassword(password);
			c.setUsername(userName);
			if (c.getName() != null && c.getPassword() != null && c.getUsername() != null && !c.getName().equals("")
					&& !c.getPassword().equals("") && !c.getUsername().equals("")) {

				int InsertResult = cd.insertCustomer(c);     //if u fill in all registration data, the registration is success and it will store in database
				if (InsertResult > 0) {
					request.setAttribute("Successmessage", "Registration Done, please login to continue!!!!");
					request.getRequestDispatcher("register.jsp").forward(request, response);

				} else {         //if u dont fill in all data provided in frontend, it wil ask u to fill in again
					
					request.setAttribute("Failmessage", "Your UserName already exists, please use different UserName.");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("Failsmessage", "UserName, Name & Password cannot be empty, Please try again!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}

			
		} else {
			request.setAttribute("message", "Data Not Found, click on Register !!!");
			request.getRequestDispatcher("register.jsp").forward(request, response);

		}
		/*
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>"); 
		try {
			
			con = MyConnectionProvider.getConnection();
			//ps = con.prepareStatement("select * from testing");
			ps = con.prepareStatement("select * from testing where id=" + Integer.toString(c.getId()));
			System.out.println(c.getName());
			System.out.println("select * from testing where id=" + String.valueOf(c.getId()));
			//ps = con.prepareStatement("select * from testing where id=12");
			ResultSet rs = ps.executeQuery();
			//System.out.println("<table border=1 width=50% height=50%>");
			String show = "<table><tr><th>UserName</th><th>Name</th><th>Password</th></tr>";
			while (rs.next()) {
				System.out.println(rs.getString(1));
				String us = rs.getString(1);
				String pw = rs.getString(2);
				String n = rs.getString(3);
				show+="<tr><td> " + us + " </td><td> " + pw + " </td><td> " + n + " </td></tr> ";
			}
			show+="</table>";
			out.println(show);
			con.close();
		} catch (Exception e) {
			System.out.println("error");
		}
		*/
	}
	
}