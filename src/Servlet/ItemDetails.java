package Servlet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.rmi.*;
import javax.naming.*;
import java.util.*;
import java.sql.*;

public class ItemDetails extends HttpServlet
{
	//Connection con;
	PrintWriter pw;
	
/*	public void init(ServletConfig sc) throws ServletException
	{
	try
	{
		super.init(sc);
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "tashu", "123456");
	}catch(Exception ce) { ce.printStackTrace();}
	}*/
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		 
	try{
		pw=res.getWriter();
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
		res.setContentType("text/html");
		//		theme(res);
		pw.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=100% border=0 ><TBODY bgcolor=grey height=30%><BR><FONT COLOR='white' FACE='arial'><strong><b>NETAuction</b></strong></font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
				"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./home.html'><STRONG><FONT COLOR='white' FACE='arial'>Home</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./NewToday'><STRONG><FONT COLOR='white' FACE='arial'>New Paintings</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
				"<A href='./EndTodayS'><STRONG><FONT COLOR='white' FACE='arial'>Closing Paitings</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  </A><A href='./LogoutServlet'><STRONG><FONT COLOR='white' FACE='arial'>Logout</STRONG></font>      </A>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./help.jsp'><STRONG><FONT COLOR='white' FACE='arial'>About Us</STRONG> </A> </font></TBODY></TABLE></p><br><br>");
	//	pw.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
	//	pw.println("<SELECT  name=category > <option >Choose Category</option>");
		try
		{
		Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select type from painting");
		while(rs.next()){
		//pw.println("<OPTION>"+rs.getString("type")+"</OPTION>");
			}
		}
		catch(Exception e){e.printStackTrace();
		                   System.out.println("try1");}
		//pw.println("</SELECT> <INPUT type=submit value=Go > ");
		pw.println("</FORM></p><!-- End ImageReady Slices -->");		pw.println("<body bgcolor=pink><h2><center>Painting Details</h2>");

		int itid =Integer.parseInt(req.getParameter("painting"));
		
//		int itid=104;
		System.out.println("id>>>>>>>"+itid);
		Statement stt=con.createStatement();
		ResultSet rss=stt.executeQuery("select image_name from painting where painting_id="+itid+"");//+" and enddate >= sysdate");
		rss.next(); 
		String iname=rss.getString(1);
	//	pw.println("<center><font size=+2 face=Arial ><u>"+iname+"</u></font></center><br>");
		pw.println("<img src="+iname+" width=20% class=img-rounded></img></center><br>");
		Statement st1 = con.createStatement();
		ResultSet rs1 = st1.executeQuery("select bidder_id,bamt from bidder where painting_id="+itid+" and bamt=(select max(bamt) from bidder where painting_id="+itid+")"); 
		
		//String bid="No Bidder Till now";
		int bid=0;
		int bamt=0;
		
		if(rs1.next()){
			
		 bid = rs1.getInt(1);
		 bamt = rs1.getInt(2);	
		}
		Statement st=con.createStatement();
		Statement st2=con.createStatement();
		Statement st3=con.createStatement();
		Statement stmt=con.createStatement();
		ResultSet rs=st.executeQuery("select description,startprice,incrementprice,dateofcreation,enddate,painter_id,bcnt from painting where painting_id="+itid);
		pw.println("<center><table border=10 width=50% cellspacing=2 cellpadding=3><font size=5 face=Arial >");
		int sp=0;
		int minincr=0;
		while(rs.next())
		{
			String desp=rs.getString(1);
			sp=rs.getInt(2);
			minincr=rs.getInt(3);
			java.sql.Date stdate=rs.getDate(4);
			java.sql.Date edate=rs.getDate(5);
			int seller=rs.getInt(6);
			String nob=rs.getString(7);
			ResultSet rs2=st2.executeQuery("select firstname,lastname from painter where painter_id="+seller);
			while(rs2.next()){
				String fname=rs2.getString(1);
				String lname=rs2.getString(2);
				pw.println("<TR><TD>Painter</TD><td>" + fname +"&nbsp"+lname+"</td></tr>");}
			
			//if (bamt==0)
				//bamt=Integer.parseInt(sp);
			pw.println("<TR><TD>Start Price</TD><td>" + sp +"</td></tr>");
			pw.println("<TR><TD>Minimum Increment</TD><td>" + minincr +"</td></tr>");
			pw.println("<TR><TD>Number Of Bids</TD><td>" + nob +"</td></tr>");
			pw.println("<TR><TD>Auction Start Date</TD><td>" + stdate +"</td></tr>");
			pw.println("<TR><TD>Auction Ending Date</TD><td>" + edate +"</td></tr>");
		   //pw.println("<TR><TD>Painter</TD><td>" + fname +"&nbsp"+lname+"</td></tr>");
		   //pw.println("<TR><TD>High Bidder</TD><td>" + bid +"</td></tr>");
			String fnameb="NO BIDDER TILL NOW";
			String lnameb="";
			ResultSet rs3=st3.executeQuery("select firstname,lastname from user where user_id="+bid+"");
			System.out.println("select firstname,lastname from user where user_id="+bid+"");
			while(rs3.next()){
				
				 fnameb=rs3.getString(1);
				 lnameb=rs3.getString(2);
				pw.println("<TR><TD>High Bidder</TD><td>" + fnameb +"&nbsp"+lnameb+"</td></tr>");
				}
		
			pw.println("<tr><td>Current Bid Price</td><td>"+bamt+"</td></tr>");
			pw.println("<TR><TD>Description</TD><td>" + desp +"</td></tr>");
			
		}
		
		ResultSet rst=stmt.executeQuery("select enddate from painting where painting_id="+itid); 
		if(rst.next())
		{
			
			java.sql.Date stdate=rst.getDate("enddate");
			java.util.Date date=new java.util.Date();
			java.sql.Date sqldate=new java.sql.Date(date.getTime());
System.out.println("sqldate>>"+sqldate+"stdate>>"+stdate+"tfdghj"+stdate.after(sqldate)+"equal"+stdate.equals(sqldate));
			if(stdate.before(sqldate)==false)
			{
				if(stdate.equals(sqldate)==false)
				{
		pw.println("</font></table><br><br><center>");
		pw.println("<P><STRONG>Do you want to bid on this item?</STRONG>");
		pw.println("<form action=./BiddingServlet>");
		pw.println("<input type=hidden name=id value="+req.getParameter("painting"));
		pw.println("><input type=hidden name=hbid value="+bamt);
		pw.println("><input type=hidden name=min value="+minincr);
		pw.println("><header><TABLE cellspacing=2 cellpadding=2 width=30%><TR><TD>Enter your user id:</TD><TD><INPUT TYPE=\"TEXT\" SIZE=20 NAME=\"bidder\"></TD></TR>");
		pw.println("<TR><TD>Enter your password:</TD><TD><INPUT TYPE=PASSWORD SIZE=20 NAME=password></TD>");
		pw.println("</TR><TR><TD>Your Bid Amount:</TD><TD><INPUT TYPE=\"TEXT\" SIZE=20 NAME=\"amount\"  onBlur=f()></TD></table></header><br><br><input type=submit value=\"Bid for Item\"></form></tr>");
				}
				else{
					pw.println("</table><center>");
					pw.println("<tr>Auction Close<br>Check the Highest Bidder<a href='BIDItemDetails.jsp?painting="+itid+"'>check</a></tr></form></table>");
					}
			
		
				}
			else{
				pw.println("</table><center>");
				pw.println("<tr>Auction Close<br>Check the Highest Bidder<a href='BIDItemDetails.jsp?painting="+itid+"'>check</a></tr></form></table>");
				}
	
			}
	}catch(Exception e){e.printStackTrace();System.out.println("nulll>>>");}
	
		/*pw.println("<CENTER><STRONG></STRONG>");
		pw.println("<A href=./Getpainterinfo>New Items</A><STRONG></STRONG>");
		pw.println("<A href=./EndToday>Closing Items</A>");
		pw.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
		pw.println("<STRONG></STRONG><A href=./home.jsp>Home</A>");
*/
		
	}
	public void theme(HttpServletResponse res) throws Exception
	{
		
		pw=res.getWriter();
		pw.println("<head>  <title>NETAuction</title>  <meta name='viewport' content='width=device-width, initial-scale=1'>  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
	//	pw.println(" <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script> <meta name='description' content='Coming soon, Bootstrap, Bootstrap 3.0, Free Coming Soon, free coming soon, free template, coming soon template, Html template, html template, html5, Code lab, codelab, codelab coming soon template, bootstrap coming soon template'><title>NETAuction</title><link href='http://fonts.googleapis.com/css?family=EB+Garamond' rel='stylesheet' type='text/css' />");
		pw.println(" <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300,800' rel='stylesheet' type='text/css' />  <link href='css/bootstrap.min.css' rel='stylesheet' type='text/css' /> <link href='css/style.css' rel='stylesheet' type='text/css' />   <link href='css/font-awesome.css' rel='stylesheet' type='text/css' />");
		pw.println("<style> .navbar {margin-bottom: 50px;border-radius: 0;} .jumbotron {margin-bottom: 0; }  footer {background-color: #f2f2f2; padding: 25px;}</style>");
		pw.println("</head><body> <div id='custom-bootstrap-menu' class='navbar navbar-default' role='navigation' style='background-color:grey'> <div class='container'> <div class='navbar-header'><a class='navbar-brand' href='#'>NETAuction</a><button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-menubuilder'><span class='sr-only'>Toggle navigation</span><span class='icon-bar'></span><span class='icon-bar'></span><span class='icon-bar'></span>   </button></div><div class='collapse navbar-collapse navbar-menubuilder'><ul class='nav navbar-nav navbar-right'><li><a href='./home.html'>Home</a></li>");
		pw.println("<li><a href='./help.jsp'>About Us</a></li><li><a href='./LogoutServlet'>Logout</a></li></ul></div></div></div>");

	}

}