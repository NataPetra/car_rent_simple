<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<header>
    <%@include file="header_of_page.jsp" %>
</header>

<c:set value="${autoBean}" var="car"/>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">The car is removed!</h5>
            <p class="card-text"><c:out value="Forget the car ${car.modelName} ${car.brandName} ${car.releaseYear} release, ${car.colour}."/></p>
            <a class="nav-link" href="/car_rent/list_cars/1.view">
            <button type="button" class="btn btn-success">Back to car list</button>
            </a>
        </div>
    </div>

</body>
</html>
