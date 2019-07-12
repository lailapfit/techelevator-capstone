<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/site.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/img/logo.png" var="logoSrc" />
        	<img src="${logoSrc}" alt="Natural Park logo" />       
    </header>
    <nav>
        <ul>
        	<c:url var="homepageHref" value="/homepage" />
            <a href="${homepageHref}">Homepage</a>
            <c:url var="surveyHref" value="/survey" />
            <a href="${surveyHref}">Survey</a>                
        </ul>    
    </nav>
