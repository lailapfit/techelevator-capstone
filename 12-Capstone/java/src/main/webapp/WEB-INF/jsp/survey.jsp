<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Survey Page" />

<%@include file="common/header.jsp"%>



<c:url var="formAction" value="/survey" />
<form:form action="${formAction}" method="POST" modelAttribute="survey">

	<label for="parkCode">Park Name</label> 
	<form:select path="parkCode">
	<form:option value="">Select your favorite park!</form:option>
		<c:forEach var="park" items="${dailySurvey}">
			<form:option value="${park.parkCode}">${park.parkName}</form:option>
		</c:forEach>
	</form:select>
	 <form:errors path="parkCode"/>
	 
	<form:label path="email">Your Email</form:label> 
	<form:input path="email" name="email" /><br />
	<form:errors path="email"/>
	
	<form:label path="state">Resident State</form:label> 
	<form:select path="state">
		<form:option value="">Select a State</form:option>
		<form:option value="AL">Alabama</form:option>
		<form:option value="AK">Alaska</form:option>
		<form:option value="AZ">Arizona</form:option>
		<form:option value="AR">Arkansas</form:option>
		<form:option value="CA">California</form:option>
		<form:option value="CO">Colorado</form:option>
		<form:option value="CT">Connecticut</form:option>
		<form:option value="DE">Delaware</form:option>
		<form:option value="DC">District Of Columbia</form:option>
		<form:option value="FL">Florida</form:option>
		<form:option value="GA">Georgia</form:option>
		<form:option value="HI">Hawaii</form:option>
		<form:option value="ID">Idaho</form:option>
		<form:option value="IL">Illinois</form:option>
		<form:option value="IN">Indiana</form:option>
		<form:option value="IA">Iowa</form:option>
		<form:option value="KS">Kansas</form:option>
		<form:option value="KY">Kentucky</form:option>
		<form:option value="LA">Louisiana</form:option>
		<form:option value="ME">Maine</form:option>
		<form:option value="MD">Maryland</form:option>
		<form:option value="MA">Massachusetts</form:option>
		<form:option value="MI">Michigan</form:option>
		<form:option value="MN">Minnesota</form:option>
		<form:option value="MS">Mississippi</form:option>
		<form:option value="MO">Missouri</form:option>
		<form:option value="MT">Montana</form:option>
		<form:option value="NE">Nebraska</form:option>
		<form:option value="NV">Nevada</form:option>
		<form:option value="NH">New Hampshire</form:option>
		<form:option value="NJ">New Jersey</form:option>
		<form:option value="NM">New Mexico</form:option>
		<form:option value="NY">New York</form:option>
		<form:option value="NC">North Carolina</form:option>
		<form:option value="ND">North Dakota</form:option>
		<form:option value="OH">Ohio</form:option>
		<form:option value="OK">Oklahoma</form:option>
		<form:option value="OR">Oregon</form:option>
		<form:option value="PA">Pennsylvania</form:option>
		<form:option value="RI">Rhode Island</form:option>
		<form:option value="SC">South Carolina</form:option>
		<form:option value="SD">South Dakota</form:option>
		<form:option value="TN">Tennessee</form:option>
		<form:option value="TX">Texas</form:option>
		<form:option value="UT">Utah</form:option>
		<form:option value="VT">Vermont</form:option>
		<form:option value="VA">Virginia</form:option>
		<form:option value="WA">Washington</form:option>
		<form:option value="WV">West Virginia</form:option>
		<form:option value="WI">Wisconsin</form:option>
		<form:option value="WY">Wyoming</form:option>
	</form:select> 
		<form:errors path="state"/>
	
	<form:label path="activityLevel">Activity Level</form:label> 
	<form:select path="activityLevel">
		<form:option value="">Select activity Level</form:option>
		<form:option value="inactive">Inactive</form:option>
		<form:option value="sedentary">Sedentary</form:option>
		<form:option value="active">Active</form:option>
		<form:option value="extremelyActive">Extremely Active</form:option>
	</form:select> 
	<form:errors path="activityLevel"/>
	
	<input type="submit" value="Submit" />

</form:form>

<%@include file="common/footer.jsp"%>