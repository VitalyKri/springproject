<%@ page contentType= "text/html; charset=windows-1251" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html lang="en">

<head>
    <meta http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create product</title>
</head>

<body>
<form:form action="create" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
    cost: <form:input path="cost"/>
    <br>
    title: <form:textarea  path="title"/>
    <br>
    manufacturer: <form:textarea  path="manufacturer.id"/>
    <br>
    manufacturer name: <form:textarea readonly="true"  path="manufacturer.name"/>
    <br>
    <input type="submit" value="Save"/>
</form:form>

</body>

</html>