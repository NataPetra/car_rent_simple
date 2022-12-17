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

<main>
    <c:set value="${autoCommonBean}" var="car"/>
    <form method="post" action="/car_rent/update_car/${car.id}.action">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="modelName">Model</label>
                <input type="text" name="modelName" class="form-control" id="modelName" value="<c:out value="${car.modelName}"/>">
            </div>
            <div class="form-group col-md-6">
                <label for="brandName">Brand</label>
                <input type="text" name="brandName" class="form-control" id="brandName" value="<c:out value="${car.brandName}"/>">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="colour">Colour</label>
                <input type="text" name="colour" class="form-control" id="colour" value="<c:out value="${car.colour}"/>">
            </div>
            <div class="form-group col-md-6">
                <label for="bodyType">Body Type</label>
                <input type="text" name="bodyType" class="form-control" id="bodyType" value="<c:out value="${car.bodyType}"/>">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="price">Price</label>
                <input type="text" name="price" class="form-control" id="price" value="<c:out value="${car.price}"/>">
            </div>
            <div class="form-group col-md-4">
                <label for="releaseYear">Release year</label>
                <input type="text" name="releaseYear" class="form-control" id="releaseYear" value="<c:out value="${car.releaseYear}"/>">
            </div>
            <div class="form-group col-md-2">
                <label for="automaticTransmission">Automatic Transmission</label>
                <input type="text" name="automaticTransmission" class="form-control" id="automaticTransmission" value="<c:out value="${car.automaticTransmission}"/>">
            </div>
            <div class="form-group col-md-2">
                <label for="withDriver">Driver</label>
                <input type="text" name="withDriver" class="form-control" id="withDriver" value="<c:out value="${car.withDriver}"/>">
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Update car</button>
    </form>

    <form method="post" action="/car_rent/update_car_picture/${car.id}.action" enctype="multipart/form-data">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="picture" class="form-label">Picture</label>
                        <input type="file" name="picture" class="form-control" id="picture">
                    </div>
                </div>
        <button type="submit" class="btn btn-primary">Update car picture</button>
    </form>

</main>

</body>
</html>
