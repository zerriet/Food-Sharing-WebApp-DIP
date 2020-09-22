// To save as "ebookshop\WEB-INF\classes\QueryServlet.java".
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/myrecipes")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class myrecipesServlet extends HttpServlet {

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
      /*out.println("<body>");*/
      out.println("<body bgcolor='#D1C3B7'>");

      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/recipeuser?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "xxxx");   // For MySQL
               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
         // Step 3 & 4: Execute a SQL SELECT query and Process the query result
         // Retrieve the books' id. Can order more than one books.
         String rating = request.getParameter("recipe_rating");
         String sqlStr = "Select * from testrecipe where user_id = " + "'" + request.getParameter("user_id") + "' and recipe_rating=" + "'" + request.getParameter("recipe_rating")+ "'";
   
         ResultSet rset = stmt.executeQuery(sqlStr);
         boolean match = false;

         // For each row in ResultSet, print one checkbox inside the <form>

         // Filter out feom table where the recipe_ratings filter chosen matches that of the testrecipe table
         while (rset.next()) {
            if(rating.equals(rset.getString("recipe_rating"))) {
                  match = true;

     }
         }

         if(match) {
            out.println("<form method='get' action='recipe'>");
         out.println("<table border = '1'>");
               out.println("<tr>");
               out.println("<th>Checkbox</th>");
               out.println("<th> </th>");
               out.println("<th>Recipe</th>");
               out.println("<th>ratings</th>");
               out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type='checkbox' name='recipe_id' value=" + rset.getString("recipe_id") + "</td>");
            out.println("<td> <img src='" + rset.getString("recipe_photo") + "'alt=\"recipe_photo\" style=\"width:104px;height:142px;\"> </td>");
            out.println("<td>" + rset.getString("recipe_name") + "</td>");
            out.println("<td>" + rset.getString("recipe_rating") + "</td>");
            out.println("</tr>");


         } 

         else {
            out.println("None");
         }
       
      } catch(Exception ex) {
         out.println("<p>Error: " + ex.getMessage() + "</p>");
         out.println("<p>Check Tomcat console for details.</p>");
         ex.printStackTrace();
      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
 
      out.println("</body></html>");
      out.close();
               

         }
    }
