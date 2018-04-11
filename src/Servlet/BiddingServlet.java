package Servlet;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.rmi.*;
import javax.naming.*;
import java.util.*;

public class BiddingServlet extends HttpServlet 
{
	//Connection con;
	PrintWriter pw;
 
/*	public void init(ServletConfig sc) throws ServletException
	{
	try
	{
		super.init(sc);
		
		Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "tashu", "123456");
	}catch(Exception ce) { ce.printStackTrace();}
	}*/
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		java.util.Date date=new java.util.Date();
		java.sql.Date sqldate=new java.sql.Date(date.getTime());

		res.setContentType("text/html");
		pw=res.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
	    pw.println("<BODY bgColor=pink leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
		pw.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=100% border=0 ><TBODY bgcolor=grey height=30%><BR><FONT COLOR='white' FACE='arial'><strong><b>NETAuction</b></strong></font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
				"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
				"<A href='./home.html'><STRONG><FONT COLOR='white' FACE='arial'>HOME</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  </A><A href='./LogoutServlet'><STRONG><FONT COLOR='white' FACE='arial'>Logout</STRONG></font>      </A>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./help.jsp'><STRONG><FONT COLOR='white' FACE='arial'>About Us</STRONG> </A> </font></TBODY></TABLE></p><br><br>");

		//pw.println("<DIV id=Layer1 style='Z-INDEX: 1; LEFT: 410px; WIDTH: 328px; POSITION: absolute; TOP: 65px; HEIGHT: 35px'>");
			
	//	pw.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD>  <TD> <A href='./ForSale.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>CURRENT BID ITEMS</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
		//pw.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
		//pw.println("<SELECT  name=category > <option >Choose Category</option>");
		/*try
		{
		Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select cat_name from category_master");
		while(rs.next()){
		pw.println("<OPTION>"+rs.getString(1)+"</OPTION>");}
		}
		catch(Exception e){}
		pw.println("</SELECT> <INPUT type=submit value=Go > ");
		pw.println("</FORM></p><!-- End ImageReady Slices -->");
		*/Statement st=con.createStatement();
		String bidder=req.getParameter("bidder");
		String pwd=req.getParameter("password");
		String amount=req.getParameter("amount");
		Cookie emailc=null;
		Cookie emailck[]=req.getCookies();
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
		if(amount.length()>0)
		{
		int amt=Integer.parseInt(amount);
		String id=req.getParameter("id");
		int hbid=Integer.parseInt(req.getParameter("hbid"));
		int min=Integer.parseInt(req.getParameter("min"));
		ResultSet rs=st.executeQuery("select password,user_id from user where email='"+bidder+"' ");
		if(rs.next())
		{
			String dpwd=rs.getString(1);
			int uid=rs.getInt(2);
			System.out.println("userid>>"+uid);
			if(!pwd.equals(dpwd))
			{
				JFrame parent = new JFrame();
	        	JOptionPane.showMessageDialog(parent, "invalid credentials");
			req.getRequestDispatcher("./ItemDetails").include(req, res);
				//pw.println("<center><b>in valid password</b></center><br><br>");
			
			}
				else if(amt>=(hbid+min))
			{
				Statement stmt=con.createStatement();
				
                ResultSet rst=stmt.executeQuery("select enddate from painting where painting_id="+id); 
				if(rst.next())
				{
					java.sql.Date stdate=rst.getDate("enddate");
					java.util.StringTokenizer stok=new java.util.StringTokenizer(sqldate.toString(),"-");
					StringTokenizer token=new StringTokenizer(sqldate.toString(),"-");
					int year=Integer.parseInt(token.nextToken());
					int month=Integer.parseInt(token.nextToken());
					int day=Integer.parseInt(token.nextToken());
					
					java.util.StringTokenizer stok1=new java.util.StringTokenizer(stdate.toString(),"-");
					StringTokenizer token1=new StringTokenizer(stdate.toString(),"-");
					int year1=Integer.parseInt(token1.nextToken());
					int month1=Integer.parseInt(token1.nextToken());
					int day1=Integer.parseInt(token1.nextToken());
					
				int dif=rst.getInt("enddate");
				System.out.println("date>>>"+day+"std"+day1+"stdate"+stdate+"sqldate"+sqldate+"functi"+stdate.before(sqldate)+"funcaft"+stdate.after(sqldate));
					if(stdate.before(sqldate)==true)
					{   int sub=day-day1;
						 pw.println("<center><b>auction is closed a "+(-1)*sub+" day(s) before</b><br<br></center>");
					}
				/*if((year >= year1))
				{
					if((month >= month1))
					{
						System.out.println("day==="+day+"==day1==="+day1);
						if((day >= day1))
						{*/
						else{
						Statement stmt1=con.createStatement();
						int i=stmt1.executeUpdate("Update bidder set status=0 where painting_id="+id+" and status!=2");
					    i=stmt1.executeUpdate("insert into bidder values('"+uid+"',"+amt+","+id+",curdate(),1) ");
						    
						Statement stm1=con.createStatement();
						stm1.executeUpdate("update painting set bcnt=bcnt+1 where painting_id="+id);
						pw.println("<strong><center><b>congratulations u have sucessfully bid for the item</b><br<br></center></strong>");
						}
						/*else
						{
							pw.println("<center><b>auction is closed a "+(day1-day)+" day before</b><br<br></center>");
						}
					}
					else
					{
						pw.println("<center><b>auction closed a "+(month1-month)+" month before</b><br<br></center>");
					}*/
				}
				/*else
				{
					pw.println("<center><b>auction closed a "+(year1-year)+" year before</b><br<br></center>");
				}*/
			}
			else
			{
				pw.println("<strong><center><b>bid more than current value + mininmum increament</b><br<br></center></strong>");	
			}
		}
		else
		{
			pw.println("<strong><center><b>User Name doesnot exist</b></center><br<br></strong>");
		}
		}
		else
		{
			pw.println("<strong><br><center>specify the bid amount</center></strong>");
		}
		}else{pw.println("<br><b><strong><center>authentication failure</strong></center></b><br><br>");}
	}catch(NumberFormatException ne) { pw.println("<br><b><center>enter a numeric value</center></b><br><br>");
	}catch(Exception e) { e.printStackTrace(); }
		
		pw.println("<br><br><br><CENTER><STRONG></STRONG>");
		pw.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
		pw.println("<A href=./EndToday>Closing Items</A>");
		pw.println("<a href= './LogoutServlet'>Logout</a>");
		pw.println("<STRONG></STRONG><A href=./home.jsp>Home</A>");

	}
}