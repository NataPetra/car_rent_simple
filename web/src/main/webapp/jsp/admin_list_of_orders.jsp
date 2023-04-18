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
            <th scope="col">Model and Brand</th>
            <th scope="col">Сolour</th>
            <th scope="col">Year Realize</th>
            <th scope="col">First and Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Date Start</th>
            <th scope="col">Date Finish</th>
            <th scope="col">Amount Of Days</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listOrders}" var="order">
        <tr>
            <td><c:out value="${order.id}"/></td>
            <td><c:out value="${order.model} ${order.brand}"/></td>
            <td><c:out value="${order.colour}"/></td>
            <td><c:out value="${order.yearRealize}"/></td>
            <td><c:out value="${order.firstName} ${order.lastName}"/></td>
            <td><c:out value="${order.email}"/></td>
            <td><c:out value="${order.dateStart}"/></td>
            <td><c:out value="${order.dateFinish}"/></td>
            <td><c:out value="${order.amountOfDays}"/></td>
            <td>
                <a class="nav-link" href="${pageContext.request.contextPath}/admin_delete_order/${order.id}.action">
                    <button type="button" class="btn btn-danger">Delete order</button>
                </a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

</main>

</body>
</html>