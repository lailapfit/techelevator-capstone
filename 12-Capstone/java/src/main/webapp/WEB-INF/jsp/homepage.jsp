<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Homepage"/>

<%@include file="common/header.jsp"%>

<c:url var="ParkDetailUrl" value="/parkDetail"/>
<a href="${ParkDetailUrl }">

<p>Homepage is here</p></a>
<%@include file="common/footer.jsp"%>