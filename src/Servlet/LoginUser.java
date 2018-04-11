/*package Servlet;
import java.io.*;

import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class MySQLConnect
 */
/*
public class LoginUser extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        try {
        	HttpSession session = request.getSession();
			//session.setAttribute("user", "Pankaj");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
            PreparedStatement pst1 = conn.prepareStatement("Select email,password from user where email='"+user+"' and password='"+pass+"'");
            pst1.setString(1, user);
            pst1.setString(2, pass);
            ResultSet rs = pst1.executeQuery();
            if (rs.next	())/* {
                out.println("Correct login credentials");
                request.getRequestDispatcher("myUpload.jsp").include(request, response); 
            } 
            else {
                out.println("Incorrect login credentials");
                request.getRequestDispatcher("login.jsp").include(request, response);
            */
  /*          	if(rs.getString("email").equals(user) && rs.getString("password").equals(pass)){
            		session.setAttribute(rs.getString("email"),rs.getString("password"));
            		session.setMaxInactiveInterval(30*60);
            		Cookie loginCookie = new Cookie("email",user);
        			//setting cookie to expiry in 30 mins
        			loginCookie.setMaxAge(30*60);
        			response.addCookie(loginCookie);
        			request.getRequestDispatcher("myUpload.jsp").include(request, response);
        			out.println(loginCookie);
        			Cookie ck[]=request.getCookies();  
        			for(int i=0;i<ck.length;i++){  
        			 out.print("<br>"+ck[i].getName());//printing name and value of cookie  
        			}
        			
        			}
            	else{
        			request.getRequestDispatcher("login.jsp").include(request, response);
        		//RequestDispatcher rd = getServletContext().getRequestDispatcher("login.jsp");
        			//PrintWriter out= response.getWriter();
        			out.print("<font color=red>Either user name or password is wrong.</font>");
        			//rd.include(request, response);}
        		//}	
        		}
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}*/