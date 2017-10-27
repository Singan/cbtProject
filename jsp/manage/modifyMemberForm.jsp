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
		<title>회원 정보 수정</title>
	</head>
	<body>
		<div>
			<h2>${member.id} 회원 정보 수정</h2>
			<a href="${pageContext.request.contextPath}/manage/managemember">회원 목록으로</a><br>
			<div>
				<form action="${pageContext.request.contextPath}/manage/modifymember" method="post">
					<input name="id" type="hidden" value="${member.id}">
					<table>
						<tbody>
							<tr>
								<th scope="row"><div>비밀번호</div></th>
								<td><input name="pass" value="${member.pass}" required><td>
							</tr>
							<tr>
								<th scope="row"><div>회원명</div></th>
								<td><input name="name" value="${member.name}" required><td>
							</tr>
							<tr>
								<th scope="row"><div>권한</div></th>
								<td>
									<input name="admin" type="checkbox" value="Y"
									<c:if test="${not empty member.admin}">
									checked="checked" </c:if>>
								<td>
							</tr>
							<tr>
								<th scope="row"><div>가입일자</div></th>
								<td>
									<div>
										<fmt:formatDate value="${member.regDate}" 
										pattern="yyyy-MM-dd HH:mm:ss"/>
									</div>
								<td>
							</tr>
						</tbody>
					</table>
					<div><button>아이고</button></div>
				</form>
			</div>
		</div>
	</body>
</html>