<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"
	uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>시험 추가</title>
		<link rel=stylesheet type="text/css" href="${pageContext.request.contextPath}/css/manage.css" />
	</head>
	<body>
		<div class="body">
			<h2>시험 추가 메뉴임</h2>
			<form action="${pageContext.request.contextPath}/manage/inserttest" method="post">
				<input name="groupCode" type="hidden" 
					<c:choose>
						<c:when test="${empty subgroup}">
							value="0"
						</c:when>
						<c:when test="${empty turngroup}">
							value="${subgroup}"
						</c:when>
						<c:otherwise>
							value="${turngroup}"
						</c:otherwise>
					</c:choose>
				>
				<table>
					<tbody>
						<tr>
							<th scope="row"><div>이름</div></th>
							<td><input name="testName" type="text" required
							oninvalid="setCustomValidity('입력하라우')"
							oninput="setCustomValidity('')"><td>
						</tr>
						<c:if test="${not empty turngroup}">
							<tr>
								<th scope="row"><div>시험일자</div></th>
								<td><input name="testDate" type="date" required
								oninvalid="setCustomValidity('선택하라우')"
								oninput="setCustomValidity('')"><td>
							</tr>
						</c:if>
					</tbody>
				</table>
				<div><button>추가</button></div>
			</form>
		</div>
	</body>
</html>