<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#body{
		float: left;
		position: static;
		margin-left: 400px;
		margin-right: 100px;
	}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css">
<p align="center"><b><font size="6" color="black">미니 프로젝트</font><font size="6" color="blue"> 메인 화면<br></font></b></p>

<div id="body">
<p align="center"><a style='cursor:pointer' onfocus="this.blur()"  onclick="javascript:window.open('${pageContext.request.contextPath}/jsp/include/test/testmain.jsp', 'newwingscom', 'left=0, top=0, width=1024, height=680, scrollbars=yes, toolbar=no, menubar=no, location=no, status=yes, resizable=yes')"><img src="/cbtProj/image/1.jpg"  onmouseover="this.src='/cbtProj/image/2.jpg'" onmouseout="this.src='/cbtProj/image/1.jpg'" border="0" height="200px"><br></a>
<p1>위 사진을 눌러 시험 시작</p1>
</div>
<c:choose>
	<c:when test="${empty user}">
		<c:import url="/jsp/include/login/login.jsp" />
	</c:when>
	<c:otherwise>
		<c:import url="/jsp/include/login/profile.jsp"></c:import>
	</c:otherwise>
</c:choose>

