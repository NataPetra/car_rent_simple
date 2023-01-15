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
    <c:set value="${userCommonBean}" var="user"/>
    <form method="post" action="${pageContext.request.contextPath}/admin_update_user/${user.userId}.action">

        <div class="form-row">
            <div class="form-group col-md-2">
                <label for="roleName">Role</label>
                <select id="roleName" class="form-control" type="text" name="roleName" >
                    <option value="SIMPLE_USER">SIMPLE_USER</option>
                    <option value="ADMIN">ADMIN</option>
                </select>
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Update info</button>
    </form>

</main>

</body>
</html>
