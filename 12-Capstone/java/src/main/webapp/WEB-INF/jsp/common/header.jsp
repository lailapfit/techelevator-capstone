<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Solar System Geek</title>
    <c:url value="/css/solarsystemgeek.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
    <header>
    		<c:url value="/" var="homePageHref" />
    		<c:url value="/img/ssg_logo.png" var="logoSrc" />
        <a href="${homePageHref}">
        		<img src="${logoSrc}" alt="Solar System Geek logo" />
        </a>
        <h1>The Solar System</h1>
    </header>
    <nav>
        <ul>
        	<c:url var="homepageHref" value="/homepage" />
            <a href="${homepageHref}">Homepage</a>
            <c:url var="surveyHref" value="/survey" />
            <a href="${surveyHref}">Survey</a>
                             
        </ul>
    </nav>
