<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function test(val,value){
		location.href="${pageContext.request.contextPath}/test/turn?type="+value+"&group="+val;
	}
</script>
<body>
	<form action="/getquiz">
		<table>
			<tr>
				<td><span>선택년도</span></td>
				<td><input type="radio"
					<c:if test="${value eq select}">checked="checked"</c:if>
					value="select" name="turntest" onclick="test(${group},this.value)" />
					<c:if test="${not empty value}">
						<c:if test="${value eq select}">
							<select name="ownturn">
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
							<select>
								<c:forEach var="turn" items="${list}">
									<option value="${turn.code}">${turn.subject}</option>
								</c:forEach>
							</select>
							~
							<select>
								<c:forEach var="turn" items="${list}">
									<option value="${turn.code}">${turn.subject}</option>
								</c:forEach>
							</select>
						</c:if>
					</c:if></td>
			</tr>
			<tr>
				<td><button>시험시작</button></td>
			</tr>
		</table>
	</form>
</body>
</html>