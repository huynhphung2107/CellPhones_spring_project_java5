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
    <h1>Danh sách Nhan vien</h1>


    <a href="/nhan-vien/viewadd" class="btn btn-success">Add</a>
    <table class="table table-bordered" style="border: 1px solid antiquewhite;text-align: center">


        <thead style="background-color: #3b5998">
        <tr>
            <th>Ma Nv</th>
            <th>Cua hang</th>
            <th>Chuc vu</th>
            <th>Ho va Ten</th>
            <th>Gioi tinh</th>
            <th>Ngay Sinh</th>
            <th>Dia Chi</th>
            <th>Trang thai</th>
            <th> action</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSp.content}" var="sp" varStatus="vt">
            <tr>
                <th>${sp.getMa()}</th>
                <td>${sp.getTenCh()}</td>
                <td>${sp.getTenCv()}</td>
                <td>${sp.getHoTen()} </td>
                <td>${sp.getGioiTinh()}</td>
                <td>${sp.getNgaySinh()}</td>
                <td>${sp.getDiaChi()}</td>
                <td>${sp.getTrangThai()}</td>
                <td>
                    <a class="btn btn-info" href="/nhan-vien/detail/${sp.getId()}">Detail</a>
                    <a class="btn btn-primary" href="/nhan-vien/viewupdate/${sp.getId()}">Update</a>
                    <a class="btn btn-danger" href="/nhan-vien/remove/${sp.getId()}">Remove</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="/nhan-vien/hien-thi?pageNo=0" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>
            <c:forEach var="i" begin="0" end="${listSp.totalPages-1}">
                <li class="page-item"><a class="page-link" href="/nhan-vien/hien-thi?pageNo=${i}">${i+1}</a></li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="/nhan-vien/hien-thi?pageNo=${listSp.totalPages-1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>
    </nav>
</div>

</body>
</html>
