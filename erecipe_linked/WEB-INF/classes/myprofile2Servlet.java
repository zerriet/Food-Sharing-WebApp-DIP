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

         out.println("<body id='home'>");
       out.println(" <nav class='navbar navbar-expand-sm bg-danger navbar-dark fixed-top'>");
            out.println("<div class='container'>");
               out.println("<a class='navbar-brand' >ReSharePeace</a>");
                   out.println(" <div class='navbar-collapse justify-content-end' id='navbarNav'>");
                       out.println("<form class='form-inline my-2 my-lg-0' action='searchresults.html'>");
                          out.println(" <input class='form-control mr-sm-2' type='text' placeholder='Search'>");
                           out.println("<button class='btn btn-primary my-2 my-sm-0' type='submit'>Search</button> &nbsp;&nbsp;");
                          out.println(" <div class='dropdown'>");
                           out.println(" <button class='btn btn-secondary dropdown-toggle' type='button' id='dropdownMenuButton' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>");
                              out.println("My Profile");
                            out.println("</button>");
                            out.println("<div class='dropdown-menu' aria-labelledby='dropdownMenuButton'>");
                             out.println(" <a class='dropdown-item' href='feeds.html'>Home</a>");
                              out.println("<a class='dropdown-item' href='favourite.html'>Favourites</a>");
                              out.println("<a class='dropdown-item' href='class.html'>Classes</a>");
                              out.println("<a class='dropdown-item' href='bookings.html'>Bookings</a>");
                              out.println("<a class='dropdown-item' href='profile.html'>Profile</a>");
                              out.println("<a class='dropdown-item' href='login.html'>Logout</a>");
                            out.println("</div>");
                          out.println("</div>");
                       out.println("</form>");
                   out.println("</div>");
           out.println("</div>");   
       out.println("</nav>");
  out.println("<p class='u-custom-font u-large-text u-text u-text-default u-text-variant u-text-1'>ReSharePeace</p>");
      out.println("</div></header>");
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

               out.println("<section class='u-align-center u-clearfix u-section-1' id='carousel_bdcc'>");
      out.println("<div class='u-clearfix u-sheet u-valign-middle-lg u-valign-middle-xl u-sheet-1'>");
       //out.println(" <h1 class='u-text u-text-default u-text-1'>about</h1>");
        out.println("<a href='editprofile.html' class='u-border-radius-50 u-btn u-btn-round u-button-style u-hover-palette-2-base u-palette-2-light-2 u-btn-1'>Edit profile</a>");
        out.println("<div alt='' class='u-image u-image'-circle u-image-1' data-image-width=450' data-image-height='562'></div>");

     out.println(" </div>");
     out.println("<h4 class='u-align-left u-text u-text-2'>Name&nbsp;" +rset2.getString("user_firstname")+"<br>");
          out.println("<br>Username:&nbsp;" +rset2.getString("user_name")+"<br>");
          out.println("<br>Account status: " +rset2.getString("user_status")+"<br>");
          out.println("<br>Contact Info: " +rset2.getString("user_FB")+"<br>");
         out.println("<br>Bio: " +rset2.getString("user_bio")+"");
         out.println(" </h4>");
    out.println("</section>");
    out.println("<section class='u-align-center u-clearfix u-section-2' id='sec-1251'>");
      out.println("<div class='u-clearfix u-sheet u-sheet-1'>");
        out.println("<div class='u-expanded-width u-tabs u-tabs-1'>");
         out.println(" <ul class='u-border-1 u-border-grey-25 u-tab-list u-unstyled' role='tablist'>");
            out.println("<li class='u-tab-item' role='presentation'>");
             out.println(" <a class='active u-active-white u-border-3 u-border-active-palette-2-base u-border-hover-palette-2-base u-border-no-left u-border-no-right u-border-no-top u-button-style u-tab-link u-text-active-palette-2-base u-tab-link-1' id='link-tab-0da5' href='#tab-0da5' role='tab' aria-controls='tab-0da5' aria-selected='true'>Your Recipe</a>");
           out.println(" </li>");
           out.println(" <li class='u-tab-item' role='presentation'>");
              out.println("<a class='u-active-white u-border-3 u-border-active-palette-2-base u-border-hover-palette-2-base u-border-no-left u-border-no-right u-border-no-top u-button-style u-tab-link u-text-active-palette-2-base u-tab-link-2' id='link-tab-2917' href='#tab-2917' role='tab' aria-controls='tab-2917' aria-selected='false'>Your Appointments</a>");
            out.println("</li>");
          out.println("</ul>");
         out.println(" <div class='u-tab-content'>");
           out.println(" <div class='u-container-style u-tab-active u-tab-pane u-white u-tab-pane-1' id='tab-0da5' role='tabpanel' aria-labelledby='link-tab-0da5'>");
              out.println("<div class='u-container-layout u-valign-top u-container-layout-1'>");
               out.println(" <a href='new-post.html' class='u-border-radius-50 u-btn u-btn-round u-button-style u-hover-palette-2-base u-palette-2-light-2 u-btn-1'>Add New Recipe</a>");
                out.println("<div class='u-gallery u-layout-grid u-lightbox u-show-text-on-hover u-gallery-1'>");
                  out.println(" <div class='u-gallery-inner u-gallery-inner-1'>");
                    out.println("<div class='u-effect-fade u-gallery-item' data-href='recipe-pancake.html'>");
                      out.println("<div class='u-back-slide' data-image-width='720' data-image-height='720'>");
                        out.println("<img class='u-back-image u-expanded' src='images/waffle.jpg'>");
                     out.println(" </div>");
                      out.println("<div class='u-over-slide u-shading u-over-slide-1'>");
                        out.println("<h3 class='u-gallery-heading'></h3>");
                        out.println("<p class='u-gallery-text'></p>");
                      out.println("</div>");
                   out.println(" </div>");
                    out.println("<div class='u-effect-fade u-gallery-item' data-href='recipe-pancake.html'>");
                     out.println(" <div class='u-back-slide' data-image-width='900' data-image-height='560'>");
                       out.println(" <img class='u-back-image u-expanded' src='images/pancake.jpg'>");
                      out.println("</div>");
                      out.println("<div class='u-over-slide u-shading u-over-slide-2'>");
                        out.println("<h3 class='u-gallery-heading'></h3>");
                        out.println("<p class='u-gallery-text'></p>");
                      out.println("</div>");
                   out.println(" </div>");
                    out.println("<div class='u-effect-fade u-gallery-item' data-href='recipe-tiramisu.html'>");
                      out.println("<div class='u-back-slide' data-image-width='1200' data-image-height='1800'>");
                        out.println("<img class='u-back-image u-expanded' src='images/tiramisu.jpg'>");
                      out.println("</div>");
                      out.println("<div class='u-over-slide u-shading u-over-slide-3'>");
                        out.println("<h3 class='u-gallery-heading'></h3>");
                        out.println("<p class='u-gallery-text'></p>");
                     out.println(" </div>");
                   out.println(" </div>");
                   out.println("<div class='u-effect-fade u-gallery-item' data-image-width='720' data-image-height='720' data-href='recipe-cheesecake.html'>");
                     out.println(" <div class='u-back-slide'>");
                        out.println("<img class='u-back-image u-expanded' src='images/cheesecake.jpg'>");
                      out.println("</div>");
                      out.println("<div class='over-slide u-shading u-over-slide-4'>");
                        out.println("<h3 class='u-gallery-heading'></h3>");
                        out.println("<p class='u-gallery-text'></p>");
                     out.println(" </div>");
                    out.println("</div>");
                  out.println("</div>");
                out.println("</div>");
              out.println("</div>");
           out.println(" </div>");
            out.println("<div class='u-container-style u-tab-pane u-white u-tab-pane-2' id='tab-2917' role='tabpanel' aria-labelledby='link-tab-2917'>");
              out.println("<div class='u-container-layout u-container-layout-2'>");
                out.println("<ol class='u-text u-text-1'>");
                  out.println("<li>");
                   out.println(" <font style='font-size: 1.875rem;'>Hazelnut Coffee Cream Baking Class on Zoom, Sunday, 14 September 5pm</font>");
                 out.println(" </li>");
                 out.println(" <li>");
                    out.println("<font style='font-size: 1.875rem;'>Beginner Baking Class on Zoom, Monday, 14 September 5pm</font>");
                  out.println("</li>");
                out.println("</ol>");
              out.println("</div>");
           out.println("</div>");
          out.println("</div>");
        out.println("</div>");
     out.println(" </div>");
    out.println("</section>");
    
    
    out.println("<footer class='foot'>");
            out.println("<div class='container'>");
               out.println("<div class='row'>");
                  out.println(" <div class='col text-center'>");
                      out.println(" <p>");
                        
                      out.println(" </p>");
                  out.println(" </div>");
              out.println(" </div>");
           out.println("</div>");
       out.println("</footer>");
       out.println("<!-- End of Footer -->");

        out.println("<script src='js/jquery.min.js'></script>");
       out.println(" <script src='js/popper.min.js'></script>");
       out.println(" <script src='js/bootstrap.min.js'></script>");
  out.println("</body>");
  out.println("</html>");
      
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

