<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Them Chi Tiet Gio Hang</title>
</head>
<body>
<%@include file="../viewform/header.jsp" %>
<div class="container" style="height: 500px;">
    <h3>Them Chi Tiet Gio Hang</h3>
    <p>
        Ban Khong Muon Them Nua: <a href="/gio-hang/hien-thi" style="text-decoration: none">Ve Trang
        Chu</a><br>
    </p>
    <p>Ban Muon Them San Pham Vao Gio Hang Chi Tiet: <a href="/gio-hang-chi-tiet/view-add-san-pham"
                                                        style="text-decoration: none">Them San Pham</a> Tai Day.</p>
    <table class="table table-bordered table-active">
        <thead class="table-dark">
        <tr>
            <td>STT</td>
            <td>Ten San Pham</td>
            <td>So Luong</td>
            <td>Don Gia</td>
            <td>Thanh Tien</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbody class="table-hover">
        <c:forEach items="${listGioHangChiTietById}" var="gioHangChiTiet" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${gioHangChiTiet.idGioHangChiTiet.chiTietSP.sanPham.tenSanPham}</td>
                <td>${gioHangChiTiet.soLuong}</td>
                <td>${gioHangChiTiet.donGia}</td>
                <td>${gioHangChiTiet.thanhTien()}</td>
                <td>
                    <a href="gio-hang-chi-tiet/delete/${gioHangChiTiet.idGioHangChiTiet.chiTietSP.sanPham.tenSanPham}"
                       onclick="if(!confirm('Ban Muon Xoa?')){return false}else{alert('Xoa Thanh Cong');}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
