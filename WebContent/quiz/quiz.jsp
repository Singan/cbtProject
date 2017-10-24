<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="navi" tagdir="/WEB-INF/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문제</title>


</head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/quiz.css">
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}">
				<img alt="처음으로" src="../images/quiz/blackmark.gif">
			</a>
		</div>
		<p class="navbar-text title">Signed in as Mark Otto</p>
		<div id="select">
			<select><option>1과목</option>
				<option>2과목</option>
				<option>3과목</option>
			</select>
		</div>
	</div>

	</nav>


	<div id="container">
		<c:forEach var="li" items="${list}">
			<div class="row">
				<c:forEach var="i" items="${li}" varStatus="status">
					<div class="col-md-6">
						<div id="quiz${i.quizNo}" style="border: 1px solid black">
							<div class="ques" style="height: 60%">${i.quizNo}.${i.quizQue}</div>
							<div class="example">
								<c:forEach var="x" items="${i.examples}">
									<img id="${i.quizNo}-${x.no}" src="../images/quiz/${x.no}.gif"
										onclick="exampleCheck(${i.quizNo},this,${x.no})"> ${x.example}
									</c:forEach>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>

		</c:forEach>

		<button type="submit">시험 종료</button>
	</div>

	<form action="#">
		<div class="OMR">
			<c:forEach var="i" step="1" begin="1" end="40">
				<div class="quiz${i}">
					<input type="hidden" value="" id="ans${i}">
					<c:if test="${i<10}">0</c:if>${i}.
					<img src="../images/quiz/1.gif" onclick="OMRcheck(${i},this,1)" id="OMR${i}-1">
					<img src="../images/quiz/2.gif" onclick="OMRcheck(${i},this,2)" id="OMR${i}-2">
					<img src="../images/quiz/3.gif" onclick="OMRcheck(${i},this,3)" id="OMR${i}-3">
					<img src="../images/quiz/4.gif" onclick="OMRcheck(${i},this,4)" id="OMR${i}-4">
					<img src="../images/quiz/5.gif" onclick="OMRcheck(${i},this,5)" id="OMR${i}-5">
				</div>
			</c:forEach>
		</div>
		<navi:page data="${pageResult}"<%--  code=999 --%>></navi:page>
	</form>
</body>

<script type="text/javascript">


			

		function OMRcheck(no,obj,bunho){
				
			if(obj.src.lastIndexOf("blackmark.gif")==-1){
			list = document.querySelectorAll(".OMR>.quiz" + no + ">img");
			for(var i = 0; i<list.length;i++){
				list[i].src="../images/quiz/"+(i+1)+".gif"
			}
			obj.src="../images/quiz/blackmark.gif";
			list = document.querySelectorAll("#quiz"+no+">"+".example>img")
			for(var i = 0 ; i<list.length;i++){
				list[i].src="../images/quiz/"+(i+1)+".gif";
			}
			$("#"+no+"-"+bunho).attr('src', "../images/quiz/"+bunho+"red.gif");
			ans(no,bunho);
		}else{
			obj.src="../images/quiz/"+bunho+".gif";
			$("#"+no+"-"+bunho).attr('src', "../images/quiz/"+bunho+".gif");
		}
		}
		function exampleCheck(no,obj,bunho){
			if(obj.src.lastIndexOf("red.gif")==-1){
				list = document.querySelectorAll(".OMR>.quiz" + no + ">img");
				for(var i = 0; i<list.length;i++){
					list[i].src="../images/quiz/"+(i+1)+".gif"
				}
				$("#OMR"+no+"-"+bunho).attr('src', "../images/quiz/blackmark.gif");
				obj.src="../images/quiz/"+bunho+"red.gif";
				list = document.querySelectorAll("#quiz"+no+">"+".example>img");
				
				for(var i = 0 ; i<list.length;i++){
					list[i].src="../images/quiz/"+(i+1)+".gif";
				}
				$("#"+no+"-"+bunho).attr('src', "../images/quiz/"+bunho+"red.gif");
				ans(no,bunho);
			}else{
				obj.src="../images/quiz/"+bunho+".gif";
				$("#OMR"+no+"-"+bunho).attr('src', "../images/quiz/"+bunho+".gif");
			}
			
		}
		function ans(no,bunho){
			$("#ans"+no).attr('value',bunho);
			list = document.querySelector("#ans"+no);
			console.dir(list.id+":"+list.value);
		}
	</script>

</html>