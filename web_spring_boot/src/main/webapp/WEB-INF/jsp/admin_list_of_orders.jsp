<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<main>
    <table class="table align-middle">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Model and Brand</th>
            <th scope="col">Сolour</th>
            <th scope="col">Year Realize</th>
            <th scope="col">First and Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Date Start</th>
            <th scope="col">Date Finish</th>
            <th scope="col">Amount Of Days</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listOrders}" var="order">
        <tr>
            <td><c:out value="${order.model} ${user.lastName}"/></td>
            <td>Sit</td>
            <td>Amet</td>
            <td>
                <a class="nav-link" href="${pageContext.request.contextPath}/admin_delete_order/${user.userId}.view">
                    <button type="button" class="btn btn-link btn-sm px-3" data-ripple-color="dark">
                        <i class="fas fa-times"></i>
                    </button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>



    <ul class="push">
        <li>
            <a class="nav-link" href="${pageContext.request.contextPath}/edit_personal_info/${admin.userId}.view">
                Here you can edit your information.
            </a>
        </li>
        <li>
            <a class="nav-link" href="${pageContext.request.contextPath}/admin_list_of_users.view">
                List of users.
            </a>
        </li>
        <li>Элемент списка</li>
        <li>Элемент списка</li>
        <li>Элемент списка</li>
    </ul>

</main>

</body>
</html>