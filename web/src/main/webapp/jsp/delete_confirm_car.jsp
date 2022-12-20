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
            <h5 class="card-title">Card title</h5>
            <p class="card-text"><c:out value="${car.modelName} ${car.brandName}"/> Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a class="nav-link" href="/car_rent/list_cars/1.view">
            <button type="button" class="btn btn-primary">Return list</button>
            </a>
        </div>
    </div>

</body>
</html>
