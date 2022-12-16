<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">-->
    <!--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>-->
    <link href="/car_rent/css/main.css" rel="stylesheet">
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
                        <a class="nav-link" aria-current="page" href="/car_rent/index.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/car_rent/list_cars.view">Show cars</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/car_rent/login.view">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/car_rent/registration.view">Registration</a>
                    </li>
                </ul>
            </div>
            <a class="nav-link" href="/car_rent/create_car.view">
            <button type="button" class="btn btn-outline-dark">Add car(for admin)</button>
            </a>
        </div>
    </nav>
</header>

<div class="bg">
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th>Number</th>
        <th>Model</th>
        <th>Brand</th>
        <th>Colour</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${carsList}" var="singlCar">
    <tr>
        <td>
            <a class="nav-link" href="/car_rent/{car.number}/details_auto.view">
                <c:out value="${singlCar.number}"/>
            </a>
        </td>
        <td><c:out value="${carsList[0].model}"/></td>
        <td><c:out value="${singlCar.brand}"/></td>
        <td><c:out value="${singlCar.colour}"/></td>
        <td><c:out value="${singlCar.price}"/></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<%--    <nav aria-label="Page navigation example">--%>
<%--        <ul class="pagination justify-content-center">--%>
<%--            <li class="page-item disabled">--%>
<%--                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>--%>
<%--            </li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--            <li class="page-item">--%>
<%--                <a class="page-link" href="#">Next</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </nav>--%>
</div>
</body>
</html>
