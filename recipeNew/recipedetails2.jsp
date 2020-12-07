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
<body style="color: black;">

  <h1 class="title is-2 is-spaced"> Home </h1>
               
        <p>
            <b>recipedetails</b>
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
                            String imageLocation = "http://localhost:9999/recipenew/images/" + p.getphotoname();
                            System.out.println(p);
                             String recipeidx = String.valueOf(p.getrecipeid()); 
                            System.out.println(session.getAttribute("recipeid"));
                            if (recipeidx.equals(session.getAttribute("recipeid"))) {
                               
                %>
                <div class="box" style="margin: 20px;">
                    <article class="media">
                      <div class="media-left">
                        <figure class="image is-128x128">
                          <img class="image is-128x128" src="<%=imageLocation%>" alt="Image">
                        </figure>
                      </div>
                      <div class="media-content">
                        <div class="content">
                          <p>
                            <strong><%=p.getrecipename()%></strong>
                            <br>
                            <p class="title is-4">time taken: <%=p.getrecipetimetaken()%> </p>
                            <p> recipe steps: </p> <br>
                            <%=p.getrecipesteps()%>
                          </p>
                        </div>
                       
                      </div>
                    
                  </div>
                <%
                            }
                    }
                    }
                 %>
        <hr/>
        
    </body>
</html>