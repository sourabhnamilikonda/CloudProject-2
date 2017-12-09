<%-- 
    Document   : user_acc
    Created on : 19 Nov, 2017, 11:04:56 AM
    Author     : Avleen Singh Khanuja/Pratik Dhumal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.setget.set"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome User</title>
        <link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,800,700,300' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=BenchNine:300,400,700' rel='stylesheet' type='text/css'>
	<script src="js/modernizr.js"></script>
        <script>
            
        function my() 
    {
        
        var file_up = document.getElementById('file');
        var flag=false;
       
        if (typeof (file_up.files) !== "undefined") 
        {
            for( var i=0;i<file_up.files.length;i++)
            {
               var size = file_up.files[i].size / 1024;
               var maxsize=10*1024;
               
               if(size>maxsize)
               {
                   alert("please reload files size of some files greater than 10 MB");
                   document.getElementById("form1").reset();
                   flag=false;

                   
               }
               else
               {
                    flag=true;
                  
                 
               }
               
            }
        } else 
        {
            
            alert("This browser does not support HTML5.");
        }
        return flag;
    }
    
    
    </script>
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
                                  <li><a class="menu active" href="user_acc.jsp" >Home</a></li>
					        <li><a class="menu" href="ChatBot_1.jsp">Medibot</a></li>
                                                <li><a class="menu" href="ViewScheduleChatBot.jsp">Appointments</a></li>
                                                <li><a class="menu" href="ScheduleAppointment.jsp">Reminders</a></li>
                                                <li><a class="menu" href="ViewMyRemainders.jsp">View Reminders</a></li>
                                                <li><a class="menu" href="search.jsp">Search</a></li>
                                                <li><a class="menu" href="Reports.jsp">Manage Reports</a></li>
                                                <li><a class="menu" href="index.jsp">Logout</a></intput></li>
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
                <h2>Welcome <%=session.getAttribute("ulog")%>!</h2>
                
                
                <form id="form1"action="index_serv"  method="post" onsubmit="return my();" enctype="multipart/form-data">
                    <h3><b>
             <table>
                 <tr>
                     <td><h2>SERVICES</h2><br></td>
                     <td></td>
                 </tr>
                 <tr>
                     <td>UPLOAD FILE</td>
                     <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                     <td><input type="file" id="file" name="file" multiple> </td>
                     <td><input type="submit" value="UPLOAD"></td>
                 </tr>
                 </table>
                        </b></h3>
             </form>
                <br>         <br>               
            <form id="f_d" action="listOfFiles.jsp" method="post">
                <h3><b>
                <table>
                    <tr>
                   <td>VIEW FILES</td>
                   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp</td>
                     <td><input type="submit" value="VIEW"></td>
                 </tr>
                </table>
                          </b></h3>
            </form>
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