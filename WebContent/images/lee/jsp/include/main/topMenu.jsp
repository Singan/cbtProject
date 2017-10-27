<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
	#top{
		width : 100%;
		height : 100px;
	}
</style>
<div id="top">
<c:if test="${not empty sessionScope.user.admin}">
<a href="${pageContext.request.contextPath}/manage">관리 메뉴</a>
</c:if>
</div>