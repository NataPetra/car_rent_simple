<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/personal_page.css" rel="stylesheet">
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<main>
    <c:set value="${appUser}" var="user"/>
    <h2>
        <c:out value="Welcome ${user.userDetails.firstName} ${user.userDetails.lastName}"/>
    </h2>
    <ol class="rectangle">
        <li><a href="${pageContext.request.contextPath}/edit_personal_info/${user.userId}.view">Here you can edit your information.</a></li>
        <li><a href="${pageContext.request.contextPath}/order_list_old/${user.userId}.view">Your previous orders</a></li>
        <li><a href="${pageContext.request.contextPath}/order_list_new/${user.userId}.view">Future Orders</a></li>
    </ol>

</main>

</body>
</html>
