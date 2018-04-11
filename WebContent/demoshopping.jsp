<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="Servlet.*,java.util.*,java.sql.*,javax.servlet.*,java.lang.*" pageEncoding="ISO-8859-1"%>
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
<!--  <form name="formp" method="get" action="./ItemDetails?painting="<%//=temp[0]%>>-->

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

try
{
	 String a=request.getParameter("painter");
	 System.out.println("piantefg"+a);
	
Connection con = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","tashu","123456");
Statement stmt=con.createStatement();
//String strSql="select Image_id,Image_name from upload_image";
//Cookie emailck[]=request.getCookies();
//String email=emailck[1].getValue();
/*String p="select painter_id from painter where email='"+a+"' ";
ResultSet rs1=stmt.executeQuery(p);
rs1.next();
int email=rs1.getInt("painter_id");
System.out.println("email"+email);
*/
String strSql="select painting_id,image_name,description,type,startprice,incrementprice,dateofcreation,enddate from painting where painter_id="+a+"";
System.out.println("ImageList query–"+strSql);
ResultSet rs=stmt.executeQuery(strSql);

while(rs.next()){
String temp[]=new String[10];
//int temp1[]=new int[5];
temp[0]=rs.getString("painting_id");
temp[1]=rs.getString("image_name");
temp[2]=rs.getString("description");
temp[3]=rs.getString("type");
temp[4]=rs.getString("startprice");
temp[5]=rs.getString("incrementprice");
temp[6]=rs.getString("dateofcreation");
temp[7]=rs.getString("enddate");

/*
Cookie ck[]=request.getCookies();  
// out.print("<br>hi!"+ck[0].getValue());//printing name and value of cookie 

 GetImage udet1 = new GetImage();
Vector V_ids1=new Vector();
V_ids1=udet1.ImageList();
for(int i=0;i<V_ids1.size();i++)
{
String temp[] = new String[10];
int j=i+1;
temp=(String[])V_ids1.get(i);
*/
%>
 <div class="container" > 
  <div class="col">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading">Painting No. <td><%=temp[0] %></td></div>
        
        <div class="panel-body"><img src="<%=temp[1] %>" class="img-responsive" style="width:100%" alt="Image"></div>
        
        <A href="./ItemDetails?painting=<%=temp[0]%>"><center><b>Bid</b></center></A><STRONG></STRONG></div>
      </div>
    </div>
    </div>
    <br><br>
<%
}
}
catch(Exception e) {
System.err.print("ImageList Exception : "+e);
System.err.println("ImageList Exception : "+e.getMessage());
}


%>
</div>

<!-- footer class="container-fluid text-center">
  <p>Online Store Copyright</p>  
  <form class="form-inline">Get deals:
    <input type="email" class="form-control" size="50" placeholder="Email Address">
    <button type="button" class="btn btn-danger">Sign Up</button>
    
  </form>
</footer>-->
</form>

</body>
</html>
    