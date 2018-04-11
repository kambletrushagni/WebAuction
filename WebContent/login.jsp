<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <title>Login</title>
    <script>
    function validate1(){
    	var username=document.form1.user.value;
    	var password=document.form1.pass.value;
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
</head>
<body>
    <%
        String error_msg = "";
        Object error = request.getAttribute("error");
        if (error != null) error_msg = error.toString();
    %>
    <form name="form1" action="Login" method ="post">
    <div id="Container">
        <div id="Header">
            <h1>NETAuction</h1>
        </div>
        <a href="../index.html" target="_self">Home</a>
        <div id="Content">
            <div id="Login">
                
                    <table align = "center" >
                        <tr><td align = "left">Username:   </td>
                                                    </tr>
                        <tr>
                            <td><input name="user" type="text" size="30"></td>
                            <td></td>
                        </tr>
                        <tr><td align = "left">Password:</td></tr>
                        <tr><td><input name="pass" type="password" size="30"></td></tr>
                        <tr><td align = "left">Forgot your password?</td></tr>
                        <tr><td align = "left">Remember me       <input type="checkbox" name="checkbox" value="checkbox"></td></tr>
                        <tr><td align = "left"><input type="Submit" value="LOGIN"></td></tr>
                    </table>
                
           </div>
        </div>
    </div>
    </form>  
</body>
</html>