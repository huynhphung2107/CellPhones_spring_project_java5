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
        Them Nhan vien
    </h1>
    <form:form action="/nhan-vien/add" method="post" modelAttribute="nhanVien">

        <div class="form-group">
            <label>Id</label>
            <br>
            <form:input cssClass="form-control"  readonly="true" cssStyle="width: 400px" path="id"/>
            <form:errors cssStyle="color:red;" path="id"/>

        </div>

        <div class="form-group">
            <label>ma</label>
            <br>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="ma"/>
            <form:errors cssStyle="color:red;" path="ma"/>

        </div>

        <div class="form-group">
            <label>Cua hang</label>
            <br>
            <select name="idCuaHang" style="width: 400px;" class="form-control">
                <br>
                <c:forEach items="${listCh}" var="sp">
                    <option value="${sp.id}"> ${sp.ten}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Chuc Vu</label>
            <br>

            <select name="idChucvu" style="width: 400px;" class="form-control">
                <c:forEach items="${listCv}" var="sp">
                    <option value="${sp.id}"> ${sp.ten}</option>
                </c:forEach>
            </select>
        </div>


        <div class="form-group">
            <label>Ho</label>
            <br>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="ho"/>
            <form:errors cssStyle="color:red;" path="ho"/>

        </div>

        <div class="form-group">
            <label>Ten dem</label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="tenDem"/>
            <form:errors cssStyle="color:red;" path="tenDem"/>
        </div>

        <div class="form-group">
            <label>Ten </label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="ten"/>
            <form:errors cssStyle="color:red;" path="ten"/>
        </div>

        <div class="form-group">
            <br>
            <label>GioiTinh</label>
            <input type="radio" value="Nam" name="gioiTinh" checked>Nam
            <input type="radio" value="Nu" name="gioiTinh">Nu
        </div>
        <br>
        <div class="form-group">
            <label>Ngay Sinh</label>
            <br>
            <input type="date" name="ngaySinh" class="form-control" style="width: 400px;">
        </div>
        <div class="form-group">
            <label>Dia Chi</label>
            <form:input cssClass="form-control" cssStyle="width: 400px" path="diaChi"/>
            <form:errors cssStyle="color:red;" path="diaChi"/>
        </div>
        <div class="form-group">
            <label>Trang thai</label>
            <input type="radio" value="1" checked name="trangThai">Hoat Dong
            <input type="radio" value="2" name="trangThai">Ngung hoat dong
        </div>


        <button type="submit" class="btn btn-primary"> Add
        </button>
        <a href="/nhan-vien/hien-thi" class="btn btn-danger">Quay lại</a>
    </form:form>

</div>
</body>
</html>
