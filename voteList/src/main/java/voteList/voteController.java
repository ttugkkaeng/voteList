package voteList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class voteController {

	   Connection con; // 멤버변수
	   Statement stmt;
	   ResultSet rs;

	   void getConnection() {
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String userid = "root"; //c##추가
	      String pwd = "1234"; //c##추가
	      
	      try 
	      {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         System.out.println("드라이버 로드 성공");
	      }
	      catch (ClassNotFoundException e) 
	      {
	         e.printStackTrace();
	      }
	      
	      try 
	      {
	         System.out.println("데이터베이스 연결 준비 .....");
	         con = DriverManager.getConnection(url,userid,pwd);
	         System.out.println("데이터베이스 연결 성공");
	      }
	      catch (SQLException e) 
	      {
	         e.printStackTrace();
	      }
	   }

	   void selectNum()
	   { 
	      String query = "SELECT * FROM voteList WHERE selectNum = null";
	      try 
	      {
	         stmt = con.createStatement(); //2
	         rs = stmt.executeQuery(query); //3
	         System.out.println("CUSTID \tNAME \tADDRESS \tPHONE");
	      
	         con.close();
	      }
	      catch (SQLException e) 
	      {
	         e.printStackTrace();
	      }
	   }
}
