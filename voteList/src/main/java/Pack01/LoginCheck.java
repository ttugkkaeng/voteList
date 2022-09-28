package Pack01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginCheck {

	private String id;
	private String pw;
	private String dbpw;
	private String redirectView;
	private String alertstr;
	
	public LoginCheck(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	void LoginValidCheck() {
		
		 System.out.println(id);
		final String driver = "org.mariadb.jdbc.Driver";
	      final String DB_IP = "18.183.36.185";
	      final String DB_PORT = "13306";
	      final String DB_NAME = "db01";
	      final String DB_URL = 
	            "jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         Class.forName(driver);
	         conn = DriverManager.getConnection(DB_URL, "root", "1234");
	         if (conn != null) {
	            System.out.println("DB 접속 성공");
	         }

	      } catch (ClassNotFoundException e) {
	         System.out.println("드라이버 로드 실패");
	         e.printStackTrace();
	      } catch (SQLException e) {
	         System.out.println("DB 접속 실패");
	         e.printStackTrace();
	      }

	      try {
	         String sql = "select * from voteList where id="+id+"";

	         pstmt = conn.prepareStatement(sql);

	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	            dbpw = rs.getString("pwd");
	         }
	         System.out.println(dbpw);

					if (pw.equals(dbpw)) {
						setRedirectView("/register/voteView");
					}else{
						setRedirectView("redirect:/");
						setAlertstr("<script>alert(\"로그인 정보가 다릅니다.\");</script>");
					}
					System.out.println(getRedirectView());
	         	
	        
	      } catch (SQLException e) {
	         System.out.println("error: " + e);
	      } finally {
	         try {
	            if (rs != null) {
	               rs.close();
	            }
	            if (pstmt != null) {
	               pstmt.close();
	            }

	            if (conn != null && !conn.isClosed()) {
	               conn.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }

	   }

	}
	public String getRedirectView() {
		return redirectView;
	}
	public void setRedirectView(String redirectView) {
		this.redirectView = redirectView;
	}
	public String getAlertstr() {
		return alertstr;
	}
	public void setAlertstr(String alertstr) {
		this.alertstr = alertstr;
	}
	
	

	
}
