<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body><%@include file="../viewform/header.jsp" %>

<div class="container">
    <h1>
        Update cua hang
    </h1>
    <form:form action="/cua-hang/update" method="post" modelAttribute="cuaHang">
        <div class="form-group">
            <label>Id</label>
            <form:input readonly="true" cssClass="form-control" cssStyle="width: 400px" path="id" value="${sp.id}"/>
        </div>

        <div class="form-group">
            <label>Ma</label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="ma" value="${sp.ma}"/>
            <form:errors cssStyle="color:red;" path="ma"/>
        </div>

        <div class="form-group">
            <label>Ten</label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="ten" value="${sp.ten}"/>
            <form:errors cssStyle="color:red;" path="ten"/>
        </div>
        <button type="submit" class="btn btn-primary"> Update
        </button>
    </form:form>

</div>
</body>
</html>
