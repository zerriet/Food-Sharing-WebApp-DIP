import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class AccountInfo
 */
@WebServlet("/accountInfo")
public class AccountInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public AccountInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
	try { 
        /*Declaration of the get method*/
		HttpSession session = request.getSession(false); 
        String n = (String)session.getAttribute("uname");
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        CustomerDAOImpl cd = new CustomerDAOImpl();
        Customer userDetails = cd.getCustomerByUserName(n);
        out.println("UserName: " + userDetails.getUsername() + "<br/>"); 
        out.println("Name: " + userDetails.getName() + "<br/>"); 
        out.println("Password: " + userDetails.getPassword()+ "<br/>"); 
        out.close(); 
    } 
    catch (Exception e) { 
        System.out.println(e); 
    } 
} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("loginRegister");
		//dispatcher.forward(request, response);
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		Customer cus = (Customer)session.getAttribute("customer");
		System.out.println(cus.getUsername());
		System.out.println(cus.getName());
		if (cus!=null) {  //if cus data are not empty
			request.setAttribute("CusUserName", (String)cus.getUsername());
			request.setAttribute("CusName", cus.getName());
			request.setAttribute("CusPassword", cus.getPassword());
			request.getRequestDispatcher("AccountInfo.jsp").forward(request, response);
			System.out.println(cus.getUsername());
		
		}
		else {
			
		}
		
	}
	*/
	
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	*/
}
