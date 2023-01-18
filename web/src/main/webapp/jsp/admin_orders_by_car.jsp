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
    <table class="table align-middle">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Model</th>
            <th scope="col">Brand</th>
            <th scope="col">Year Realize</th>
            <th scope="col">Date Start</th>
            <th scope="col">Date Finish</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listOrders}" var="order">
            <tr>
                <td>
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin_order/${order.id}.view">
                        <c:out value="${order.id}"/>
                    </a>
                </td>
                <td><c:out value="${order.modelName}"/></td>
                <td><c:out value="${order.brandName}"/></td>
                <td><c:out value="${order.releaseYear}"/></td>
                <td><c:out value="${order.dateStart}"/></td>
                <td><c:out value="${order.dateStart}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>

</body>
</html>

