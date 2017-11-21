<%-- 
    Document   : newjspcontactUs
    Created on : 19 Nov, 2017, 10:48:47 AM
    Author     : Avleen Singh Khanuja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us</title>
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,800,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=BenchNine:300,400,700' rel='stylesheet' type='text/css'>
        <script src="js/modernizr.js"></script>
    </head>
    
    
   <body>

        <!-- ====================================================header section -->
        <header class="top-header">
            <div class="container">
                <div class="row">
                    <div class="col-xs-5 header-logo">
                        <br>
                        <a href="index.html"><img src="img/logo.png" alt="" class="img-responsive logo"></a>
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
        <hr><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
               <!-- team section -->
       <section class="contact">
		<div class="container">
			<div class="row">
				<div class="contact-caption clearfix">
					<div class="contact-heading text-center">
						<h2>contact us</h2>
					</div>
					<div class="col-md-5 contact-info text-left">
						<h3>contact information</h3>
						<div class="info-detail">
							<ul><li><i class="fa fa-calendar"></i><span>Monday - Friday:</span> 9:30 AM to 6:30 PM</li></ul>
							<ul><li><i class="fa fa-map-marker"></i><span>Address:</span> 123 Some Street , London, UK, CP 123</li></ul>
							<ul><li><i class="fa fa-phone"></i><span>Phone:</span> (032) 987-1235</li></ul>
							<ul><li><i class="fa fa-fax"></i><span>Fax:</span> (123) 984-1234</li></ul>
							<ul><li><i class="fa fa-envelope"></i><span>Email:</span> info@doctor.com</li></ul>
						</div>
					</div>
					<div class="col-md-6 col-md-offset-1 contact-form">
						<h3>leave us a message</h3>

						<form class="form">
							<input class="name" type="text" placeholder="Name">
							<input class="email" type="email" placeholder="Email">
							<input class="phone" type="text" placeholder="Phone No:">
							<textarea class="message" name="message" id="message" cols="30" rows="10" placeholder="Message"></textarea>
							<input class="submit-btn" type="submit" value="SUBMIT">
						</form>
					</div>
				</div>
			</div>
		</div>
	</section><!-- end of contact section -->

        
        
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
