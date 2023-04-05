<%-- 
    Document   : adminpage
    Created on : 22 Nov 2022, 14:29:26
    Author     : Conor Dorgan
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <c:set var="loc" value="en_US"/>
<c:if test="${!(empty param.locale)}">
    <c:set var="loc" value="${param.locale}"/>
</c:if>
<fmt:setLocale value="${loc}" />
    <link rel="icon" type="image/x-icon" href="https://api.iconify.design/typcn/pencil.svg?color=%233e65f6">   
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Abstract Solutions</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
    <link rel="stylesheet" href="assets/fonts/typicons.min.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md sticky-top navbar-shrink py-3" id="mainNav">
        
        <fmt:bundle basename="app">
            <c:url value="index.jsp" var="index">
                        <c:param name="locale" value="${loc}"/>
                     </c:url>
            <c:url value="userpage.jsp" var="userpage">
                        <c:param name="locale" value="${loc}"/>
                     </c:url>
                    <c:url value="products" var="page">
                        <c:param name="locale" value="${loc}"/>
                     </c:url>
            <c:url value="adminpage.jsp" var="admin">
     <c:param name="locale" value="${loc}"/>
  </c:url>
<c:url value="login.jsp" var="login">
     <c:param name="locale" value="${loc}"/>
  </c:url>
            
            
            
        <div class="container"><a class="navbar-brand d-flex align-items-center" href="${index}"><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon"><i class="typcn typcn-pen"></i></span><span>Abstract  Solutions</span></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="navbar-nav mx-auto">
                    <c:url value="index.jsp" var="index">
                        <c:param name="locale" value="${loc}"/>
                     </c:url>
                    <c:url value="products" var="page">
                        <c:param name="locale" value="${loc}"/>
                     </c:url>
                    <li class="nav-item"><a class="nav-link active" href="${index}"><fmt:message key="home"/></a></li>
                    <li class="nav-item"><a class="nav-link" name="locale" value="${loc}" href="${page}"><fmt:message key="products"/></a></li>
                    
                </ul>
                <c:url value="" var="engURL">
   <c:param name="locale" value="en_US"/>
 </c:url>
                <a href="${engURL}">
     <img src="https://media.giphy.com/media/Mh9fsz5AolnDq/giphy.gif" height="50" width="50"/>
      <c:url value="" var="chineseURL">
     <c:param name="locale" value="zh_HK"/>
  </c:url>
<c:url value="" var="frenchURL">
     <c:param name="locale" value="fr_FR"/>
  </c:url>

  <a href="${frenchURL}"> 
       <img src="https://media.giphy.com/media/ErPDvrEYZYNOM/giphy.gif" height="50" width="50"/>
  </a>
       <c:url value="" var="irishURL">
     <c:param name="locale" value="ga_IE"/>
  </c:url>

  <a href="${irishURL}"> 
       <img src="https://cdn.pixabay.com/animation/2022/08/21/20/03/20-03-50-93_512.gif" height="50" width="50"/>
  </a>
  <a href="${chineseURL}"> 
       <img src="https://media.tenor.com/uqOIuxCZPqgAAAAd/china-flag-chinese.gif" height="50" width="50"/>
  </a>
 </a>
<br/>
<br/>
  <c:url value="adminpage.jsp" var="admin">
     <c:param name="locale" value="${loc}"/>
  </c:url>
<c:url value="login.jsp" var="login">
     <c:param name="locale" value="${loc}"/>
  </c:url>
                    <c:choose>
                    <c:when test="${SKUSER.userType == 'ADMIN' }"><a class="btn btn-primary shadow" role="button" href="${admin}"><fmt:message key="admin"/></a></c:when>
                    <c:when test="${not empty SKUSER.firstName}"><a class="btn btn-primary shadow" role="button" href="${userpage}"><fmt:message key="greeting"/> ${SKUSER.firstName}</a></c:when>
                    <c:otherwise><a class="btn btn-primary shadow" role="button" href="${login}"><fmt:message key="login"/></a></c:otherwise>
                    </c:choose>
            </div>
            
        </div>
         </fmt:bundle>       
    </nav>
    <header class="bg-primary-gradient">
        <div class="container pt-4 pt-xl-5">
            <div class="row pt-5" style="padding: 0px !important;">
                <div class="col-md-8 col-xl-6 text-center text-md-start mx-auto">
                    <div class="text-center">
                        <h1 class="fw-bold mb-5">Admin Directory</h1> 
</div></div>      
                
                
               <div class="container mb-5">
  <div class="row">
    <div class="col">
      
        <a href="userAdmin" style="display: block; width: 400px; height: 400px; margin: auto;">
          <img class="rounded mx-auto d-block" src="assets/img/products/2.png" height="400" width="400">
        </a>
      
    </div>
    <div class="col">
     
        <a href="productAdmin" style="display: block; width: 400px; height: 400px; margin: auto;">
          <img class="rounded mx-auto d-block" src="assets/img/products/1.png" height="400" width="400">
        </a>
      
    </div>
  </div>
</div>


                                      

                    
                
                <div class="col-12 col-lg-10 mx-auto">
                        </div>
                </div>
            </div>
        </div>
    </header>
    <section class="py-5">
        <div class="container text-center py-5">
            <p class="mb-4" style="font-size: 1.6rem;">Used by <span class="bg-success-light p-1"><strong>2400+</strong></span>&nbsp;of the best companies in the world.</p><a href="#"> <img class="m-3" src="assets/img/brands/instacart.png"></a><a href="#"> <img class="m-3" src="assets/img/brands/kickstarter.png"></a><a href="#"> <img class="m-3" src="assets/img/brands/lyft.png"></a><a href="#"> <img class="m-3" src="assets/img/brands/shopify.png"></a><a href="#"> <img class="m-3" src="assets/img/brands/pinterest.png"></a><a href="#"> <img class="m-3" src="assets/img/brands/twitter.png"></a>
        </div>
    </section>
    <section></section>
    <section></section>
    <footer class="bg-primary-gradient">
        <div class="container py-4 py-lg-5">
            <div class="row justify-content-center">
                <div class="col-sm-4 col-md-3 text-center text-lg-start d-flex flex-column">
                    <h3 class="fs-6 fw-bold">Services</h3>
                    <ul class="list-unstyled">
                        <li><a href="#">Web design</a></li>
                        <li><a href="#">Development</a></li>
                        <li><a href="#">Hosting</a></li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 text-center text-lg-start d-flex flex-column">
                    <h3 class="fs-6 fw-bold">About</h3>
                    <ul class="list-unstyled">
                        <li><a href="#">Company</a></li>
                        <li><a href="#">Team</a></li>
                        <li><a href="#">Legacy</a></li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 text-center text-lg-start d-flex flex-column">
                    <h3 class="fs-6 fw-bold">Careers</h3>
                    <ul class="list-unstyled">
                        <li><a href="#">Job openings</a></li>
                        <li><a href="#">Employee success</a></li>
                        <li><a href="#">Benefits</a></li>
                    </ul>
                </div>
                <div class="col-lg-3 text-center text-lg-start d-flex flex-column align-items-center order-first align-items-lg-start order-lg-last">
                    <div class="fw-bold d-flex align-items-center mb-2"><span class="bs-icon-sm bs-icon-circle bs-icon-primary d-flex justify-content-center align-items-center bs-icon me-2"><i class="typcn typcn-pen"></i></span><span>Abstract Solutions</span></div>
                    <p class="text-muted">Committed to delivering qualtity office supplies to workplaces around the globe </p>
                </div>
            </div>
            <hr>
            <div class="text-muted d-flex justify-content-between align-items-center pt-3">
                <p class="mb-0">Copyright © 2022 Abstract Solutions</p>
                <ul class="list-inline mb-0">
                    <li class="list-inline-item"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-facebook">
                            <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"></path>
                        </svg></li>
                    <li class="list-inline-item"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-twitter">
                            <path d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"></path>
                        </svg></li>
                    <li class="list-inline-item"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-instagram">
                            <path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"></path>
                        </svg></li>
                </ul>
            </div>
        </div>
    </footer>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bold-and-bright.js"></script>
</body>
</html>
