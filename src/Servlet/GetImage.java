package Servlet;

import java.sql.*;

import java.util.*;

import javax.servlet.http.Cookie;

public class GetImage {

public Vector ImageList() throws SQLException
{
Vector vList=new Vector();

try
{
	
Connection con = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","tashu","123456");
Statement stmt=con.createStatement();
//String strSql="select Image_id,Image_name from upload_image";
//Cookie emailck[]=request.getCookies();
//String email=emailck[1].getValue();
String p="select painter_id from painter where email='trush@gm.com' ";
ResultSet rs1=stmt.executeQuery(p);
rs1.next();
int email=rs1.getInt("painter_id");
System.out.println("email"+email);

String strSql="select painting_id,image_name,description,type,startprice,incrementprice,dateofcreation,enddate from painting where painter_id="+email+"";
System.out.println("ImageList query–"+strSql);
ResultSet rs=stmt.executeQuery(strSql);

while(rs.next()){
String temp[]=new String[10];
//int temp1[]=new int[5];
temp[0]=rs.getString("painting_id");
temp[1]=rs.getString("image_name");
temp[2]=rs.getString("description");
temp[3]=rs.getString("type");
temp[4]=rs.getString("startprice");
temp[5]=rs.getString("incrementprice");
temp[6]=rs.getString("dateofcreation");
temp[7]=rs.getString("enddate");
vList.add(temp);
//vList.add(temp1);
}

}
catch(Exception e) {
System.err.print("ImageList Exception : "+e);
System.err.println("ImageList Exception : "+e.getMessage());
}

return vList;
}
}
