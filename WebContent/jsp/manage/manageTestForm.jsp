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
		<title>시험 관리</title>
		<link rel=stylesheet type="text/css" href="${pageContext.request.contextPath}/css/manage.css" />
	</head>
	<body>
		<div class="body box">
			<h2>시험 관리 메뉴임</h2>
			<a class="btn" href="${pageContext.request.contextPath}/manage">관리 메인으로</a><br>
			
			<!-- 시험목록 -->
			
			<div style="overflow-y: scroll; height: 200px;">
				<c:forEach var="object" items="${objectlist}">
					<div>
						<a>${object.testName}</a>
						<a class="btn" href="${pageContext.request.contextPath}/manage/managetest?
						subject=${object.testCode}">선택</a>
					</div>
				</c:forEach>
			</div>
			
			<!-- 등급목록 또는 시험추가 -->
			
			<c:choose>
				<c:when test="${not empty subgroup}">
					<c:if test="${empty turngroup}">
						<div>
								<a class="btn" href="${pageContext.request.contextPath}/manage/managetest">
								접기</a>
						</div>
					</c:if>
					<div style="overflow-y: scroll; height: 200px;">
						<c:forEach var="subject" items="${subjectlist}">
							<div>
								<a>${subject.testName}</a>
								<a class="btn" href="${pageContext.request.contextPath}/manage/managetest?
								subject=${subgroup}&turn=${subject.testCode}">선택</a>
							</div>
						</c:forEach>
					</div>
				</c:when>
				<c:otherwise>
					<a class="btn" href="${pageContext.request.contextPath}/manage/inserttestform">
					시험 추가하기</a>
				</c:otherwise>
			</c:choose>
			
			<!-- 회차목록 또는 등급추가 -->
			
			<c:choose>
				<c:when test="${not empty turngroup}">
					<div>
						<a class="btn" href="${pageContext.request.contextPath}/manage/managetest?
						subject=${subgroup}">접기</a>
					</div>
					<div style="overflow-y: scroll; height: 200px;">
						<c:forEach var="turn" items="${turnlist}">
							<div>
								<a>${turn.testName}</a>
								<a>${turn.testDate}</a>
								<a class="btn" href="${pageContext.request.contextPath}/manage/managesub?
								subject=${subgroup}&turn=${turngroup}&testcode=${turn.testCode}">문제</a>
							</div>
						</c:forEach>
					</div>
				</c:when>
				<c:when test="${not empty subgroup}">
					<a class="btn" href="${pageContext.request.contextPath}/manage/inserttestform?
					subject=${subgroup}">등급 추가하기</a>
				</c:when>
			</c:choose>
			
			<!-- 회차추가 -->
			<c:if test="${not empty turngroup}">
				<a class="btn" href="${pageContext.request.contextPath}/manage/inserttestform?
				subject=${subgroup}&turn=${turngroup
				}">회차 추가하기</a>
			</c:if>
		</div>
	</body>
</html>