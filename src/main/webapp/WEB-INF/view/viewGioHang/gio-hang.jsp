<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Gio Hang</title>
</head>
<body>
<%@include file="../viewform/header.jsp" %>
<div class="container">
    <h3>Quan Ly Gio Hang</h3>
    <form action="/gio-hang/search" method="post">
        <h4>Tim Kiem Gio Hang</h4>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ma Gio Hang:</label>
            <div class="col-sm-8">
                <input type="text" name="maGioHang" class="form-control" placeholder="Nhap Ma Gio Hang Can Tim"/><br>
            </div>
            <div class="col-sm-2">
                <button class="btn btn-success" type="submit">Tim Kiem</button>
                <br>
            </div>
        </div>
    </form>
    <p>Ban Muon Them Gio Hang: <a href="/gio-hang/view-add" style="text-decoration: none">Them Gio
        Hang</a> Tai Day.</p>
    <table class="table table-bordered table-active">
        <thead class="table-dark">
        <tr>
            <td>STT</td>
            <td>Ho Va Ten Khach Hang</td>
            <td>Ho Va Ten Nhan Vien</td>
            <td>Ma Gio Hang</td>
            <td>Ngay Tao</td>
            <td>Dia Chi</td>
            <td>So Dien Thoai</td>
            <td>Tinh Trang</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbody class="table-hover">
        <c:forEach items="${listGioHang}" var="gioHang" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${gioHang.khachHang.ho} ${gioHang.khachHang.tenDem} ${gioHang.khachHang.ten}</td>
                <td>${gioHang.nhanVien.ho} ${gioHang.nhanVien.tenDem} ${gioHang.nhanVien.ten}</td>
                <td>
                    <a href="/gio-hang-chi-tiet/hien-thi/${gioHang.idGioHang}"
                       style="text-decoration: none">${gioHang.ma}</a>
                </td>
                <td>${gioHang.ngayTao}</td>
                <td>${gioHang.diaChi}</td>
                <td>${gioHang.sdt}</td>
                <td>${gioHang.layTrangThai()}</td>
                <td>
                    <a href="/gio-hang/delete/${gioHang.idGioHang}"
                       onclick="if(!confirm('Ban Muon Huy Gio Hang?')){return false}else{alert('Huy Thanh Cong');}">Huy
                        Gio Hang</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
