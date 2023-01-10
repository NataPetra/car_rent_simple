<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/order_list.css" rel="stylesheet">
</head>
<body>

<header>
    <%@include file="header_of_page.jsp" %>
</header>

<main>
    <c:if test="${orders!=null}">
    <dl class="holiday">
        <c:forEach items="${orders}" var="order">
        <dt> <c:out value="${order.dateStart} - ${order.dateFinish}"/></dt>
        <dd><c:out value="You rented ${order.modelName} ${order.brandName}, ${order.releaseYear}."/></dd>
        </c:forEach>
    </dl>
    </c:if>
    <h6>
        No more orders
    </h6>

</main>

</body>
</html>