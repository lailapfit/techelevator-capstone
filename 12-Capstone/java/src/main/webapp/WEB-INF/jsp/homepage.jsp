<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Homepage"/>

<%@include file="common/header.jsp"%>

 

<c:forEach items="${parks}" var="park">
<p>
${park.parkName}
${park.description}
${park.parkName}
<c:url var="details" value="/parkDetail?parkCode=${park.parkCode}"/>

<a href="${details}">
<c:url var="ImageUrl" value="/img/parks/${park.imgParkName}.jpg"/>
<img src="${ImageUrl }"></a>


</p>
</c:forEach>


<p>Homepage is here</p>
<%@include file="common/footer.jsp"%>