<%@page import="member.MemberDomain" %>
<%@page import="member.MemberDAO" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("utf-8");
	MemberDomain domain = new MemberDomain();
	domain.setId(request.getParameter("id"));
	domain.setPass(request.getParameter("pass"));
	domain.setName(request.getParameter("name"));
	
	new MemberDAO().insertMember(domain);
	String msg = "가입완료";
%>

<script type="text/javascript">
	alert($('msg'));
	
</script>