<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>시험점수</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/jsp/include/test/testmain.jsp">첫화면으로</a>
	<table border="2" align="center" width="60%"
		style="border-collapse: collapse; border: 3px #6699cc solid;">
		<tbody>
			<tr>
				<td width="100%"><p>&nbsp;</p>
					<p align="center">
						<font color="blue"> <b>과목을 선택하여 주십시요.</b></font>
					</p>
					<p align="center">
						<select name="object" onchange="obj(this.value)">
							<option<c:if test="${obj.code ne object}">selected="selected"</c:if> >--과목을 선택하세요--</option>
							<c:forEach var="obj" items="${list}">
								<option value="${obj.code}"<c:if test="${obj.code eq object}">selected="selected"</c:if>>${obj.object}</option>
							</c:forEach>
						</select>

						<c:if test="${not empty subject}">
							<select name="subject" onchange="sbj(this.value)">
								<option selected="selected">--과목을 선택하세요--</option>
								<c:forEach var="sbj" items="${subject}">
									<option value="${sbj.code}">${sbj.subject}</option>
								</c:forEach>
							</select>
						</c:if>
		</tbody>
	</table>
</body>
<script>
	function obj(value) {
		location.href = "${pageContext.request.contextPath}/test/subject?group="
				+ value;
	}
	function sbj(value) {
		location.href = "${pageContext.request.contextPath}/test/turn?type=none&group="
				+ value;
	}
</script>
</html>