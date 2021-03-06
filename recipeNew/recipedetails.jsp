<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@page import="pack.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<title>Receipe Pancake</title>

<link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="recipe-pancake.css" media="screen">
<link href="assets/css/styles.css" rel="stylesheet" type="text/css" media="all">
<link href="assets/css/heart.css" rel="stylesheet" >
<link rel="stylesheet" media="all" href="../component/styles/setup.css">
<link rel="stylesheet" media="all" href="../component/styles/says.css">
<link rel="stylesheet" media="all" href="../component/styles/reply.css">
<link rel="stylesheet" media="all" href="../component/styles/typing.css">
<link rel="stylesheet" media="all" href="../component/styles/input.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/font-awesome-animation.min.css">

</head>

<!-- Put the serach bar on top and the menu dropdown button -->

<!-- resharepeace Section, P 0 -->
<section class="resharepeace-section p-0">
  <div class="container">
    <!-- resharepeace Header, Bg White -->
     <!-- resharepeace Header, Bg White -->
    <header class="resharepeace-header bg-white">
      <nav class="navbar navbar-expand-lg has-header-inner px-0">
        <a class="navbar-brand" href="homeUser.html">
          <h5> ReSharePeace </h5>
        </a>
        
        <div class="resharepeace-header-links d-flex align-items-center ml-auto order-0 order-lg-2">
          <a href="javascript:void(0);" class="search-link">
            <svg xmlns="http://www.w3.org/2000/svg" width="26.667" height="26.667" viewBox="0 0 26.667 26.667">
              <path d="M24.39,26.276l-4.9-4.9a12.012,12.012,0,1,1,1.885-1.885l4.9,4.9a1.334,1.334,0,0,1-1.886,1.886ZM2.666,12a9.329,9.329,0,0,0,15.827,6.7,1.338,1.338,0,0,1,.206-.206A9.332,9.332,0,1,0,2.666,12Z"/>
            </svg>
          </a>
          <a href="#0" class="ml-4 ml-md-4 mr-2 mr-md-0 circle"><img src="assets/images/avatars/user.png" alt="Avatar"></a>
          <div class="collapse navbar-collapse" id="menu-4">
          <ul class="navbar-nav m-auto pt-3 pt-lg-0">
            <li class="nav-item dropdown">
              <div class="dropdown">
          <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> My Account </button>
          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
           <a class="dropdown-item" href="homeUser.html"> <i class="fa fa-home faa-wrench animated-hover" aria-hidden="true"> </i> Home</a>
           <a class="dropdown-item" href="profile.html"> <i class="fa fa-heart faa-pulse animated-hover" aria-hidden="true"> </i> Profile</a>
           <a class="dropdown-item" href="redemption.html"> <i class="fa fa-trophy faa-wrench animated-hover" aria-hidden="true"> </i> Redemption</a>
                    <a class="dropdown-item" onclick="OpenZoomClone()"> <i class="fa fa-plus" aria-hidden="true"> </i> Start Class</a>
   <script>
   function OpenZoomClone() {
   var NewId = getGuid();
   window.open('https://arcane-savannah-98517.herokuapp.com/'+ NewId + '?open=true')
   }
   function getGuid() {
   return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
   var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
   return v.toString(16);
   });
   }
   </script>
           <a class="dropdown-item" href="home.html"> <i class="fas fa-power-off faa-burst animated-hover" aria-hidden="true"> </i> Logout</a>
          </div>
        </div>
            </li>
             </ul>
           
          </div>

        </div>
        <button class="navbar-toggler pr-0 ml-2 ml-md-3" type="button" data-toggle="collapse" data-target="#menu-4" aria-controls="menu-4" aria-expanded="false" aria-label="Toggle navigation">
          <svg data-name="Icon/Hamburger" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
            <path data-name="Icon Color" d="M1.033,14a1.2,1.2,0,0,1-.409-.069.947.947,0,0,1-.337-.207,1.2,1.2,0,0,1-.216-.333,1.046,1.046,0,0,1-.072-.4A1.072,1.072,0,0,1,.072,12.6a.892.892,0,0,1,.216-.321.947.947,0,0,1,.337-.207A1.2,1.2,0,0,1,1.033,12H22.967a1.206,1.206,0,0,1,.409.069.935.935,0,0,1,.336.207.9.9,0,0,1,.217.321,1.072,1.072,0,0,1,.072.391,1.046,1.046,0,0,1-.072.4,1.206,1.206,0,0,1-.217.333.935.935,0,0,1-.336.207,1.206,1.206,0,0,1-.409.069Zm0-6a1.2,1.2,0,0,1-.409-.069.934.934,0,0,1-.337-.207,1.189,1.189,0,0,1-.216-.333A1.046,1.046,0,0,1,0,6.989,1.068,1.068,0,0,1,.072,6.6a.9.9,0,0,1,.216-.322.947.947,0,0,1,.337-.207A1.2,1.2,0,0,1,1.033,6H22.967a1.206,1.206,0,0,1,.409.068.935.935,0,0,1,.336.207.9.9,0,0,1,.217.322A1.068,1.068,0,0,1,24,6.989a1.046,1.046,0,0,1-.072.4,1.193,1.193,0,0,1-.217.333.923.923,0,0,1-.336.207A1.206,1.206,0,0,1,22.967,8Zm0-6a1.2,1.2,0,0,1-.409-.068.947.947,0,0,1-.337-.207,1.193,1.193,0,0,1-.216-.334A1.039,1.039,0,0,1,0,.988,1.068,1.068,0,0,1,.072.6.892.892,0,0,1,.288.276.934.934,0,0,1,.625.069,1.2,1.2,0,0,1,1.033,0H22.967a1.206,1.206,0,0,1,.409.069.923.923,0,0,1,.336.207A.9.9,0,0,1,23.928.6,1.068,1.068,0,0,1,24,.988a1.039,1.039,0,0,1-.072.4,1.2,1.2,0,0,1-.217.334.935.935,0,0,1-.336.207A1.206,1.206,0,0,1,22.967,2Z" transform="translate(0 5)" fill="#000"></path>
                </svg>
              </button>
            </nav>
          </header>
        </div>
      </section>

<!-- Put the recipe name, author, date, ratings, and description -->
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
<section class="u-clearfix u-section-1">
  <div class="u-clearfix u-sheet u-sheet-1">
    <div class="u-layout">
      <div class="u-layout-row">
        <div class="u-align-center-lg u-align-center-sm u-align-center-xl u-align-center-xs u-container-style">
          <div class="u-container-layout u-valign-middle-xl u-container-layout-1">
            <h6 class="u-align-center-md u-text u-text-grey-60 u-text-1"><%=p.getrecipename()%><br>
              <font style="font-size: 1.875rem;">By <a href="profile.html" class="u-btn u-button-style u-none u-text-palette-1-base u-btn-1"> Jamie </a>
              </font>
            </h6>

            <p class="u-align-center-md u-text u-text-grey-40 u-text-2"> 9 September 2020 <br> 
              <i class="fa fa-star" aria-hidden="true"> </i> 
              <i class="fa fa-star" aria-hidden="true"> </i> 
              <i class="fa fa-star" aria-hidden="true"> </i> 
              <i class="fa fa-star" aria-hidden="true"> </i> 
              <i class="far fa-star" aria-hidden="true"> </i> 
            </p>

            <p class="u-align-center-md u-text u-text-grey-40 u-text-2">A waffle is a dish made from leavened batter or dough that is cooked between two plates that are patterned to give a characteristic size, shape, and surface impression.<br>Waffles may be made fresh or simply heated after having been commercially cooked and frozen.
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- put the recipe image -->

<section class="u-section-2" id="carousel_c5cf">
  <div class="u-expanded-width u-layout-wrap u-layout-wrap-2">
    <div class="u-layout">
      <img class="image is-576x576" src="<%=imageLocation%>" alt="Image">
  
    </div>
  </div>
</section>

<!-- put the serving size, preparation time, nutrition facts there -->

<section class="u-clearfix u-section-3" id="carousel_c5cf">
  <div class="u-clearfix u-sheet u-sheet-1">
    <div class="u-clearfix u-expanded-width u-layout-wrap u-layout-wrap-1">
      <div class="u-layout">
        <div class="u-layout-row">
          <div class="u-align-center-sm u-align-center-xs u-container-style u-layout-cell u-left-cell u-size-30 u-layout-cell-1">
            <div class="u-container-layout u-valign-top u-container-layout-1">
              <h2 class="u-align-center-lg u-align-center-md u-align-center-xl u-text u-text-grey-60 u-text-1">Serving Size: <i class="fa fa-utensils" aria-hidden="true"> </i> <br> 
              </h2>

              <h5 class="u-align-center-lg u-align-center-md u-align-center-xl u-text u-text-grey"> 2 pax <br> 
              </h5>

              <h2 class="u-align-center-lg u-align-center-md u-align-center-xl u-text u-text-grey-60 u-text-1"> Preparation Time :   <i class="fa fa-hourglass-half fa-spin"> </i> 
              <i class="faa-pulse animated" aria-hidden="true"> </i> <br> 
              </h2> 

              <h5 class="u-align-center-lg u-align-center-md u-align-center-xl u-text u-text-grey"> 15 min 
              </h5> 
            </div>
          </div>

          <div class="u-align-center-sm u-align-center-xs u-container-style u-layout-cell u-left-cell u-size-30 u-layout-cell-2">
            <div class="u-container-layout u-valign-top u-container-layout-2">
              <blockquote>
                <h2 class="u-align-center-lg u-align-center-md u-align-center-xl u-text u-text-grey-60 u-text-2">Nutrition Facts: <i class="fa fa-info-circle" aria-hidden="true"> </i>
                </h2>

                <h6 class="u-align-lg u-align-md u-align-center-xl u-text u-text-grey">
                  Total Fat: 10g <br>
                  Saturated fat: 2.1g <br>
                  Polyunsaturated fat: 4.4g <br>
                  Cholestrol: 59mg <br>
                  Sodium: 439 mg <br>
                  Potassium: 132 mg <br>
                  Total Carbohydrate: 28 g <br>
                  Protein: 6 g <br>
                </h6>
              </blockquote>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
    
<!-- content of Search Bar -->

<!-- resharepeace Search -->
<div class="resharepeace-search">
  <div class="container">
    <div class="input-group search-box">
      <input type="text" name="Search" placeholder="Search" class="form-control" id="Search">
      <button type="button"><img src="assets/images/icons/close.svg" alt="img"> </button>
    </div>

    <div class="search-results" id="SearchList">
      <div class="resharepeace-search-list">
        <a href="#0">
          <figure><img src="assets/images/menus/cheesecake.jpg" class="rounded-2" alt="Menu" width="65" height="49"></figure>

          <div class="resharepeace-search-name">
            <strong class="small">Creamy Homemade Cheesecake</strong>
          </div>
        </a>
      </div>

      <div class="resharepeace-search-list">
        <a href="#0">
          <figure><img src="assets/images/menus/donut.jpg" class="rounded-2" alt="Menu" width="65" height="49"></figure>

          <div class="resharepeace-search-name">
            <strong class="small">Donut</strong>
          </div>
        </a>
      </div>

      <div class="resharepeace-search-list">
        <a href="#0">
          <figure><img src="assets/images/menus/tiramisu.jpg" class="rounded-2" alt="Menu" width="65" height="49"></figure>

          <div class="resharepeace-search-name">
            <strong class="small">Tiramisu</strong>
          </div>
        </a>
      </div>

      <div class="resharepeace-search-list">
        <a href="#0">
          <figure><img src="assets/images/menus/muffin.jpg" class="rounded-2" alt="Menu" width="65" height="49"></figure>

          <div class="resharepeace-search-name">
            <strong class="small">Blueberry Muffin</strong>
          </div>
        </a>
      </div>

      <div class="resharepeace-search-list">
        <a href="#0">
          <figure><img src="assets/images/menus/pancake.jpg" class="rounded-2" alt="Menu" width="65" height="49"></figure>

          <div class="resharepeace-search-name">
            <strong class="small">Japanese Souffle Pancake</strong>
          </div>
        </a>
      </div>

      <div class="resharepeace-search-list">
        <a href="#0">
          <figure><img src="assets/images/menus/waffle.jpg" class="rounded-2" alt="Menu" width="65" height="49"></figure>

          <div class="resharepeace-search-name">
            <strong class="small">Homemade Waffle</strong>
          </div>
        </a>
      </div>

      <div class="text-center py-4">
        <a href="searchresult.html" class="btn btn-sm btn-outline-dark px-4 py-2"> See all results </a>
      </div>
    </div>
  </div>
</div>

<!-- put the Ingredients section there -->

<section class="u-align-left u-clearfix u-section-4" id="carousel_d13c">
  <div class="u-clearfix u-sheet u-sheet-4">
    <div class="container">
      <div class="row">
        <div class="col-sm-12">
          <table class="table">
            <thead class="thead-dark">
              <tr>
                <th scope="col"> 
                  <h3 class="u-custom-font u-text u-text-default u-text-grey-50 u-text-1"> Ingredients </h3> 

                  <form class="form" action="measurementConversion.html">
                    <button type="submit" class="btn-default float-right"> 
                      <h3 class="u-custom-font u-text u-text-default u-text-grey-50 u-text-3"> Measurement <br> Conversion Calculator </h3> </button>  
                  </form>
                </th> 
              </tr>
            </thead>

            <tbody>
              <tr>
                <td> <%=p.getrecipeingredient()%> </td>
              </tr>

              /*<tr>
                <td> 3 1/2 teaspoons baking powder </td>
              </tr>

              <tr>
                <td> 1 teaspoon salt </td>
              </tr>

              <tr>
                <td> 1 tablespoon white sugar </td>
              </tr>

              <tr>
                <td> 1 1/4 cups milk </td>
              </tr>

              <tr>
                <td> 1 egg </td>
              </tr>

              <tr>
                <td> 3 tablespoons butter, melted </td>
              </tr>

              <tr>
                <td> 1 teapoon vanilla extract </td>
              </tr> */
            </tbody>              
          </table>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- put the Directions section there -->

<section class="u-align-left u-clearfix u-section-5" id="carousel_d13c">
  <div class="u-clearfix u-sheet u-sheet-4">
    <div class="container">
      <div class="row">
        <div class="col-sm-12">
          <table class="table">
            <thead class="thead-dark">
              <tr>
                <th scope="col">
                  <h3 class="u-custom-font u-text u-text-default u-text-grey-50 u-text-1"> Directions </h3> </th> 
              </tr>
            </thead>

            <tbody>
              <tr>
                <td> <%=p.getrecipesteps()%> Step 1: In a large bowl, mix together flour, salt, baking powder and sugar; set aside. Preheat waffle iron to desired temperature 

                  <iframe src="https://giphy.com/embed/26xBKmPkJLYvGV9yE" width="200" height="200" frameBorder="0" class="giphy-embed" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/sweet-cake-dessert-26xBKmPkJLYvGV9yE"> </a></p>
                </td>
              </tr>

              <tr>
                <td> Step 2: In a separate bowl, beat the eggs. Stir in the milk, butter and vanilla. Pour the milk mixture into the flour mixture; beat until blended. </td>
              </tr>

              <tr>
                <td> Step 3: Ladle the batter into a preheated waffle iron. Cook the waffles until golden and crisp. Serve immediately. 

                  <iframe src="https://giphy.com/embed/a3lZcbkBdySqY" width="200" height="200" frameBorder="0" class="giphy-embed" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/satisfying-pancake-flipping-a3lZcbkBdySqY"> </a></p>

                </td>
              </tr>             
            </tbody>              
          </table>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- put the Related Searches section there -->

<section class="u-align-center u-clearfix u-section-6" id="carousel_f8e8">
  <div class="u-clearfix u-sheet u-sheet-1">
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col"> <h3 class="u-custom-font u-text u-text-default u-text-grey-50 u-text-1"> Related Searches </h3> </th> 
        </tr>
      </thead>
    </table>

    <div id="carousel-8627" data-interval="5000" data-u-ride="carousel" class="u-carousel u-expanded-width-lg u-expanded-width-xl u-slider u-slider-1">
      <ol class="u-absolute-hcenter u-carousel-indicators u-carousel-indicators-1">
        <li data-u-target="#carousel-8627" class="u-active u-grey-30 u-shape-circle" data-u-slide-to="0" style="height: 10px; width: 10px;"></li>

        <li data-u-target="#carousel-8627" class="u-grey-30 u-shape-circle" data-u-slide-to="1" style="height: 10px; width: 10px;"></li>
      </ol>

      <div class="u-carousel-inner" role="listbox">
        <div class="active u-active u-align-center u-carousel-item u-container-style u-slide">
          <div class="u-container-layout u-valign-middle u-container-layout-1">
            <div class="u-expanded-width-lg u-expanded-width-md u-expanded-width-sm u-expanded-width-xs u-gallery u-layout-grid u-lightbox u-no-transition u-show-text-always u-gallery-1">
              <div class="u-gallery-inner u-gallery-inner-1">
                <div class="u-gallery-item" data-href="recipe-waffle.html">
                  <div class="u-back-slide" data-image-width="720" data-image-height="720">
                    <img class="u-back-image u-expanded" src="images/waffle.jpg" alt="Homemade Pancake">
                  </div>

                  <div class="u-over-slide u-shading u-valign-bottom u-over-slide-1">
                    <h3 class="u-gallery-heading">Homemade Pancake</h3>
                    <p class="u-gallery-text" style="margin-top: 0;"></p>
                  </div>
                </div>

                <div class="u-gallery-item" data-href="recipe-cheesecake.html">
                  <div class="u-back-slide" data-image-width="720" data-image-height="720">
                    <img class="u-back-image u-expanded" src="images/cheesecake.jpg" alt="Creamy Homemade Cheescake">
                  </div>

                  <div class="u-over-slide u-shading u-valign-bottom u-over-slide-2">
                    <h3 class="u-gallery-heading">Creamy Homemade Cheescake</h3>
                    <p class="u-gallery-text" style="margin-top: 0;"></p>
                  </div>
                </div>
                
                <div class="u-gallery-item" data-href="recipe-tiramisu.html">
                  <div class="u-back-slide" data-image-width="1200" data-image-height="1800">
                    <img class="u-back-image u-expanded" src="images/tiramisu.jpg" alt="Tiramisu">
                  </div>
              
                  <div class="u-over-slide u-shading u-valign-bottom u-over-slide-3">
                    <h3 class="u-gallery-heading">Tiramisu</h3>
                    <p class="u-gallery-text" style="margin-top: 0;"></p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="u-carousel-item u-container-style u-expanded-width-xl u-shape-rectangle u-slide">
          <div class="u-container-layout u-valign-top u-container-layout-2">
            <div class="u-expanded-width-lg u-expanded-width-md u-expanded-width-sm u-expanded-width-xs u-gallery u-layout-grid u-lightbox u-no-transition u-show-text-always u-gallery-2">
              <div class="u-gallery-inner u-gallery-inner-2">
                <div class="u-gallery-item" data-href="recipe-pancake.html">
                  <div class="u-back-slide" data-image-width="900" data-image-height="560">
                    <img class="u-back-image u-expanded" src="images/pancake.jpg" alt="Japanse Soufle Pancake">
                  </div>
                  
                  <div class="u-align-right u-over-slide u-shading u-valign-bottom u-over-slide-4">
                    <h3 class="u-gallery-heading" style="margin-right: 0; margin-left: 0;">Japanse Soufle Pancake</h3>
                    <p class="u-align-center u-gallery-text" style="margin-right: 0; margin-left: 0;"></p>
                  </div>
                  
                  </div>

                  <div class="u-gallery-item" data-href="recipe-muffin.html">
                    <div class="u-back-slide" data-image-width="850" data-image-height="850">
                      <img class="u-back-image u-expanded" src="images/muffin.jpg" alt="Blueberry Muffin">
                    </div>
                    
                    <div class="u-align-right u-over-slide u-shading u-valign-bottom u-over-slide-5">
                      <h3 class="u-gallery-heading" style="margin-right: 0; margin-left: 0;">Blueberry Muffin</h3>
                      <p class="u-align-center u-gallery-text" style="margin-right: 0; margin-left: 0;"></p>
                    </div>
                  </div>
                  
                  <div class="u-gallery-item">
                    <div class="u-back-slide" data-image-width="1600" data-image-height="2240">
                      
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <a class="u-absolute-vcenter u-black u-carousel-control u-carousel-control-prev u-icon-circle u-spacing-10 u-text-body-alt-color u-carousel-control-1" href="#carousel-8627" role="button" data-u-slide="prev">
          <span aria-hidden="true">
            <svg viewBox="0 0 477.175 477.175"><path d="M145.188,238.575l215.5-215.5c5.3-5.3,5.3-13.8,0-19.1s-13.8-5.3-19.1,0l-225.1,225.1c-5.3,5.3-5.3,13.8,0,19.1l225.1,225
            c2.6,2.6,6.1,4,9.5,4s6.9-1.3,9.5-4c5.3-5.3,5.3-13.8,0-19.1L145.188,238.575z"></path></svg>
          </span>
          
          <span class="sr-only">Previous</span>
        </a>
        
        <a class="u-absolute-vcenter u-black u-carousel-control u-carousel-control-next u-icon-circle u-spacing-10 u-text-body-alt-color u-carousel-control-2" href="#carousel-8627" role="button" data-u-slide="next">
          <span aria-hidden="true">
            <svg viewBox="0 0 477.175 477.175"><path d="M360.731,229.075l-225.1-225.1c-5.3-5.3-13.8-5.3-19.1,0s-5.3,13.8,0,19.1l215.5,215.5l-215.5,215.5
            c-5.3,5.3-5.3,13.8,0,19.1c2.6,2.6,6.1,4,9.5,4c3.4,0,6.9-1.3,9.5-4l225.1-225.1C365.931,242.875,365.931,234.275,360.731,229.075z"></path></svg>
          </span>
          
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
  </section>

<!-- put the Reviews section in -->

<section id="carousel_6f7a" class="u-carousel u-slide u-block-2bc8-1" data-u-ride="carousel" data-interval="5000">
  <ol class="u-absolute-hcenter u-carousel-indicators u-block-2bc8-2">
    <li data-u-target="#carousel_6f7a" data-u-slide-to="0" class="u-active u-grey-30"></li>

    <li data-u-target="#carousel_6f7a" class="u-grey-30" data-u-slide-to="1"></li>
  </ol>
  
  <div class="u-carousel-inner" role="listbox">
    <div class="u-active u-align-center u-carousel-item u-clearfix u-section-7-1">
      <div class="u-clearfix u-sheet u-valign-middle-md u-valign-middle-sm u-valign-middle-xs u-sheet-1">
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col"> <h3 class="u-custom-font u-text u-text-default u-text-grey-50 u-text-1"> Reviews </h3> </th> 
            </tr>
          </thead>
        </table>
        
        <div class="u-clearfix u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-container-style u-layout-cell u-left-cell u-size-16 u-layout-cell-1">
                <div class="u-container-layout u-valign-top u-container-layout-1">
                  <img alt="" class="u-align-left u-image u-image-default u-image-1" src="images/user.jpg" data-image-width="1044" data-image-height="1162">
                </div>
              </div>
              
              <div class="u-align-center-sm u-align-center-xs u-align-left-lg u-align-left-md u-align-left-xl u-container-style u-layout-cell u-right-cell u-size-44 u-layout-cell-2">
                <div class="u-container-layout u-container-layout-2">
                  <p class="u-large-text u-text u-text-variant u-text-2">Best ever!!! I was really impressed. I will add some maple syrup toward the end next time. in my recipe forever</p>

                  <h5 class="u-text u-text-3"><i>
                    <a href="678612635" class="u-btn u-button-style u-none u-text-palette-1-base u-btn-1">Dawn</a></i>
                  </h5>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <div class="u-align-center u-carousel-item u-clearfix u-section-7-2">
      <div class="u-clearfix u-sheet u-sheet-1">
        <table class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col"> <h3 class="u-custom-font u-text u-text-default u-text-grey-50 u-text-1"> Reviews </h3> </th> 
            </tr>
          </thead>
        </table>
        
        <div class="u-clearfix u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-container-style u-layout-cell u-left-cell u-size-16 u-layout-cell-1">
                <div class="u-container-layout u-valign-top u-container-layout-1">
                  <img alt="" class="u-align-left u-image u-image-default u-image-1" src="images/profile.png" data-image-width="1920" data-image-height="1280">
                </div>
              </div>
              
              <div class="u-align-center-sm u-align-center-xs u-align-left-lg u-align-left-md u-align-left-xl u-container-style u-layout-cell u-right-cell u-size-44 u-layout-cell-2">
                <div class="u-container-layout u-container-layout-2">
                  <p class="u-large-text u-text u-text-variant u-text-2">My husband and I never had waffles. I made this recipe and it was awesome. I must say, it was better than eating at some famous restuarants. Thanks</p>

                  <h5 class="u-text u-text-3"><i>
                    <a href="678612635" class="u-btn u-button-style u-none u-text-palette-1-base u-btn-1">Kim<br>
                    </a></i>
                  </h5>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <a class="u-carousel-control u-carousel-control-prev u-text-body-color u-block-2bc8-3" href="#carousel_6f7a" role="button" data-u-slide="prev">
    <span aria-hidden="true">
      <svg viewBox="0 0 477.175 477.175"><path d="M145.188,238.575l215.5-215.5c5.3-5.3,5.3-13.8,0-19.1s-13.8-5.3-19.1,0l-225.1,225.1c-5.3,5.3-5.3,13.8,0,19.1l225.1,225
      c2.6,2.6,6.1,4,9.5,4s6.9-1.3,9.5-4c5.3-5.3,5.3-13.8,0-19.1L145.188,238.575z"></path></svg>
    </span>
 
    <span class="sr-only">Previous</span>
  </a>
  
  <a class="u-carousel-control u-carousel-control-next u-text-body-color u-block-2bc8-4" href="#carousel_6f7a" role="button" data-u-slide="next">
    <span aria-hidden="true">
      <svg viewBox="0 0 477.175 477.175"><path d="M360.731,229.075l-225.1-225.1c-5.3-5.3-13.8-5.3-19.1,0s-5.3,13.8,0,19.1l215.5,215.5l-215.5,215.5
      c-5.3,5.3-5.3,13.8,0,19.1c2.6,2.6,6.1,4,9.5,4c3.4,0,6.9-1.3,9.5-4l225.1-225.1C365.931,242.875,365.931,234.275,360.731,229.075z"></path></svg>
    </span>
    
    <span class="sr-only">Next</span>
  </a>
</section>
                      
                    
                  </div>
                <%
                            }
                    }
                    }
                 %>
     
   
    
    
   <footer class="resharepeace-footer pt-3 pt-md-5 bg-lightest-gray">
  <div class="container">
    <div class="row pt-4 pb-0 pb-md-5">
      <div class="col-md-6">
          
      </div>
    </div>
  </div>
</div>
</footer>


<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/html5.min.js"></script>
<script src="assets/js/hover-animation.min.js"></script>
<script src="assets/js/jquery.malihu.PageScroll2id.min.js"></script>
<script src="assets/js/jquery.mCustomScrollbar.min.js"></script>
<script src="assets/js/jquery.sticky.js"></script>
<script src="assets/js/masonry.min.js"></script>
<script src="assets/js/scripts.js"></script>
<script src="assets/js/heart.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
    <script class="u-script" type="text/javascript" src="js/jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="js/nicepage.js" defer=""></script>
</body>
</html>