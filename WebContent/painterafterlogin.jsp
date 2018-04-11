<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="Servlet.*,java.util.*,java.io.*,javax.servlet.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"&gt;>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <!-- Set the viewport width to device width for mobile -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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

</head>
<%try
{	Cookie ck[]=request.getCookies();  
System.out.print("<br>hi!"+ck[0].getValue()+"\n"+ck[1].getValue());//printing name and value of cookie 
String s=ck[0].getValue();

	 //String a=request.getParameter("painter_id");
	 //System.out.println("piantefg"+a);
	
Connection con = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","tashu","123456");
Statement stmt=con.createStatement();
String strSql="select painter_id from painter where email='"+s+"'";
System.out.println("afterlogin query–"+strSql);
ResultSet rs=stmt.executeQuery(strSql);
while(rs.next())
{
int pid=rs.getInt("painter_id");	
System.out.println("id"+pid);

%>
<body>
<form action="Login" method="post">

    <div id="custom-bootstrap-menu" class="navbar navbar-default " role="navigation" style="background-color:grey">
    <div class="container">
        <div class="navbar-header"><a class="navbar-brand" href="#">NETAuction</a>
            <!--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>-->
        </div>
        <div class="collapse navbar-collapse navbar-menubuilder">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="home.html">Home</a>
                </li>
                <li><a href="/about-us">About Us</a>
                </li>
                <li><a href="./LogoutServlet">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</div>

        <header class="intro-header" >
      <div class="uploadform" >
       <div class="intro-message" align="center" >
       <legend>Painter Form <i class="fa fa-pencil pull-right"></i></legend>
          <hr class="intro-divider" >
          <ul class="list-inline intro-social-buttons">
            <li class="list-inline-item">
              <a href="showpaintings.jsp?painter_id=<%=pid%>" class="btn btn-secondary btn-lg" >
                <i class="fa fa-twitter fa-fw"></i>
                <span class="network-name">View Bidder</span>
              </a>
            </li>
             <li class="list-inline-item">
              <a href="myUpload.jsp" class="btn btn-secondary btn-lg">
                <i class="fa fa-twitter fa-fw"></i>
                <span class="network-name">Upload Painting</span>
              </a>
            </li>
             <li class="list-inline-item">
              <a href="showimage.jsp?painter_id=<%=pid%> "class="btn btn-secondary btn-lg">
                <i class="fa fa-twitter fa-fw"></i>
                <span class="network-name">View Painting</span>
              </a>
            </li>
           
           
           </ul>
           
        </div>
      
               
</div>    </header>
    
        
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
         "img/img1.jpg"
        ],

        {
            duration: 4500,
            fade: 1500
        }
    );
        </script>
</form>
</body>
<%} } catch(Exception e){
	System.out.println("Exception in afterlogin servlet"+e.getMessage());
}%>
</html>
