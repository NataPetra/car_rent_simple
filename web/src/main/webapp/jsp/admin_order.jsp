<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/order_list.css" rel="stylesheet">
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<main>

    <c:if test="${order!=null}">
        <dl class="holiday">
            <dt>Model</dt>
            <dd><c:out value="${order.model}"/></dd>
            <dt>Brand</dt>
            <dd><c:out value="${order.brand}"/></dd>
            <dt>Colour</dt>
            <dd><c:out value="${order.colour}"/></dd>
            <dt>Year Realize</dt>
            <dd><c:out value="${order.yearRealize}"/></dd>
            <dt>First Name</dt>
            <dd><c:out value="${order.firstName}"/></dd>
            <dt>Last Name</dt>
            <dd><c:out value="${order.lastName}"/></dd>
            <dt>Email</dt>
            <dd><c:out value="${order.email}"/></dd>
            <dt>Date Start</dt>
            <dd><c:out value="${order.dateStart}"/></dd>
            <dt>Date Finish</dt>
            <dd><c:out value="${order.dateFinish}"/></dd>
            <dt>Amount of Days</dt>
            <dd><c:out value="${order.amountOfDays}"/></dd>
            <dt>Price</dt>
            <dd><c:out value="${order.price}"/></dd>
        </dl>
    </c:if>

</main>

</body>
</html>
