<%@ page contentType= "text/html; charset=windows-1251" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>product list</title>
</head>

<body>
<h1>product list</h1>
<url>
  <c:forEach var="product" items="${products}">
      <c:url var="viewUrl" value="/product/ +${product.id}"/>
      <li>
        <a href="${viewUrl}">View</a>
        <br>
        Product id: ${product.id}
        <br>
        Product title: ${product.title}
        <br>
        Product cost: ${product.cost}
        <br>
      </li>
  </c:forEach>

</url>
<br>
<c:url var="createUrl" value="/product/create"/>

<a href="${createUrl}">CREATE</a>

</body>

</html>