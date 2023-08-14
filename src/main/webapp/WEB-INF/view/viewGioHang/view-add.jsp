<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="shortcut icon" href="../image/logo.png" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Tao Gio Hang</title>
</head>
<body>
<%@include file="../viewform/header.jsp" %>
<div class="container" style="height: 800px;">
    <h3>Tao Gio Hang</h3>
    <p>
        Ban Khong Muon Tao Nua: <a href="/gio-hang/hien-thi" style="text-decoration: none">Ve Trang
        Chu</a><br>
    </p>
    <form:form action="/gio-hang/add" method="post" modelAttribute="addGioHang"
               onsubmit="if(!confirm('Ban Muon Tao Gio Hang?')){
                            return false
                        }else{
                            alert('Tao Gio Hang Thanh Cong');
                        }">
        <div class="form-group row">
            <form:label path="khachHang" class="col-sm-2 col-form-label">Ho Va Ten Khach Hang: </form:label>
            <div class="col-sm-6">
                <select name="khachHang" ${addGioHang.khachHang} class="form-control">
                    <c:forEach items="${listKhachHang}" var="cbbKhachHang">
                        <option value="${cbbKhachHang.id}">${cbbKhachHang.ho} ${cbbKhachHang.tenDem} ${cbbKhachHang.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-4">
                <p>
                    Ban Muon Xem Danh Sach Khach Hang:
                    <a href="/khach-hang/hien-thi" style="text-decoration: none">Xem Tai Day</a>
                </p>
            </div>
        </div>
        <br>

        <div class="form-group row">
            <form:label path="nhanVien" class="col-sm-2 col-form-label">Ho Va Ten Nhan Vien: </form:label>
            <div class="col-sm-6">
                <select name="nhanVien" ${addGioHang.nhanVien} class="form-control">
                    <c:forEach items="${listNhanVien}" var="cbbNhanVien">
                        <option value="${cbbNhanVien.id}">${cbbNhanVien.ho} ${cbbNhanVien.tenDem} ${cbbNhanVien.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-4">
                <p>
                    Ban Muon Xem Danh Sach Nhan Vien:
                    <a href="/nhan-vien/hien-thi" style="text-decoration: none">Xem Tai Day</a>
                </p>
            </div>
        </div>
        <br>

        <div class="form-group row">
            <form:label path="tenNguoiNhan" class="col-sm-2 col-form-label">Ten Nguoi Nhan:</form:label>
            <div class="col-sm-10">
                <input type="text" name="tenNguoiNhan" value="${addGioHang.tenNguoiNhan}" class="form-control"
                       placeholder="Nhap Ten Nguoi Nhan"/>
            </div>
        </div>
        <br>

        <div class="form-group row">
            <form:label path="diaChi" class="col-sm-2 col-form-label">Dia Chi:</form:label>
            <div class="col-sm-10">
                <input type="text" name="diaChi" value="${addGioHang.diaChi}" class="form-control"
                       placeholder="Nhap Dia Chi"/>
            </div>
        </div>
        <br>

        <div class="form-group row">
            <form:label path="sdt" class="col-sm-2 col-form-label">SDT:</form:label>
            <div class="col-sm-10">
                <input type="text" name="sdt" value="${addGioHang.sdt}" class="form-control"
                       placeholder="Nhap So Dien Thoai"/>
            </div>
        </div>
        <br>

        <form:button class="btn btn-primary" type="reset">Lam Moi</form:button>
        <form:button class="btn btn-success" onsubmit="" type="submit">Tao Gio Hang</form:button>
    </form:form>
</div>
</body>
</html>
