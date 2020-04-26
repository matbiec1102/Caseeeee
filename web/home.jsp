<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Book Store - Home</title>
    <meta content="" name="descriptison">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="Squadfree/assets/img/favicon.png" rel="icon">
    <link href="Squadfree/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="Squadfree/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="Squadfree/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
    <link href="Squadfree/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="Squadfree/assets/vendor/venobox/venobox.css" rel="stylesheet">
    <link href="Squadfree/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="Squadfree/assets/vendor/aos/aos.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="Squadfree/assets/css/style.css" rel="stylesheet">

    <!-- =======================================================
    * Template Name: Squadfree - v2.0.1
    * Template URL: https://bootstrapmade.com/squadfree-free-bootstrap-template-creative/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
    <style>#_no-clickjacking-0 {
        opacity: 1 !important;
        overflow: visible !important
    }</style>
    <style>#_no-clickjacking-0 {
        opacity: 1 !important;
        overflow: visible !important
    }</style>
</head>

<body data-aos-easing="ease-in-out" data-aos-duration="800" data-aos-delay="0">
<button type="button" class="mobile-nav-toggle d-lg-none"><i class="icofont-navigation-menu"></i></button>

<!-- ======= Header ======= -->
<header id="header" class="fixed-top">
    <div class="container d-flex">
        <div class="logo mr-auto">
            <h1 class="text-light"><a href="home.jsp"><span>Yuki Store</span></a></h1>
            <!-- Uncomment below if you prefer to use an image logo -->
            <!-- <a href="home.jsp"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>
        <nav class="nav-menu d-none d-lg-block">
            <ul>
                <li class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                <li class="drop-down"><a href="">
                    Book classification</a>
                    <ul>
                        <li class="drop-down"><a href="#">Category</a>
                            <ul>
                                <c:forEach items="${requestScope['categoryList']}" var="category">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/home?action=showBookByCategory&name=${category.getName()}">${category.getName()}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                        <li class="drop-down"><a href="#">Publisher</a>
                            <ul>
                                <c:forEach items="${requestScope['publisherList']}" var="publisher">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/home?action=showBookByPublisher&name=${publisher.getName()}">${publisher.getName()}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                        <li class="drop-down"><a href="#">Author</a>
                            <ul>
                                <c:forEach items="${requestScope['authorList']}" var="author">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/home?action=findAllBookByAuthor&name=${author.getName()}">${author.getName()}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                    </ul>
                </li>
                <li class="active"><a href="${pageContext.request.contextPath}/login?action=loginForm">Login</a>
                </li>
                <li class="active"><a
                        href="${pageContext.request.contextPath}/login?action=registerForm">Register</a></li>
            </ul>
        </nav>
        <!-- .nav-menu -->
    </div>
</header>
<!-- End Header -->

<!-- ======= Hero Section ======= -->
<section id="hero">
    <div class="hero-container aos-init aos-animate" data-aos="fade-up">
        <h1>Book Made Your Life</h1>
        <h2>“Good friends, good books, and a sleepy conscience: this is the ideal life.”</h2>
        <a href="#about" class="btn-get-started scrollto"><i class="bx bx-chevrons-down"></i></a>
    </div>

</section>
<section>
    <div class="container">
        <div class="row">
            <c:forEach items="${requestScope['bookList']}" var="book">
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                    <div class="my-list">
                        <img src="${book.getImage()}" alt="image"/>
                        <h3>${book.getTitle()}</h3>
                        <h4>Pride: ${book.getPrice()}VNĐ</h4>
                        <div class="detail">
                            <a href="${pageContext.request.contextPath}/order?action=addToCard&id=${requestScope['user'].getId()}"
                               class="btn btn-info">Add To Cart</a>
                            <a href="${pageContext.request.contextPath}/book?action=showDetailBook"
                               class="btn btn-info">Detail</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- End Hero -->

<!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer">
    <div class="footer-top">
        <div class="container">
            <div class="row">

                <div class="col-lg-4 col-md-6">
                    <div class="footer-info aos-init" data-aos="fade-up" data-aos-delay="50">
                        <h3>Yuki Store</h3>
                        <p class="pb-3"><em>Bad boy ain't good,good boy ain't fun</em></p>
                        <p>fucking heaven<br>
                            NY 535022, USA<br><br>
                            <strong>Phone:</strong>1800-1508<br>
                            <strong>Email:</strong>biettuot505@gmail.com<br>
                        </p>
                        <div class="social-links mt-3">
                            <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
                            <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
                            <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
                            <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
                            <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
                        </div>
                    </div>
                </div>

                <div class="col-lg-2 col-md-6 footer-links aos-init" data-aos="fade-up" data-aos-delay="150">
                    <h4>Quick Link</h4>
                    <ul>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Home</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">About us</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Services</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Terms of service</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Privacy policy</a></li>
                    </ul>
                </div>

                <div class="col-lg-2 col-md-6 footer-links aos-init" data-aos="fade-up" data-aos-delay="250">
                    <h4>Our Services</h4>
                    <ul>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Web Design</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Web Development</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Product Management</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Marketing</a></li>
                        <li><i class="bx bx-chevron-right"></i> <a href="#">Graphic Design</a></li>
                    </ul>
                </div>

                <div class="col-lg-4 col-md-6 footer-newsletter aos-init" data-aos="fade-up" data-aos-delay="350">
                    <h4>Our Newsletter</h4>
                    <p>Tamen quem nulla quae legam multos aute sint culpa legam noster magna</p>
                    <form action="" method="post">
                        <input type="email" name="email"><input type="submit" value="Subscribe">
                    </form>

                </div>

            </div>
        </div>
    </div>

    <div class="container">
        <div class="copyright">
            © Copyright <strong><span>Squadfree</span></strong>. All Rights Reserved
        </div>
        <div class="credits">
            <!-- All the links in the footer should remain intact. -->
            <!-- You can delete the links only if you purchased the pro version. -->
            <!-- Licensing information: https://bootstrapmade.com/license/ -->
            <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/squadfree-free-bootstrap-template-creative/ -->
            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
        </div>
    </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top" style="display: none;"><i class="icofont-simple-up"></i></a>

<!-- Vendor JS Files -->
<script src="Squadfree/assets/vendor/jquery/jquery.min.js"></script>
<script src="Squadfree/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="Squadfree/assets/vendor/jquery.easing/jquery.easing.min.js"></script>
<script src="Squadfree/assets/vendor/php-email-form/validate.js"></script>
<script src="Squadfree/assets/vendor/waypoints/jquery.waypoints.min.js"></script>
<script src="Squadfree/assets/vendor/counterup/counterup.min.js"></script>
<script src="Squadfree/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="Squadfree/assets/vendor/venobox/venobox.min.js"></script>
<script src="Squadfree/assets/vendor/owl.carousel/owl.carousel.min.js"></script>
<script src="Squadfree/assets/vendor/aos/aos.js"></script>

<!-- Template Main JS File -->
<script src="Squadfree/assets/js/main.js"></script>
<nav class="mobile-nav d-lg-none">
    <ul>
        <li class="active"><a href="#header">Home</a></li>
        <li><a href="#about">About Us</a></li>
        <li><a href="#services">Services</a></li>
        <li><a href="#portfolio">Portfolio</a></li>
        <li><a href="#team">Team</a></li>
        <li class="drop-down"><a href="">Drop Down</a>
            <ul>
                <li><a href="#">Drop Down 1</a></li>
                <li class="drop-down"><a href="#">Drop Down 2</a>
                    <ul>
                        <li><a href="#">Deep Drop Down 1</a></li>
                        <li><a href="#">Deep Drop Down 2</a></li>
                        <li><a href="#">Deep Drop Down 3</a></li>
                        <li><a href="#">Deep Drop Down 4</a></li>
                        <li><a href="#">Deep Drop Down 5</a></li>
                    </ul>
                </li>
                <li><a href="#">Drop Down 3</a></li>
                <li><a href="#">Drop Down 4</a></li>
                <li><a href="#">Drop Down 5</a></li>
            </ul>
        </li>
        <li><a href="#contact">Contact Us</a></li>

    </ul>
</nav>
<div class="mobile-nav-overly"></div>


<div id="eJOY__extension_root" style="all: unset;"></div>
</body>
</html>