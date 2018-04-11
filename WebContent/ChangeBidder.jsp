<%@ page import="java.sql.*"%>
<html>
<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0>
<%
   String theuser=request.getParameter("bidder");
%>
<p align=right><TABLE cellSpacing=0 cellPadding=0 width=500 border=0><TBODY><BR><TR><TD align=center><A href='./AfterLogin?theuser=<%=theuser%>'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>My Profile</STRONG></A></TD><td align=center> | </td><TD align=center><A href='./Buy.jsp?theuser=<%=theuser%>'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>Buy Item</STRONG></A></TD><td align=center> | </td><TD align=center><A href='./Sold.jsp?theuser=<%=theuser%>'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>Sold Items</STRONG></A></TD><td align=center> | </td><TD align=center>  <A href='./login.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>LogOut</STRONG></A></TD>  </TR><TD></TD>  </TBODY></TABLE></p><br><br><marquee behaviour='ALTERNATE'><B><FONT COLOR='BLUE'><FONT FACE='Comic Sans MS' SIZE='6'>SECURED NETAUCTION</FONT></B></marquee><br>

<%	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "tashu", "123456");
	   Statement stmt=con.createStatement();

		
		

		out.println("<h2><center>Your request is processed</h2><br>");
		Statement st2=con.createStatement();
		int i=st2.executeUpdate("Update bidding_info set status=3 where bidderid='"+theuser+"' and bamt="+request.getParameter("bamt")+" and itemid="+request.getParameter("itemid"));
		if(i>0)
            i=st2.executeUpdate("Update bidding_info set status=1 where bamt=(select max(bamt) from bidding_info where itemid="+request.getParameter("itemid")+" and status!=3)");
		out.println("<br><br><br><CENTER><STRONG></STRONG>");
		out.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
		out.println("<A href=./EndToday>Closing Items</A>");
		out.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
		out.println("<STRONG></STRONG><A href=./home.jsp>Home/Search</A>");

	}catch(Exception e) { e.printStackTrace(); }
%>


</body>
</html>