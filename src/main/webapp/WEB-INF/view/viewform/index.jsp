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

<%--        <link rel="stylesheet" href="/viewform/zform.css">--%>
</head>
<body >

<jsp:include page="zimg/header.jsp"/>

<div class="container-fluid">
    <div class="col-10">
        <jsp:include page="${view}"/>
    </div>

</div>

<footer style="
 position: absolute;
 bottom: 0;
 width: 100%;" class="footer">
    <jsp:include page="zimg/footer.jsp"/>
</footer>



</body>
</html>
