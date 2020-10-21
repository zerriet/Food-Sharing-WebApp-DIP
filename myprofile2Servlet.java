// To save as "recipe\WEB-INF\classes\acctSettingsServlet.java".
import java.io.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/*linking from the acctSettings.html to account settings page*/
@WebServlet("/myprofile2")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class myprofile2Servlet extends HttpServlet {
 @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

         	response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();

     // Html visual design was changed */

      /*out.println("<html>");
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
      out.println("</div>");*/
      /* End of Html visual design */


      out.println("<!DOCTYPE html>");
out.println("<html style='font-size: 16px;'>");
  out.println("<head>");
    out.println("<meta name='viewport content='width=device-width, initial-scale=1.0'>");
    out.println("<meta charset='utf-8'>");
    
    out.println("<title>profile</title>");
    out.println("<link rel='stylesheet' href='nicepage.css' media='screen'>");
    out.println("<link rel='stylesheet' href='profile.css' media='screen'>");
    out.println("<script class='u-script' type='text/javascript' src='jquery.js' defer=''></script>");
    out.println("<script class='u-script' type='text/javascript' src='nicepage.js defer=''></script>");
   out.println("<meta name='generator' content='Nicepage 2.25.0, nicepage.com'>");
   out.println("<link rel='stylesheet' href='css/bootstrap.css'>");
    
    
    out.println("<link id='u-theme-google-font' rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i'>");
    out.println("<link id='u-page-google-font' rel='stylesheet' href='https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i'>");
   out.println("</head>");




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
      	

        //[Removed] Does not show profile details and list of user recipe post concurrently, join table function is used below
        //Comment away /*String SqlStr1......*/ to show list of user's post  OR  /*String SqlStr2......*/ to show myprofile details, not able to have 2 seperate while loops to call values from seperate tables(testprofile, testrecipe)

         /*String sqlStr1 = "Select * from testprofile where user_id = " + "'" + request.getParameter("user_id") + "'" ;
         ResultSet rset1= stmt.executeQuery(sqlStr1);
          while(rset1.next()) {
          //  out.println("<p>Upload your file: <input type='file' name='myfile' /></p>");
            out.println("<p>Username: " + rset1.getString("user_name") +  "</p>");
            out.println("<p>Name: " + rset1.getString("user_firstname") +  "</p>");
            out.println("<p>Account Status: " + rset1.getString("user_status") +  "</p>");
            out.println("<p>Contact Infofmation: " + rset1.getString("user_FB") +  "</p>");
            out.println("<p>Bio: " + rset1.getString("user_bio") +  "</p>");
            }*/
      	 //String sqlStr2 = "Select * from testrecipe where user_id = " + "'" + request.getParameter("user_id") + "'" ;
            /* out.println("<table border = '1'>");
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
               out.println("</tr>"); */

              //[REMOVED] Cancel button that hyperlinks back to home page
               //out.println("<button type='button' class='cancelbtn'>");
               // out.println("<a href=http://localhost:9999/recipenew/homepage2.html'>Cancel</a> </button>");
               // out.println("</tr>"); 


         //Join testprofile and testrecipe table for rows where userid(userid=123 set in myprofile2.html) is the same value on both tables
         String sqlStr2 = "select testprofile.user_id, testprofile.user_name, testprofile.user_firstname, testprofile.user_status, testprofile.user_FB, testprofile.user_bio, testrecipe.recipe_id, testrecipe.recipe_name, testrecipe.recipe_rating, testrecipe.recipe_photo from testprofile testprofile inner join testrecipe testrecipe on testprofile.user_id = testrecipe.user_id  where testprofile.user_id = " + "'" + request.getParameter("user_id") + "'" ;
         ResultSet rset2= stmt.executeQuery(sqlStr2);
      	
        
            //print out list of recipe posted by user
             //out.println("<form method='get' action='myrecipes'>");
             while(rset2.next()) {
      
            out.println("<p>Username: " + rset2.getString("user_name") +  "</p>");
            out.println("<p>Name: " + rset2.getString("user_firstname") +  "</p>");
            out.println("<p>Account Status: " + rset2.getString("user_status") +  "</p>");
            out.println("<p>Contact Infofmation: " + rset2.getString("user_FB") +  "</p>");
            out.println("<p>Bio: " + rset2.getString("user_bio") +  "</p>");

           
                  
               //out.println("<input type='submit' name='recipe_name' value=" + rset2.getString("recipe_name") );
               out.println("<p> <img src='" + rset2.getString("recipe_photo") + "'alt=\"recipe_photo\" style=\"width:300px;height:300px;\"> </p>");
              // out.println("<p><input type='image' src='" + rset2.getString("recipe_photo") + " alt='Submit' width='300' height='300'></p>");
              out.println("<form method='get' action='description'>");
              out.println("<p> <input type='submit' name='recipe_name' value=" + rset2.getString("recipe_name")  + "</p>");
              
               //out.println("<p>" + rset2.getString("recipe_name") + "</p>");
               out.println("<p>" + rset2.getString("recipe_rating") + "</p>");

               
               }

     
      //[REMOVED] sort function from myprofile page, method get was supposed to obtain a sorted list of users posted recipe
      //out.println("<form method='get' action='myrecipes'>");

      /* out.println("<p> Sort by ratings:</p>");
        out.println("<p> <select name='recipe_rating' size='1'></p>");
        out.println("<p><option value='1 Star'>1 Star</option></p>");
        out.println("<p><option value='2 Stars'>2 Stars</option></p>");
        out.println("<p><option value='3 Stars'>3 Stars</option></p>"); 
        out.println("<p><option value='4 Stars'>4 Stars</option></p>"); 
        out.println("<p><option value='5 Stars'>5 Stars</option></p>");     
        out.println("<p></select></p>");
        out.println("<p><button type='submit' name = 'btn' value='recipe_rating'> Submit</button></p>");*/
             

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

