package Servlet;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class EndToday extends HttpServlet 
{
	Connection con;
	
	PrintWriter pw;
 
	public void init(ServletConfig sc) throws ServletException
	{
	try
	{
		super.init(sc);
	}catch(Exception ce) { ce.printStackTrace();}
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
	try{
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
		res.setContentType("text/html");
		pw=res.getWriter();

pw.println("<BODY bgColor=pink leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
		//pw.println("<DIV id=Layer1 style='Z-INDEX: 1; LEFT: 410px; WIDTH: 328px; POSITION: absolute; TOP: 65px; HEIGHT: 35px'>");
pw.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=100% border=0 ><TBODY bgcolor=grey height=30%><BR><FONT COLOR='white' FACE='arial'><strong><b>NETAuction</b></strong></font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
		"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./NewToday'><STRONG><FONT COLOR='white' FACE='arial'>New Paintings</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
		"<A href='./home.html'><STRONG><FONT COLOR='white' FACE='arial'>HOME</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  </A><A href='./LogoutServlet'><STRONG><FONT COLOR='white' FACE='arial'>Logout</STRONG></font>      </A>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./help.jsp'><STRONG><FONT COLOR='white' FACE='arial'>About Us</STRONG> </A> </font></TBODY></TABLE></p><br><br>");
		pw.println("</FORM></p><!-- End ImageReady Slices -->");
		pw.println("<h2><center>Closing ITems Today </h2><br>");
		Statement st2=con.createStatement();
		ResultSet rs2=st2.executeQuery("select * from painting where enddate=curdate() ");
		pw.println("<center><table border=5 width=50% cellspacing=3 cellpadding=2 bordercolor=black>");
		pw.println("<thead><th>Item<Th>Description<Th>Current Price");
		pw.println("<Th>Number Of Bids<Th>Auction Starting Date</thead>");
		while(rs2.next())
		{
		int itemno=rs2.getInt("painting_id");
		String desp=rs2.getString("description");
		int cp=rs2.getInt("startprice");
		java.sql.Date sdate=rs2.getDate("enddate");
		int nob=rs2.getInt("bcnt");
		pw.println("<tr><td><a href='./ItemDetails?id="+itemno+"'> "+itemno+"</td>");
		pw.println("<td>" + desp +"</td>");
		pw.println("<td>" + cp +"</td>");
		pw.println("<td>" + nob +"</td>");
		pw.println("<td align=center>" + sdate +"</td></tr>");
		}
		pw.println("</table></center><br><br>");

		pw.println("<h2>Closing ITems Tomarrow </h2><br>");
		Statement st4=con.createStatement();
		ResultSet rs4=st4.executeQuery("select * from painting where enddate=curdate()+1");
		pw.println("<center><table border=5 width=50% cellspacing=3 cellpadding=2 bordercolor=black>");
		pw.println("<thead><th>Item<Th>Description<Th>Current Price");
		pw.println("<Th>Number Of Bids<Th>Auction Starting Date</thead>");
		while(rs4.next())
		{
		int itemno=rs4.getInt("painting_id");
		String desp=rs4.getString("description");
		int cp=rs4.getInt("startprice");
		java.sql.Date sdate=rs4.getDate("enddate");
		int nob=rs4.getInt("bcnt");
		pw.println("<tr><td><a href='./ItemDetails?painting="+itemno+"'> "+itemno+"</td>");
		pw.println("<td>" + desp +"</td>");
		pw.println("<td>" + cp +"</td>");
		pw.println("<td>" + nob +"</td>");
		pw.println("<td align=center>" + sdate +"</td></tr>");
		}
		pw.println("</table></center><br><br>");

	//	pw.println("<CENTER><STRONG></STRONG>");
		//pw.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
		//pw.println("<A href=./EndToday>Closing Items</A>");
		//pw.println("<STRONG></STRONG><A href=./home.jsp>Home/Search</A>");


	}catch(Exception e) { e.printStackTrace(); }
	}
}
