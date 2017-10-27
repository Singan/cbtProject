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
		<title>과목 관리</title>
	</head>
	<body>
		<div>
			<h2>과목 관리 메뉴임</h2>
			<a href="${pageContext.request.contextPath}/manage/managetest?
			subject=${subgroup}&turn=${turngroup}">돌아가라</a>
			
			<div style="overflow-y: scroll; width: 50%; height: 200px;">
				<c:forEach var="sub" items="${sublist}" varStatus="loop">
					<div>
						<a>${sub.quizSub} ( ${sub.quizNo}문제 )</a>
						
						<a href="${pageContext.request.contextPath}/manage/managequiz?
						testcode=${testcode}&subject=${subgroup}&
						turn=${turngroup}&quizsub=${sub.quizSub}">문제목록</a>
						
						<c:if test="${loop.last}">
							<a href="${pageContext.request.contextPath}/manage/deletesub?
							testcode=${testcode}&quizsub=${sub.quizSub}&
							subject=${subgroup}&turn=${turngroup}">삭제</a>
						</c:if>
						<!-- quizSub를 직접 보내지 않고 삭제하도록 바꿀 필요가 있음-->
					</div>
				</c:forEach>
			</div>
			
			<a href="${pageContext.request.contextPath}/manage/insertsubform?
			subject=${subgroup}&turn=${turngroup}&testcode=${testcode}"
			>과목 추가</a>
		</div>
	</body>
</html>