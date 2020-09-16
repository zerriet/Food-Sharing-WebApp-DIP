// To save as "<TOMCAT_HOME>\webapps\hello\WEB-INF\classes\HelloServlet.java"
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
@WebServlet("/useraccountsettings")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class UserAccountSettings extends HttpServlet {

   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
      // Set the MIME type for the response message
      response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      // Print an HTML page as the output of the query
      out.println("<html>");
      out.println("<head><title>Query Response</title></head>");
      out.println("<body>");

      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/erecipe?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "xxxx");   // For MySQL
               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
         // Step 3: Execute a SQL UPDATE query
            String sqlStr;
            String new_username = request.getParameter("username");  // Returns an array of Strings
            if (new_username == null) {
               out.println("<h2>Username is missing.</h2><body></html>");
               return; // Exit doGet()
               }

            String new_email = request.getParameter("email");  // Returns an array of Strings
            if (new_email == null) {
               out.println("<h2>Email is missing.</h2><body></html>");
               return; // Exit doGet()
               }

            String new_firstname = request.getParameter("firstname");  // Returns an array of Strings
               if (new_firstname == null) {
                  out.println("<h2>First name is missing.</h2><body></html>");
                  return; // Exit doGet()
               }

            String new_lastname = request.getParameter("lastname");  // Returns an array of Strings
               if (new_lastname == null) {
                  out.println("<h2>Last name is missing.</h2><body></html>");
                  return; // Exit doGet()
               }

            String current_password = request.getParameter("password");  // Returns an array of String
            //String password = "select password from useraccount";
            //ResultSet rset = stmt.executeQuery(password);
            String new_password = request.getParameter("newpassword");  // Returns an array of Strings
            String new_password2 = request.getParameter("newpassword2");  // Returns an array of Strings
         
               //if (current_password != password) {
                 // out.println("<h2>Incorrect password.</h2><body></html>");
                  //return; // Exit doGet()
                  //}

               //if (new_password != new_password2) {
                 // out.println("<h2>Entries of new password does not match.</h2><body></html>");
                 // return; // Exit doGet()
                 // } else if (new_password == new_password2){
                 //      new_password = new_password2; 
                 // }

              sqlStr = "Update useraccount set username = '"+new_username+"', email = '"+new_email+"', firstname = '"+new_firstname+"', lastname = '"+new_lastname+"', password = '"+new_password+"'  where id = 1001";              
              stmt.executeUpdate(sqlStr);
              
            // Step 4: Process the query result set
         out.println("<center><form method='get' action='useraccountsettings'>");
         // Print the submit button and </form> end-tag
         out.println("<p>Your account setting has been updated.</p>");
         out.println("<p><input type='submit' value='Back' />");
         out.println("</form></center>");

         } catch(Exception ex) {
            out.println("<p>Error: " + ex.getMessage() + "</p>");
            out.println("<p>Check Tomcat console for details.</p>");
            ex.printStackTrace();
            }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
 
      out.println("</body></html>");
      out.close();
   }
}