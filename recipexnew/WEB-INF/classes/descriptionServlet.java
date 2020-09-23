
// To save as "ebookshop\WEB-INF\classes\QueryServlet.java".
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import javax.servlet.http.Part;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;

@WebServlet("/description")
public class descriptionServlet extends HttpServlet{

   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
      // Set the MIME type for the response message
      response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      // Print an HTML page as the output of the query
      List<recipe> searchResult = new ArrayList<>();
      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/erecipe?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "xxxx");   // For MySQL
               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
          // Step 3 & 4: Execute a SQL SELECT query and Process the query result
         // Retrieve the books' id. Can order more than one books.
            String sqlStr;
            // int id = request.getParameter("catID");
               // Update the qty of the table books
                sqlStr = "select * from recipe where recipeid = " + request.getParameter("receipeid") ;
               
               System.out.println(sqlStr);
               ResultSet rset = stmt.executeQuery(sqlStr);  // Send the query to the server
 
               // Create a transaction record
               while(rset.next()) {
                   recipe p = new recipe();
                   p.setrecipeid(rset.getString("recipeid"));
                   p.setrecipename(rset.getString("recipename"));
                   p.setreceipetimetaken(rset.getString("recipetimetaken"));
                   p.setrecipeingredients(rset.getString("recipeingredients"));
                   p.setreceipesteps(rset.getString("recipesteps"));
                   p.setuploaddatetime(rset.getString("uploaddatetime"));
                   p.setphotoname(rset.getString("photoname"));
                  // p.setrecipephoto(rset.getBlob("recipephoto"));
                 searchResult.add(p);
                out.println("<p><input type=\"hidden\"  value=\"Descrpt/List successfully created.\"></p>");
                }
             
      } catch(Exception ex) {
         ex.printStackTrace();
      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
      request.getSession().setAttribute("receipeid", request.getParameter("receipeid"));
  
        response.sendRedirect(this.getServletContext().getContextPath() +"/recipedetails.jsp");
 
      out.close();
   }
}




     //request.getSession().setAttribute("recommendation", (Object)searchResult);