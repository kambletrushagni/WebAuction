<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <!--[if lt IE 7]> <html class="no-js ie6 oldie" lang="en"> <![endif]-->
    <!--[if IE 7]>    <html class="no-js ie7 oldie" lang="en"> <![endif]-->
    <!--[if IE 8]>    <html class="no-js ie8 oldie" lang="en"> <![endif]-->
    <!--[if IE 9]> <html class="no-js ie9 oldie" lang="en"> <![endif]-->
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
<form action="./RegisterUser" method="post">

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
            <div class="regform">
            <form class="form-horizontal">
                <fieldset>
                    <legend>Registration Form <i class="fa fa-pencil pull-right"></i></legend>
                    <div class="form-group">
                        <label for="fName" class="col-lg-2 control-label">
                            First_Name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="fName" name="fName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lName" class="col-lg-2 control-label">
                            Last_Name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="lName" name="lName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="userEmail" class="col-lg-2 control-label">
                            Email</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="userEmail" name="userEmail">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phno" class="col-lg-2 control-label">
                            Phone_No</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="phno" name="phno">
                        </div>
                    </div>
                     <div class="form-group">
                        <label for="address" class="col-lg-2 control-label">
                            Address</label>
                        <div class="col-lg-10">
                        <textarea name="description" rows="4" cols="30" id="address" name="address" class="form-control"></textarea>
                        </div>
                    </div>
                     <div class="form-group">
                        <label for="city" class="col-lg-2 control-label">
                            City</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="city" name="city">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="state" class="col-lg-2 control-label">
                            State</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="state" name="state">
                        </div>
                    </div>
                   
                    <div class="form-group">
                        <label for="userPass" class="col-lg-2 control-label">
                            Password</label>
                        <div class="col-lg-10">
                            <input type="password" class="form-control" id="userPass" name="userPass" placeholder="Password">
                              </div>
                    </div>
                         <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button type="reset" class="btn btn-warning">
                                Cancel</button>
                            <button type="submit" class="btn btn-primary">
                                Submit</button>
                        </div>
                    
                    </div>
                </fieldset>
            </form>
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
            duration: 4500,
            fade: 1500
        }
    );
        </script>
</form>
</body>
</html>
