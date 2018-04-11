package Servlet;

import java.io.IOException;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NowToday
 */
public class Getpainterinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PrintWriter pw;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getpainterinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
			res.setContentType("text/html");
			pw=res.getWriter();
	pw.println("<BODY bgColor=#a3d881 leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
	pw.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=781 border=0><TBODY><BR><TR><TD><A href='./home.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HOME</STRONG></A> </TD>      <TD>  <A href='./login.jsp'><STRONG> <FONT COLOR='BROWN' FACE='CURLZ MT'>LOGIN</STRONG>  </A></TD>      <TD>    <A href='./registration.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>REGISTER</STRONG></A></TD>    <TD> <A href='./sell.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>SELL</STRONG>      </A></TD>  <TD> <A href='./ForSale.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>CURRENT BID ITEMS</STRONG>      </A></TD> <TD> <A href='./help.jsp'><STRONG><FONT COLOR='BROWN' FACE='CURLZ MT'>HELP</STRONG> </A></TD></TR><TD></TD>  </TBODY></TABLE></p><br><br>");
			//pw.println("<DIV id=Layer1 style='Z-INDEX: 1; LEFT: 410px; WIDTH: 328px; POSITION: absolute; TOP: 65px; HEIGHT: 35px'>");
			pw.println("<p align=right><FORM name=form1 action='./SearchServlet'  method=post >Search:<INPUT name=sstring> ");
			pw.println("<SELECT  name=category > <option >Choose Category</option>");
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction", "tashu", "123456");
			    Statement st=conn.createStatement();
				ResultSet rs=st.executeQuery("select type from painting");
			while(rs.next()){
			pw.println("<OPTION>"+rs.getString(1)+"</OPTION>");}
			}
			catch(Exception e){}
			pw.println("</SELECT> <INPUT type=submit value=Go > ");
			pw.println("</FORM></p><!-- End ImageReady Slices -->");
			

			pw.println("<h2><center>New ITems</h2><br>");
			Statement st2=con.createStatement();
			ResultSet rs2=st2.executeQuery("select painting_id,description,startprice,bcnt,enddate from painting where dateofcreation>curdate()-2");
			pw.println("<center><table border=3 bordercolor=green>");
			pw.println("<thead><th>Item<Th>Description<Th>Current Price");
			pw.println("<Th>Number Of Bids<Th>Auction Ending Date</thead>");
			while(rs2.next())
			{
			String itemno=rs2.getString(1);
			String desp=rs2.getString(2);
			int cp=rs2.getInt(3);
			java.sql.Date edate=rs2.getDate(5);
			int nob=rs2.getInt(4);
			pw.println("<tr><td><a href='./ItemDetails?id="+itemno+"' >"+itemno+"</a></td>");
			pw.println("<td>" + desp +"</td>");
			pw.println("<td>" + cp +"</td>");
			pw.println("<td>" + nob +"</td>");
			pw.println("<td align=center>" + edate +"</td></tr>");
			}
			pw.println("</table></center><br><br>");

			pw.println("<CENTER><STRONG></STRONG>");
			pw.println("<A href=./NewToday>New Items</A><STRONG></STRONG>");
			pw.println("<A href=./EndToday>Closing Items</A>");
			pw.println("<STRONG></STRONG><A href=./sell.jsp>Sell Items</A>");
			pw.println("<STRONG></STRONG><A href=./home.jsp>Home/Search</A>");

		}catch(Exception e) { e.printStackTrace(); }

	}

}
