<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">-->
    <!--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>-->
    <link href="../css/main.css" rel="stylesheet">
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
                        <a class="nav-link" href="/car_rent/list_of_cars.view">Show cars</a>
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
        <th scope="col">Number</th>
        <th scope="col">Model</th>
        <th scope="col">Brand</th>
        <th scope="col">Colour</th>
        <th scope="col">Price</th>
    </tr>
    </thead>
    <tbody>
    <tr>

        <td>
            <a class="nav-link" href="/car_rent/details_auto.view">{auto.id}</a>
<%--            <form action="<!--/hello/search.do--!>" method="get">--%>
<%--                {auto.id}--%>
<%--                <input type="submit" id="id" name="id" value="Show">--%>
<%--            </form>--%>
        </td>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
        <td>@fat</td>
    </tr>
    </tbody>
</table>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
