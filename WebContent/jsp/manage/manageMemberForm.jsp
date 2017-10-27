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
		<title>회원 관리</title>
		<c:import url="/css/basicInclude.jsp" />
		<link rel=stylesheet type="text/css" href="${pageContext.request.contextPath}/css/manage.css" />
		<script>
			function deletemember(id){
				var chk;
				chk = confirm("해당 회원을 삭제하시겠습니까?");
				
				if(chk){
					location.href =
						"${pageContext.request.contextPath}/manage/deletemember?id="+id;
				}
			}
			
		</script>
	</head>
	<body>
		<div class="body">
			<h2>회원 관리 메뉴임</h2>
			<a class="btn" href="${pageContext.request.contextPath}/manage">관리 메인으로</a><br>
			<div style="overflow-y: scroll; height: 300px;">
				<table class="table">
					<tr>
						<th>아이디</th>
						<th>닉네임</th>
						<th>가입일</th>
						<td></td>
					</tr>
				<c:forEach var="member" items="${memberlist}">
					<tr>
						<td>${member.id}</td>
						<td>${member.name}</td>
						<td><fmt:formatDate value="${member.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><a class="btn" href="${pageContext.request.contextPath}/manage/modifymemberform?
						id=${member.id}">
						수정</a>
						<a class="btn" href=# id="deletebox"
						onclick="deletemember('${member.id}')">
						삭제</a></td>
					</tr>
				</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>