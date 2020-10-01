<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@page import="pack.*"%>

<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
</head>
<body style="color: white;">
  <h1 class="title is-2 is-spaced"> Home </h1>
               
        <p>
            <b>Search Results</b>
        </p>
            <!--Results-->
            <div class="tile">
            
                <%
                    List<recipe> searchResult = (List<recipe>) session.getAttribute("searchResult");
                    if (searchResult == null || searchResult.size()<=0){
                %>
                <tr><td colspan="6">(No result is found)</td></tr>
                <%
                    }else
                    {
                        for (recipe p : searchResult){

                       String imageLocation = "http://localhost:9999/recipexnew/images/" + p.getphotoname();
                %>
                <div class="card tile" style="margin: 20px 80px;padding: 0 40px ;">
                    <div class="card-image" style="margin: 10px;">
                      <figure class="image is-128x128">
                        <img class ="image is-128x128" src="<%=imageLocation%>" alt="Placeholder image">
                      </figure>
                    </div>
                    <div class="card-content">
                        <div class="media-content">
                            <p class="title is-4">$<%=p.getrecipename()%></p>
                          <a href="description?recipeid=<%=p.getrecipeid()%>" class="subtitle is-6"><%=p.getrecipename()%></a>
                        </div>
                      </div>
                  
                    </div>
                </div>
                <%
                    }
                    }
                 %>
                
        <hr/>
      
    </body>
</html>