<%-- 
    Document   : listOfFiles
    Created on : 19 Nov, 2017, 12:41:17 PM
    Author     : Avleen Singh Khanuja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.db.listfiles"%>
<%@page import="com.setget.set"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of Files</title>
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
					        <li><a class="menu" href="login.jsp">logout</a></li>
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
              <header class="major">
             <h2> <%=session.getAttribute("ulog")%>'s &nbsp;&nbsp; Files</h2> 
             </header>
             <h3><b>
             <table width="100%" border="1">
                 <tr><td><h3>Name</h3></td><td><h3>Uploaded on</h3></td><td><h3>Last Updated</h3></td><td><h3>Description</h3></td><td></td><td></td><td></td><td></td></tr>
                  <%
         
       String username=session.getAttribute("ulog").toString();
       
       System.out.println("Username:"+username);
       ArrayList<set> s=new ArrayList<set>();
       listfiles info=new listfiles();
       s=info.f_d(username);
       
       for(int i=0;i<s.size();i++)
        {
           set obj=new set();   
           obj=s.get(i);
            %>
                
            <tr>
                      <td>
                      <%= obj.getFileName()%>
                      </td>
                      
                      <td>
                      <%= obj.getFileUploadTime()%>
                      </td>
                      
                      <td>
                      <%= obj.getUpdateTime()%>
                      </td>
                      <td>
                      <%= obj.getFileDescription()%>
                      </td>
                     <td>
                         <form action="download_serv" method="post">
                         <button value="DOWNLOAD">DOWNLOAD</button>
                         <input type="hidden" name="objdownld" value="<%= obj.getFileName()%>" > 
                         </form>
                     </td>
                     
                     <td>
                         <form action="del_servlet" method="post">
                             <button value="DELETE">DELETE</button>
                             <input type="hidden" name="delobj" value="<%= obj.getFileName()%>">
                         </form>
                     </td>
                     
                     <td>
                         <form action="index_serv" method="post" enctype="multipart/form-data">
                          <input type="submit" value="UPDATE">
                          <td><input type="file" id="file" name="file" multiple></td>                        
                         </form>
                     </td>
            </tr>
            <% 
        }
    %>
             </table>
                 </b></h3>
            </div>
             
             <br><br><br><br><br><br><br><br><br><br><br><br><br>
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
