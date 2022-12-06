<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">-->
    <!--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>-->
<%--    <link href="../css/main.css" rel="stylesheet">--%>
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<main>

    <form>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputModel">Model</label>
                <input type="text" class="form-control" id="inputModel">
            </div>
            <div class="form-group col-md-6">
                <label for="inputBrand">Brand</label>
                <input type="text" class="form-control" id="inputBrand">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputColour">Colour</label>
                <input type="text" class="form-control" id="inputColour">
            </div>
            <div class="form-group col-md-6">
                <label for="inputBodyType">Body Type</label>
                <input type="text" class="form-control" id="inputBodyType">
            </div>
        </div>

<%--        <div class="form-group">--%>
<%--            <label for="inputColour">Colour</label>--%>
<%--            <input type="text" class="form-control" id="inputColour">--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="inputBodyType">Body Type</label>--%>
<%--            <input type="text" class="form-control" id="inputBodyType">--%>
<%--        </div>--%>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="inputPrice">Price</label>
                <input type="text" class="form-control" id="inputPrice">
            </div>
            <div class="form-group col-md-4">
                <label for="inputYear">Release year</label>
                <input type="text" class="form-control" id="inputYear">
            </div>
            <div class="form-group col-md-2">
                <label for="inputTransmission">Automatic Transmission</label>
                <select id="inputTransmission" class="form-control">
                    <option selected>Choose...</option>
                    <option>Yes</option>
                    <option>No</option>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="inputDriver">Driver</label>
                <select id="inputDriver" class="form-control">
                    <option selected>Choose...</option>
                    <option>Yes</option>
                    <option>No</option>
                </select>
<%--                <input type="text" class="form-control" id="inputDriver">--%>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Add car</button>
    </form>

</main>

</body>
</html>
