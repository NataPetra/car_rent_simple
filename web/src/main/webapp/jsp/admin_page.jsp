<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<main>
    <c:set value="${appAdmin}" var="admin"/>
    <h1>
        <c:out value="Welcome admin ${admin.userDetails.firstName} ${admin.userDetails.lastName}"/>
    </h1>
    <p>
        <a class="nav-link" href="${pageContext.request.contextPath}/edit_personal_info/${admin.userId}.view">
            Here you can edit your information.
        </a>
    </p>
</main>

</body>
</html>
