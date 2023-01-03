<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">-->
    <!--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>-->
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-white">
        <div class="container-fluid">
            <button
                    class="navbar-toggler"
                    type="button"
                    data-mdb-toggle="collapse"
                    data-mdb-target="#navbarExample01"
                    aria-controls="navbarExample01"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarExample01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/index.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/list_cars/1.view">Show cars</a>
                    </li>
                    <li class="nav-item">
                        <security:authorize access="isAuthenticated()">
                            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                        </security:authorize>
                        <security:authorize access="!isAuthenticated()">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login.view">Login</a>
                        </security:authorize>
                    </li>
                    <li class="nav-item">
                        <security:authorize access="!isAuthenticated()">
                        <a class="nav-link" href="${pageContext.request.contextPath}/registration.view">Registration</a>
                        </security:authorize>
                    </li>
                    <li class="nav-item">
                        <security:authorize access="isAuthenticated()">
                            <a class="nav-link" href="${pageContext.request.contextPath}/personal_page.view">Personal account</a>
                        </security:authorize>
                    </li>
                </ul>
            </div>
            <security:authorize access="hasRole('ROLE_ADMIN')">
            <a class="nav-link" href="${pageContext.request.contextPath}/create_car.view">
            <button type="button" class="btn btn-outline-dark">Add car</button>
            </a>
            </security:authorize>
        </div>
    </nav>
</header>

<div class="bg">
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th>Model and brand of car</th>
        <th>Colour</th>
        <th>Price per day</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${carsList}" var="car">
    <tr>
        <td>
            <a class="nav-link" href="${pageContext.request.contextPath}/details_auto/${car.number}.view">
                <c:out value="${car.model} ${car.brand}"/>
            </a>
        </td>
        <td><c:out value="${car.colour}"/></td>
        <td><c:out value="${car.price}"/></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
    <c:forEach items="${pages}" var="pages">
            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/list_cars/${pages}.view">${pages}</a></li>
    </c:forEach>
        </ul>
    </nav>
</div>
</body>
</html>
