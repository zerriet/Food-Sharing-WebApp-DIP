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


@WebServlet("/Addsrecipe")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
   

   public class Addsrecipe extends HttpServlet {

   private static final String SAVE_DIR = "images";

      private String extractFileName(Part part) {
          String contentDisp = part.getHeader("content-disposition");
          String[] items = contentDisp.split(";");
          for (String s : items) {
              if (s.trim().startsWith("filename")) {
                  return s.substring(s.indexOf("=") + 2, s.length()-1);
              }
          }
          return "";
      }

      private String getFileName(final Part part) {
          final String partHeader = part.getHeader("content-disposition");
          // LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
          for (String content : part.getHeader("content-disposition").split(";")) {
              if (content.trim().startsWith("filename")) {
                  return content.substring(
                          content.indexOf('=') + 1).trim().replace("\"", "");
              }
          }
          return null;
      } 



  // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
      // Set the MIME type for the response message
       //doGet(request, response);
       response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      // Print an HTML page as the output of the query
      out.println("<html>");
     
      out.println("<body>");

     
       
      
      PreparedStatement statement = null;

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

      DateFormat dform= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date obj = new Date();
      String rtime = dform.format(obj);
      out.println(rtime); 

      String rname = request.getParameter("recipename");
        String rtimetaken = request.getParameter("recipetimetaken");
        String ringredient = request.getParameter("recipeingredient");
        String rsteps = request.getParameter("recipesteps");
       

        out.println (rname+rtimetaken+ringredient+rsteps);
       
  
     

      String path = "C:/myWebProject/apachetomcat/webapps/recipexnew/images/"; //!!! everyone different
      Part filePart = request.getPart("file");
      


      
      InputStream filecontent = filePart.getInputStream();
      InputStream inputstream = filecontent;
      String fileName = getFileName(filePart);

      OutputStream  outstream = new FileOutputStream(new File(path + File.separator + fileName));
        
             
        
        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = inputstream.read(bytes)) != -1) {
            outstream.write(bytes, 0, read);
        }


        /* Try and error code1:
        Part filePart = request.getPart("file");
        InputStream inputStream = null;
        
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
        */

        // if (ids != null) {
           
           int count;

        
            // Generate new ID:
              String latestid = "select recipeid from recipe ORDER BY uploaddatetime desc LIMIT 1";
              ResultSet rset = stmt.executeQuery(latestid);  // Send the query to the server
            
                int newid=0;
              
                while(rset.next()) {
             
                newid =rset.getInt("recipeid");
                out.println("<p><input type=\"hidden\"  value=\" Generated ID:" + newid + ".\"></p>");
                
               }
                
                int finalid= newid +1;

              
              //sqlStr = "INSERT INTO recipe (recipeid,recipename,recipetimetaken,recipeingredient,recipesteps,uploaddatetime) VALUES (1005,'" +rname+"'," +rtimetaken+",'"+ringredient+"','"+rsteps+"','"+rtime+"')";
              
                // sqlStr = "INSERT INTO recipe (recipeid,recipename,recipetimetaken,recipeingredient,recipesteps,uploaddatetime) VALUES ('" +finalid+"','" +rname+"'," +rtimetaken+",'"+ringredient+"','"+rsteps+"','"+rtime+"',"+inputStream+")";
              //sqlStr = "INSERT INTO recipe (recipeid,recipename,recipetimetaken,recipeingredient,recipesteps,uploaddatetime) VALUES ('" +finalid+"','" +rname+"'," +rtimetaken+",'"+ringredient+"','"+rsteps+"','"+rtime+"',"+inputStream+")";
              
              String sqlStr= "INSERT INTO recipe (recipeid,recipename,recipetimetaken,recipeingredient,recipesteps,uploaddatetime,photoname,recipephoto) VALUES (?,?,?,?,?,?,?,?)";
              statement = conn.prepareStatement(sqlStr);
              statement.setInt(1, finalid);
              statement.setString(2, rname);
              statement.setString(3, rtimetaken);
              statement.setString(4, ringredient);
              statement.setString(5, rsteps);
              statement.setString(6, rtime);
              statement.setString(7, fileName);

               if (filecontent != null) {
                statement.setBlob(8, filecontent);
              } //statement.setBlob(7, filecontent);
              

              
              //out.println("<p><input type=\"hidden\"  value=\"" + sqlStr + "\"></p>");  // for debugging
             
              count = statement.executeUpdate();
              out.println("<p><input type=\"hidden\"  value=\"" + count + " record inserted.\"><c</p>");
              
              
      }









      catch(Exception ex) {
         out.println("<p>Error: " + ex.getMessage() + "</p>");
         out.println("<p>Check Tomcat console for details.</p>");
         ex.printStackTrace();
      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
 
      out.println("</body></html>");
      out.close();
   }
}

