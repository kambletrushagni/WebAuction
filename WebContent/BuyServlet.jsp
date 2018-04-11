<%@ page import="java.sql.*,javax.servlet.*"%>
<html>

<BODY  bgcolor=pink leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0>
<%
   String theuser=request.getParameter("bidder");
%><%	try


	{
	 out.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=100% border=0 ><TBODY bgcolor=grey height=30% ><BR><FONT COLOR='white' FACE='arial'><strong><b>NETAuction</b></strong></font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
				"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./home.html'><STRONG><FONT COLOR='white' FACE='arial'>Home</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./NewToday'><STRONG><FONT COLOR='white' FACE='arial'>New Paintings</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
				"<A href='./EndToday'><STRONG><FONT COLOR='white' FACE='arial'>Closing Paitings</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  </A><A href='./LogoutServlet'><STRONG><FONT COLOR='white' FACE='arial'>Logout</STRONG></font>      </A>&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./help.jsp'><STRONG><FONT COLOR='white' FACE='arial'>About Us</STRONG> </A> </font></TBODY></TABLE></p><br><br>");
		
	Class.forName("com.mysql.jdbc.Driver");
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
	   //Statement stmt=con.createStatement();

		Statement st3=con.createStatement();
		Statement st=con.createStatement();
		String bidder=request.getParameter("bidder");
		String itid=request.getParameter("id");
		String pwd=request.getParameter("password");
		String amount=request.getParameter("cardno");
		
		
		
	//	if(amount.length()>0)
		//{
		//int amt=Integer.parseInt(amount);
		String id=request.getParameter("id");
		int hbid=Integer.parseInt(request.getParameter("hbid"));
		int min=Integer.parseInt(request.getParameter("min"));
		Cookie emailc=null;
		Cookie emailck[]=request.getCookies();
		if(emailck!=null)
		{
		System.out.println("cookie found");
		for(int i=0;i<emailck.length;i++){
			emailc=emailck[i];

		String email=emailc.getName();
		String email1=emailc.getValue();
		System.out.println("email\t"+email1+"tfghj"+email);
		}
		}
		String email1=emailck[0].getValue();
		System.out.println("email\t"+email1);
		if(email1.equals(bidder)==true)
		{
		ResultSet rs=st.executeQuery("select password from user where email='"+bidder+"' ");
		System.out.println("select password from user where email='"+bidder+"' ");
		
		
		
		if(rs.next())
		{
			ResultSet rs1=st3.executeQuery("select user_id from user where email='"+bidder+"' ");
			if(rs1.next()){
				int bidid=rs1.getInt(1);
			String dpwd=rs.getString(1);
			if(!pwd.equals(dpwd))
				out.println("<center><b>invalid Userid or   password</b></center><br><br><center><input type='button' value='Back' onclick='history.back()'");
			else 
			{
				try{
			
				int maxid=0;
                //DBS d=new DBS(1,amount); 
				Statement st2=con.createStatement();
				String str="select bamt from bidder where bidder_id="+bidid+" and painting_id="+itid+"";
				System.out.println(str);				
				ResultSet rss=st2.executeQuery(str);
				while(rss.next()){maxid=rss.getInt("bamt");}
				/*
				String str="select nvl(max(bamt),0) from bidding_info where itemid=1 and bidderid='"+bidder+"'";
				//System.out.println("update bidding_info set status=2 where bamt=("+str+")");
				ResultSet rss=st2.executeQuery(str);
				rss.next();*/				//int no=rss.getInt("bamt");
				System.out.println("\n update bidder set status=2 where bamt="+maxid+"");
				int i=st2.executeUpdate("update bidder set status=2 where bamt="+maxid+"");//select max(bamt) from bidding_info where itemid=1 and bidderid='"+bidder+"')");
				//System.out.println("update bidding_info set status=2 where bamt=("+rss.getInt("bamt")+")");
				if(i>0)
				{
		//ResultSet rs2=st2.executeQuery("select im.itemid,im.catid,im.itemname,im.startprice,im.enddate,im.seller,bi.bidderid,bi.bamt,cm.cat_name from item_master im,bidding_info bi,category_master cm where to_date(im.enddate)<= to_date(sysdate) and cm.catid=im.catid and bi.bidderid='"+bidder+"' and bi.status=2 and bi.itemid=1");
		/*out.println("<center><table border=3 bordercolor=green>");
		out.println("<thead><th>Item ID</th><Th>Cat. ID</th><Th>Item Name</th><Th>Category Name</th><Th>Start Price</th><Th>End Date</th>");
		out.println("<Th>Seller ID</th><Th>Bidder ID</th><Th>Bid Amount</th></thead>");*/
	/*	while(rs2.next())
		{
		String itemno=rs2.getString(1);
		String catid=rs2.getString(2);
		String itemname=rs2.getString(3);

        String sprice=rs2.getString(4); 
		java.sql.Date edate=rs2.getDate(5);
		String seller=rs2.getString(6);
		bidder=rs2.getString(7);
        String bamt=rs2.getString(8);
		String catname=rs2.getString(9);
		out.println("<tr><td>"+itemno+"</td>");
		out.println("<td>" + catid +"</td>");
		out.println("<td>" + itemname +"</td>");
		out.println("<td>" + catname +"</td>");
		out.println("<td>" + sprice +"</td>");
		out.println("<td>" + edate +"</td>");
		out.println("<td>" + seller +"</td>");
		out.println("<td>" + bidder +"</td>");
		out.println("<td align=center>" + bamt +"</td></tr>");
		}
		out.println("</table></center><br><br>");*/
				Statement stmt=con.createStatement();
						Statement stmt1=con.createStatement();
						//int i=stmt1.executeUpdate("insert into bidding_info values('"+bidder+"',"+amt+","+id+",sysdate) ");
						out.println("<center><b> Rs. "+hbid+" /- is Deducted from your Credit card.<br>Collect Your Item At the following Address</b><br<br></center>");
						rs=stmt.executeQuery("select firstname,lastname,address,city,state,phno,email from user where email='"+bidder+"'");
						System.out.println("select firstname,lastname,address,city,state,phno,email from user where email='"+bidder+"'");
						while(rs.next())
				        {%>
                            <center><br> <table><tr><th><u>Address</u></th></tr><tr><td><%=rs.getString(1)%> <%=rs.getString(2)%></td></tr>
							        <tr><td><%=rs.getString(3)%></td></tr>
									<tr><td><%=rs.getString(4)%></td></tr>
									<tr><td><%=rs.getString(5)%></td></tr>
									<tr><td><%=rs.getString(6)%></td></tr>
									<tr><td><%=rs.getString(7)%></td></tr>
									<!-- <tr><td><%//=rs.getString(8)%></td></tr>
									<tr><td><%//=rs.getString(9)%></td></tr>--></table>
									
				        <%}
				}}
			catch(Exception e){
					System.out.print("else try >>>>>----");
							e.printStackTrace();
							}
			}
								
		}
		}

		//}
		out.println("<br><input type='button' value='Print this page' onclick='print()'><br><br><CENTER><STRONG></STRONG>");
		//out.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
		//out.println("<A href=./EndToday>Closing Items</A>");
		//out.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
		//out.println("<STRONG></STRONG><A href=./home.html>Home</A>");
		}
		else{out.println("<br><b><strong><center>authentication failure</strong></center></b><br><br>");}
		}
		catch(Exception e){System.out.println("OT>>>>>");e.printStackTrace();}
		%>


</body>
</html>