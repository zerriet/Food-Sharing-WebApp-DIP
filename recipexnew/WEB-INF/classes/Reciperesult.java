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


@WebServlet("/Reciperesult")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)

   public class Reciperesult extends HttpServlet {

  

  // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
      // Set the MIME type for the response message
      // Set the MIME type for the response message
       //doGet(request, response);
       response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      // Print an HTML page as the output of the query
     // out.println("<html>");
     
      //out.println("<body>");

     
       
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
         /* Step 3: Execute a SQL SELECT query
         //String[] ids = request.getParameterValues("id");
         if (ids != null) {
            String sqlStr;
            int count;
 
            // Process each of the books
            for (int i = 0; i < ids.length; ++i) {
               /*//* Update the qty of the table books
               sqlStr = "UPDATE printmaking SET qty = qty - 1 WHERE id = " + ids[i];
               out.println("<p>" + sqlStr + "</p>");  // for debugging
               count = stmt.executeUpdate(sqlStr);
               out.println("<p>" + count + " record updated.</p>");
 
               // Create a transaction record
               sqlStr = "INSERT INTO order_records (id, qty_ordered) VALUES ("
                     + ids[i] + ", 1)";
               out.println("<p>" + sqlStr + "</p>");  // for debugging
               count = stmt.executeUpdate(sqlStr);
               out.println("<p>" + count + " record inserted.</p>");*/
               /*out.println("<h3>Your order for book id=" + ids[i]
                     + " has been confirmed.</h3>");
            }
            out.println("<h3>Thank you.<h3>");
         } else { // No book selected
            out.println("<h3>Please go back and select a book...</h3>");
         }
      } */

       String sqlStr;
       String getresult = request.getParameter("all");
        if (getresult == "all"){
          sqlStr= "select * from recipe";
        }
           out.println("<p><input type=\"hidden\"  value=\" SQL operation:" + sqlStr + ".\"></p>");
          ResultSet rset = stmt.executeQuery(sqlStr);  // Send the query to the server
 

          while(rset.next()) {
                   recipe p = new recipe();
                   p.setrecipeid(rset.getString("recipeid"));
                   p.setrecipename(rset.getString("recipename"));
                   p.setrecipetimetaken(rset.getString("recipetimetaken"));
                   p.setrecipeingredient(rset.getString("recipetimetaken"));
                   p.setrecipesteps(rset.getString("recipesteps"));
                   p.setuploaddatetime(rset.getString("uploaddatetime"));
                   p.setphotoname(rset.getString("photoname"));
                  // p.setrecipephoto(rset.getBlob("recipephoto"));
                   searchResult.add(p);

                out.println("<p><input type=\"hidden\"  value=\"List successfully created.\"></p>");
                
          }
                
    
      }


      catch(Exception ex) {
         out.println("<p>Error: " + ex.getMessage() + "</p>");
         out.println("<p>Check Tomcat console for details.</p>");
         ex.printStackTrace();
      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
     request.getSession().setAttribute("searchResult", (Object)searchResult);
   
       response.sendRedirect(this.getServletContext().getContextPath() +"/recipe.jsp");
 out.close();
   }
}

