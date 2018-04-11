<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Servlet.*,java.util.*,javax.servlet.*,java.lang.*,java.sql.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NETAuction</title>
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
<body>

<div id="custom-bootstrap-menu" class="navbar navbar-default " role="navigation" style="background-color:grey">
    <div class="container">
        <div class="navbar-header"><a class="navbar-brand" href="#">NETAuction</a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse navbar-menubuilder">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="home.html">Home</a>
                </li>
                <li><a href="">Products</a>
                </li>
                <li><a href="/about-us">About Us</a>
                </li>
                <li><a href="./LogoutServlet">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</div>



<div class="container">
 <form name=logout action="${pageContext.request.contextPath}/LogoutServlet" method="post">
   <button type="submit">Logout</button>
</form>     
</div>
<div>
<form name=frm1 method="get" action="./InsertImage">

 <div class="table-responsive">
           
  <table class="table">
    <thead>
      <tr bgcolor="grey">
        <th>Painting No.</th>
        <th>Description</th>
        <th>Type&nbsp&nbsp&nbsp&nbsp&nbsp</th>
        <th>Painting&nbsp&nbsp&nbsp&nbsp&nbsp</th>
        <th>Start Price</th>
        <th>Increment Price</th>
        <th>Auction Start Date</th>
        <th>Auction End Date</th>
      </tr>
    </thead>
 <%

try
{
	 String a=request.getParameter("painter_id");
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

//vList.add(temp1);


 //String a=request.getParameter("painter_id");
 /*GetImage udet1 = new GetImage();
Vector V_ids1=new Vector();
V_ids1=udet1.ImageList();
for(int i=0;i<V_ids1.size();i++)
{
String temp[] = new String[10];
int j=i+1;
temp=(String[])V_ids1.get(i);
*/
%>
<tbody>
      <tr>
<td >
<b><%=temp[0] %></b></td>
<td >
<b><%=temp[2] %></b></td>
<td >
<b><%=temp[3] %></b></td>
<td width=100><a target='_blank' href='<%=response.encodeURL("DisplayImage?painting_id="+temp[0])%>' onmouseover='_ScrollStatus("Click here for view", 1);' onmouseout='_StopScrollStatus();' onblur='_StopScrollStatus();' >
<b><%=temp[1]%></b></a></td>
<td >
<b><%=temp[4] %></b></td>
<td >
<b><%=temp[5] %></b></td>
<td >
<b><%=temp[6] %></b></td>
<td >
<b><%=temp[7] %></b></td>

</tr>

<%

}
}
catch(Exception e) {
System.err.print("ImageList Exception : "+e);
System.err.println("ImageList Exception : "+e.getMessage());
}

%>
 </tbody>
  </table>
  </div>
  </div>


</form>

</body>
</html>
