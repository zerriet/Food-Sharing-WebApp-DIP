

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
		maxFileSize = 1024*1024*10,
		maxRequestSize = 1024 *1024*50)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FileUploadServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		Part part = request.getPart("file");
		String fileName = extractFileName(part);
		String savePath ="" + File.separator + fileName;
		File fileSaveDir = new File(savePath);
		
		part.write(savePath + File.separator);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipeproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
			PreparedStatement pst = con.prepareStatement("insert into image values(?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4,  fileName);
			pst.setString(5, savePath);
			pst.executeUpdate();
			out.println("<center><h1>Image inserted Successfully....</h1></center>");
			out.println("<center><a href='Display.jsp?id=" + id + "'>Display</a></center>");
			}
		catch(Exception e) {
			out.println(e);
		}
	}
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s: items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
