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
    <c:set value="${appUser}" var="user"/>
    <form method="post" action="${pageContext.request.contextPath}/edit_personal_info/${user.userId}.action">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="firstName">First Name</label>
                <input type="text" name="firstName" class="form-control" id="firstName" value="<c:out value="${user.firstName}"/>">
            </div>
            <div class="form-group col-md-6">
                <label for="lastName">Last Name</label>
                <input type="text" name="lastName" class="form-control" id="lastName" value="<c:out value="${user.lastName}"/>">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="birthDay">Birth Day</label>
                <input type="text" name="birthDay" class="form-control" id="birthDay" value="<c:out value="${user.birthDay}"/>">
            </div>
            <div class="form-group col-md-4">
                <label for="phoneNumber">Phone Number</label>
                <input type="text" name="phoneNumber" class="form-control" id="phoneNumber" value="<c:out value="${user.phoneNumber}"/>">
            </div>
            <div class="form-group col-md-2">
                <label for="email">Email</label>
                <input type="email" name="email" class="form-control" id="email" value="<c:out value="${user.email}"/>">
            </div>
            <div class="form-group col-md-2">
                <label for="password">Password</label>
                <input type="text" name="password" class="form-control" id="password" value="<c:out value="${user.password}"/>">
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Update personal info</button>
    </form>

</main>

</body>
</html>
