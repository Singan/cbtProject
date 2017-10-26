<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>0점이야~</title>
<style>
.space {
	height: 30px;
}
#main{
	width: 65%;
}

</style>
</head>
<body>
<a href="${pageContext.request.contextPath}/jsp/include/test/testmain.jsp">첫화면으로</a>
	<center>
		<div id="main" align="center" style="border-collapse:collapse; border:3px #6699cc solid;">
			<p align="center">
				<font size="5"><b>미니 프로젝트</b></font><font size="5" color="blue"><b>
						범위 선택</b></font>
			</p>
			<center>
				<b>응시과목 : </b><b>${nowtest}</b>
				<div class="space"></div>
				<table border="1" cellspacing="0" bordercolor="#bfbfbf">
					<tbody>
						<tr>
							<th bgcolor="yellow" align="center"><b>과목</b></th>
							<th bgcolor="yellow" align="center"><b>과 목 명</b></th>
							<th bgcolor="yellow" align="center"><b>문제갯수</b></th>
						</tr>
						<c:forEach var="view" items="${over}">
							<tr>
								<td bgcolor="EEEEEE">${view.quizSub}</td>
								<td bgcolor="EEEEEE">미정</td>
								<td align="center" bgcolor="EEEEEE">${view.quizNo}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</center>
			<center>

				<div class="space"></div>
				<form action="/getquiz" method="post">
					<table>
						<tr>
							<td><span>선택년도</span></td>
							<td><input type="radio"
								<c:if test="${value eq 'select'}">checked="checked"</c:if>
								value="select" name="turntest"
								onclick="test(${group},this.value)" /> <c:if
									test="${not empty value}">
									<c:if test="${value eq 'select'}">
										<select name="test_code">
											<c:forEach var="turn" items="${list}">
												<option value="${turn.code}">${turn.subject}</option>
											</c:forEach>
										</select>
									</c:if>
								</c:if></td>
						</tr>
						<tr>
							<td><span>모의고사</span></td>
							<td><input type="radio" value="tests"
								<c:if test="${value eq 'tests'}">checked="checked"</c:if>
								name="turntest" onclick="test(${group},this.value)" /> <c:if
									test="${not empty value}">
									<c:if test="${value eq 'tests'}">
										<select name="first_code"
											onchange="mockgo(${group},this.value)">
											<c:forEach var="turn" items="${list}">
												<option value="${turn.code}"<c:if test="${turn.code eq requestScope.code}">selected="selected"</c:if>>${turn.subject}</option>
											</c:forEach>
										</select>
										<c:if test="${not empty mocklist}">
							~
							<select name="last_code">
												<option value="null">--선택해주세요--</option>
												<c:forEach var="turn" items="${mocklist}">
													<option value="${turn.code}">${turn.turn}</option>
												</c:forEach>
											</select>
										</c:if>
									</c:if>
								</c:if></td>
						</tr>
						<tr>
							<td><button>시험시작</button></td>
						</tr>
					</table>
				</form>
			</center>
		</div>
	</center>
</body>
<script type="text/javascript">
	function test(val,value){
		location.href="${pageContext.request.contextPath}/test/turn?type="+value+"&group="+val;
	}
	
	function mockgo(group,code){
		location.href="${pageContext.request.contextPath}/test/mocktest?code="+code+"&group="+group;
	}
</script>
</html>