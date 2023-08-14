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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%@include file="../viewform/header.jsp" %>

  <div class="container">
      <h1>Chi tiết sản phẩm</h1>
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
          <label class="form-control">${sp.tenSp}</label>
      </div>
  </div>
</body>
</html>
