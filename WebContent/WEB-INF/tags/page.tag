<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="data" type="common.PageResult"%>
<%-- %><%@ attribute name="code" type="int"%> --%>
<c:if test="${dataResult.count ne 0 }">
	<nav>
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<li><a href="#">${data.pageNo}</a></li>
			<li><a href="${pageContext.request.contextPath}/quiz/getQuiz?pageNo=2&code=999" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</c:if>