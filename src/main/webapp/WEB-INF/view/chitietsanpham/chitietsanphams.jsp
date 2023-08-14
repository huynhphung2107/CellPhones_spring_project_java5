<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@include file="../viewform/header.jsp" %>

<div class="container-fluid">
    <h1>Danh sách chi tiet san pham</h1>


    <a href="/chi-tiet-san-pham/viewadd" class="btn btn-success">Add</a>
    <table class="table table-bordered" style="border: 1px solid antiquewhite;text-align: center">


    <thead style="background-color: #3b5998">
        <tr>
            <th>STT</th>
            <th>Ten Sp</th>
            <th>Dong SP</th>
            <th>Mau Sac</th>
            <th>Noi San Xuat</th>
            <th>Nam BH</th>
            <th>MoTa</th>
            <th>So luong ton</th>
            <th>Gia Nhap</th>
            <th>Gia Ban</th>
            <th>Action</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSp.content}" var="sp"  varStatus="vitri">
            <tr>
                <td>${vitri.index}</td>
                <td>${sp.getTenSp()}</td>
                <td>${sp.getTenDongSp()}</td>
                <td>${sp.getTenMauSac()}</td>
                <td>${sp.gettenNsx()}</td>
                <td>${sp.getNamBh()}</td>
                <td>${sp.getMota()}</td>
                <td>${sp.getSoLuongTon()}</td>
                <td>${sp.getGiaNhap()}</td>
                <td>${sp.getGiaBan()}</td>
                <td>
                    <a class="btn btn-info" href="/chi-tiet-san-pham/detail/${sp.getId()}">Detail</a>
                    <a class="btn btn-primary" href="/chi-tiet-san-pham/viewupdate/${sp.getId()}">Update</a>
                    <a class="btn btn-danger" href="/chi-tiet-san-pham/remove/${sp.getId()}">Remove</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="/chi-tiet-san-pham/hien-thi?pageNo=0" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>
            <c:forEach var="i" begin="0" end="${listSp.totalPages-1}">
                <li class="page-item"><a class="page-link" href="/chi-tiet-san-pham/hien-thi?pageNo=${i}">${i+1}</a></li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="/chi-tiet-san-pham/hien-thi?pageNo=${listSp.totalPages-1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>
    </nav>
</div>

</body>
</html>
