<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="Servlet.*,java.util.*,java.io.*,javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"&gt;>

<html>
<head>
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
<form name=frm method="post" action="./InsertImage">
<%
Cookie emailc=null;
Cookie emailck[]=request.getCookies();
if(emailck!=null)
{
System.out.println("cookie found");
for(int i=0;i<emailck.length;i++){
	emailc=emailck[i];

String email=emailc.getName();
String email1=emailc.getValue();
System.out.println("email\t"+email1+"\t"+email);
}
}
%>
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
                <li><a href="/contact">Contact Us</a>
                </li>
            </ul>
        </div>
    </div>
</div>
 
            <div class="regform">
            <form class="form-horizontal">
            <fieldset>
                    <legend>UPLOAD <i class="fa fa-pencil pull-right"></i></legend>
                    <div class="form-group">
                        <label for="Image" class="col-lg-2 control-label">
                            Image</label>&nbsp&nbsp&nbsp&nbsp&nbsp
                        <div class="col-lg-10">
                            <input type="file" class="form-control" id="Image" name="Image">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="type" class="col-lg-2 control-label">
                            Image Type</label>
                        <div class="col-lg-10">
                            <select class="form-control" id="type" name="type">
                            <option name="Acr">Acrylic</option>
							<option name="oil">Oil</option>
							<option name="wat">Watercolor</option>
							</select>
							</div>
							</div>
							<div class="form-group">
                        <label for="description" class="col-lg-2 control-label">
                           Description</label>
                        <div class="col-lg-10">
                           <textarea name="description" rows="4" cols="30" id="address" name="address" class="form-control"></textarea>
                                                   </div>
                    </div>
                    <div class="form-group">
                        <label for="stp" class="col-lg-2 control-label">
                            Initial Price</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="stp" name="stp">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="intp" class="col-lg-2 control-label">
                            Increment Price</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="intp" name="intp">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dur" class="col-lg-2 control-label">
                            Duration</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="dur" name="dur">
                        </div>
                    </div>
                    <div>
                                                     <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2" align="center"><br><br>
                            
                            <button type="submit" class="btn btn-primary">
                                Upload</button>
                        </div>
                    </div>
                </fieldset>
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
                
                                               

<!--<table>
<tr><TD >Upload Image</TD>
<TD><input type="file" name="Image" size="30" ></TD>
</tr>
<tr><TD >Image Type</TD>
<td><select name="type" row="3" color="#000">
<option name="Acr">Acrylic</option>
<option name="oil">Oil</option>
<option name="wat">Watercolor</option></TD>
</tr>

<tr><TD >Description</TD>
<td><textarea name="description" rows="4" cols="30"></textarea></TD>
</tr>

<tr><TD>Start Price</TD>
<td><input type="text" name="stp" size="30" ></TD>
</tr>

<tr><TD >Increment Price</TD>
<td><input type="text" name="intp" size="30"></TD>
</tr>

<tr><TD >Duration</TD>
<td><input type="text" name="dur" size="30"></TD>
</tr>

<tr>
<td><input type="submit" height=”30″ width=”62″ value="submit"> </td>
</tr>
</table>-->
</form>
</div>        

</form>
</body>
</html>
