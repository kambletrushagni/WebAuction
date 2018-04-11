package Servlet;
import java.io.*;


import javax.swing.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Servlet.Session;
/**
 * Servlet implementation class MySQLConnect
 */

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected SessionCache sessionCache;
    protected long flushTimeout=600000;
    protected long sessionTimeout=7200000;
    String e="";
    //String user = request.getParameter("userp");
	public Connection getConnection() throws SQLException 
	{
		//return
		//Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
        
    }
	public void init(ServletConfig config) throws ServletException  {
        super.init(config);
		try
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		
	}catch(Exception e)
		{ 
			System.out.println("new pool error"+e);
		}
		
        sessionCache = new SessionCache (flushTimeout);
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PreparedStatement pst=null;
        ResultSet rs=null;

        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        Cookie thisCookie=null;
        boolean activeSession;
        HttpSession hs=request.getSession(true);
    	//HttpSession session = request.getSession();
    	Session session = validateSession (request, response);
      	//setNoCache (request, response);
String theuser=request.getParameter("user");
session = startSession (user, pass, response,request);
System.out.println("the user="+user);
System.out.println("the pass="+pass);
hs.setAttribute("user",user);
if (session == null ) 
{
 
        
        try {
        	//HttpSession session = request.getSession();
			//session.setAttribute("user", "Pankaj");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
             pst = conn.prepareStatement("select email,password from user where email=? and password=?");
            pst.setString(1, user);
            pst.setString(2, pass);
             rs = pst.executeQuery();
            System.out.println(pst);
            if(rs.next())
            	
            {
            
            /*{
            	
                out.println("Correct login credentials");
                request.getRequestDispatcher("myUpload.jsp").include(request, response); 
            } 
            else {
                out.println("Incorrect login credentials");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }*/
           	if(rs.getString("email").equals(user) && rs.getString("password").equals(pass)){
            		//session.setAttribute(rs.getString("email"),rs.getString("password"));
            		//session.setMaxInactiveInterval(30*60);
            		Cookie PloginCookie = new Cookie("email",user);
        			//setting cookie to expiry in 30 mins
        			PloginCookie.setMaxAge(30*60);
        			response.addCookie(PloginCookie);
        			request.getRequestDispatcher("painterinfo.jsp").include(request, response);
        			out.println(PloginCookie);
        			Cookie ck[]=request.getCookies();  
        			for(int i=0;i<ck.length;i++){  
        		//	 out.print("<br>"+ck[i].getName());//printing name and value of cookie  
        			}
           	}
        			else{
        			request.getRequestDispatcher("painterlogin.jsp").include(request, response);
        		//RequestDispatcher rd = getServletContext().getRequestDispatcher("login.jsp");
        			//PrintWriter out= response.getWriter();
        			//out.print("<font color=red>Either user name or password is wrong.</font>");
        			//rd.include(request, response);}
        		//}	
        		}
        } 
        
        else {
        	 JFrame parent = new JFrame();
        	JOptionPane.showMessageDialog(parent, "invalid");
        	//out.print("<font color=red>Either user name or password is wrong.</font>");
        	request.getRequestDispatcher("login1.jsp").include(request, response);
        }
        }
        catch (Exception e) {
            System.out.println(e);
        }
}
if (session != null) 
{ 
	
	try {
    	//HttpSession session = request.getSession();
		//session.setAttribute("user", "Pankaj");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
         pst = conn.prepareStatement("select email,password from user where email=? and password=?");
        pst.setString(1, user);
        pst.setString(2, pass);
         rs = pst.executeQuery();
        System.out.println(pst);
        if(rs.next())
        	
        {
        
        /*{
        	
            out.println("Correct login credentials");
            request.getRequestDispatcher("myUpload.jsp").include(request, response); 
        } 
        else {
            out.println("Incorrect login credentials");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }*/
       	if(rs.getString("email").equals(user) && rs.getString("password").equals(pass)){
        		//session.setAttribute(rs.getString("email"),rs.getString("password"));
        		//session.setMaxInactiveInterval(30*60);
        		Cookie PloginCookie = new Cookie("email",user);
    			//setting cookie to expiry in 30 mins
    			PloginCookie.setMaxAge(30*60);
    			response.addCookie(PloginCookie);
    			request.getRequestDispatcher("painterinfo.jsp?user="+user+"").include(request, response);
    			//out.println(PloginCookie);
    			Cookie ck[]=request.getCookies();  
    			for(int i=0;i<ck.length;i++){  
    			// out.print("<br>"+ck[i].getName());//printing name and value of cookie  
    			}
       	}
    			else{
    			request.getRequestDispatcher("login1.jsp").include(request, response);
    		//RequestDispatcher rd = getServletContext().getRequestDispatcher("login.jsp");
    			//PrintWriter out= response.getWriter();
    		//	out.print("<font color=red>Either user name or password is wrong.</font>");
    			//rd.include(request, response);}
    		//}	
    		}
    } 
    
    else {
    	 JFrame parent = new JFrame();
    	JOptionPane.showMessageDialog(parent, "invalid");
    	out.print("<font color=red>Either user name or password is wrong.</font>");
    	request.getRequestDispatcher("login1.jsp").include(request, response);
    }
    }
    catch (Exception e) {
        System.out.println(e);
    }
	
	// already logged in
          		if ( response.containsHeader ("Expires") == false ) 
	{

	}                		response.setDateHeader ("Expires", session.getExpires());
          		
	//response.sendRedirect ("myUpload.jsp?user="+user);
          		//else{request.getRequestDispatcher("painterlogin.jsp").include(request, response);}
}

        
    }
    
    

    protected boolean verifyPassword(String user, String pass,HttpServletResponse response,HttpServletRequest request) {
        String originalPassword=null;

        try {
           Connection con=getConnection();
           Statement stmt= con.createStatement();
           String str="select email,password from user where email='"+user+"' and password='"+pass+"'";
           //System.out.println("222select email,password from user where email='"+user+"' and password='"+pass+"'");
           ResultSet rs1 = stmt.executeQuery(str);
           //System.out.println("111select email,password from user where email='"+user+"' and password='"+pass+"'");
	           try{
	        	   if(rs1.next()) {
	           
	     //   	   System.out.println("3333select email,password from user where email='"+user+"' and password='"+pass+"'");
	        	   Cookie pcookie = new Cookie("email",user);
	       			//setting cookie to expiry in 30 mins
	       			//loginCookie.setMaxAge(30*60);
	       			response.addCookie(pcookie);
	       			//request.getRequestDispatcher("painterinfo.jsp").include(request, response);
	       			System.out.println("logincookie"+pcookie);
	       			Cookie ck[]=request.getCookies();  
	       			for(int i=0;i<ck.length;i++){  
	       			 System.out.print("<br>Cookie"+ck[i].getName());//printing name and value of cookie
	       			}
	        	   
	           //catch(Exception e){System.out.println("ttt");e.printStackTrace();}
              			// originalPassword=rs1.getString("password");
        }}catch(Exception e){System.out.println("ttt");e.printStackTrace();}System.out.println("Original pwd : "+originalPassword);
			System.out.println("Original pwd : "+pass);
		        //   }
          
           if(pass.equals(pass)) {
               return true;
           } else {
               return false;
           }
       } catch (Exception e){
           System.out.println("Sys..Exception: verifyPassword="+e);
           return false;
       }
    }
    protected Session startSession (String user, String pass, HttpServletResponse response,HttpServletRequest request) {
    	Session session = null;
    	// Create a session
session = new Session (user);
session.setExpires (sessionTimeout+System.currentTimeMillis());
sessionCache.put (session);
if ( verifyPassword(user, pass,response,request) ) {
	try {
        Connection con=getConnection();
        Statement stmt1= con.createStatement();
        stmt1.executeQuery("select email,password from user where email='"+user+"' and password='"+pass+"'");
        ResultSet rs = stmt1.getResultSet();
	           if(rs.next()) {
	        	   
           			 //originalPassword=rs.getString("password");
		//	System.out.println("Original pwd : "+originalPassword);
			System.out.println("Original pwd email: "+user);
		 String	e=rs.getString("email");
// Create a client cookie
		
Cookie cl1 = new Cookie(e,e);
cl1.setMaxAge (-1);
//cl1.setMaxAge(30*60);
response.addCookie (cl1);

System.out.println(cl1+"\n");
Cookie ck[]=request.getCookies();
for(int i=0;i<ck.length;i++){  
	 System.out.println("Cookie>>"+ck[i].getValue());
	}
	           }
    stmt1.close();
con.close();
}catch(Exception e){System.out.println("trfyg");e.printStackTrace();}
   	}
   	
else
return null;
return session;
}

private Session validateSession (HttpServletRequest request, HttpServletResponse response) {
	String user = request.getParameter("userp");
	Cookie c[] = request.getCookies();
Session session = null;
if ( c != null ) {
for (int i=0; i < c.length && session == null; i++ ) {
if(c[i].getName().equals(user)) {
String key = String.valueOf (c[i].getValue());
session=sessionCache.get (key);
}
}
}
return session;
}

protected void endSession (Session session) {
synchronized (sessionCache) {
sessionCache.remove (session);
}
}

private void setNoCache (HttpServletRequest request, 
        HttpServletResponse response) {

if(request.getProtocol().compareTo ("HTTP/1.0") == 0) {
response.setHeader ("Pragma", "no-cache");
} else if (request.getProtocol().compareTo ("HTTP/1.1") == 0) {
response.setHeader ("Cache-Control", "no-cache");
}
response.setDateHeader ("Expires", 0);
}

}
