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
	
	<h1>������ �� �̱�</h1>
	
	
	<form action="voteResult" method="post">
		<input type="radio" name="selectNum"value="1"/>ȣ����
		<input type="radio" name="selectNum" value="2"/>�ڳ���
		<input type="radio" name="selectNum" value="3"/>������
		<input type="submit" value="��ǥ�ϱ�"/>
	</form>

</body>
</html>