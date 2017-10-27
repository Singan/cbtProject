<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>관리 메뉴</title>
	</head>
	<body>
		<div>
			<h2>관리 메뉴 메인임</h2>
			<a href="${pageContext.request.contextPath}/main/main">집으로</a><br>
			<a href="${pageContext.request.contextPath}/manage/managemember">회원 관리</a><br>
			<a href="${pageContext.request.contextPath}/manage/managetest">문제 관리</a>
		</div>
	</body>
</html>