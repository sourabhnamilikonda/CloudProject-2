<%-- 
    Document   : login
    Created on : 18 Nov, 2017, 9:30:53 PM
    Author     : Avleen Singh Khanuja
--%>

<%@page import="com.mycompany.poly.SpeechRecognition"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
        
        
               <!-- team section -->
        <section class="team" id="team">
            <div class="container">
             <form action="login_servlet" method="post">
                 <b><h3>
             <table>
                 <tr><td><h2>LOGIN HERE</h2><br><br></td>
                     <td></td>
                 </tr>
                 <tr>
                     <td><h3><b>Enter  User Name</b></h3></td>
                     <td><input type="text" name="txtname1"></td>
                 </tr>
                 
                 <tr>
                     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                     
                 </tr>
                 
                 <tr>
                     <td><h3><b>Enter Password</b></h3></td>
                     <td><input type="password" name="txtpass"></td>
                 </tr>
                  <tr>
                     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                     
                 </tr>
                 <tr>
                     <td></td>
                     <td><input type="submit" value="LOGIN">&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;   <input type="reset" value="RESET"></td>
                     
                 </tr>
                 
             </table>
                     </h3></b>
      </form>	
                <%
                    
                   
                    try
                    {
                        HttpSession sessionsa = request.getSession(false);
                      if(!sessionsa.isNew())
                      {
                                 if(sessionsa.getAttribute("ulog")!=null)
                                 {
                                     String username=sessionsa.getAttribute("ulog").toString();
                    if(username.equals("invalid"))
                    {
                         SpeechRecognition speech=new SpeechRecognition();
                         speech.invalidUser(username);
                    }
                    }
                    }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    
                    
                %>
                
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
