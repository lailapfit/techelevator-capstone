<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="Park Details" />

<%@include file="common/header.jsp"%>

<h2>Thanks for voting! Here are the results for our top 5 National Parks survey!</h2>
<div id="surveyResults">
	<table id="resultTable">
		<th>Park Name</th>
		<th>Votes</th>
		<c:forEach var="survey" items="${surveys}">
			<tr>
				<td>${survey.key}</td>
				<td>${survey.value}</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@include file="common/footer.jsp"%>