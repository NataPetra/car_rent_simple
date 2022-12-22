<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<main>
    <c:set value="${autoCommonBean}" var="car"/>
    <form method="post" action="${pageContext.request.contextPath}/order/${car.id}.action" enctype="multipart/form-data">
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
            <div class="form-group col-md-4">
                <label for="price">Price</label>
                <input type="text" name="price" class="form-control" id="price" value="<c:out value="${car.price}"/>">
            </div>
            <div class="form-group col-md-4">
                <label for="releaseYear">Release year</label>
                <input type="text" name="releaseYear" class="form-control" id="releaseYear" value="<c:out value="${car.releaseYear}"/>">
            </div>
            <div class="form-group col-md-4">
                <label for="colour">Colour</label>
                <input type="text" name="colour" class="form-control" id="colour" value="<c:out value="${car.colour}"/>">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="amountOfDays">Amount of days</label>
                <input type="number" name="amountOfDays" class="form-control" id="amountOfDays" min="1"/>
            </div>
            <div class="form-group col-md-4">
                <label for="sdate">Rental start date</label>
                <input type="date" name="sdate" class="form-control" id="sdate"/>
            </div>
            <div class="form-group col-md-4">
                <label for="fdate">Rental finish date</label>
                <input type="date" name="fdate" class="form-control" id="fdate"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="comments">Here you can leave a comment to your order:</label>
                <input type="text" name="comments" class="form-control" id="comments">
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Create order</button>
    </form>



</main>

</body>
</html>
