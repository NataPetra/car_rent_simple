<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

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
                    <a class="nav-link" href="/car_rent/list_cars/1.view">Show cars</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/car_rent/login.view">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/car_rent/registration.view">Registration</a>
                </li>
            </ul>
        </div>
        <c:set value="${autoDetailsBean}" var="car"/>
<%--        if (--%>
        <a class="nav-link" href="/car_rent/update_car/${car.id}.view">
            <button type="button" class="btn btn-outline-dark">Update car(for admin)</button>
        </a>
<%--        <a class="nav-link" href="/car_rent/delete_car/${car.id}.view">--%>
            <button type="button" class="btn btn-outline-dark" data-toggle="modal" data-target="#myModal">Delete car(for admin)</button>
<%--        </a>--%>
            <div class="modal fade" id="myModal">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Modal Heading</h4>
                            <button type="button" class="close" data-dismiss="modal">×</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            Modal body.. <c:out value="${car.modelName} ${car.brandName}"/>
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <a class="nav-link" href="/car_rent/delete_confirm/${car.id}.action">
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </a>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>

                    </div>
                </div>
            </div>
        <a class="nav-link" href="#">
            <button type="button" class="btn btn-success">Create order</button>
        </a>
    </div>
</nav>


<div class="card mb-3">
    <img src="/car_rent/image/${car.id}/picture.jpg" class="card-img-top">
    <div class="card-body">
        <h5 class="card-title"><c:out value="${car.id}) ${car.modelName} ${car.brandName}."/></h5>
        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
    </div>
</div>



</body>
</html>
