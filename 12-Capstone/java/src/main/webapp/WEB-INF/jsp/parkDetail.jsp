<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Park Details"/>

<%@include file="common/header.jsp"%>
<c:url var="SurveylUrl" value="/survey"/>
<a href="${SurveylUrl}">

<a href="${details}">
<c:url var="ImageUrl" value="/img/parks/${park.imgParkName}.jpg"/>
<img src="${ImageUrl }"></a>

<p>
${park.parkName}
${park.state}
${park.acreage}
${park.elevation}
${park.milesOfTrail}
${park.campsites}
${park.climate}
${park.yearFounded}
${park.annualVisitorCount}
${park.quote}
${park.quoteSource}
${park.description}
${park.entreeFee}
${park.animalSpecies}
<c:url var="details" value="/parkDetail?parkCode=${park.parkCode}"/>

<c:forEach var="weatherList" items="${weather}">
<c:url var="weatherImageUrl" value="/img/weather/${weatherList.imgWeatherName}.png"/>
<img src="${weatherImageUrl}"></a>
<p>${weatherList.lowTemp}</p>
<p>${weatherList.highTemp}</p>
<p>${weatherList.forecast}</p>
<p>${weatherList.day}</p>
<p>${weatherList.advisory}</p>
</c:forEach>


</p>



<p>Park detail page is here</p>
</a>

<%@include file="common/footer.jsp"%>