<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body><%@include file="../viewform/header.jsp" %>

<div class="container">
    <h1>
        Them noi san xuat
    </h1>
    <form:form action="/noi-san-xuat/add" method="post" modelAttribute="noiSanXuat">
        <div class="form-group">
            <label>Ma</label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="ma"/>
            <form:errors cssStyle="color:red;" path="ma"/>
        </div>

        <div class="form-group">
            <label>Ten</label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="ten"/>
            <form:errors cssStyle="color:red;" path="ten"/>
        </div>
        <button type="submit" class="btn btn-primary"> Add
        </button>
    </form:form>

</div>
</body>
</html>
