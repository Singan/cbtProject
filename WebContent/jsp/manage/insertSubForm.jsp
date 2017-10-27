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
		<title>과목 추가</title>
		<link rel=stylesheet type="text/css" href="${pageContext.request.contextPath}/css/manage.css" />
		<script>
		</script>
	</head>
	<body>
		<div class="body">
			<h2>과목 추가</h2>
			<div>
				<form action="${pageContext.request.contextPath}/manage/insertsub" method="post">
					<input name="testcode" type="hidden" value="${testcode}">
					<input name="subject" type="hidden" value="${subgroup}">
					<input name="turn" type="hidden" value="${turngroup}">
					<table>
						<tbody>
							<tr>
								<th scope="row"><div>과목명</div></th>
								<td><input name="quizsub" type="text" required><td>
							</tr>
							<tr>
								<th scope="row"><div>문제수</div></th>
								<td><input name="lastno" type="number" required><td>
							</tr>
						</tbody>
					</table>
					<div><button>추가</button></div>
				</form>
			</div>
		</div>
	</body>
</html>