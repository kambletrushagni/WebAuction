<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="Servlet.*,java.util.*,javax.servlet.*,java.lang.*,java.sql.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>NETAuction</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <meta name="description" content="Coming soon, Bootstrap, Bootstrap 3.0, Free Coming Soon, free coming soon, free template, coming soon template, Html template, html template, html5, Code lab, codelab, codelab coming soon template, bootstrap coming soon template">
    <title>NETAuction</title>
    <!-- ============ Google fonts ============ -->
    <link href='http://fonts.googleapis.com/css?family=EB+Garamond' rel='stylesheet'
        type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300,800'
        rel='stylesheet' type='text/css' />
    <!-- ============ Add custom CSS here ============ -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
      <link href="css/style.css" rel="stylesheet" type="text/css" />    
   
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css" />
  
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>
<form name="formp" method="post" action="./Displaypainter">

    <div id="custom-bootstrap-menu" class="navbar navbar-default " role="navigation" style="background-color:grey">
    <div class="container">
        <div class="navbar-header"><a class="navbar-brand" href="#">NETAuction</a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse navbar-menubuilder">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="./home.html">Home</a>
                </li>
                <li><a href="./help.jsp">About Us</a>
                </li>
                <li><a href="./LogoutServlet">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="regform">
<%
response.setContentType("text/html");
PreparedStatement pst=null;

ResultSet rs=null,rs1=null;
/*
Cookie ck[]=request.getCookies();  
out.print("<br>hi!"+ck[0].getValue());//printing name and value of cookie 
*/
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
Statement stmt=conn.createStatement();
Cookie emailc=null;
Cookie emailck[]=request.getCookies();
if(emailck!=null)
{
System.out.println("cookie found");
for(int i=0;i<emailck.length;i++){
	emailc=emailck[i];

String email=emailc.getName();
String email1=emailc.getValue();
System.out.println("email\t"+email1+"tfghj"+email);
}
}pst = conn.prepareStatement("select * from painter");
 
 rs = pst.executeQuery();
while(rs.next())
{
%>

<div class="container" align="center">

    
  <div class="col" align=center>
    <div class="col-sm-4">
      <div class="panel panel-primary" align=center>
        <div class="panel-heading">Painter</div>
       
        <div class="panel-body"><h3><input type=hidden name=number value="<%=rs.getInt("painter_id") %>"></input><a href="demoshopping.jsp?painter=<%=rs.getInt("painter_id") %> "> <%=rs.getString("firstname") %>  &nbsp <%=rs.getString("lastname")%></a></h3></div>
      <!--  <div class="panel-footer"><input type=button name=bid value=Paintings></div>-->
      </div>
    </div>
    </div>
    </div>

<br><br>
<% }
}
catch(Exception e) { System.out.println(e); }
%>
</div>

        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.backstretch.js" type="text/javascript"></script>
        <script type="text/javascript">
            'use strict';

            /* ========================== */
            /* ::::::: Backstrech ::::::: */
            /* ========================== */
            // You may also attach Backstretch to a block-level element
            $.backstretch(
        [
            
		"img/44.jpg",
		"img/colorful.jpg",
		"img/34.jpg",
		"img/images.jpg"
		],

        {
            duration: 450,
            fade: 1500
        }
    );
        </script>

</form>
</body>
</html>
    