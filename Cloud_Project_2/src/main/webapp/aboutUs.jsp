<%-- 
    Document   : aboutUs
    Created on : 18 Nov, 2017, 4:10:34 PM
    Author     : Avleen Singh Khanuja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,800,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=BenchNine:300,400,700' rel='stylesheet' type='text/css'>
        <script src="js/modernizr.js"></script>
        <title>About Us</title>
    </head>
    <body>

        <!-- ====================================================header section -->
        <header class="top-header">
            <div class="container">
                <div class="row">
                    <div class="col-xs-5 header-logo">
                        <br>
                        <a href="index.jsp"><img src="img/logo.jpg" alt="" class="img-responsive logo"></a>
                    </div>

                    <div class="col-md-7">
                        <nav class="navbar navbar-default">
                            <div class="container-fluid nav-bar">
                                <!-- Brand and toggle get grouped for better mobile display -->
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                </div>

                                <!-- Collect the nav links, forms, and other content for toggling -->
                                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                                    <ul class="nav navbar-nav navbar-right">
					        <li><a class="menu active" href="index.html" >Home</a></li>
					        <li><a class="menu" href="aboutUs.jsp">about us</a></li>
                                                <li><a class="menu" href="login.jsp">login</a></li>
					        <!--<li><a class="menu" href="services.jsp">services </a></li>-->
					        <li><a class="menu" href="signup.jsp">sign up</a></li>
					        <li><a class="menu" href="contactUs.jsp"> contact us</a></li>
					      </ul>
                                </div><!-- /navbar-collapse -->
                            </div><!-- / .container-fluid -->
                        </nav>
                    </div>
                </div>
            </div>
        </header> <!-- end of header area -->

        <section class="slider" id="home">
            <div class="container-fluid">
                <div class="row">
                    <div id="carouselHacked" class="carousel slide carousel-fade" data-ride="carousel">
                        <div class="header-backup">
                        </div>
                </div>
            </div>
        </section><!-- end of slider section -->
        <hr>
               <!-- team section -->
        <section class="team" id="team">
            <div class="container">
                <h2>ABOUT US</h2>
                <br>
                <p><h1><b>The project idea is to build a fully functional, globally available, auto scaling, load balanced 3 tier web application deployed on cloud. It contains general as well as user specific customized information distribution in the Healthcare and Medical domain. 
                        We wish to build a repository of terms, procedures, organizations, names, definitions etc. to mine and provide relevant details to a user. Our aim is to simplify and provide accurate information which might be easier for a layman to understand. By using Chatbot like functionality user will be able to resolve his queries in a fast and easy manner. 
                        <br><br>Implementing image recognition will help user save their time by directly scanning an image and then getting the required text instead of typing long set of words. Patient will be able to upload their reports as and when they want. 
                        These reports will be available to them globally and at any given instance of time. Feature such as SMS is also implemented as a part of the project.</b></h1></p>
            </div>
        </section><!-- end of team section -->

       <!-- footer starts here -->
        <footer class="footer clearfix">
            <div class="container">
                <div class="row">
                    <div class="col-xs-6 footer-para">
                        <p>All right reserved</p>
                    </div>
                    <div class="col-xs-6 text-right">
                        <a href=""><i class="fa fa-facebook"></i></a>
                        <a href=""><i class="fa fa-twitter"></i></a>
                        <a href=""><i class="fa fa-skype"></i></a>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
