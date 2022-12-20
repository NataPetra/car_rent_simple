<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

    <form method="post" action="${pageContext.request.contextPath}/create_car.action" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="modelName">Model</label>
                <input type="text" name="modelName" class="form-control" id="modelName">
            </div>
            <div class="form-group col-md-6">
                <label for="brandName">Brand</label>
                <input type="text" name="brandName" class="form-control" id="brandName">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="colour">Colour</label>
                <input type="text" name="colour" class="form-control" id="colour">
            </div>
            <div class="form-group col-md-6">
                <label for="bodyType">Body Type</label>
                <input type="text" name="bodyType" class="form-control" id="bodyType">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="price">Price</label>
                <input type="text" name="price" class="form-control" id="price">
            </div>
            <div class="form-group col-md-4">
                <label for="releaseYear">Release year</label>
                <input type="text" name="releaseYear" class="form-control" id="releaseYear">
            </div>
            <div class="form-group col-md-2">
                <label for="automaticTransmission">Automatic Transmission</label>
                <select id="automaticTransmission" name="automaticTransmission" class="form-control">
                    <option selected>Choose...</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="withDriver">Driver</label>
                <select id="withDriver" name="withDriver" class="form-control">
                    <option selected>Choose...</option>
                    <option value="yes">Yes</option>
                    <option value="no">No</option>
                </select>
            </div>
        </div>

<%--        <div class="form-row">--%>
<%--            <div class="form-group col-md-6">--%>
<%--                <label for="picture" class="form-label">Picture</label>--%>
<%--                <input type="file" name="picture" class="form-control" id="picture">--%>
<%--            </div>--%>
<%--        </div>--%>

        <button type="submit" class="btn btn-primary">Add car</button>
    </form>

</main>

</body>
</html>
