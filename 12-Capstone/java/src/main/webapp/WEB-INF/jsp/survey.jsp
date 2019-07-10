<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Survey Page"/>

<%@include file="common/header.jsp"%>
<c:url var="SurveyResultlUrl" value="/surveyResult"/>
<a href="${SurveyResultlUrl}">
<p>Survey page is here</p>
</a>

<%@include file="common/footer.jsp"%>