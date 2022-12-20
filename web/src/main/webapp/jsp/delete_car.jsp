<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<%--    <div class="card">--%>
<%--        <div class="card-body">--%>
<%--            <h5 class="card-title">Card title</h5>--%>
<%--            <p class="card-text"><c:out value="${car.modelName} ${car.brandName}"/> Some quick example text to build on the card title and make up the bulk of the card's content.</p>--%>
<%--            <a class="nav-link" href="/car_rent/delete_confirm/{car.id}.action">--%>
<%--            <button type="button" class="btn btn-primary">Button</button>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--    </div>--%>

<c:set value="${autoCommonBean}" var="car"/>
<%--<div class="modal" tabindex="-1" role="dialog">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <h5 class="modal-title">Modal title</h5>--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                    <span aria-hidden="true">&times;</span>--%>
<%--                </button>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <p> <c:out value="${car.modelName} ${car.brandName}"/> Modal body text goes here.</p>--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <a class="nav-link" href="/car_rent/delete_confirm/{car.id}.action">--%>
<%--                <button type="button" class="btn btn-primary">Save changes</button>--%>
<%--                </a>--%>
<%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="container">--%>
<%--    <h2>Small Modal</h2>--%>
<%--    <!-- Button to Open the Modal -->--%>
<%--    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">--%>
<%--        Open modal--%>
<%--    </button>--%>
<%--<div class="modal fade" id="myModal">--%>
<%--    <div class="modal-dialog modal-sm">--%>
<%--        <div class="modal-content">--%>

<%--            <!-- Modal Header -->--%>
<%--            <div class="modal-header">--%>
<%--                <h4 class="modal-title">Modal Heading</h4>--%>
<%--                <button type="button" class="close" data-dismiss="modal">×</button>--%>
<%--            </div>--%>

<%--            <!-- Modal body -->--%>
<%--            <div class="modal-body">--%>
<%--                Modal body.. <c:out value="${car.modelName} ${car.brandName}"/>--%>
<%--            </div>--%>

<%--            <!-- Modal footer -->--%>
<%--            <div class="modal-footer">--%>
<%--                <a class="nav-link" href="/car_rent/delete_confirm/{car.id}.action">--%>
<%--                    <button type="button" class="btn btn-primary">Save changes</button>--%>
<%--                </a>--%>
<%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--            </div>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--</div>--%>

</body>
</html>
