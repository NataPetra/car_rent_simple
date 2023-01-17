<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <table style="width:100%" class="table">
        <tr>
            <th>Your order has been successfully created</th>
        </tr>
            <tr>
                <td><a href="${pageContext.request.contextPath}/report">Get the Report</a></td>
            </tr>
    </table>

</main>

</body>
</html>

