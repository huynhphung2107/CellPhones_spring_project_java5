<%--
  Created by IntelliJ IDEA.
  User: Huynh
  Date: 3/25/2023
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>WEB BAN HANG</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<%--    <link rel="stylesheet" href="/view/Form.css">--%>
</head>
<body style="background: white">

<jsp:include page="zimg/header.jsp"/>
<div class="container mt-5">
    <div class="row">
        <div  class="col-md-3 col-xs-6">
            <div class="thumbnail">
                <h3 style="text-decoration: none;" >
                    <img src="zimg/kh.jpg" height="250px" alt="Lights" style="width:100%">
                    <p class="txtCap" style="text-align: center">Quản lý Khách Hàng</p>
                </h3>
                <div class="caption text-center">
                    <a href="/khachang/hienthi" class="btn btn-success">Đi Đến Trang</a>

                </div>
            </div>
        </div>
        <div  class="col-md-3 col-xs-6">
            <div class="thumbnail">
                <h3 style="text-decoration: none;" >
                    <img src="/zimg/nv.jpg" height="250px" alt="Lights" style="width:100%">
                    <p class="txtCap" style="text-align: center">Quản lý Sản Phẩm</p>
                </h3>
                <div class="caption text-center">
                    <a href="/sanpham/hienthi" class="btn btn-success">Đi Đến Trang</a>

                </div>
            </div>
        </div>
        <div  class="col-md-3 col-xs-6">
            <div class="thumbnail">
                <h3 style="text-decoration: none;" >
                    <img src="/zimg/sp.jpg" height="250px" alt="Lights" style="width:100%">
                    <p class="txtCap" style="text-align: center">Quản lý Cửa Hàng</p>
                </h3>
                <div class="caption text-center">
                    <a href="/cuahan/hienthi" class="btn btn-success">Đi Đến Trang</a>

                </div>
            </div>
        </div>
        <div  class="col-md-3 col-xs-6">
            <div class="thumbnail">
                <h3 style="text-decoration: none;" >
                    <img src="/zimg/ctsp.jpg" height="250px" alt="Lights" style="width:100%">
                    <p class="txtCap" style="text-align: center">Quản lý Nhân Viên </p>
                </h3>
                <div class="caption text-center">
                    <a href="/nhanvien/hienthi" class="btn btn-success">Đi Đến Trang</a>

                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div  class="col-md-3 col-xs-6">
            <div class="thumbnail">
                <h3 style="text-decoration: none;" >
                    <img src="/zimg/nsx.jpg" height="250px" alt="Lights" style="width:100%">
                    <p class="txtCap" style="text-align: center">Quản lý Chức Vụ</p>
                </h3>
                <div class="caption text-center">
                    <a href="/chucvu/hienthi" class="btn btn-success">Đi Đến Trang</a>

                </div>
            </div>
        </div>
        <div  class="col-md-3 col-xs-6">
            <div class="thumbnail">
                <h3 style="text-decoration: none;" >
                    <img src="/zimg/dsp.jpg" height="250px" alt="Lights" style="width:100%">
                    <p class="txtCap" style="text-align: center">Quản lý Màu Sắc</p>
                </h3>
                <div class="caption text-center">
                    <a href="/mausac/hienthi" class="btn btn-success">Đi Đến Trang</a>

                </div>
            </div>
        </div>
        <div  class="col-md-3 col-xs-6">
            <div class="thumbnail">
                <h3 style="text-decoration: none;" >
                    <img src="/zimg/cv.jpg" height="250px" alt="Lights" style="width:100%">
                    <p class="txtCap" style="text-align: center">Quản lý Dòng SP</p>
                </h3>
                <div class="caption text-center">
                    <a href="/dongsp/hienthi" class="btn btn-success">Đi Đến Trang</a>

                </div>
            </div>
        </div>
        <div  class="col-md-3 col-xs-6">
            <div class="thumbnail">
                <h3 style="text-decoration: none;" >
                    <img src="/zimg/ch.jpg" height="250px" alt="Lights" style="width:100%">
                    <p class="txtCap" style="text-align: center">Quản lý Nhà Sản Xuất</p>
                </h3>
                <div class="caption text-center">
                    <a href="/nsx/hienthi" class="btn btn-success">Đi Đến Trang</a>

                </div>
            </div>
        </div>
        <div  class="col-md-3 col-xs-6">
            <div class="thumbnail">
                <h3 style="text-decoration: none;" >
                    <img src="/zimg/ms.jpg" height="250px" alt="Lights" style="width:100%">
                    <p class="txtCap" style="text-align: center">Quản lý Chi Tiết SP</p>
                </h3>
                <div class="caption text-center">
                    <a href="/chitietsanpham/hienthi" class="btn btn-success">Đi Đến Trang</a>

                </div>
            </div>
        </div>
    </div>

</div>
<div class="footer">
    <jsp:include page="zimg/footer.jsp"/>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>

</body>
</html>
