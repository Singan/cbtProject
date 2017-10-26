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
			<li><a href="#" onclick="doPrev(${data.prev},${data.pageNo},${code})" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<li><a href="#">${data.pageNo}</a></li>
			<li><a
				href="#" onclick="doNext(${data.next},${data.pageNo},${code})"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</c:if>
<script>
 function doPrev(chk,pageNo,code){
	var f = document.form;
	if(chk){
		f.code.value = code
		f.pageNo.value = pageNo-1;
		console.dir(f.pageNo.value);
		f.action = "${pageContext.request.contextPath}/quiz/quiz";
		f.submit();
	}
 }
 function doNext(chk,pageNo,code){
		var f = document.form;
		if(chk){
			f.code.value = code;
			f.pageNo.value = pageNo+1;
			console.dir(f.pageNo.value);
			f.action = "${pageContext.request.contextPath}/quiz/quiz";
			f.submit();
		}
	 }
</script>