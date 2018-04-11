<%@ page import="java.sql.*"%>
<html>
<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0>
<%
   String theuser=request.getParameter("user");
%>
<p align=right><TABLE cellSpacing=0 cellPadding=0 width=500 border=0><TBODY><BR><TR><TD align=center><A href='./AfterLogin?theuser=<%=theuser%>'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>My Profile</STRONG></A></TD><td align=center> | </td><TD align=center><A href='./Buy.jsp?theuser=<%=theuser%>'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>Buy Item</STRONG></A></TD><td align=center> | </td><TD align=center><A href='./Sold.jsp?theuser=<%=theuser%>'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>Sold Items</STRONG></A></TD><td align=center> | </td><TD align=center>  <A href='./login.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>LogOut</STRONG></A></TD>  </TR><TD></TD>  </TBODY></TABLE></p><br><br><marquee behaviour='ALTERNATE'><B><FONT COLOR='BLUE'><FONT FACE='Comic Sans MS' SIZE='6'>SECURED NETAUCTION</FONT></B></marquee><br>

<%	try
	{
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","tashu","123456");
	Statement stmt=con.createStatement();

		
		

		out.println("<h2><center>Bid Items</h2><br>");
		Statement st2=con.createStatement();
		ResultSet rs2=st2.executeQuery("select im.painting_id,im.type,im.image_name,im.startprice,im.enddate,im.painter_id,bi.bidder_id,bi.bamt from painting im,bidder bi where enddate<= curdate() and bi.bidder_id=1 and bi.status=2 and im.painting_id=bi.painting_id order by painting_id");
		out.println("<center><table border=3 bordercolor=green>");
		out.println("<thead><th>Item ID</th><Th>Cat. ID</th><Th>Item Name</th><Th>Start Price</th><Th>End Date</th>");
		out.println("<Th>Seller ID</th><Th>Bidder ID</th><Th>Bid Amount</th></thead>");
		while(rs2.next())
		{
		int itemno=rs2.getInt(1);
		String catid=rs2.getString(2);
		String itemname=rs2.getString(3);
        String sprice=rs2.getString(4); 
		java.sql.Date edate=rs2.getDate(5);
		String seller=rs2.getString(6);
		String bidder=rs2.getString(7);
        String bamt=rs2.getString(8);
		out.println("<tr><td><a href='./BIDItemDetails.jsp?id="+itemno+"&theuser="+theuser+"'>"+itemno+"</a></td>");
		out.println("<td>" + catid +"</td>");
		out.println("<td>" + itemname +"</td>");
		out.println("<td>" + sprice +"</td>");
		out.println("<td>" + edate +"</td>");
		out.println("<td>" + seller +"</td>");
		out.println("<td>" + bidder +"</td>");
		out.println("<td align=center>" + bamt +"</td></tr>");
		}
		out.println("</table></center><br><br>");

		out.println("<CENTER><STRONG></STRONG>");
		out.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
		out.println("<A href=./EndToday>Closing Items</A>");
		out.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
		out.println("<STRONG></STRONG><A href=./home.jsp>Home/Search</A>");

	}catch(Exception e) { e.printStackTrace(); }
%>


</body>
</html>