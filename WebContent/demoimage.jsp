<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="img2.jpg">
<%
Cookie ck[]=request.getCookies();  
 out.print("<br>hi!"+ck[0].getValue());//printing name and value of cookie 

 GetImage udet1 = new GetImage();
Vector V_ids1=new Vector();
V_ids1=udet1.ImageList();
for(int i=0;i<V_ids1.size();i++)
{
String temp[] = new String[5];
int j=i+1;
temp=(String[])V_ids1.get(i);

%>


<div class="container">
  <h2>Rounded Corners</h2>
  <p>The img-rounded class adds rounded corners to an image (not available in IE8):</p>   
   <img src="img/34.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236">
  
</div>
<%
}
%>
</body>
</html>
    