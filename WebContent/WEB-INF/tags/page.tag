<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="data" type="common.PageResult"%>
<%@ attribute name="code" type="java.lang.Integer"%>
<%-- %><%@ attribute name="code" type="int"%> --%>
<c:if test="${data.count ne 0 }">
	<nav>
		<ul class="pagination">
			<li><a
				href="<c:choose><c:when test="${data.prev}">
			${pageContext.request.contextPath}/quiz/quiz?pageNo=${data.pageNo-1}&code=${code}
			</c:when>
			<c:otherwise>#</c:otherwise></c:choose>"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<li><a href="#">${data.pageNo}</a></li>
			<li><a
				href="<c:choose>
			<c:when test="${data.next}">
			${pageContext.request.contextPath}/quiz/quiz?pageNo=${data.pageNo+1}&code=${code}
			</c:when>
			<c:otherwise>#</c:otherwise>
			</c:choose>
			"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</c:if>