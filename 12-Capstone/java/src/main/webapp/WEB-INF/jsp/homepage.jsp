<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="Homepage" />

<%@include file="common/header.jsp"%>

<!-- This method loops through the list of parks and display the park image, name, and description-->
 <c:forEach items="${parks}" var="park">
	<div id="parkBlock">
		<c:url var="details" value="/parkDetail?parkCode=${park.parkCode}" />
		<a href="${details}"> <c:url var="ImageUrl"	value="/img/parks/${park.imgParkName}.jpg" /> 
		<img src="${ImageUrl}"></a>
		<div id="parkName">
			<h2>${park.parkName} - ${park.state}</h2>
			<br> ${park.description}
		</div>
	</div>
</c:forEach>

<%@include file="common/footer.jsp"%>