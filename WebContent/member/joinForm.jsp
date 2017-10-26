<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	
	
	
	  function idchk()
	{
		var frm = document.frm;	
		var id = document.getElementById("userId");
		frm.action = "${pageContext.request.contextPath}/member/memberidchk?id="+id.value;
		
		frm.submit();
	}
	  function check(){
		  if(!document.joinform.id.value){
			  alert("ID를 입력하세요");
			  return false;
		  }
		  if(!document.joinform.pass.value){
			  alert("Password를 입력하세요");
			  return false;
		  }
		  if(!document.joinform.name.value){
			  alert("Name를 입력하세요");
			  return false;
		  }
	  }



</script>

</head>
<body>

	<form method="post" name = "joinform" onSubmit="return check()"
		  action="${pageContext.request.contextPath}/member/joincontroller">
		<table>
			<tbody>
				<tr>
					<th>ID</th>
					<td>
						<input type="text" name="id" id="userId" value="${id}">
						<input type="button" value="중복확인" onclick="idchk()" >
					</td>
					<td>${error}</td><td>${ok}</td>
				</tr>
				<tr>
					<th>Password</th>
					<td>
						<input type="password" name="pass">
					</td>
				</tr>
				<tr>
					<th>Name</th>
					<td>
						<input type="text" name="name">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button>회원가입</button><td>${errid}</td><td>${errpass}</td><td>${errname}</td>
					</td>
				</tr>
			</tbody>
		</table>	  
	</form>


</body>
</html>