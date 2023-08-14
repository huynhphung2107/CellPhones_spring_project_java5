<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Chi Tiet San Pham</title>
</head>
<body>
<%@include file="../viewform/header.jsp" %>
<div class="container">
    <h3>Danh Sach San Pham Chi Tiet De Add Cho Hoa
        Don</h3>
    <table class="table table-bordered table-active container">
        <thead class="table-dark">
        <tr>
            <td>STT</td>
            <td>Ten San Pham</td>
            <td>So Luong Ton</td>
            <td>Gia Ban</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbody class="table-hover">
        <c:forEach items="${listSanPhamAddToCart}" var="ctsp" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${ctsp.sanPham.ten}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.giaBan}</td>
                <td>
                    <a href="/gio-hang-chi-tiet/addtocart/${ctsp.getId()}">Add To Cart</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
