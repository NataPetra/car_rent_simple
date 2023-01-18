<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/error.css" rel="stylesheet">
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<main>

    <form:form method = "post" action = "${pageContext.request.contextPath}/create_car.action" modelAttribute="autoCommon" enctype="multipart/form-data">
        <form:errors path = "*" cssClass = "errorblock" element = "div" />
        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label path = "modelName">Model</form:label>
                <form:input path = "modelName" type="text" name="modelName" cssClass="form-control" id="modelName"/>
                <form:errors path = "modelName" cssClass = "error" id="modelName"/>
            </div>
            <div class="form-group col-md-6">
                <form:label path = "brandName">Brand</form:label>
                <form:input path = "brandName" type="text" name="brandName" class="form-control" id="brandName"/>
                <form:errors path = "modelName" cssClass = "error"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label path = "colour">Colour</form:label>
                <form:input path = "colour" type="text" name="colour" class="form-control" id="colour"/>
                <form:errors path = "colour" cssClass = "error"/>
            </div>
            <div class="form-group col-md-6">
                <form:label path = "bodyType">Body Type</form:label>
                <form:input path = "bodyType" type="text" name="bodyType" class="form-control" id="bodyType"/>
                <form:errors path = "bodyType" cssClass = "error"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label path = "price">Price</form:label>
                <form:input path = "price" type="text" name="price" class="form-control" id="price"/>
                <form:errors path = "price" cssClass = "error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label path = "releaseYear">Release year</form:label>
                <form:input path = "releaseYear" type="text" name="releaseYear" class="form-control" id="releaseYear"/>
                <form:errors path = "releaseYear" cssClass = "error"/>
            </div>
            <div class="form-group col-md-2">
                <form:label path = "automaticTransmission">Automatic Transmission</form:label>
                <form:select path = "automaticTransmission" type="text" name="automaticTransmission" class="form-control" id="automaticTransmission">
                    <form:option value="yes">Yes</form:option>
                    <form:option value="no">No</form:option>
                </form:select>
            </div>
            <div class="form-group col-md-2">
                <form:label path = "withDriver">Driver</form:label>
                <form:select path = "withDriver" type="text" name="withDriver" class="form-control" id="withDriver">
                    <form:option value="yes">Yes</form:option>
                    <form:option value="no">No</form:option>
                </form:select>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label path = "pictureImg">Picture</form:label>
                <form:input path = "pictureImg" type="file" name="pictureImg" class="form-control" id="pictureImg"/>
            </div>
        </div>

        <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Add car</button>

</form:form>

</main>

</body>
</html>
