package Servlet;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Displaypainter extends HttpServlet 
{
    protected SessionCache sessionCache;
    protected long flushTimeout=600000;
    protected long sessionTimeout=7200000;
	
	public Connection getConnection() throws SQLException 
	{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
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

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
   {

       Cookie thisCookie=null;
       boolean activeSession;
       HttpSession hs=request.getSession(true);
       String cmd;

	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();

       	Session session = validateSession (request, response);
          	//setNoCache (request, response);
	String theuser=request.getParameter("user");
	String thepass=request.getParameter ("pass");
	session = startSession (theuser, request.getParameter ("pass"), response,request);
	System.out.println("the user="+theuser);
	hs.setAttribute("user",theuser);
	if (session == null ) 
	{
		
		request.getRequestDispatcher("login1.jsp").include(request, response);
		
       /*pw.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
		//pw.println("<DIV id=Layer1 style='Z-INDEX: 1; LEFT: 410px; WIDTH: 328px; POSITION: absolute; TOP: 65px; HEIGHT: 35px'>");
		
		pw.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD>  <TD> <A href='./ForSale.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>CURRENT BID ITEMS</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
		pw.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
		pw.println("<SELECT  name=category > <option >Choose Category</option>");
		try
		{
			Connection con=getConnection();
		Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select type from painting");
		while(rs.next()){
		pw.println("<OPTION>"+rs.getString(1)+"</OPTION>");}
		}
		catch(Exception e){}
		/*pw.println("</SELECT> <INPUT type=submit value=Go > ");
		pw.println("</FORM></p><!-- End ImageReady Slices -->");
		pw.println("<br><br><center><b>in valid user name or password</b></center>");

		pw.println("</center><br><br><br><CENTER><STRONG></STRONG>");
		pw.println("<A href='./NewToday'>New Items</A><STRONG></STRONG>");
		pw.println("<A href='./EndToday'>Closing Items</A>");
		pw.println("<STRONG></STRONG><A href='./sell.jsp'>Sell Items</A>");
		pw.println("<STRONG></STRONG><A href='./home.jsp'>Home</A>");
		pw.println("<br><br>");*/
		//request.getRequestDispatcher("login1.jsp").include(request, response);


	}
	if (session != null) 
	{ 
		
               		// already logged in
              		if ( response.containsHeader ("Expires") == false ) 
		{

                    		response.setDateHeader ("Expires", session.getExpires());
              		}
		response.sendRedirect ("./painterinfo.jsp?user="+theuser);
	}
   }

    protected boolean verifyPassword(String theuser, String password,HttpServletResponse response,HttpServletRequest request) {
        String originalPassword=null;

        try {
           Connection con=getConnection();
           Statement stmt= con.createStatement();
           stmt.executeQuery("select password from user where email='"+theuser+"'");
           ResultSet rs = stmt.getResultSet();
	           if(rs.next()) {
              			 originalPassword=rs.getString(1);
              			Cookie pcookie = new Cookie("email",theuser);
    	       			//setting cookie to expiry in 30 mins
    	       			//loginCookie.setMaxAge(30*60);
    	       			response.addCookie(pcookie);
    	       			//request.getRequestDispatcher("painterinfo.jsp").include(request, response);
    	       			System.out.println("logincookie"+pcookie);
    	       			Cookie ck[]=request.getCookies();  
    	       			for(int i=0;i<ck.length;i++){  
    	       			 System.out.print("<br>Cookie"+ck[i].getName());//printing name and value of cookie
			System.out.println("Original pwd : "+originalPassword);
			System.out.println("Original pwd : "+password);
		           }
           stmt.close();
	con.close();
           if(originalPassword.equals(password)) {
               return true;
           } else {
               return false;
           }}
	           
    } catch (Exception e){
        System.out.println("Exception: verifyPassword="+e);
        return false;
    }
    }

    protected Session startSession (String theuser, String password, 
                                           HttpServletResponse response,HttpServletRequest request) {
        Session session = null;
        if ( verifyPassword(theuser, password,response,request) ) {
            // Create a session
            session = new Session (theuser);
            session.setExpires (sessionTimeout+System.currentTimeMillis());
            sessionCache.put (session);
            try {
		        Connection con=getConnection();
		        Statement stmt= con.createStatement();
		        stmt.executeQuery("select email,password from painter where email='"+theuser+"' and password='"+password+"'");
		        ResultSet rs = stmt.getResultSet();
			           if(rs.next()) {
			        	   
		           			 //originalPassword=rs.getString("password");
				//	System.out.println("Original pwd : "+originalPassword);
					System.out.println("Original pwd email: "+theuser);
					String e=rs.getString("email");
		// Create a client cookie
				
		Cookie cl = new Cookie(e,e);
		//cl.setMaxAge (-1);
		cl.setMaxAge(30*60);
		response.addCookie (cl);

		System.out.println("dfghjk"+e+"\n");
		Cookie ck[]=request.getCookies();
		for(int i=0;i<ck.length;i++){  
			 System.out.println("Cookie>>"+ck[i].getValue());
			}
			           }
			          // else{request.getRequestDispatcher("login1.jsp").include(request, response);}
		    stmt.close();
		con.close();
		}catch(Exception e){e.printStackTrace();}
	
            // Create a client cookie
            Cookie c = new Cookie("AUCTION", String.valueOf (session.getId()));
            c.setMaxAge (-1);
            response.addCookie (c);
	}
	else
		return null;
	return session;
    }

    private Session validateSession (HttpServletRequest request, HttpServletResponse response) {
       Cookie c[] = request.getCookies();
       Session session = null;
       if ( c != null ) {
          for (int i=0; i < c.length && session == null; i++ ) {
             if(c[i].getName().equals("AUCTION")) {
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

