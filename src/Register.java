import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ResultSet rs;
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String fname=request.getParameter("fName");  
		String pass=request.getParameter("userPass");  
		String email=request.getParameter("userEmail");  
		String lname=request.getParameter("lName");
		String phno=request.getParameter("phno");
		          
		try{  
			
		
		Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","tashu","123456");  
		  
		PreparedStatement ps=con.prepareStatement("insert into painter (firstname,lastname,email,phone_no,password) values (?,?,?,?,?)");  
		  
		ps.setString(1,fname);  
		ps.setString(2,lname);  
		ps.setString(3,email);  
		ps.setString(4,phno);  
		ps.setString(5,pass);          
		PreparedStatement ps1=con.prepareStatement("select painter_no,password from painter where email = '"+email+"'");
	     int i=ps.executeUpdate();  
		if(i>0)
			
		{
        	//rs = ps1.executeQuery();
            //if (rs.next())
            
	//	out.print("You are successfully registered...\n your Username is "+email+"Password is :"+pass);
			out.print("<html><head><title>NETAuction</title></head>");
		out.print("<div id='d2' style='background-color:grey'><table cellspacing=10><tr><td><h1>NETAuction</h1></td></tr></table></div></div><div id='d1'><h2>Congratulations!!"+fname+" You Are Successfully Registered</h2><br><h3>Your Username  :&nbsp&nbsp&nbsp&nbsp&nbsp"+email+"<br>Password&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :&nbsp&nbsp&nbsp&nbsp"+pass+"</h3>");
		out.print("Click &nbsp&nbsp<a href='painterlogin.jsp'>LOGIN</a>");
		out.print("</div></body></html>");
        }
        else
        {
        	request.getRequestDispatcher("painterregister.html").include(request, response);
    		out.println("<font color=red>Either user name or password is wrong.</font>");
        }
			
		          
		 }catch (Exception e2) {System.out.println(e2);System.out.println(lname);}  
		          
		out.close();
	}

}
