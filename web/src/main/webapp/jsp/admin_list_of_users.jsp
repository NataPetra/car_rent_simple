<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        table{
            border-collapse: collapse;
            width: 100%;
        }
        th,td{
            border: 2px solid green;
            padding: 15px;
        }
    </style>
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<main>
    <table>
        <tr>
            <th>First and Last Name</th>
            <th>Birth Day</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
        <tr>
            <td><c:out value="${user.firstName} ${user.lastName}"/></td>
            <td><c:out value="${user.birthDay}"/></td>
            <td><c:out value="${user.phoneNumber}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.roleName}"/></td>
            <td>
                <a class="nav-link" href="${pageContext.request.contextPath}/admin_delete_user/${user.userId}.view">
                <button type="button" class="btn btn-danger">Delete user</button>
                </a>
                <a class="nav-link" href="${pageContext.request.contextPath}/admin_update_user/${user.userId}.view">
                    <button type="button" class="btn btn-warning">Edit user</button>
                </a>
            </td>
        </tr>
        </c:forEach>
    </table>

</main>

</body>
</html>