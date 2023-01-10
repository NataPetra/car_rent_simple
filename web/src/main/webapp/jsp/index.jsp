<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <title>Title</title>
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


                    <div class="dropdown open">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Show cars
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/list_cars/1.view">Show all cars</a>
                            <c:forEach items="${models}" var="model">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/list_cars.view?model=${model}">Show only ${model}</a>
                            </c:forEach>
                        </div>
                    </div>

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
        </div>
    </nav>

    <!-- Jumbotron -->
    <div class="p-5 text-center bg-light">
        <h1 class="mb-3">Royal cars</h1>
        <h4 class="mb-3">сar rent</h4>
    </div>
</header>

<main>
    <img src="${pageContext.request.contextPath}/res/background.jpeg" class="img-fluid" alt="Wild Landscape" />
</main>

<!-- Footer -->
<footer class="text-center text-lg-start bg-light text-muted">

    <!-- Section: Links  -->
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <!-- Grid row -->
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        <i class="fas fa-gem me-3"></i>Company name: "Royal cars"
                    </h6>
                    <p>
                        You have a unique opportunity to rent a premium class car. Machines from the best manufacturers with the best set of qualities.
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                    <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                    <p>
                        <i class="fas fa-envelope me-3"></i>
                        info@example.com
                    </p>
                    <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                    <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                </div>
                <!-- Grid column -->
            </div>
            <!-- Grid row -->
        </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        © 2023 Copyright:
        <a class="text-reset fw-bold" href="https://www.it-academy.by/">It-academy.by</a>
    </div>
    <!-- Copyright -->
</footer>
<!-- Footer -->

</body>
</html>
