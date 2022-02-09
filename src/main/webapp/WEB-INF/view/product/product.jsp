<%@ page contentType= "text/html; charset=windows-1251" language="java"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product</title>
</head>

<body>
<h2>Product id: ${product.id}</h2>
<h2>product title: ${product.title}</h2>
<h2>product cost: ${product.cost}</h2>
<c:url var="deleteUrl" value="/product/delete">
    <c:param name="id" value="${product.id}"/>
</c:url>

<a href="${deleteUrl}">DELETE</a>
<br>

<c:url var="editUrl" value="/product/edit">
    <c:param name="id" value="${product.id}"/>
</c:url>

<a href="${editUrl}">EDIT</a>

</body>

</html>