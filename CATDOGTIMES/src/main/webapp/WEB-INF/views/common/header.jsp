<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/png" href="assets/images/k_favicon_32x.png">
    <title>CatDogTimes</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Libre+Baskerville:300,300i,400,400i,500,500i&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/font-icon.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/reset.css">
    <link rel="stylesheet" href="assets/css/defined.css">
    <link rel="stylesheet" href="assets/css/base.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/css/home-fashion-vertical.css">

    <style>
/* 전체 레이아웃 */
        .header_7 .header__mid{padding-top: 32px; padding-bottom: 32px;}
        .widget_img_pr, .widget_img_ar {min-width: 64px;  max-width: 64px;}
        .allrank .rank{padding-left: 0;}
/* 마이페이지  */
        #nt_content .profile{align-items: center; justify-content: center;}
        #nt_content .profile_photo img{width: 200px;} 
        #nt_content .profile_info .summ_cnt>span{display: inline-block; padding: 8px 8px 8px 0;}
        .tab_cat_title.des_tab_2 > li > a, .tab_cat_title.des_tab_3 > li > a, .tab_cat_title.des_tab_11 > li > a{border-radius: 0;}
        .tab_cat_title.des_tab_1 > li > a:hover, .tab_cat_title.des_tab_2 > li > a:hover, .tab_cat_title.des_tab_3 > li > a:hover, .tab_cat_title.des_tab_11 > li > a:hover, .tab_cat_title.des_tab_1 > li > a.tt_active, .tab_cat_title.des_tab_2 > li > a.tt_active, .tab_cat_title.des_tab_3 > li > a.tt_active, .tab_cat_title.des_tab_11 > li > a.tt_active{border:0; border-bottom:1px  double gray ;}
    </style>

</head>

<body
    class="lazy_icons btnt4_style_2 zoom_tp_2 css_scrollbar template-index cart_pos_side kalles_toolbar_true hover_img2 swatch_style_rounded swatch_list_size_small label_style_rounded wrapper_full_width header_full_true header_sticky_true hide_scrolld_true des_header_7 h_banner_true top_bar_true prs_bordered_grid_1 search_pos_full lazyload">

    <div id="nt_wrapper">
        <!-- header -->
        <header id="ntheader" class="ntheader header_7 h_icon_iccl p-3">
            <div class="ntheader_wrapper pr z_200">
                <div id="kalles-section-header_7" class="kalles-section sp_header_mid">
                    <div class="header__mid pl__15 pr__15">
                        <div class="row al_center">
                            <div class="col-lg-12 col-3 dn_lg">
                                <a href="#" data-id="#nt_menu_canvas"
                                    class="push_side push-menu-btn lh__1 flex al_center">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="30" height="16" viewBox="0 0 30 16">
                                        <rect width="30" height="1.5"></rect>
                                        <rect y="7" width="20" height="1.5"></rect>
                                        <rect y="14" width="30" height="1.5"></rect>
                                    </svg>
                                </a>
                            </div>
                            <div class="col-lg-12 col-6 tc">
                                <div class="branding ts__05 lh__1">
                                    <a class="dib" href="mypage2.html">멍냥일보
                                        <!-- <img class="w__95 logo_normal dn db_lg" src="assets/images/svg/kalles.svg"
                                            alt="Kalles Html Template">
                                        <img class="w__100 logo_sticky dn" src="assets/images/svg/kalles.svg"
                                            alt="Kalles Html Template">
                                        <img class="w__100 logo_mobile dn_lg" src="assets/images/svg/kalles.svg"
                                            alt="Kalles Html Template"> -->
                                    </a>
                                </div>
                            </div>
                            
                            <div class="col-12 dn db_lg mt__10 mb__30 tc">
                                <nav id="nav_header7" class="nav_header7 nt_navigation center-xs">
                                    <ul class="nt_mb_menu">
                                        <li id="item_header_7-0" class="menu-item  ">
                                            <a href="#"><span class="nav_link_txt flex al_center">HOME</span></a>
                                        </li>
                                        <li class="menu-item ">
                                            <a href="#" class="icon_search push_side cb chp"  data-id="#nt_search_canvas" ><span class="nav_link_txt flex al_center">검색</span></a>
                                        </li>
                                        <li class="menu-item ">
                                            <a href="#"><span class="nav_link_txt flex al_center">탐색</span></a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="#" class="kalles-lbl__nav-sale">알림<span class="lbc_nav_mb ml__5">5</span></a>
                                        </li>
                                        <li class="menu-item ">
                                            <a href="#"><span class="nav_link_txt flex al_center">DM</span></a>
                                        </li>
                                        <li class="menu-item  ">
                                            <a href="#"><span class="nav_link_txt flex al_center">북마크</span></a>
                                        </li>
                                        <!-- <li class="menu-item menu-item-has-children only_icon_false">
                                            <a href="#"><span class="nav_link_txt flex al_center">북마크</span><span
                                                    class="nav_link_icon ml__5"></span></a>
                                        </li> -->
                                    </ul>
                                </nav>
                            </div>

                        </div>
                    </div>
                </div>
                
            </div>
            <div class="d-flex flex-column text-center p-3">
                <a class="button p-3 m-3" href="shop-filter-options.html">새글쓰기</a>
                <a class="button p-3 m-3" href="shop-filter-options.html">산책하기</a>
            </div>
        </header>
        <!-- end header -->