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
		<title>문제 관리</title>
	</head>
	<body>
		<div>
			<h2>문제 관리 메뉴임</h2>
			<a href="${pageContext.request.contextPath}/manage/managesub?
			subject=${subgroup}&turn=${turngroup}&testcode=${testcode}">돌아가라</a>
			
			<div style="overflow: scroll; height: 500px;">
				<div>
				</div>
				<c:forEach var="quiz" items="${quizlist}" varStatus="loop">
					<form action="${pageContext.request.contextPath}/manage/modifyquiz" method="post">
						<div id="${quiz.quizNo}">
							<a>${quiz.quizNo}번</a>
							<input name="quizquestion" type="text" value="${quiz.quizQuestion}">
							<input name="example1" type="text" value="${quiz.example1}">
							<input name="example2" type="text" value="${quiz.example2}">
							<input name="example3" type="text" value="${quiz.example3}">
							<input name="example4" type="text" value="${quiz.example4}">
							<input name="example5" type="text" value="${quiz.example5}">
							
							<input name="quizanswer" type="text" value="${quiz.quizAnswer}">
							<input name="quizscore" type="text" value="${quiz.quizScore}">
							
							<input name="testcode" type="hidden" value="${quiz.testCode}">
							<input name="quizcode" type="hidden" value="${quiz.quizCode}">
							
							<input name="subject" type="hidden" value="${subgroup}">
							<input name="turn" type="hidden" value="${turngroup}">
							<input name="quizsub" type="hidden" value="${quiz.quizSub}">
							<input name="quizno" type="hidden" value="${quiz.quizNo}">
							<button>수정</button>
						</div>
					</form>
				</c:forEach>
			</div>
		</div>
	</body>
</html>