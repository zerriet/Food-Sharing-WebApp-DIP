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


     
        try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/erecipe?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
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
         String sqlStr2 = "select useraccount.userid, useraccount.username, useraccount.Firstname,useraccount.email, useraccount.user_status, useraccount.user_FB, useraccount.user_bio, testrecipe.recipe_id, testrecipe.recipe_name, testrecipe.recipe_rating, testrecipe.recipe_photo from useraccount useraccount inner join testrecipe testrecipe on useraccount.userid = testrecipe.userid  where useraccount.userid = 1001" ;
         ResultSet rset2= stmt.executeQuery(sqlStr2);
        
        
            //print out list of recipe posted by user
             //out.println("<form method='get' action='myrecipes'>");
             while(rset2.next()) {
                         out.println("<!DOCTYPE html>");
          out.println("<html dir='ltr' lang='en'>");
          out.println("<head>");
          out.println("<meta charset='UTF-8'>");
          out.println("<meta name='viewport' content='width=device-width, initial-scale=1, maximum-scale=1'>");
          out.println("<meta name='generator' content='Nicepage 2.25.0, nicepage.com'>");
          out.println("<title>Profile</title>");
          out.println("<link href='assets/css/owl.carousel.min.css' rel='stylesheet' type='text/css' media='all'>");
          out.println("<link href='assets/css/jquery.mCustomScrollbar.min.css' rel='stylesheet' type='text/css' media='all'>");
          out.println("<link href='assets/images/favicon.ico' rel='shortcut icon' type='image/x-icon'>");
          out.println("<link href='assets/css/styles.css' rel='stylesheet' type='text/css' media='all'>");
          out.println("<link rel='stylesheet' href='assets/css/nicepage.css' media='screen'>");
          out.println("<link rel='stylesheet' href='assets/css/profile.css' media='screen'>");
          out.println("<link rel='stylesheet' href='css/font-awesome.min.css'>");
          out.println("<link rel='stylesheet' href='css/font-awesome-animation.min.css'>");
          out.println("<link href='assets/css/styles.css' rel='stylesheet' type='text/css' media='all'>");
          out.println("<link href='assets/css/heart.css' rel='stylesheet' >");
          out.println("<link rel='stylesheet' media='all' href='../component/styles/setup.css'>");
          out.println("<link rel='stylesheet' media='all' href='../component/styles/says.css'>");
          out.println("<link rel='stylesheet' media='all' href='../component/styles/reply.css'>");
          out.println("<link rel='stylesheet' media='all' href='../component/styles/typing.css'>");
          out.println("<link rel='stylesheet' media='all' href='../component/styles/input.css'>");

          out.println("</head>");
          out.println("<body>");
          out.println("<!-- Put the serach bar on top and the menu dropdown button -->");

          out.println("<!-- resharepeace Section, P 0 -->");
          out.println("<section class='resharepeace-section p-0'>");
            out.println("<div class='container'>");
              out.println("<!-- resharepeace Header, Bg White -->");
              out.println(" <!-- resharepeace Header, Bg White -->");
              out.println("<header class='resharepeace-header bg-white'>");
                out.println("<nav class='navbar navbar-expand-lg has-header-inner px-0'>");
                  out.println("<a class='navbar-brand' href='homeUser.html'>");
                    out.println("<h5> ReSharePeace </h5>");
                 out.println(" </a>");
                  
                  out.println("<div class='resharepeace-header-links d-flex align-items-center ml-auto order-0 order-lg-2'>");
                    out.println("<a href='javascript:void(0);'' class='search-link'>");
                      out.println("<svg xmlns='http://www.w3.org/2000/svg width='26.667' height='26.667' viewBox='0 0 26.667 26.667'>");
                       out.println(" <path d='M24.39,26.276l-4.9-4.9a12.012,12.012,0,1,1,1.885-1.885l4.9,4.9a1.334,1.334,0,0,1-1.886,1.886ZM2.666,12a9.329,9.329,0,0,0,15.827,6.7,1.338,1.338,0,0,1,.206-.206A9.332,9.332,0,1,0,2.666,12Z'/>");
                      out.println("</svg>");
                   out.println(" </a>");
                   out.println(" <a href='#0' class='ml-4 ml-md-4 mr-2 mr-md-0 circle'><img src='assets/images/avatars/user.png' alt='Avatar'></a>");
                   out.println("<div class='collapse navbar-collapse' id='menu-4'>");
                    out.println("<ul class='navbar-nav m-auto pt-3 pt-lg-0'>");
                     out.println(" <li class='nav-item dropdown'>");
                        out.println("<div class='dropdown'>");
                    out.println("<button class='btn btn-secondary dropdown-toggle' type='button' id='dropdownMenuButton' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'> My Account </button>");
                    out.println("<div class='dropdown-menu' aria-labelledby='dropdownMenuButton'>");
                     out.println("<a class='dropdown-item' href='homeUser.html'> <i class='fa fa-home faa-wrench animated-hover' aria-hidden='true'> </i> Home</a>");
                     out.println("<a class='dropdown-item' href='profile.html'> <i class='fa fa-heart faa-pulse animated-hover' aria-hidden='true'> </i> Profile</a>");
                     out.println("<a class='dropdown-item' href='redemption.html'> <i class='fa fa-trophy faa-wrench animated-hover' aria-hidden='true'> </i> Redemption</a>");
                     out.println("<a class='dropdown-item' href='home.html'> <i class='fas fa-power-off faa-burst animated-hover' aria-hidden='true'> </i> Logout</a>");
                    out.println("</div>");
                  out.println("</div>");
                      out.println("</li>");
                       out.println("</ul>");
                     
                    out.println("</div>");

                  out.println("</div>");
                  out.println("<button class='navbar-toggler pr-0 ml-2 ml-md-3' type='button' data-toggle='collapse' data-target='#menu-4' aria-controls='menu-4' aria-expanded='false' aria-label='Toggle navigation'>");
                    out.println("<svg data-name='Icon/Hamburger' xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                      out.println("<path data-name='Icon Color' d='M1.033,14a1.2,1.2,0,0,1-.409-.069.947.947,0,0,1-.337-.207,1.2,1.2,0,0,1-.216-.333,1.046,1.046,0,0,1-.072-.4A1.072,1.072,0,0,1,.072,12.6a.892.892,0,0,1,.216-.321.947.947,0,0,1,.337-.207A1.2,1.2,0,0,1,1.033,12H22.967a1.206,1.206,0,0,1,.409.069.935.935,0,0,1,.336.207.9.9,0,0,1,.217.321,1.072,1.072,0,0,1,.072.391,1.046,1.046,0,0,1-.072.4,1.206,1.206,0,0,1-.217.333.935.935,0,0,1-.336.207,1.206,1.206,0,0,1-.409.069Zm0-6a1.2,1.2,0,0,1-.409-.069.934.934,0,0,1-.337-.207,1.189,1.189,0,0,1-.216-.333A1.046,1.046,0,0,1,0,6.989,1.068,1.068,0,0,1,.072,6.6a.9.9,0,0,1,.216-.322.947.947,0,0,1,.337-.207A1.2,1.2,0,0,1,1.033,6H22.967a1.206,1.206,0,0,1,.409.068.935.935,0,0,1,.336.207.9.9,0,0,1,.217.322A1.068,1.068,0,0,1,24,6.989a1.046,1.046,0,0,1-.072.4,1.193,1.193,0,0,1-.217.333.923.923,0,0,1-.336.207A1.206,1.206,0,0,1,22.967,8Zm0-6a1.2,1.2,0,0,1-.409-.068.947.947,0,0,1-.337-.207,1.193,1.193,0,0,1-.216-.334A1.039,1.039,0,0,1,0,.988,1.068,1.068,0,0,1,.072.6.892.892,0,0,1,.288.276.934.934,0,0,1,.625.069,1.2,1.2,0,0,1,1.033,0H22.967a1.206,1.206,0,0,1,.409.069.923.923,0,0,1,.336.207A.9.9,0,0,1,23.928.6,1.068,1.068,0,0,1,24,.988a1.039,1.039,0,0,1-.072.4,1.2,1.2,0,0,1-.217.334.935.935,0,0,1-.336.207A1.206,1.206,0,0,1,22.967,2Z' transform='translate(0 5)' fill='#000'></path>");
                          out.println("</svg>");
                       out.println(" </button>");
                      out.println("</nav>");
                    out.println("</header>");
                  out.println("</div>");
                out.println("</section>");

                
             

           out.println(" <!-- resharepeace Search -->");
            out.println("<div class='resharepeace-search'>");
                out.println("<div class='container'>");
                  out.println("<div class='input-group search-box'>");
                    out.println("<input type='text' name='Search' placeholder='Search' class='form-control' id='Search'>");
                    out.println("<button type='button'><img src='assets/images/icons/close.svg' alt='img'></button>");
                 out.println(" </div>");
                  out.println("<div class='search-results' id='SearchList'>");
                    
                    out.println("<div class='resharepeace-search-list'>");
                      out.println("<a href='#0'>");
                       out.println(" <figure><img src='assets/images/menus/cheesecake.jpg' class='rounded-2' alt='Menu' width='65' height='49'></figure>");
                        out.println("<div class='resharepeace-search-name'>");
                         out.println(" <strong class='small'>Creamy Homemade Cheesecake</strong>");
                       out.println(" </div>");
                     out.println(" </a>");
                   out.println(" </div>");
                    out.println("<div class='resharepeace-search-list'>");
                     out.println(" <a href='#0'>");
                        out.println("<figure><img src='assets/images/menus/donut.jpg' class='rounded-2' alt='Menu' width='65' height='49'></figure>");
                        out.println("<div class='resharepeace-search-name'>");
                         out.println(" <strong class='small'>Donut</strong>");
                       out.println(" </div>");
                      out.println("</a>");
                    out.println("</div>");
                   out.println(" <div class='resharepeace-search-list'>");
                      out.println("<a href='#0'>");
                        out.println("<figure><img src='assets/images/menus/tiramisu.jpg' class='rounded-2' alt='Menu' width='65' height='49'></figure>");
                        out.println("<div class='resharepeace-search-name'>");
                          out.println("<strong class='small'>Tiramisu</strong>");
                        out.println("</div>");
                      out.println("</a>");
                    out.println("</div>");
                   out.println(" <div class='resharepeace-search-list'>");
                      out.println("<a href='#0'>");
                       out.println(" <figure><img src='assets/images/menus/muffin.jpg' class='rounded-2' alt='Menu' width='65' height='49'></figure>");
                       out.println(" <div class='resharepeace-search-name'>");
                          out.println("<strong class='small'>Blueberry Muffin</strong>");
                        out.println("</div>");
                      out.println("</a>");
                   out.println(" </div>");
                   out.println(" <div class='resharepeace-search-list'>");
                      out.println("<a href='recipePancake.html'>");
                        out.println("<figure><img src='assets/images/menus/pancake.jpg' class='rounded-2' alt='Menu' width='65' height='49'></figure>");
                        out.println("<div class='resharepeace-search-name'>");
                          out.println("<strong class='small'>Japanese Souffle Pancake</strong>");
                       out.println(" </div>");
                      out.println("</a>");
                    out.println("</div>");
                    out.println("<div class='resharepeace-search-list'>");
                      out.println("<a href='#0'>");
                       out.println(" <figure><img src='assets/images/menus/waffle.jpg' class='rounded-2' alt='Menu' width='65' height='49'></figure>");
                        out.println("<div class='resharepeace-search-name'>");
                          out.println("<strong class='small'>Homemade Waffle</strong>");
                        out.println("</div>");
                      out.println("</a>");
                    out.println("</div>");
                   out.println(" <div class='text-center py-4'>");
                      out.println("<a href='searchresult.html' class='btn btn-sm btn-outline-dark px-4 py-2'>See all results</a>");
                   out.println(" </div>");
                 out.println(" </div>");
                out.println("</div>");
              out.println("</div>");

            out.println("<div class='container'>");
             out.println(" <!-- resharepeace Components, My 4, My Md 5 -->");
                out.println("<div class='row align-items-center pt-0 pt-md-5'>");
                 out.println(" <div class='col-lg-9 col-8 col-6'>");
                    out.println("<h5>Profile</h5>");
                 out.println(" </div>");
                  
                out.println("</div>");
                out.println("<hr>");
                out.println("<div class='d-flex flex-wrap pt-3 pt-md-5 pb-4 mb-2 align-items-center'>");
                  out.println("<div class='resharepeace-profile resharepeace-sm-profile col-2'>");
                    out.println("<img src='assets/images/avatars/user.png' alt='Avatar'>");
                  out.println("</div>");
                  out.println("<h2> <i class='fas fa-coins' aria-hidden='true'> </i> </h2> ");
                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-grey-70'> <br> Available Points: 1,000 </h6>");

                        out.println("</div>");
                out.println("<div class='row'>");
                  out.println("<div class='col-lg-8'>");
                    out.println("<form class='mt-4'>");
                      out.println("<div class='row'>");
                        out.println("<div class='col-sm-6'>");
                          out.println("<div class='form-group custom-form-group'>");
                            out.println("<label>Full Name</label>");
                            out.println("<div class='form-control-box'>");
                              out.println("<input type='text' class='form-control' value='" + rset2.getString("Firstname") + "'>");
                             out.println(" <span class='form-icon'>");
                                out.println("<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                                  out.println("<rect data-name='Bounding Box' width='24' height='24' fill='rgba(255,255,255,0)'/>");
                                  out.println("<path d='M16,19V17a3,3,0,0,0-3-3H5a3,3,0,0,0-3,3v2a1,1,0,0,1-2,0V17a5,5,0,0,1,5-5h8a5,5,0,0,1,5,5v2a1,1,0,0,1-2,0ZM4,5a5,5,0,1,1,5,5A5.006,5.006,0,0,1,4,5ZM6,5A3,3,0,1,0,9,2,3,3,0,0,0,6,5Z' transform='translate(3 2)'' fill='#7f7f7f'/>");
                                out.println("</svg>");
                              out.println("</span>");
                            out.println("</div>");
                          out.println("</div>");
                        out.println("</div>");
                        out.println("<div class='col-sm-6'>");
                          out.println("<div class='form-group custom-form-group'>");
                            out.println("<label>Username</label>");
                            out.println("<div class='form-control-box'>");
                              out.println("<input type='text' class='form-control' value='" + rset2.getString("username") + "'>");
                              out.println("<span class='form-icon'>");
                               out.println(" <svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                                  out.println("<rect data-name='Bounding Box' width='24' height='24' fill='rgba(255,255,255,0)'/>");
                                  out.println("<path d='M4.017,19.5A11,11,0,1,1,22,11v1a4,4,0,0,1-7.261,2.316A5,5,0,1,1,14,7V7a1,1,0,0,1,2,0v5a2,2,0,1,0,4,0V11a9,9,0,1,0-3.528,7.146,1,1,0,1,1,1.216,1.588A11,11,0,0,1,4.017,19.5ZM8,11a3,3,0,1,0,3-3A3,3,0,0,0,8,11Z' transform='translate(0.999 0.999)'' fill='#7f7f7f'/>");
                                out.println("</svg>");
                              out.println("</span>");
                            out.println("</div>");
                          out.println("</div>");
                        out.println("</div>");
                        out.println("<div class='col-sm-6'>");
                          out.println("<div class='form-group custom-form-group'>");
                            out.println("<label>Email</label>");
                            out.println("<div class='form-control-box'>");
                              out.println("<input type='text' class='form-control' value='" + rset2.getString("email") + "'>");
                             out.println(" <span class='form-icon'>");
                                out.println("<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                                  out.println("<rect data-name='Bounding Box' width='24' height='24' fill='rgba(255,255,255,0)'/>");
                                  out.println("<path d='M3,18a3,3,0,0,1-3-3V3.01C0,3,0,2.99,0,2.98A3,3,0,0,1,3,0H19a3,3,0,0,1,3,2.968c0,.018,0,.036,0,.054V15a3,3,0,0,1-3,3ZM2,15a1,1,0,0,0,1,1H19a1,1,0,0,0,1-1V4.921l-8.427,5.9a1,1,0,0,1-1.147,0L2,4.921ZM11,8.78l8.895-6.226A1,1,0,0,0,19,2H3a1,1,0,0,0-.895.553Z' transform='translate(1 3)' fill='#7f7f7f'/>");
                                out.println("</svg>");
                             out.println(" </span>");
                            out.println("</div>");
                          out.println("</div>");
                        out.println("</div>");
                        out.println("<div class='col-sm-6'>");
                          out.println("<div class='form-group custom-form-group'>");
                            out.println("<label>Contacts</label>");
                            out.println("<div class='form-control-box'>");
                              out.println("<input type='text' class='form-control' value='98123456'>");
                              out.println("<span class='form-icon'>");
                                out.println("<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                                  out.println("<rect data-name='Bounding Box' width='24' height='24' fill='rgba(255,255,255,0)'/>");
                                  out.println("<path d='M3,22a3,3,0,0,1-3-3V12A3,3,0,0,1,3,9H4V6A6,6,0,0,1,16,6V9h1a3,3,0,0,1,3,3v7a3,3,0,0,1-3,3ZM2,12v7a1,1,0,0,0,1,1H17a1,1,0,0,0,1-1V12a1,1,0,0,0-1-1H3A1,1,0,0,0,2,12ZM14,9V6A4,4,0,1,0,6,6V9Z' transform='translate(2 1)' fill='#7f7f7f'/>");
                                out.println("</svg>");
                              out.println("</span>");
                              out.println("<div class='text-right'>");
                               out.println(" <a href='javascript:void(0);' data-toggle='modal' data-target='#exampleModalCenter' class='btn btn-sm btn-outline-dark ml-0 ml-md-4'>Edit Profile</a>");
                              out.println("</div>");
                            out.println("</div>");
                         out.println(" </div>");
                        out.println("</div>");
                     out.println(" </div>");

          out.println("<!-- Modal Edit Profile -->");
             out.println(" <div class='modal fade' id='exampleModalCenter' tabindex='-1' role='dialog' aria-labelledby='exampleModalCenterTitle' aria-hidden='true'>");
               out.println(" <div class='modal-dialog modal-dialog-centered' role='document'>");
                  out.println("<div class='modal-content rounded-4 shadow-17 mb-4 mb-md-5'>");
                    out.println("<button type='button' class='close' data-dismiss='modal' aria-label='Close'>");
                      out.println("<span aria-hidden='true'>");
                        out.println("<svg id='feather-icon_search' data-name='feather-icon/search' xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                          out.println("<rect id='Bounding_Box' data-name='Bounding Box' width='24' height='24' fill='#d8d8d8' opacity='0'></rect>");
                          out.println("<path id='Shape' d='M14.435,15.849,8.071,9.485,1.707,15.849A1,1,0,0,1,.293,14.435L6.657,8.071.293,1.707A1,1,0,0,1,1.707.293L8.071,6.657,14.435.293a1,1,0,0,1,1.414,1.415L9.485,8.071l6.364,6.364a1,1,0,1,1-1.414,1.414Z' transform='translate(3.929 3.929)'></path>");
                       out.println(" </svg>");
                     out.println(" </span>");
                    out.println("</button>");
                   out.println(" <div class='modal-body'>");
                      out.println("<h6 class='text-uppercase mb-4 pb-2'>Edit Profile</h6>");
                      out.println("<form>");
                        out.println("<div class='form-group mt-md-3 pb-md-3'>");
                          out.println("<label>Name</label>");
                          out.println("<div class='form-control-box'>");
                            out.println("<div class='form-control-box'>");
                             out.println(" <input type='text' class='form-control' value='" + rset2.getString("Firstname") + "'>");
                              out.println("<span class='form-icon'>");
                                out.println("<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                                 out.println(" <rect data-name='Bounding Box' width='24' height='24' fill='rgba(255,255,255,0)'/>");
                                  out.println("<path d='M16,19V17a3,3,0,0,0-3-3H5a3,3,0,0,0-3,3v2a1,1,0,0,1-2,0V17a5,5,0,0,1,5-5h8a5,5,0,0,1,5,5v2a1,1,0,0,1-2,0ZM4,5a5,5,0,1,1,5,5A5.006,5.006,0,0,1,4,5ZM6,5A3,3,0,1,0,9,2,3,3,0,0,0,6,5Z' transform='translate(3 2)' fill='#7f7f7f'/>");
                                out.println("</svg>");
                             out.println("</span>");
                            out.println("</div>");
                            out.println("</span>");
                          out.println("</div>");
                        out.println("</div>");

                        out.println("<div class='form-group custom-form-group'>");
                          out.println("<label>Username</label>");
                            out.println("<div class='form-control-box'>");
                              out.println("<input type='text' class='form-control' value='" + rset2.getString("username") + "'>");
                              out.println("<span class='form-icon'>");
                                out.println("<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                                  out.println("<rect data-name='Bounding Box' width='24' height='24' fill='rgba(255,255,255,0)'/>");
                                  out.println("<path d='M4.017,19.5A11,11,0,1,1,22,11v1a4,4,0,0,1-7.261,2.316A5,5,0,1,1,14,7V7a1,1,0,0,1,2,0v5a2,2,0,1,0,4,0V11a9,9,0,1,0-3.528,7.146,1,1,0,1,1,1.216,1.588A11,11,0,0,1,4.017,19.5ZM8,11a3,3,0,1,0,3-3A3,3,0,0,0,8,11Z' transform='translate(0.999 0.999)'' fill='#7f7f7f'/>");
                                out.println("</svg>");
                              out.println("</span>");
                            out.println("</div>");
                          out.println("</div>");

                          out.println("<div class='form-group custom-form-group'>");
                            out.println("<label>Email</label>");
                            out.println("<div class='form-control-box'>");
                              out.println("<input type='text' class='form-control' value='" + rset2.getString("email") + "'>");
                              out.println("<span class='form-icon'>");
                                out.println("<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                                  out.println("<rect data-name='Bounding Box' width='24' height='24' fill='rgba(255,255,255,0)'/>");
                                  out.println("<path d='M3,18a3,3,0,0,1-3-3V3.01C0,3,0,2.99,0,2.98A3,3,0,0,1,3,0H19a3,3,0,0,1,3,2.968c0,.018,0,.036,0,.054V15a3,3,0,0,1-3,3ZM2,15a1,1,0,0,0,1,1H19a1,1,0,0,0,1-1V4.921l-8.427,5.9a1,1,0,0,1-1.147,0L2,4.921ZM11,8.78l8.895-6.226A1,1,0,0,0,19,2H3a1,1,0,0,0-.895.553Z' transform='translate(1 3)'' fill='#7f7f7f'/>");
                                out.println("</svg>");
                              out.println("</span>");
                            out.println("</div>");
                          out.println("</div>");

                         out.println(" <div class='form-group custom-form-group'>");
                           out.println(" <label>Contacts</label>");
                            out.println("<div class='form-control-box'>");
                              out.println("<input type='text' class='form-control' value='98123456'>");
                              out.println("<span class='form-icon'>");
                                out.println("<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                                 out.println(" <rect data-name='Bounding Box' width='24' height='24' fill='rgba(255,255,255,0)'/>");
                                  out.println("<path d='M3,22a3,3,0,0,1-3-3V12A3,3,0,0,1,3,9H4V6A6,6,0,0,1,16,6V9h1a3,3,0,0,1,3,3v7a3,3,0,0,1-3,3ZM2,12v7a1,1,0,0,0,1,1H17a1,1,0,0,0,1-1V12a1,1,0,0,0-1-1H3A1,1,0,0,0,2,12ZM14,9V6A4,4,0,1,0,6,6V9Z' transform='translate(2 1)' fill='#7f7f7f'/>");
                                out.println("</svg>");
                              out.println("</span>");
                            out.println("</div>");
                          out.println("</div>");


                       out.println(" <div class='form-group mt-md-3 pb-md-3'>");
                          out.println("<label>Password</label>");
                          out.println("<div class='form-control-box'>");
                            out.println("<input type='password' class='form-control' placeholder='Password'>");
                            out.println("<span class='form-icon'>");
                              out.println("<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>");
                                out.println("<rect data-name='Bounding Box' width='24' height='24' fill='rgba(255,255,255,0)'></rect>");
                                out.println("<path d='M3,22a3,3,0,0,1-3-3V12A3,3,0,0,1,3,9H4V6A6,6,0,0,1,16,6V9h1a3,3,0,0,1,3,3v7a3,3,0,0,1-3,3ZM2,12v7a1,1,0,0,0,1,1H17a1,1,0,0,0,1-1V12a1,1,0,0,0-1-1H3A1,1,0,0,0,2,12ZM14,9V6A4,4,0,1,0,6,6V9Z' transform='translate(2 1)' fill='#7f7f7f'></path>");
                              out.println("</svg>");
                            out.println("</span>");
                            
                          out.println("</div>");
                        out.println("</div>");
                        out.println("<a href='profile.html'>");
                       out.println(" <button type='button' class='btn btn-lg btn-block btn-primary'>Save</button>");
                     out.println(" </form>");
                      
                      
                    out.println("</div>");
                  out.println("</div>");
                out.println("</div>");
              out.println("</div>");




           out.println("<body class='u-body'><header class='u-clearfix u-header u-header' id='sec-965c'><div class='u-clearfix u-sheet u-sheet-1'>");
                  
                    
                    out.println("<div class='u-custom-menu u-nav-container-collapse'>");
                      out.println("<div class='u-align-center u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav'>");
                        out.println("<div class='u-sidenav-overflow'>");
                         out.println(" <div class='u-menu-close'></div>");
                          out.println("<ul class='u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2'><li class='u-nav-item'><a class='u-button-style u-nav-link' href='Page-1.html'style='padding: 10px 20px;'>home</a>");
          out.println("</li></ul>");
                        out.println("</div>");
                      out.println("</div>");
                     out.println(" <div class='u-black u-menu-overlay u-opacity u-opacity-70'></div>");
                   out.println(" </div>");
                 out.println(" </nav>");
                out.println("</div></header>");
              out.println("<section class='u-align-left u-clearfix u-section-1' id='sec-75b4'>");
                out.println("<div class='u-clearfix u-sheet u-sheet-1'>");
                  out.println("<div class='u-expanded-width u-tab-links-align-left u-tabs u-tabs-1'>");
                    out.println("<ul class='u-border-2 u-border-palette-1-base u-spacing-10 u-tab-list u-unstyled' role='tablist'>");
                      out.println("<li class='u-tab-item u-tab-item-1' role='presentation'>");
                       out.println(" <a class='active u-active-palette-1-dark-2 u-button-style u-grey-10 u-tab-link u-text-active-white u-text-black u-tab-link-1' id='tab-ea5a' href='#link-tab-ea5a' role='tab' aria-controls='link-tab-ea5a' aria-selected='true'>Your Favourites&nbsp;<span class='u-icon u-icon-circle u-text-palette-1-base u-icon-1'>");
                            out.println("<svg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' version='1.1' xml:space='preserve' class='u-svg-content' viewBox='0 0 50 50' x='0px' y='0px' style='color: rgb(215, 90, 74); width: 1em; height: 1em;'><path style='fill:currentColor;' d='M24.85,10.126c2.018-4.783,6.628-8.125,11.99-8.125c7.223,0,12.425,6.179,13.079,13.543 c0,0,0.353,1.828-0.424,5.119c-1.058,4.482-3.545,8.464-6.898,11.503L24.85,48L7.402,32.165c-3.353-3.038-5.84-7.021-6.898-11.503 c-0.777-3.291-0.424-5.119-0.424-5.119C0.734,8.179,5.936,2,13.159,2C18.522,2,22.832,5.343,24.85,10.126z'></path></svg>");
                          out.println("</span>");
                        out.println("</a>");
                      out.println("</li>");
                      out.println("<li class='u-tab-item u-tab-item-2' role='presentation'>");
                        out.println("<a class='u-active-palette-1-dark-2 u-button-style u-grey-10 u-tab-link u-text-active-white u-text-black u-tab-link-2' id='tab-2365' href='#link-tab-2365' role='tab' aria-controls='link-tab-2365' aria-selected='false'>Your Recipes&nbsp;<span class='u-icon u-icon-circle u-text-palette-1-base u-icon-2'>");
                            out.println("<svg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' version='1.1' xml:space='preserve' class='u-svg-content' viewBox='0 0 64 64' style='width: 1em; height: 1em;'><path d='m13 62h44v-12h-44c-3.314 0-6 2.686-6 6 0 3.314 2.686 6 6 6z' fill='#c1c8d1'></path><path d='m57 54h-44c-1.105 0-2 .895-2 2s.895 2 2 2h44' fill='#a8b0bc'></path><path d='m7 56v-47c0-3.866 3.134-7 7-7h36c3.866 0 7 3.134 7 7v41h-44c-3.314 0-6 2.686-6 6z' fill='#2b74ca'></path><path d='m19.5 43c16.845 0 30.5-13.208 30.5-29.5 0-4.08-.857-7.966-2.405-11.5h-33.595c-3.866 0-7 3.134-7 7v31.407c3.816 1.661 8.044 2.593 12.5 2.593z' fill='#3d98f7'></path><path d='m42 10c-.989 0-1.933.186-2.808.514-1.296-2.669-4.025-4.514-7.192-4.514s-5.896 1.845-7.192 4.514c-.875-.328-1.819-.514-2.808-.514-4.418 0-8 3.582-8 8s3.582 8 8 8v14h20v-14c4.418 0 8-3.582 8-8s-3.582-8-8-8z' fill='#c7e2fc'></path><path d='m39.192 10.514c-1.296-2.669-4.025-4.514-7.192-4.514s-5.896 1.845-7.192 4.514c-.875-.328-1.819-.514-2.808-.514-4.418 0-8 3.582-8 8s3.582 8 8 8v4.822c.82.105 1.65.178 2.5.178 10.217 0 18.5-7.835 18.5-17.5 0-1.188-.128-2.347-.366-3.468-.21-.016-.42-.032-.634-.032-.989 0-1.933.186-2.808.514z' fill='#ebf7fe'></path><path d='m22 36h20v4h-20z' fill='#a1cdfb'></path><path d='m57 63h-44c-3.859 0-7-3.14-7-7v-47c0-4.411 3.589-8 8-8h36c4.411 0 8 3.589 8 8v53c0 .552-.447 1-1 1zm-49-7c0 2.757 2.243 5 5 5h43v-10h-43c-2.757 0-5 2.243-5 5zm6-53c-3.309 0-6 2.691-6 6v42.105c1.271-1.298 3.043-2.105 5-2.105h43v-40c0-3.309-2.691-6-6-6z'></path><path d='m41 14h-2c0-3.86-3.141-7-7-7s-7 3.14-7 7h-2c0-4.962 4.037-9 9-9s9 4.038 9 9z'></path><path d='m42 41h-20c-.553 0-1-.448-1-1v-13.055c-4.494-.499-8-4.32-8-8.945 0-4.962 4.037-9 9-9 1.166 0 2.302.22 3.375.655l-.75 1.854c-.834-.338-1.717-.509-2.625-.509-3.859 0-7 3.14-7 7s3.141 7 7 7c.553 0 1 .448 1 1v13h18v-13c0-.552.447-1 1-1 3.859 0 7-3.14 7-7s-3.141-7-7-7c-.908 0-1.791.171-2.625.508l-.75-1.854c1.073-.434 2.209-.654 3.375-.654 4.963 0 9 4.038 9 9 0 4.625-3.506 8.446-8 8.945v13.055c0 .552-.447 1-1 1z'></path><path d='m22 35h20v2h-20z'></path><path d='m42 23v-2c1.654 0 3-1.346 3-3h2c0 2.757-2.243 5-5 5z'></path><path d='m19 43h26v2h-26z'></path><path d='m57 59h-44c-1.654 0-3-1.346-3-3s1.346-3 3-3h44v2h-44c-.552 0-1 .449-1 1s.448 1 1 1h44z'></path></svg>");
                          out.println("</span>");
                        out.println("</a>");
                      out.println("</li>");
                      out.println("<li class='u-tab-item u-tab-item-3' role='presentation'>");
                        out.println("<a class='u-active-palette-1-dark-2 u-button-style u-grey-10 u-tab-link u-text-active-white u-text-black u-tab-link-3' id='tab-cf79' href='#link-tab-cf79' role='tab' aria-controls='link-tab-cf79' aria-selected='false'>Your Classes&nbsp;<span class='u-icon u-icon-circle u-spacing-10 u-white u-icon-3;>");
                            out.println("<svg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' version='1.1' xml:space='preserve' class='u-svg-content' viewBox='0 0 512 512' style='width: 1em; height: 1em;'><g><path d='m471 385.284v-49.284c0-12.971-6.335-25.477-17.379-34.313-.249-.199-.508-.386-.76-.58 6.34-8.011 10.139-18.121 10.139-29.107 0-20.671-13.42-38.256-32-44.531v-182.469c0-24.813-20.187-45-45-45h-260c-24.813 0-45 20.187-45 45v182.469c-18.58 6.275-32 23.86-32 44.531 0 10.998 3.808 21.118 10.16 29.134-11.144 8.607-18.16 21.049-18.16 34.866v49.284c-22.468 2.496-40 21.593-40 44.716v37c0 24.813 20.187 45 45 45h420c24.813 0 45-20.187 45-45v-37c0-23.123-17.532-42.22-40-44.716zm-160-.284v-49c0-12.971-6.335-25.477-17.379-34.313-.249-.199-.508-.386-.76-.58 3.313-4.187 5.927-8.946 7.67-14.107h70.938c1.747 5.172 4.368 9.94 7.691 14.134-11.144 8.607-18.16 21.049-18.16 34.866v49zm-160 0v-49c0-12.971-6.335-25.477-17.379-34.313-.249-.199-.508-.386-.76-.58 3.313-4.187 5.927-8.946 7.67-14.107h70.938c1.747 5.172 4.368 9.94 7.691 14.134-11.144 8.607-18.16 21.049-18.16 34.866v49zm-80-49c0-9.056 11.683-17 25-17 7.143 0 14.023 2.229 18.88 6.113 2.285 1.829 6.12 5.675 6.12 10.887v49h-50zm185-47c-9.374 0-17-7.626-17-17s7.626-17 17-17 17 7.626 17 17-7.626 17-17 17zm-25 47c0-9.056 11.683-17 25-17 7.143 0 14.023 2.229 18.88 6.113 2.285 1.829 6.12 5.675 6.12 10.887v49h-50zm160 0c0-9.056 11.683-17 25-17 7.143 0 14.023 2.229 18.88 6.113 2.285 1.829 6.12 5.675 6.12 10.887v49h-50zm25-47c-9.374 0-17-7.626-17-17s7.626-17 17-17 17 7.626 17 17-7.626 17-17 17zm-290-259h260c8.271 0 15 6.729 15 15v182.469c-13.866 4.684-24.848 15.665-29.531 29.531h-70.938c-6.276-18.58-23.86-32-44.531-32s-38.255 13.42-44.531 32h-70.938c-4.684-13.866-15.665-24.848-29.531-29.531v-182.469c0-8.271 6.729-15 15-15zm-47 242c0-9.374 7.626-17 17-17s17 7.626 17 17-7.626 17-17 17-17-7.626-17-17zm402 195c0 8.271-6.729 15-15 15h-420c-8.271 0-15-6.729-15-15v-37c0-8.271 6.729-15 15-15h420c8.271 0 15 6.729 15 15z'></path><path d='m226.7 193.894c3.636 1.919 7.597 2.869 11.545 2.868 4.881 0 9.742-1.451 13.938-4.318l56.046-38.294c6.723-4.594 10.749-12.197 10.771-20.339.022-8.141-3.961-15.766-10.656-20.396l.001.001-56.046-38.77c-7.583-5.244-17.367-5.845-25.536-1.563-8.167 4.282-13.24 12.67-13.24 21.891v77.062c-.001 9.192 5.049 17.567 13.177 21.858zm16.822-88.84 41.435 28.662-41.435 28.312z'></path>");
                           out.println("</g></svg>");
                         out.println(" </span>");
                        out.println("</a>");
                      out.println("</li>");
                    out.println("</ul>");
                    out.println("<div class='u-tab-content'>");
                      out.println("<div class='u-align-left u-container-style u-tab-active u-tab-pane u-white u-tab-pane-1' id='link-tab-ea5a' role='tabpanel' aria-labelledby='tab-ea5a'>");
                        out.println("<div class='u-container-layout u-container-layout-1'>");
                          out.println("<span class='u-border-2 u-border-palette-1-base u-icon u-icon-circle u-spacing-10 u-text-palette-1-base u-icon-4'>");
                            out.println("<svg class='u-svg-link' preserveAspectRatio='xMidYMin slice' viewBox='0 0 50 50' style=''><use xmlns:xlink='http://www.w3.org/1999/xlink' xlink:href='#svg-9b1e'></use></svg>");
                            out.println("<svg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' version='1.1' xml:space='preserve' class='u-svg-content' viewBox='0 0 50 50' x='0px' y='0px' id='svg-9b1e' style='color: rgb(215, 90, 74);'><path style='fill:currentColor;'' d='M24.85,10.126c2.018-4.783,6.628-8.125,11.99-8.125c7.223,0,12.425,6.179,13.079,13.543 c0,0,0.353,1.828-0.424,5.119c-1.058,4.482-3.545,8.464-6.898,11.503L24.85,48L7.402,32.165c-3.353-3.038-5.84-7.021-6.898-11.503  c-0.777-3.291-0.424-5.119-0.424-5.119C0.734,8.179,5.936,2,13.159,2C18.522,2,22.832,5.343,24.85,10.126z></path></svg>");
                          out.println("</span>");
                          out.println("<div class='u-expanded-width u-gallery u-layout-grid u-lightbox u-no-transition u-show-text-always u-gallery-1'>");
                           out.println(" <div class='u-gallery-inner u-gallery-inner-1'>");
                              out.println("<div class='u-gallery-item' data-href='Page-1.html'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/muffin1.jpg' alt='Blueberry Muffins'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-1'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-grey-5' style='background-image: none; font-weight: 400;'>Blueberry Muffins</h6>");
                                  out.println("<p class='u-gallery-text'></p>");
                                out.println("</div>");
                              out.println("</div>");
                              out.println("<div class='u-gallery-item' data-href='Page-1.html'>");
                               out.println(" <div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/donut.jpg' alt='' Mochi Glazed Donuts'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-2'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-grey-5' style='background-image: none; font-weight: 400;'> Mochi Glazed Donuts</h6>");
                                  out.println("<p class='u-gallery-text'></p>");
                                out.println("</div>");
                             out.println(" </div>");
                              out.println("<div class='u-gallery-item' data-href='https://nicepage.com'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/tiramisu1.jpg' alt='Tiramisu'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-3'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-grey-5' style='background-image: none; font-weight: 400;'>Tiramisu</h6>");
                                  out.println("<p class='u-gallery-text'></p>");
                                out.println("</div>");
                              out.println("</div>");
                             out.println(" <div class='u-gallery-item'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/pancake1.jpg' alt='Pancakes'>");
                               out.println(" </div>");
                               out.println(" <div class='u-over-slide u-shading u-valign-bottom u-over-slide-4'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-grey-5' style='background-image: none; font-weight: 400;'>Pancakes</h6>");
                                 out.println(" <p class='u-gallery-text'></p>");
                                out.println("</div>");
                              out.println("</div>");
                           out.println(" </div>");
                          out.println("</div>");
                        out.println("</div>");
                      out.println("</div>");
                      out.println("<div class='u-align-left u-container-style u-tab-pane u-white u-tab-pane-2' id='link-tab-2365' role='tabpanel' aria-labelledby='tab-2365'>");
                        out.println("<div class='u-container-layout u-valign-top u-container-layout-2'>");
                          out.println("<a href='AddRecipe-2.html' class='u-border-2 u-border-grey-75 u-border-radius-11 u-btn u-btn-round u-button-style u-hover-palette-1-dark-2 u-palette-1-base u-btn-1'>");
                            out.println("<span class='u-icon u-icon-5'>");
                              out.println("<svg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' version='1.1' xml:space='preserve' class='u-svg-content' viewBox='0 0 448 448' style='width: 1em; height: 1em;''><path d='m408 184h-136c-4.417969 0-8-3.582031-8-8v-136c0-22.089844-17.910156-40-40-40s-40 17.910156-40 40v136c0 4.417969-3.582031 8-8 8h-136c-22.089844 0-40 17.910156-40 40s17.910156 40 40 40h136c4.417969 0 8 3.582031 8 8v136c0 22.089844 17.910156 40 40 40s40-17.910156 40-40v-136c0-4.417969 3.582031-8 8-8h136c22.089844 0 40-17.910156 40-40s-17.910156-40-40-40zm0 0'></path></svg>");
                            out.println("</span>&nbsp;Add recipe");
                         out.println(" </a>");
                          out.println("<div class='u-expanded-width u-gallery u-layout-grid u-lightbox u-no-transition u-show-text-always u-gallery-2'>");
                            out.println("<div class='u-gallery-inner u-gallery-inner-2'>");
                              out.println("<div class='u-gallery-item' data-href='Page-1.html'>");
                               out.println(" <div class='u-back-slide'>");
                                 out.println(" <img class='u-back-image u-expanded' src='images/muffin1.jpg' alt='Blueberry Muffins'>");
                               out.println(" </div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-5'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-grey-5' style='background-image: none; font-weight: 400;''>Blueberry Muffins</h6>");
                                 out.println(" <p class='u-gallery-text'></p>");
                                out.println("</div>");
                              out.println("</div>");
                              out.println("<div class='u-gallery-item' data-href='Page-1.html'>");
                               out.println(" <div class='u-back-slide'>");
                                 out.println(" <img class='u-back-image u-expanded' src='images/donut.jpg' alt='' Mochi Glazed Donuts'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-6'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-grey-5' style='background-image: none; font-weight: 400;''> Mochi Glazed Donuts</h6>");
                                  out.println("<p class='u-gallery-text'></p>");
                                out.println("</div>");
                             out.println(" </div>");
                              out.println("<div class='u-gallery-item' data-href='https://nicepage.com'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/tiramisu1.jpg' alt='Tiramisu'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-7'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-grey-5' style='background-image: none; font-weight: 400;'>Tiramisu</h6>");
                                  out.println("<p class='u-gallery-text'></p>");
                                out.println("</div>");
                              out.println("</div>");
                              out.println("<div class='u-gallery-item'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/macarons.jpg' alt='Macarons'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-8'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-grey-5' style='background-image: none; font-weight: 400;'>Macarons</h6>");
                                 out.println(" <p class='u-gallery-text'></p>");
                               out.println(" </div>");
                             out.println(" </div>");
                              out.println("<div class='u-gallery-item' data-image-width='800' data-image-height='450'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='" + rset2.getString("recipe_photo")  + "' alt='" + rset2.getString("recipe_name")  + "'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-9'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-grey-5' style='background-image: none; font-weight: 400;''>" + rset2.getString("recipe_name")  + "</h6>");
                                  out.println("<p class='u-gallery-text'></p>");
                               out.println(" </div>");
                              out.println("</div>");
                           out.println("</div>");
                         out.println(" </div>");
                        out.println("</div>");
                      out.println("</div>");
                      out.println("<div class='u-align-left u-container-style u-tab-pane u-white u-tab-pane-3' id='link-tab-cf79' role='tabpanel' aria-labelledby='tab-cf79'>");
                        out.println("<div class='u-container-layout u-valign-top u-container-layout-3'>");
                          out.println("<a href='AddClass.html' class='u-border-2 u-border-grey-75 u-border-radius-11 u-btn u-btn-round u-button-style u-hover-palette-1-dark-2 u-palette-1-base u-btn-2'>");
                            out.println("<span class='u-icon u-icon-6'>");
                             out.println(" <svg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' version='1.1' xml:space='preserve' class='u-svg-content' viewBox='0 0 448 448' style='width: 1em; height: 1em;' id='svg-4e1b'><path d='m408 184h-136c-4.417969 0-8-3.582031-8-8v-136c0-22.089844-17.910156-40-40-40s-40 17.910156-40 40v136c0 4.417969-3.582031 8-8 8h-136c-22.089844 0-40 17.910156-40 40s17.910156 40 40 40h136c4.417969 0 8 3.582031 8 8v136c0 22.089844 17.910156 40 40 40s40-17.910156 40-40v-136c0-4.417969 3.582031-8 8-8h136c22.089844 0 40-17.910156 40-40s-17.910156-40-40-40zm0 0'></path></svg>");
                            out.println("</span>&nbsp;Add class");
                          out.println("</a>");
                          out.println("<div class='u-expanded-width u-gallery u-layout-grid u-lightbox u-no-transition u-show-text-always u-gallery-3'>");
                            out.println("<div class='u-gallery-inner u-gallery-inner-'>");
                              out.println("<div class='u-gallery-item' data-href='Page-1.html'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/bakingclass.jpeg' alt='Fine Dining Class'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-10'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-white' style='background-image: none; font-weight: 400;''>Fine Dining Class</h6>");
                                  out.println("<p class='u-gallery-text' style='margin-top: 3px;'></p>");
                                out.println("</div>");
                              out.println("</div>");
                              out.println("<div class='u-gallery-item' data-href='Page-1.html'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/cookingclass.jpg' alt='Cooking Class'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-1'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-white' style='background-image: none; font-weight: 400;''>Cooking Class</h6>");
                                 out.println(" <p class='u-gallery-text' style='margin-top: 3px;'></p>");
                                out.println("</div>");
                              out.println("</div>");
                              out.println("<div class='u-gallery-item' data-href='https://nicepage.com'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/maggieclass.jpg' alt='Instant Noodle Class'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-12'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-white' style='background-image: none; font-weight: 400;''>Instant Noodle Class</h6>");
                                  out.println("<p class='u-gallery-text' style='margin-top: 3px;'></p>");
                                out.println("</div>");
                              out.println("</div>");
                              out.println("<div class='u-gallery-item'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/sushimakingclass.png' alt='Sushi Making Class'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-13'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-white' style='background-image: none; font-weight: 400;''>Sushi Making Class</h6>");
                                  out.println("<p class='u-gallery-text' style='margin-top: 3px;'></p>");
                                out.println("</div>");
                            
                              out.println("</div>");
                              out.println("<div class='u-gallery-item'>");
                                out.println("<div class='u-back-slide'>");
                                  out.println("<img class='u-back-image u-expanded' src='images/macaronclass.jpg' alt='Macaron Class'>");
                                out.println("</div>");
                                out.println("<div class='u-over-slide u-shading u-valign-bottom u-over-slide-15'>");
                                  out.println("<h6 class='u-align-center u-custom-font u-font-Lobster u-gallery-heading u-text-white' style='background-image: none; font-weight: 400;'>Macaron Class</h6>");
                                  out.println("<p class='u-gallery-text' style='margin-top: 3px;'></p>");
                                out.println("</div>");
                              out.println("</div>");
                            out.println("</div>");
                          out.println("</div>");
                        out.println("</div>");
                      out.println("</div>");
                    out.println("</div>");
                  out.println("</div>");
                out.println("</div>");
              out.println("</section>");



            
            out.println("<!-- resharepeace Footer, Pt 3, Pt Md 5 -->");
            out.println("<footer class='resharepeace-footer pt-3 pt-md-5 bg-lightest-gray'>");
              out.println("<div class='container'>");
                out.println("<div class='row pt-4 pb-0 pb-md-5'>");
                  out.println("<div class='col-md-6'>");
                    
                    out.println("</div>");
                  out.println("</div>");
                out.println("</div>");
              out.println("</div>");
            out.println("</footer>");

          out.println("<!-- Scripts -->");
          out.println("<script src='assets/js/jquery.min.js'></script>");
          out.println("<script src='assets/js/bootstrap.bundle.min.js'></script>");
          out.println("<script src='assets/js/html5.min.js'></script>");
          out.println("<script src='assets/js/hover-animation.min.js'></script>");
          out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js'></script>");
          out.println("<script src='assets/js/sticky.min.js'></script>");
          out.println("<script src='assets/js/swiper-bundle.min.js'></script>");
          out.println("<script src='assets/js/masonry.min.js'></script>");
          out.println("<script src='assets/js/scripts.js'></script>");
          out.println("<script class='u-script' type='text/javascript' src='js/jquery.js' defer=''></script>");
          out.println("<script class=u-script' type='text/javascript' src='js/nicepage.js' defer=''></script>");

          out.println("</body>");
          out.println("</html>");
                
                     /* out.println("<p>Username: " + rset2.getString("username") +  "</p>");
                      out.println("<p>Name: " + rset2.getString("Firstname") +  "</p>");
                      out.println("<p>Account Status: " + rset2.getString("user_status") +  "</p>");
                      out.println("<p>Contact Infofmation: " + rset2.getString("user_FB") +  "</p>");
                      out.println("<p>Bio: " + rset2.getString("user_bio") +  "</p>");

                     
                            
                         //out.println("<input type='submit' name='recipe_name' value=" + rset2.getString("recipe_name") );
                         out.println("<p> <img src='" + rset2.getString("recipe_photo") + "'alt=\"recipe_photo\" style=\"width:300px;height:300px;\"> </p>");
                        // out.println("<p><input type='image' src='" + rset2.getString("recipe_photo") + " alt='Submit' width='300' height='300'></p>");
                        out.println("<form method='get' action='description'>");
                        out.println("<p> <input type='submit' name='recipe_name' value=" + rset2.getString("recipe_name")  + "</p>");
                        
                         //out.println("<p>" + rset2.getString("recipe_name") + "</p>");
                         out.println("<p>" + rset2.getString("recipe_rating") + "</p>"); */

               
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