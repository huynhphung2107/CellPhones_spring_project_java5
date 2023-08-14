<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel="shortcut icon" href="../static/iphone14" type="image/x-icon">
    <title>CellPhonex</title>
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css' rel='stylesheet'>
    <link href='https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css' rel='stylesheet'>
    <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src="https://kit.fontawesome.com/600f0dcfd4.js" crossorigin="anonymous"></script>
    <style>
        ::-webkit-scrollbar {
            width: 8px;
        }

        /* Track */
        ::-webkit-scrollbar-track {
            background: #f1f1f1;
        }

        /* Handle */
        ::-webkit-scrollbar-thumb {
            background: #888;
        }

        /* Handle on hover */
        ::-webkit-scrollbar-thumb:hover {
            background: #555;
        }

        @import url("https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap");

        :root {
            --header-height: 3rem;
            --nav-width: 68px;
            --first-color: #4723D9;
            --first-color-light: #AFA5D9;
            --white-color: #F7F6FB;
            --body-font: 'Nunito', sans-serif;
            --normal-font-size: 1rem;
            --z-fixed: 100
        }

        *,
        ::before,
        ::after {
            box-sizing: border-box
        }

        body {
            position: relative;
            margin: var(--header-height) 0 0 0;
            padding: 0 1rem;
            font-family: var(--body-font);
            font-size: var(--normal-font-size);
            transition: .5s
        }

        a {
            text-decoration: none
        }

        .header {
            width: 100%;
            height: var(--header-height);
            position: fixed;
            top: 0;
            left: 0;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 1rem;
            background-color: var(--white-color);
            z-index: var(--z-fixed);
            transition: .5s
        }

        .header_toggle {
            color: var(--first-color);
            font-size: 1.5rem;
            cursor: pointer
        }

        .header_img {
            width: 35px;
            height: 35px;
            display: flex;
            justify-content: center;
            border-radius: 80%;
            overflow: hidden
        }

        .header_img img {
            width: 40px
        }

        .l-navbar {
            position: fixed;
            top: 0;
            left: -30%;
            width: var(--nav-width);
            height: 100vh;
            background-color: #3b5998;
            padding: .5rem 1rem 0 0;
            transition: .5s;
            z-index: var(--z-fixed)
        }

        .nav {
            height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            overflow: hidden
        }

        .nav_logo,
        .nav_link {
            display: grid;
            grid-template-columns: max-content max-content;
            align-items: center;
            column-gap: 1rem;
            padding: .5rem 0 .5rem 1.5rem
        }

        .nav_logo {
            margin-bottom: 2rem
        }

        .nav_logo-icon {
            font-size: 1.25rem;
            color: var(--white-color)
        }

        .nav_logo-name {
            color: var(--white-color);
            font-weight: 700
        }

        .nav_link {
            position: relative;
            color: var(--first-color-light);
            margin-bottom: 1.5rem;
            transition: .3s
        }

        .nav_link:hover {
            color: var(--white-color)
        }

        .nav_icon {
            font-size: 1.25rem
        }

        .show {
            left: 0
        }

        .body-pd {
            padding-left: calc(var(--nav-width) + 1rem)
        }

        .active {
            color: var(--white-color)
        }

        .active::before {
            content: '';
            position: absolute;
            left: 0;
            width: 2px;
            height: 32px;
            background-color: var(--white-color)
        }

        .height-100 {
            height: 100vh
        }

        @media screen and (min-width: 768px) {
            body {
                margin: calc(var(--header-height) + 1rem) 0 0 0;
                padding-left: calc(var(--nav-width) + 2rem)
            }

            .header {
                height: calc(var(--header-height) + 1rem);
                padding: 0 2rem 0 calc(var(--nav-width) + 2rem)
            }

            .header_img {
                width: 40px;
                height: 40px
            }

            .header_img img {
                width: 45px
            }

            .l-navbar {
                left: 0;
                padding: 1rem 1rem 0 0
            }

            .show {
                width: calc(var(--nav-width) + 156px)
            }

            .body-pd {
                padding-left: calc(var(--nav-width) + 188px)
            }
        }

        .glow {
            animation: glow-animation 1s infinite;
        }

        @keyframes glow-animation {
            0% {
                color: #fff;
                text-shadow: 0 0 5px #fff;
            }
            50% {
                color: #ffcc00;
                text-shadow: 0 0 20px #ffcc00;
            }
            100% {
                color: #fff;
                text-shadow: 0 0 5px #fff;
            }
        }

        .rainbow-text {
            /*font-size: 80px;*/
            font-family: "Copperplate Gothic Bold";
            font-weight: bold;
            animation: rainbow-animation 1s linear infinite;
        }

        @keyframes rainbow-animation {
            0% {
                color: red;
            }
            14% {
                color: orange;
            }
            28% {
                color: yellow;
            }
            42% {
                color: green;
            }
            57% {
                color: blue;
            }
            71% {
                color: indigo;
            }
            85% {
                color: violet;
            }
            100% {
                color: red;
            }
        }
        .animated-text {
            display: inline-block;
            overflow: hidden;
        }

        .animated-text span {
            animation: slide-animation 2s linear infinite;
            white-space: nowrap;
        }

        @keyframes slide-animation {
            0% {
                transform: translateX(-100%);
            }
            100% {
                transform: translateX(100%);
            }
        }
    </style>
</head>
<jsp:include page="../viewform/content.jsp"></jsp:include>
<body className='snippet-body'>

<body id="body-pd">
<header class="header" id="header">
    <div class="header_toggle"><i class='bx bx-menu' id="header-toggle"> </i>

    </div>
    <h3 class="">CellPhoneX-Trang quản trị</h3>
    <div class="header_imga">
        <%--        <img src="" alt="">--%>
        <span class="glyphicon glyphicon-user">&nbsp;</span>Xin chào: Huỳnh</a>
        <a href="<c:url value="/login" />"><span class="glyphicon glyphicon-log-out"></span> Đăng xuất</a>
    </div>
</header>
<div class="l-navbar" id="nav-bar">
    <nav class="nav">
        <div><a href="#" class="nav_logo"><i
                class='bx bx-layer nav_logo-icon'></i><span class="nav_logo-name">CellPhonex</span></a>
            <div class="nav_list">
                <a href="/dashboard/home" class="nav_link"><i class="fa fa-home" aria-hidden="true"></i><span
                        class="nav_name">Trang chủ</span> </a>
                <a href="/nhan-vien/hien-thi" class="nav_link"><i
                        class='bx bx-user nav_icon'></i><span class="nav_name">Nhân viên</span> </a>
                <a href="/khach-hang/hien-thi" class="nav_link"><i
                        class='bx bx-male-female nav_icon'></i><span class="nav_name">Khách hàng</span> </a>
                <a href="/san-pham/hien-thi" class="nav_link"><i
                        class='bx bx-outline nav_icon'></i><span class="nav_name">Sản phẩm</span> </a>
                <a href="/chi-tiet-san-pham/hien-thi" class="nav_link"><i
                        class='bx bx-barcode-reader nav_icon'></i><span class="nav_name">Chi tiết sản phẩm</span> </a>
                <a href="/gio-hang/hien-thi" class="nav_link"><i
                        class='bx bx-fingerprint nav_icon'></i><span class="nav_name">Gio Hang</span> </a>
                <a href="/home" class="nav_link"><i class='bx bx-cart nav_icon'></i><span
                        class="nav_name">Quản lý danh mục</span> </a>
                <a href="#" class="nav_link"><i class='bx bx-log-out nav_icon'></i> <span
                        class="nav_name">SignOut</span> </a>
            </div>
        </div>
    </nav>

</div>


<script type='text/javascript'
        src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js'></script>
<script type='text/javascript' src='#'></script>
<script type='text/javascript' src='#'></script>
<script type='text/javascript' src='#'></script>
<script type='text/javascript'>
    document.addEventListener("DOMContentLoaded", function (event) {
        const showNavbar = (toggleId, navId, bodyId, headerId) => {
            const toggle = document.getElementById(toggleId),
                nav = document.getElementById(navId),
                bodypd = document.getElementById(bodyId),
                headerpd = document.getElementById(headerId)
            if (toggle && nav && bodypd && headerpd) {
                toggle.addEventListener('click', () => {
                    nav.classList.toggle('show')
                    toggle.classList.toggle('bx-x')
                    bodypd.classList.toggle('body-pd')
                    headerpd.classList.toggle('body-pd')
                })
            }
        }
        showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header')
        const linkColor = document.querySelectorAll('.nav_link')

        function colorLink() {
            if (linkColor) {
                linkColor.forEach(l => l.classList.remove('active'))
                this.classList.add('active')
            }
        }

        linkColor.forEach(l => l.addEventListener('click', colorLink))
    });
</script>
<script type='text/javascript'>var myLink = document.querySelector('a[href="#"]');
myLink.addEventListener('click', function (e) {
    e.preventDefault();
});
</script>
</body>

</body>
<style></style>
</html>