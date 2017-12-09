<%-- 
    Document   : ViewMyRemainders
    Created on : Nov 29, 2017, 1:41:25 PM
    Author     : Pratik Dhumal
--%>

<%@page import="com.mycompany.mediworld.DatabaseInformation"%>
<%@page import="com.mycompany.mediworld.DatabasePojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
               <h2>Schedule of medicines </h2>
               <h3>
               <table width="90%" border="1" id="TablePratik" name="TablePratik" value="TablePratik">
            <tr ><td>No</td><td>Medicine name</td><td>Creation time</td><td>Frequency</td><td>Time of week</td><td>Time</td><td>Delete Schedule</td></tr>
            
        <%    
             DatabaseInformation info=new DatabaseInformation();
             ArrayList<DatabasePojo> informationPojo=new ArrayList<DatabasePojo>();
             informationPojo=info.fetchData();
             
             DatabasePojo ObjectInPojo=new DatabasePojo();
             
      
             try
             {
             for(int i=0;i<informationPojo.size();i++)
        {
           ObjectInPojo=informationPojo.get(i);
          
         

            %>
            <tr id="1">
                <td>
                    
                      <%= i+1%>
                      </td>
                    <td class="nr">
                        
                      <%=ObjectInPojo.getMedicine_name()%>
                     
                      </td>
                      
                        <td class="nr">
                        
                      <%=ObjectInPojo.getDate_of_creation()%>
                     
                      </td>
                      
                      
                      <td>
                    
                      <%= ObjectInPojo.getFrequency()%>
                      </td>
                      
                      <td>
                    
                      <%= ObjectInPojo.getWeek()%>
                    
                      </td>
                      
                      <td>
                     
                      <%= ObjectInPojo.getTime()%>
                      </td>
                      
                     <td><a href="DeleteScheduleServlet?name=<%= ObjectInPojo.getMedicine_name()%>"><input type="button"  value="Delete"/></a></td>
             
                     
                     
                </tr>
            <% 
        }
}
catch(Exception e)
{

e.printStackTrace();

}
  %>
            
            
            
            
            
            
            
           </table>
               </h3>
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
