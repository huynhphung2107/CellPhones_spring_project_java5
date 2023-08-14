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

<div class="container">
    <h1>Danh sách sản phẩm</h1>


<%--    <a href="/san-pham/home" class="btn btn-danger">Home</a>--%>
    <a href="/san-pham/viewadd" class="btn btn-success">Add</a>
    <table class="table table-bordered" style="border: 1px solid antiquewhite;text-align: center">


        <thead style="background-color: #3b5998">
        <tr>
            <th>Stt</th>
<%--            <th>Image</th>--%>
            <th>Ma</th>
            <th>Ten</th>
            <th>Chuc nang</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSp.content}" var="sp" varStatus="vt">
            <tr>
                <th>${vt.index}</th>
<%--                <td><img src="/static/zimg/+${sp.image}" alt="Product Image" style="width: 200px;height: 100px"></td>--%>
                <td>${sp.ma}</td>
                <td>${sp.ten}</td>
                <td>
                    <a class="btn btn-info" href="/san-pham/detail/${sp.id}">Detail</a>
                    <a class="btn btn-primary" href="/san-pham/viewupdate/${sp.id}">Update</a>
                    <a class="btn btn-danger" href="/san-pham/remove/${sp.id}">Remove</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="/san-pham/hien-thi?pageNo=0" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>
            <c:forEach var="i" begin="0" end="${listSp.totalPages-1}">
                <li class="page-item"><a class="page-link" href="/san-pham/hien-thi?pageNo=${i}">${i+1}</a></li>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="/san-pham/hien-thi?pageNo=${listSp.totalPages-1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>
    </nav>
</div>

</body>
</html>
