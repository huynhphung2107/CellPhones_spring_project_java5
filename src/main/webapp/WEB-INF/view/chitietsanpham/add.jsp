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
<body>
<%@include file="../viewform/header.jsp" %>
<div class="container">


    <h1>
        Them san pham chi tiet
    </h1>
    <form:form action="/chi-tiet-san-pham/add" method="post" modelAttribute="chiTietSanPham">
        <div class="form-group">
            <label>TenSp</label>
            <br>
            <select name="idSp" style="width: 400px;" class="form-control">
                <br>
                <c:forEach items="${listSp1}" var="sp">
                    <option value="${sp.id}"> ${sp.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Dong Sp</label>
            <br>

            <select name="idDongSp" style="width: 400px;" class="form-control">
                <c:forEach items="${listDsp}" var="sp">
                    <option value="${sp.id}"> ${sp.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Mau Sac</label>
            <br>

            <select name="idMauSac" style="width: 400px;" class="form-control">
                <c:forEach items="${listMs}" var="sp">
                    <option value="${sp.id}"> ${sp.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Noi San Xuat</label>
            <br>

            <select name="idNoiSanXuat" style="width: 400px;" class="form-control">
                <c:forEach items="${listNsx}" var="sp">
                    <option value="${sp.id}"> ${sp.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Nam bh</label>
            <br>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="namBh"/>
            <form:errors cssStyle="color:red;" path="namBh"/>

        </div>

        <div class="form-group">
            <label>Mo ta</label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="moTa"/>
            <form:errors cssStyle="color:red;" path="moTa"/>
        </div>

        <div class="form-group">
            <label>So Luong Ton</label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="soLuongTon"/>
            <form:errors cssStyle="color:red;" path="soLuongTon"/>
        </div>
        <div class="form-group">
            <label>Gia Nhap</label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="giaNhap"/>
            <form:errors cssStyle="color:red;" path="giaNhap"/>
        </div>
        <div class="form-group">
            <label>Gia ban</label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="giaBan"/>
            <form:errors cssStyle="color:red;" path="giaBan"/>
        </div>
        <button type="submit" class="btn btn-primary"> Add
        </button>
        <a href="/chi-tiet-san-pham/hien-thi" class="btn btn-danger">Quay lại</a>

    </form:form>

</div>
</body>
</html>
