package Servlet;

import java.io.*;


import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class InsertImage
*/
public class InsertImage extends HttpServlet {

/**
*
*/
private static final long serialVersionUID = -337920480578240289L;
ResultSet rs;

/**
* Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");

try
{/*String email1="";
	Cookie emailc=null;
	Cookie emailck[]=request.getCookies();
	if(emailck!=null)
	{
	System.out.println("cookie found");
	for(int i=0;i<emailck.length;i++){
		emailc=emailck[1];

	String email2=emailc.getName();
 email1=emailc.getValue();
	System.out.println("email\t"+email1);
	
*/
	
	Cookie ck[]=request.getCookies();  
	 System.out.print("<br>hi!"+ck[0].getValue());//printing name and value of cookie 
	String s=ck[0].getValue();

	String user=request.getParameter("userp");	
String strpath=request.getParameter("Image");
String type=request.getParameter("type");
String desc=request.getParameter("description");
int price=Integer.parseInt(request.getParameter("stp"));
int incrprice=Integer.parseInt(request.getParameter("intp"));
int acDays=Integer.parseInt(request.getParameter("dur"));

String filepath=strpath.substring(strpath.lastIndexOf("\\")+1);
File imgfile = new File(strpath);
FileInputStream fin = new FileInputStream(imgfile);
Connection con = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","tashu","123456");
Statement stmt=con.createStatement();
java.util.Date date=new java.util.Date();
java.sql.Date sqldate=new java.sql.Date(date.getTime());
//PreparedStatement pre = con.prepareStatement("insert into upload_image(image,image_name,image_length) values(?,?,?)");
//Cookie emailck[]=request.getCookies();  
//out.print("hi"+ck[0].getValue());//printing name and value of cookie 

String p="select painter_id from painter where email='"+s+"'";
System.out.println(p);
	
rs=stmt.executeQuery(p);
rs.next();
String email=rs.getString("painter_id");
System.out.println("\n"+p+"\n"+email);
PreparedStatement pre = con.prepareStatement("insert into painting(image,image_name,description,type,startprice,painter_id,incrementprice,dateofcreation,enddate,bcnt) values(?,?,?,?,?,?,?,curdate(),curdate()+"+acDays+",0)");
pre.setBinaryStream(1,fin,(int)imgfile.length());
pre.setString(2,filepath);
//pre.setLong(3,imgfile.length());
pre.setString(3,desc);
pre.setString(4,type);
pre.setInt(5,price);
pre.setString(6,email);
pre.setInt(7,incrprice);
//pre.setDate(8,sqldate);
//pre.setInt(9,sqldate);


//System.out.println("query............"+pre.executeUpdate());
//Connection con1 = getConnection();
/*Statement st1=con.createStatement();
String squery = "insert into painting(dateofcreation,enddate,painter_id) values(curdate(),curdate()+"+acDays+",'"+email+"') ";
System.out.println("----" +squery+ " -------");
int i=st1.executeUpdate(squery);
*/pre.executeUpdate();
pre.close();

String L_url1=response.encodeRedirectURL("showimage.jsp?painter_id="+email);
response.sendRedirect(L_url1);
	

		}
catch(Exception ex){
System.out.println("Exception in InsertImage servlet"+ex.getMessage());
}
	
}

// <editor-fold defaultstate=”collapsed” desc=”HttpServlet methods. Click on the + sign on the left to edit the code.”>
/**
* Handles the HTTP <code>GET</code> method.
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

/**
* Handles the HTTP <code>POST</code> method.
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
processRequest(request, response);
}

/**
* Returns a short description of the servlet.
* @return a String containing servlet description
*/

public String getServletInfo() {
return "Short description";
}// </editor-fold>

}
