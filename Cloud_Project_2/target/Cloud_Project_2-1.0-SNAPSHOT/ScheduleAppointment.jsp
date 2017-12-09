<%-- 
    Document   : ScheduleAppointment
    Created on : Nov 29, 2017, 1:11:15 AM
    Author     : Pratik Dhumal
--%>

<%@page import="com.mycompany.poly.SpeechRecognition"%>
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
            <h2>SET REMINDER</h2>
            <h3> <form name="Dashboard" method="post" action="SetReminderServlet">
                    <label for="medicine">Medicine Name: &nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text"   name="medicine"  required/><br><br>
                    <label for="Frequecy">Frequency for reminder per day:&nbsp;&nbsp;&nbsp;&nbsp;</label>

                    <select id="Frequecy" name="Frequecy">
                        <option value="One">One</option>
                        <option value="Two">Two</option>
                        <option value="Three">Three</option>
                        <option value="Four">Four</option>
                    </select> <br><br>

                    <label for="Frequecy">Frequency for reminder in week:&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <select id="week" name="week">
                        <option value="All days of the week">All days of the week</option>
                        <option value="Every alternate day">Every alternate day</option>
                        <option value="Sunday">Sunday</option>
                        <option value="Monday">Monday</option>
                        <option value="Tuesday">Tuesday</option>
                        <option value="Wednesday">Wednesday</option>
                        <option value="Thursday">Thursday</option>
                        <option value="Friday">Friday</option>
                        <option value="Saturday">Saturday</option>
                    </select> <br><br>
                    
                    

<%
                    
                     String username=null;
                    try
                    {
                        HttpSession sessionsa = request.getSession(false);
                     
                 username =sessionsa.getAttribute("ulog").toString();
                  
                 System.out.println("JSP user"+username);
                    
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    
                    
                %>
                
                    Select a time:&nbsp;&nbsp;&nbsp;&nbsp;<input type="time" name="usr_time" required="true"><br><br>
                    <br>
                    <input type="hidden" name="hidden" value=<%=username%>
                    <b> <input type="submit" id="start" value="Set Reminder"/></b>
                     
                </form></h3>
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
