<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="Park Details" />

<%@include file="common/header.jsp"%>

<p>Here are the results for our top 5 National Parks survey! Thanks
	for voting!</p>
<table>
	<c:forEach var="survey" items="${surveys}">
		<tr>
			<td>${survey.key}</td>
			<td>${survey.value}</td>
		</tr>
	</c:forEach>
</table>

<%@include file="common/footer.jsp"%>