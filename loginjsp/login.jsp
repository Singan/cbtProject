<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="${pageContext.request.contextPath}/login/login" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" name="pass" /></td>
		</tr>
		<button>로그인</button>
	</table>
</form>