<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Park Details"/>

<%@include file="common/header.jsp"%>

<c:url var="formAction" value="/parkDetail?parkCode=${park.parkCode}" />
<form action="${formAction}" method="POST">

<input name="temperatureChoice" type="radio" value="false">Farenheit
<input name="temperatureChoice" type="radio" value="true">Celcius
<input type="hidden" name="parkCode" value="${park.parkCode }">
<input type="submit">
 
</form>


<c:url var="ImageUrl" value="/img/parks/${park.imgParkName}.jpg"/>
<img src="${ImageUrl }">

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
</p>
<c:url var="details" value="/parkDetail?parkCode=${park.parkCode}"/>

<c:forEach var="weatherList" items="${weather}">
<c:url var="weatherImageUrl" value="/img/weather/${weatherList.imgWeatherName}.png"/>
<img src="${weatherImageUrl}"></a>
<c:if test="${temperatureChoice == false}">
<p>${weatherList.lowTemp}&#8457</p>
<p>${weatherList.highTemp}&#8457</p>
</c:if>
<c:if test="${temperatureChoice == true}">
<p>${weatherList.lowTempC}&#8451</p>
<p>${weatherList.highTempC}&#8451</p>
</c:if>
<p>${weatherList.forecast}</p>
<p>${weatherList.day}</p>
<p>${weatherList.advisory}</p>
</c:forEach>


<%@include file="common/footer.jsp"%>