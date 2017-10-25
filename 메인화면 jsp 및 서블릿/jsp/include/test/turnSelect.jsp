<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="1">
		<tr background="#ff0">
			<th>과목</th><th>과목명</th><th>문제갯수</th>
		</tr>
		<c:forEach var="view" items="${over}">
			<tr>
				<td>${view.quiz_sub}</td>
				<td>미정</td>
				<td>${view.last_no}</td>
			</tr>
		</c:forEach>
	</table>



	<form action="/getquiz" method="post">
		<table>
			<tr>
				<td><span>선택년도</span></td>
				<td><input type="radio"
					<c:if test="${value eq select}">checked="checked"</c:if>
					value="select" name="turntest" onclick="test(${group},this.value)" />
					<c:if test="${not empty value}">
						<c:if test="${value eq select}">
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
					<c:if test="${value eq tests}">checked="checked"</c:if>
					name="turntest" onclick="test(${group},this.value)" /> <c:if
						test="${not empty value}">
						<c:if test="${value eq tests}">
							<select name="first_code" onchange="mockgo(${group},this.value)">
								<c:forEach var="turn" items="${list}">
									<option value="${turn.code}" <%-- <c:if test="${turn.code eq requestScope.code}">selected="selected"</c:if> --%>>${turn.subject}</option>
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