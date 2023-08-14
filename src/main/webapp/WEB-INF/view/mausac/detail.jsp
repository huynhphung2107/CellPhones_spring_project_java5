<%--
  Created by IntelliJ IDEA.
  User: Huynh
  Date: 3/30/2023
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body><%@include file="../viewform/header.jsp" %>

<div class="container">
    <h1>Chi tiết mau sac</h1>
    <div class="form-group">
        <label >ID:</label>
        <label class="form-control">${sp.id}</label>
    </div>
    <div class="form-group">
        <label>Mã:</label>
        <label class="form-control">${sp.ma}</label>
    </div>
    <div class="form-group">
        <label>Tên:</label>
        <label class="form-control">${sp.ten}</label>
    </div>
</div>
</body>
</html>
