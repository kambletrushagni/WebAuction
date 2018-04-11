<%@ page import="java.sql.*"%>
<html>
<script language="javascript">
function luhnCheck() {
	
	var cardNumber=document.buy.cardno.value;

                if (isLuhnNum(cardNumber)) {
                    var no_digit = cardNumber.length;
					var oddoeven = no_digit & 1;
					var sum = 0;
                    for (var count = 0; count < no_digit; count++) {
                        var digit = parseInt(cardNumber.charAt(count));
                        if (!((count & 1) ^ oddoeven)) {
                            digit *= 2;
                            if (digit > 9) digit = 9;
                        };
                        sum += digit;
						
                    };
                    if (sum == 0) return false;
                    if (sum % 10 == 0) return true;
                };
				alert("Enter Valid Credit card Number");
                return false;
            }

            function isLuhnNum(argvalue) {
                argvalue = argvalue.toString();
                if (argvalue.length == 0) {
                    return false;
                }
                for (var n = 0; n < argvalue.length; n++) {
                    if ((argvalue.substring(n, n+1) < "0") ||
                        (argvalue.substring(n,n+1) > "9")) {
                        return false;
                    }
                }
                return true;
            }
</script>
<BODY bgColor=pink leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0>
<%
   String theuser=request.getParameter("user");
%><%
   try
	{
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
	   Statement stmt=con.createStatement();
	   out.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=100% border=0 ><TBODY bgcolor=grey height=30% ><BR><FONT COLOR='white' FACE='arial'><strong><b>NETAuction</b></strong></font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
				"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./home.html'><STRONG><FONT COLOR='white' FACE='arial'>Home</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./NewToday'><STRONG><FONT COLOR='white' FACE='arial'>New Paintings</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
				"<A href='./EndToday'><STRONG><FONT COLOR='white' FACE='arial'>Closing Paitings</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  </A><A href='./LogoutServlet'><STRONG><FONT COLOR='white' FACE='arial'>Logout</STRONG></font>      </A>&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./help.jsp'><STRONG><FONT COLOR='white' FACE='arial'>About Us</STRONG> </A> </font></TBODY></TABLE></p><br><br>");
		out.println("<h2><center>Painting Details</h2>");
		//out.println("<h2><center>Item Wise Details</h2>");

		//String itid =request.getParameter("id");
		//int itid=104;
		int itid =Integer.parseInt(request.getParameter("painting"));
		
		System.out.println(itid);
		
		Statement stt=con.createStatement();
		ResultSet rss=stt.executeQuery("select type from painting where painting_id=104");
		rss.next(); 
		String iname=rss.getString(1);
		out.println("<center><font size=+2 face=Arial ><u>"+iname+"</u></font></center><br>");
		Statement st1 = con.createStatement();
		ResultSet rs1 = st1.executeQuery("select bidder_id,bamt from bidder where bamt=(select max(bamt) from bidder where painting_id="+itid+" and status=1)"); 
		System.out.println("select bidder_id,bamt from bidder where bamt=(select max(bamt) from bidder where painting_id="+itid+" and status=1");
		String bid="No Bidder Till now";
		int bamt=0;
		if(rs1.next()){
		 bid = rs1.getString(1);
		bamt = rs1.getInt(2);	
		}
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from painting where painting_id="+itid+"");
		out.println("<center><table border=2>");
		int sp=0;
		int minincr=0;
		int seller=0;
		while(rs.next())
		{
			String desp=rs.getString("description");
			sp=rs.getInt("startprice");
			minincr=rs.getInt("incrementprice");
			java.sql.Date stdate=rs.getDate("dateofcreation");
			java.sql.Date edate=rs.getDate("enddate");
			seller=rs.getInt("painter_id");
			int nob=rs.getInt("bcnt");
			//if (bamt==0)
				//bamt=Integer.parseInt(sp);
			out.println("<TR><TD>Start Price</TD><td>" + sp +"</td></tr>");
			out.println("<TR><TD>MinimunIncrement</TD><td>" + minincr +"</td></tr>");
			out.println("<TR><TD>Number Of Bids</TD><td>" + nob +"</td></tr>");
			out.println("<TR><TD>Auction Start Date</TD><td>" + stdate +"</td></tr>");
			out.println("<TR><TD>Auction Ending Date</TD><td>" + edate +"</td></tr>");
			out.println("<TR><TD>Seller</TD><td>" + seller +"</td></tr>");
			out.println("<TR><TD>High Bidder</TD><td>" + bid +"</td></tr>");
			out.println("<tr><td>Current Bid Price</td><td>"+bamt+"</td></tr>");
			out.println("<TR><TD>Description</TD><td>" + desp +"</td></tr>");
		}

		out.println("</table><center>");
		out.println("<P><STRONG>Do you want to buy this item?</STRONG>");
		out.println("<form action='./BuyServlet.jsp?id="+itid+"' name='buy' onsubmit='return luhnCheck()' method='post'> ");
		out.println("<input type=hidden name=id value="+itid);//+request.getParameter("id"));
		out.println("><input type=hidden name=hbid value="+bamt);
		out.println("><input type=hidden name=seller value="+seller);
		out.println("><input type=hidden name=min value="+minincr);
		out.println("><TABLE><TR><TD>Enter your user id:</TD><TD><INPUT TYPE=\"TEXT\" SIZE=20 NAME=\"bidder\"></TD></TR>");
		out.println("<TR><TD>Enter your password:</TD><TD><INPUT TYPE=PASSWORD SIZE=20 NAME=password></TD>");
		//out.println("</TR><TR><TD>Enter your BID PRICE:</TD><TD><INPUT TYPE=\"TEXT\" SIZE=60 NAME=\"bidamt\"  onBlur=f()></TD></TR></TABLE><br><br><input type=submit value=\"Buy this Item\">&nbsp;&nbsp;<input type=button value=\"Decline\" onclick=javascript:location.href='./ChangeBidder.jsp?theuser="+theuser+"&bamt="+bamt+"&itemid=1'></form>");
		out.println("</TR><TR><TD>Enter your credit Card No:</TD><TD><INPUT TYPE=\"TEXT\" SIZE=60 NAME=\"cardno\"  onBlur=f()></TD></TR></TABLE><br><br><input type=submit value=\"Buy this Item\">&nbsp;&nbsp;<input type=button value=\"Decline\" onclick=javascript:location.href='./ChangeBidder.jsp?theuser="+theuser+"&bamt="+bamt+"&itemid="+itid+"'></form>");

		out.println("<CENTER><STRONG></STRONG>");
		out.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
		out.println("<A href=./EndToday>Closing Items</A>");
		//out.println("<STRONG></STRONG><A hre0f=./sell.jsp>Sell Items</A>");
		out.println("<STRONG></STRONG><A href=./home.html>Home</A>");

		}catch(Exception e){System.out.println("bid item");e.printStackTrace();}
%>