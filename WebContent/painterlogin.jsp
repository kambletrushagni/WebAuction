<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
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

<script>
    function validate(){
    	var username=document.form.user.value;
    	var password=document.form.pass.value;
    	if(username==""){
    	 alert("Enter Username!");
    	  return false;
    	}
    	if(password==""){
    	 alert("Enter Password!");
    	  return false;
    	}
    	return true;
    	}
    </script>
    <script type="text/javascript" src="registervalidation.js"></script>
</head>

<body>
<%
        String error_msg = "";
        Object error = request.getAttribute("error");
        if (error != null) error_msg = error.toString();
    %>
<form name="forms" action="Login" method="post" onsubmit="email-validation.js">

    <div id="custom-bootstrap-menu" class="navbar navbar-default " role="navigation" style="background-color:grey">
    <div class="container">
        <div class="navbar-header"><a class="navbar-brand" href="#">NETAuction</a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse navbar-menubuilder">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">Home</a>
                </li>
                <li><a href="/products">Products</a>
                </li>
                <li><a href="/about-us">About Us</a>
                </li>
                <li><a href="/contact">Contact Us</a>
                </li>
            </ul>
        </div>
    </div>
</div>

        <div class="container" >
           <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-center" style="heigth:500px">
           <div id="banner" >
             <h1>Painter <strong>LOGIN Form</strong></h1>

            <h5><strong>.</strong></h5>
           
           </div>
          
              
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
            <div class="registrationform">
            <form class="form-horizontal">
                <fieldset>
                    <legend>Login Form <i class="fa fa-pencil pull-right"></i></legend>
                    <div class="form-group">
                        <label for="userp" class="col-lg-2 control-label">
                            User Name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="userp" name="userp">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="passp" class="col-lg-2 control-label">
                            Password</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="passp" name="passp">
                        </div>
                    </div>
                    
                     <div class="form-group" align="left">
                        <label for="passp" class="col-lg-2 control-label"></b>
                        <h4>
                     <!--       <a href="#">Forgot Your Password</a></h4></b>-->
                        
                    
                       
                                              <h3>   If not register then<a href="painterregister.html">Register</a></h3>                        
                          </label>
                    </div>
                                             <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2" align="center"><br><br>
                            <button type="reset" class="btn btn-warning">
                                Cancel</button>
                            <button type="submit" class="btn btn-primary">
                                LOGIN</button>
                        </div>
                    </div>
                </fieldset>
            </form>
         </div>



         </div>
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
