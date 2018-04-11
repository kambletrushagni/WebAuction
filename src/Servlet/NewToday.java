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
public class NewToday extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PrintWriter pw;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewToday() {
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
	pw.println("<BODY bgColor=pink leftMargin=0 topMargin=0 MARGINHEIGHT=0 MARGINWIDTH=0><!-- ImageReady Slices (Untitled-1) -->");
	pw.println("<p align=right><TABLE cellSpacing=0 cellPadding=0 width=100% border=0 ><TBODY bgcolor=grey height=30%><BR><FONT COLOR='white' FACE='arial'><strong><b>NETAuction</b></strong></font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
			"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./EndToday'><STRONG><FONT COLOR='white' FACE='arial'>Closing Paintings</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp" +
			"<A href='./home.html'><STRONG><FONT COLOR='white' FACE='arial'>HOME</STRONG></A>  </font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  </A><A href='./LogoutServlet'><STRONG><FONT COLOR='white' FACE='arial'>Logout</STRONG></font>      </A>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<A href='./help.jsp'><STRONG><FONT COLOR='white' FACE='arial'>About Us</STRONG> </A> </font></TBODY></TABLE></p><br><br>");
			

			pw.println("<h2><center>New Paintings</h2><br>");
			Statement st2=con.createStatement();
			ResultSet rs2=st2.executeQuery("select painting_id,description,startprice,bcnt,enddate from painting where dateofcreation>curdate()-2");
			pw.println("<center><table border=5 width=50% cellspacing=3 cellpadding=2 bordercolor=black>");
			pw.println("<thead><th>Item<Th>Description<Th>Current Price");
			pw.println("<Th>Number Of Bids<Th>Auction Ending Date</thead>");
			while(rs2.next())
			{
			String itemno=rs2.getString(1);
			String desp=rs2.getString(2);
			int cp=rs2.getInt(3);
			java.sql.Date edate=rs2.getDate(5);
			int nob=rs2.getInt(4);
			pw.println("<tr><td><a href='./ItemDetails?painting="+itemno+"' >"+itemno+"</a></td>");
			pw.println("<td>" + desp +"</td>");
			pw.println("<td>" + cp +"</td>");
			pw.println("<td>" + nob +"</td>");
			pw.println("<td align=center>" + edate +"</td></tr>");
			}
			pw.println("</table></center><br><br>");

		}catch(Exception e) { e.printStackTrace(); }

	}

}
