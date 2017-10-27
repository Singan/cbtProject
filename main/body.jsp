<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<a href="${pageContext.request.contextPath}/test/object">시작하기</a>
<c:choose>
	<c:when test="${empty user}">
		<c:import url="/include/login/login.jsp" />
	</c:when>
	<c:otherwise>
		<li><a href="${pageContext.request.contextPath}/login/logout">로그아웃</a></li>
	</c:otherwise>
</c:choose>