// To save as "recipe\WEB-INF\classes\acctSettingsServlet.java".
import java.io.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/*linking from the acctSettings.html to account settings page*/
@WebServlet("/myprofile")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class myprofileServlet extends HttpServlet {
 @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

         	response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();

     /* Html visual design to be changed, scroll down for button function to launch acctSettings page */

      out.println("<html>");
      out.println("<head><title>Profile Query Response</title></head>");
      out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
      out.println("<style>");
      out.println("body, html {height: 100%; margin: 0; font-family: 'Times New Roman', Times, serif;} .hero-image {background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('https://waylandlibrary.org/wp-content/uploads/2017/06/cooking-header.jpg');height: 50%; background-position: center; background-repeat: no-repeat; background-size: cover; position: relative;} .hero-text {text-align: center; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);color: white; }");

      out.println("</style>");
      out.println("</head>");
      //out.println("<body>");
      out.println("<body bgcolor='#D1C3B7'>");

      //

      out.println("<div class='hero-image'>");
      out.println("<div class='hero-text'>");
      out.println("<h1 style='font-size:50px'>Recipe</h1>");
      out.println("<p> <span style = 'font-style:italic;'>Explore a world of cuisines</span></p>");
      out.println("</div>");
      out.println("</div>");
      out.println("<div class='container' style='background-color:#808080'> ");
      out.println("<button type='button' class='cancelbtn' >");
      out.println(" <a href= 'http://localhost:9999/recipe/recipelogin.html'>Sign Out</a> </button> ");
      out.println("</div>");
      /* End of Html visual design */


      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/recipeuser?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "xxxx");   // For MySQL
               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password", my database is recipeuser with variables user_email and pwd

         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
         // Step 3: Execute a SQL SELECT query
      	
      	/*request.getParameter obtains the specific user_email value=abc@ggmail.com and prints corresponding user_email and Password using rset.getString()   */
      	
         //String sqlStr1 = "Select * from testprofile where user_id = " + "'" + request.getParameter("user_id") + "'" ;
         //ResultSet rset1= stmt.executeQuery(sqlStr1);
      	 String sqlStr2 = "Select * from testrecipe where user_id = " + "'" + request.getParameter("user_id") + "'" ;
         ResultSet rset2= stmt.executeQuery(sqlStr2);
         


      	
          /*while(rset1.next()) {
          //  out.println("<p>Upload your file: <input type='file' name='myfile' /></p>");
            out.println("<p>Username: " + rset1.getString("user_name") +  "</p>");
            out.println("<p>Name: " + rset1.getString("user_firstname") +  "</p>");
            out.println("<p>Account Status: " + rset1.getString("user_status") +  "</p>");
            out.println("<p>Contact Infofmation: " + rset1.getString("user_FB") +  "</p>");
            out.println("<p>Bio: " + rset1.getString("user_bio") +  "</p>");
            }*/
            //print out list of recipe posted by user
             while(rset2.next()) {

              out.println("<table border = '1'>");
               out.println("<tr>");
               out.println("<th>Checkbox</th>");
               out.println("<th> </th>");
               out.println("<th>Recipe</th>");
               out.println("<th>ratings</th>");
               out.println("</tr>");
               out.println("<tr>");
               out.println("<td><input type='checkbox' name='recipe_id' value=" + rset2.getString("recipe_id") + "</td>");
               out.println("<td> <img src='" + rset2.getString("recipe_photo") + "'alt=\"recipe_photo\" style=\"width:104px;height:142px;\"> </td>");
               out.println("<td>" + rset2.getString("recipe_name") + "</td>");
               out.println("<td>" + rset2.getString("recipe_rating") + "</td>");
               out.println("</tr>"); 
               }



out.println("<form method='get' action='myrecipes'>");

      out.println("<p> Sort by ratings:</p>");
      out.println("<p> <select name='recipe_rating' size='1'></p>");
      out.println("<p><option value='1 Star'>1 Star</option></p>");
      out.println("<p><option value='2 Stars'>2 Stars</option></p>");
      out.println("<p><option value='3 Stars'>3 Stars</option></p>"); 
      out.println("<p><option value='4 Stars'>4 Stars</option></p>"); 
      out.println("<p><option value='5 Stars'>5 Stars</option></p>");     
      out.println("<p></select></p>");
      out.println("<p><button type='submit' name = 'btn' value='recipe_rating'> Submit</button></p>");
             





         

         // Step 3: Execute a SQL SELECT query
         // String[] genres = request.getParameterValues("genre");  // Returns an array of Strings
      // Send the query to the server
         
      } catch(Exception ex) {
         out.println("<p>Error: " + ex.getMessage() + "</p>");
         out.println("<p>Check Tomcat console for details.</p>");
         ex.printStackTrace();
      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
 
      out.println("</body></html>");
      out.close();
         	   

         }
    }

