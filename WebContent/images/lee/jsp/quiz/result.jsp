<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="jumsu">점수 : ${score}</div>
	<div>
		<div>-------------맞은 문제-------------- (맞은 갯수 :
			${fn:length(correctList)})</div>
		<c:forEach var="i" items="${correctList}">
			<div>${i.quizNo}${i.quizQue}.(${i.quizAnswer})</div>

			<div>
				<c:forEach var="x" items="${i.examples}">
					<img alt="" src="../images/quiz/${x.no}.gif"> ${x.example}
		</c:forEach>
			</div>
		</c:forEach>
	</div>
	
	<div>
		<div>-------------틀린 문제-------------- (틀린 갯수 :
			${fn:length(wrongList)})</div>
		<c:forEach var="i" items="${wrongList}">
			<div>${i.quizNo}.${i.quizQue}(${i.quizAnswer})</div>

			<div>
				<c:forEach var="x" items="${i.examples}">
					<img alt="" src="../images/quiz/${x.no}.gif"> ${x.example}
		</c:forEach>
			</div>
		</c:forEach>
	</div>
</body>
</html>