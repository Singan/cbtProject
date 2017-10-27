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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/result.css">
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>

	<div class="page-header">
		<h1>
			<p>점수: ${score}</p>
			<small><c:forEach var="i" items="${subList}">
			과목:${i}<br>
				</c:forEach></small>
		</h1>
	</div>
	<div>

		<span class="label label-primary">-------------맞은
			문제-------------- (맞은 갯수 : ${fn:length(correctList)})</span>


	</div>

	<ul class="list-group">
		<c:forEach var="i" items="${correctList}">
			<li class="list-group-item">
				<div>
					<p class="sub">과목:${i.quizSub}</p>
					<p class="que">${i.quizNo}.${i.quizQue}
					</p><p class="answer">체크한 답:(${i.quizAnswer})</p>
				</div>

				<div>
					
					 <c:forEach items="${i.examples}" var="z" varStatus="x">
						<c:if test="${i.quizAnswer eq x.count}">
							<img src="../images/quiz/${x.count}red.gif">
						</c:if>
						<c:if test="${i.quizAnswer ne x.count}">
							<img src="../images/quiz/${x.count}.gif">
						</c:if>
						${z.example}
					</c:forEach> 
				</div>
			</li>
		</c:forEach>
	</ul>
	<div>

		<span class="label label-primary">-------------틀린
			문제-------------- (틀린 갯수 : ${fn:length(wrongList)})</span>


	</div>

	<ul class="list-group">
		<c:forEach var="i" items="${wrongList}" varStatus="z">
			<li class="list-group-item">
				<div>
					<p class="sub">과목:${i.quizSub}</p>
					<p class="que">${i.quizNo}.${i.quizQue} 
					</p>
					<p class="answer">
					체크한 답:
					(<c:if test="${reList[z.count-1].recordAnswer ne 0}">${reList[z.count-1].recordAnswer}</c:if>)
					</p>
					
				</div>

				<div>
					
					 <c:forEach items="${i.examples}" var="z" varStatus="x">
						<c:if test="${i.quizAnswer eq x.count}">
							<img src="../images/quiz/${x.count}red.gif">
						</c:if>
						<c:if test="${i.quizAnswer ne x.count}">
							<img src="../images/quiz/${x.count}.gif">
						</c:if>
						${z.example}
					</c:forEach> 
				</div>
			</li>
		</c:forEach>
	</ul>


</body>
</html>