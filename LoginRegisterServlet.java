
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/loginRegister")
public class LoginRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// if (submitType.equals("login") && c!=null && c.getName()!=null)
		//System.out.println("Line 29: " + userName);
		//System.out.println("Line 30: " + password);

		if (submitType.equals("login") && userName.equals(c.getName()) && password.equals(c.getPassword())) {  //if the user clicks the login button & fill the correct login info
			request.setAttribute("message", c.getName());                                                     //from database, it will go to new page called welcome.jsp
			request.getRequestDispatcher("welcome.jsp").forward(request, response);

		} else if (submitType.equals("register")) {       //if user click register button,
			c.setName(request.getParameter("name"));      //it will store the data u put from frontend to customer object
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
	}

}
