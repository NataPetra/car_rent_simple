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
      <th scope="col">Model</th>
      <th scope="col">Brand</th>
      <th scope="col">Сolour</th>
      <th scope="col">Year Realize</th>
      <th scope="col">Count of orders</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCars}" var="car">
      <tr>
        <td><c:out value="${car.id}"/></td>
        <td><c:out value="${car.model}"/></td>
        <td><c:out value="${car.brand}"/></td>
        <td><c:out value="${car.colour}"/></td>
        <td><c:out value="${car.yearRealize}"/></td>
        <td>
          <a class="nav-link" href="${pageContext.request.contextPath}/admin_one_car_orders/${car.id}.view">
            <c:out value="${car.countOfOrders}"/>
          </a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

      <nav aria-label="Page navigation">
          <ul class="pagination justify-content-center">
              <c:forEach items="${pages}" var="pages">
                  <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/admin_list_of_car_with_orders/${pages}.view">${pages}</a></li>
              </c:forEach>
          </ul>
      </nav>

</main>

</body>
</html>
