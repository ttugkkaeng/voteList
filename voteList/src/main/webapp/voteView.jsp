<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<h1>동물의 왕 뽑기</h1>
	
	
	<form action="voteResult" method="post">
		<input type="radio" name="selectNum"value="1"/>호랑이
		<input type="radio" name="selectNum" value="2"/>코끼리
		<input type="radio" name="selectNum" value="3"/>독수리
		<input type="submit" value="투표하기"/>
	</form>

</body>
</html>