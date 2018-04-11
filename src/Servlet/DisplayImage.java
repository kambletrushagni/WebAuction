package Servlet;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayImage
 */
public class DisplayImage extends HttpServlet {
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
        private static final long serialVersionUID = 4593558495041379082L;

        public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
        {
        ResultSet rs,rs1;
        InputStream sImage;

        try{

        //String id =request.getParameter("image_id");
        String id =request.getParameter("painting_id");
        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","tashu","123456");
        Statement stmt=con.createStatement();
        //String strSql="select IMAGE from upload_image where image_id='"+id+"'";
        Cookie emailck[]=request.getCookies();
        String email=emailck[0].getValue();
        String strSql1="select painter_id from painter where email='"+email+"'";
        System.out.println("inside servlet Sql–>"+strSql1);
        rs1=stmt.executeQuery(strSql1);
        if(rs1.next()){
        	int no=rs1.getInt(1);
        
        String strSql="select image from painting where painting_id="+id+" and painter_id="+no+"";
        System.out.println("inside servlet Sql–>"+strSql+"id->"+id+"---------"+email);
        rs=stmt.executeQuery(strSql);
        if(rs.next()) {
        byte[] bytearray = new byte[1048576];
        int size=0;
        sImage = rs.getBinaryStream(1);
        response.reset();
        response.setContentType("image/jpeg");
        while((size=sImage.read(bytearray))!= -1 ){
        response.getOutputStream().
        write(bytearray,0,size);
        }
        }}

        } catch (Exception e){
        e.printStackTrace();
        }
        }

        // TODO Auto-generated constructor stub
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
