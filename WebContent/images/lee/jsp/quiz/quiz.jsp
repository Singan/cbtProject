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
			<select onchange="boxChange(this)">
				<c:forEach items="${subList}" var="i">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
		</div>
	</div>

	</nav>

	<div id="container">
		<c:forEach var="li" items="${list}">
			<div class="row">
				<c:forEach var="i" items="${li}" varStatus="status">
					<c:if test="${i.quizNo eq 1}">
						<div>${i.quizSub}</div>
					</c:if>

					<div class="col-md-6">
						<div id="quiz${i.quizCode}" style="border: 1px solid black">
							<div class="ques" style="height: 60%">${i.quizNo}.${i.quizQue}</div>
							<div class="example">
								<c:forEach var="x" items="${i.examples}" varStatus="z">
									<img id="${i.quizCode}-${x.no}"
										src="../images/quiz/${x.no}.gif"
										onclick="exampleCheck(${i.quizCode},this,${x.no})"> ${x.example}
									</c:forEach>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
	</div>
	<form action="${pageContext.request.contextPath}/quiz/result"
		method="post" name="form">
		<input type="hidden" name="code" value="${code}" />
		<div class="OMR">
			<c:forEach var="val" items="${chkList}" varStatus="i">
				<div class="quiz${i.count}">
					<input type="hidden" value="${chkList[i.count-1]}"
						name="ans${i.count}" id="ans${i.count}">
					<c:if test="${i.count<10}">0</c:if>${i.count}.
					<c:forEach begin="1" var="x" end="5">
						<c:if test="${val eq x}">
							<img src="../images/quiz/blackmark.gif"
								onclick="OMRcheck(${i.count},this,${x})" id="OMR${i.count}-${x}">
						</c:if>
						<c:if test="${val ne x}">
							<img src="../images/quiz/${x}.gif"
								onclick="OMRcheck(${i.count},this,${x})" id="OMR${i.count}-${x}">
						</c:if>
					</c:forEach>

				</div>
			</c:forEach>
		</div>
		<input type="hidden" value="" name="pageNo"> <input
			type="hidden" value="" name="code"> <input type="hidden"
			value="" name="sub">
		<button type="submit">시험 종료</button>
	</form>
	<div>
		<navi:page data="${pageResult}" code="${code}"></navi:page>
	</div>
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
			noans(no,bunho);
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
				noans(no,bunho);
			}
			
		}
		function ans(no,bunho){
			$("#ans"+no).attr('value',bunho);
			list = document.querySelector("#ans"+no);
			console.dir(list.id+":"+list.value);
		}
		function noans(no,bunho){
			$("#ans"+no).attr('value',-1);
			list = document.querySelector("#ans"+no);
			console.dir(list.id+":"+list.value);
			
		}
		window.onload=function(){
		var list = ${chkList};
		for(var i = 0 ; i <list.length;i++){
			if(list[i]!=-1){
				$("#"+(i+1)+"-"+list[i]).attr('src', "../images/quiz/"+list[i]+"red.gif");
			}
		}
		
	
		}
		function boxChange(obj){
			var f = document.form;
				alert(obj.value);
				f.code.value = ${code};
				f.pageNo.value = ${pageResult.pageNo};
				console.dir(f.pageNo.value);
				f.action = "${pageContext.request.contextPath}/jsp/quiz/quiz";
				f.submit();
			
		}
		
	</script>

</html>