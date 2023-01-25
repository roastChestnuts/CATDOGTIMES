<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/png" href="../images/k_favicon_32x.png">
    <title>CatDogTimes</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Libre+Baskerville:300,300i,400,400i,500,500i&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/bootstrap/font-icon.min.css">
    <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap/reset.css">
    <link rel="stylesheet" href="../css/bootstrap/defined.css">
    <link rel="stylesheet" href="../css/bootstrap/base.css">
    <link rel="stylesheet" href="../css/bootstrap/style.css">
    <link rel="stylesheet" href="../css/bootstrap/home-fashion-vertical.css">

    <style>
/* 전체 레이아웃 */
        .header_7 .header__mid{padding-top: 32px; padding-bottom: 32px;}
        .widget_img_pr, .widget_img_ar {min-width: 64px;  max-width: 64px;}
        .allrank .rank{padding-left: 0;}

    </style>

</head>

<body
    class="lazy_icons btnt4_style_2 zoom_tp_2 css_scrollbar template-index cart_pos_side kalles_toolbar_true hover_img2 swatch_style_rounded swatch_list_size_small label_style_rounded wrapper_full_width header_full_true header_sticky_true hide_scrolld_true des_header_7 h_banner_true top_bar_true prs_bordered_grid_1 search_pos_full lazyload">
        <aside id="ntside" class="ntheader right_side h_icon_iccl p-3">
<%-- 		<span>${loginMember}</span> --%>
            <div class="ntheader_wrapper pr z_200">
                <div id="kalles-section-header_7" class="kalles-section sp_header_mid">
                    <div class="header__mid pl__15 pr__15">
                        <div class="row al_center">
                            <div class="col-lg-12 col-6 tc">
                                <div class="branding ts__05 lh__1">
                                    <a class="dib" href="">
                                        <img class="w__95 logo_normal dn db_lg rounded-circle " src="../images/catdog.svg"
                                            alt="photo">
                                        <img class="w__100 logo_sticky dn rounded-circle" src="../images/catdog.svg"
                                            alt="photo">
                                        <img class="w__100 logo_mobile dn_lg rounded-circle" src="../images/catdog.svg"
                                            alt="">
                                        <span class="nickname pt-3 d-inline-block">${loginMember.name}</span>
                                    </a>
                                    <div class="myranking pt-2" style="margin-bottom: 10px;">
                                        (<span class="">${loginMember.email}</span>) 
                                    </div>
                                </div>
                                <div class="profile-btns pt-3">
<!--                                     <a href="#" class="d-inline-block p-3">정보수정</a> -->
                                    <a class="member-logout" href="/times/member/login">로그아웃</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
<!--             <div class="col-12 dn db_lg mt__10 mb__30 tc allrank"> -->
<!--                 <div class="widget widget_product_list text-left p-3"> -->
<!--                     <h5 class="widget-title pt-5">전체랭킹</h5> -->
<!--                     <ul class="product_list_widget"> -->
<!--                         <li class="row mb__10 pb__10"> -->
<!--                             <div class="col widget_img_pr"> -->
<!--                                 <a class="db pr oh" href="#"> -->
<!--                                     <img src="../images/profile1.jpg"  class="w__100 ls-is-cached lazyloaded" alt="랭킹 1위"> -->
<!--                                 </a> -->
<!--                             </div> -->
<!--                             <div class="col widget_if_pr"> -->
<!--                                 <a class="product-title db" href="#">흰둥이</a><span class="money">@white1004</span> -->
<!--                             </div> -->
<!--                             <div class="col rank al_center"><span class="badge badge-info">1위</span></div> -->
<!--                         </li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--             </div> -->
        </aside>
    <script src="../js/bootstrap/jquery-3.5.1.min.js"></script>
    <script src="../js/bootstrap/jarallax.min.js"></script>
    <script src="../js/bootstrap/packery.pkgd.min.js"></script>
    <script src="../js/bootstrap/jquery.hoverIntent.min.js"></script>
    <script src="../js/bootstrap/magnific-popup.min.js"></script>
    <script src="../js/bootstrap/flickity.pkgd.min.js"></script>
    <script src="../js/bootstrap/lazysizes.min.js"></script>
    <script src="../js/bootstrap/js-cookie.min.js"></script>
    <script src="../js/bootstrap/jquery.countdown.min.js"></script>
    <script src="../js/bootstrap/interface.js"></script>
</body>

</html>