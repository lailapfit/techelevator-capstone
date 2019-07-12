<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Park Details"/>

<%@include file="common/header.jsp"%>

<c:url var="formAction" value="/parkDetail?parkCode=${park.parkCode}" />
<form action="${formAction}" method="POST">
<div>
<input name="temperatureChoice" type="radio" value="false">&#8457
<input name="temperatureChoice" type="radio" value="true">&#8451
<input type="hidden" name="parkCode" value="${park.parkCode }">
<input type="submit" value="Temperature Scale">
</div> 
</form>

<div id="parkDetailImg">
<c:url var="ImageUrl" value="/img/parks/${park.imgParkName}.jpg"/>
<img src="${ImageUrl }">
</div>

<div id="quote">
<p>${park.quote}
~<i>${park.quoteSource}</i></p>
</div>

<div id="parkDescription">
<h1>${park.parkName}</h1>
<h2>${park.state}</h2>

<table id="descriptionTable">
<tr>
<th>Year Founded</th>
<th>Acreage</th>
<th>Miles of Trail</th>
<th>Elevation</th>
<th>Number of Campsites</th>
<th>Annual Visitor Count</th>
<th>Number of Animal Species</th>
<th>Entry Fee</th>
<th>Climate</th>
</tr>
<tr>
<td>${park.yearFounded}</td>
<td>${park.acreage}</td>
<td>${park.milesOfTrail}</td>
<td>${park.elevation} ft</td>
<td>${park.campsites}</td>
<td>${park.annualVisitorCount}</td>
<td>${park.animalSpecies}</td>
<td>$${park.entreeFee}</td>
<td>${park.climate}</td>
</tr>

</table>

<p>${park.description}</p>

</div>

<div id="weather">
<c:forEach var="weatherList" items="${weather}">
<c:url var="weatherImageUrl" value="/img/weather/${weatherList.imgWeatherName}.png"/>
<img src="${weatherImageUrl}"></a>

<c:if test="${temperatureChoice == false}">
<p>${weatherList.lowTemp}&#8457
${weatherList.highTemp}&#8457
</c:if>

<c:if test="${temperatureChoice == true}">
${weatherList.lowTempC}&#8451
${weatherList.highTempC}&#8451
</c:if>

${weatherList.forecast}
${weatherList.day}
${weatherList.advisory}</p>

</c:forEach>

</div>


<%@include file="common/footer.jsp"%>