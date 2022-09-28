package voteList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RequestMapping("/voteResult")
public class voteResult{
	
	String selectNum = request.getParameter("selectNum");
	
	
	try{	

		String sql = "update voteList set selectNum=? where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, selectNum);
		pstmt.setString(2, id);
		rs = pstmt.executeQuery(); 	
		
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("loginView.jsp"); //잘못되면 로그인 페이지로 
	}finally{
		try{
			if(conn != null) conn.close();
			if(pstmt != null)pstmt.close();
			if(rs != null)rs.close();			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
	
	
}