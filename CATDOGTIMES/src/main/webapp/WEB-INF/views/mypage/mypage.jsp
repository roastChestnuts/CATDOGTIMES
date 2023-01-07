<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp"  %> 

<div id="nt_content" class="mainContent p-5">
            <!-- 프로필 -->
            <div class="main_header pt-3 pb-5">
                <div class="profile d-flex">
                    <div class="profile_photo pr-5">                   	
                    	<c:choose>
                    		<c:when test="${memberinfo.memberPhoto eq '' or memberinfo.memberPhoto eq null}">
                    			<img src="assets/images/no.jpg" alt="사진없음" class="img-thumbnail rounded-circle">
                    		</c:when>
                    		<c:otherwise>
                    			<img src="assets/images/${memberinfo.memberPhoto} " alt="${memberinfo.memberNickname} 사진" class="img-thumbnail rounded-circle">
                    		</c:otherwise>
                    	</c:choose>
                    	
                        
                    </div>
                    <div class="profile_info">
                        <h3 class="nickname ">${memberinfo.memberNickname} </h3>
                        <div class="summ_cnt">
                            <span class="posts">총게시글수 (<span>${memberinfo.postTotal}</span>)</span> 
                            <span class="follower">팔로워 수 (<span>${memberinfo.followerCnt}</span>)</span>
                            <span class="follow">팔로우 수 (<span>${memberinfo.followingCnt}</span>)</span>
                        </div>
                        <p class="accountid">@white1004</p>
                    </div>
                </div>
            </div>

            <!-- tab section-->
            <div class="kalles-section nt_section type_tab type_tab_collection tp_se_cdt pt-5">
                <div class="kalles-fashion-vertical__tab-container container">
                    
                    <div class="tab_se_wrap">
                        <div class="tab_se_header tc mt__30">
                            <ul class="tab_cat_title ul_none des_tab_3">
                                <li class="dib">
                                    <a class="js_t4_tab tt_active" data-bid="kalles_tab_100" href="#"><span>게시물</span></a>
                                </li>
                                <li class="dib">
                                    <a class="js_t4_tab" data-bid="kalles_tab_200" href="#"><span>좋아요</span></a>
                                </li>
                                <li class="dib">
                                    <a class="js_t4_tab" data-bid="kalles_tab_300" href="#"><span>북마크</span></a>
                                </li>
                                
                            </ul>
                        </div>
                        <div class="tab_se_content">
                            <div class="tab_se_element tab-0 lazyload ct_active" id="kalles_tab_100">
                                <div
                                    class="products nt_products_holder row fl_center row_pr_1 cdt_des_1 round_cd_false nt_cover ratio_nt position_8 space_30 equal_nt">
                                    <div
                                        class="col-lg-4 col-md-4 col-6 pr_animated done mt__30 pr_grid_item product nt_pr desgin__1">
                                        <div class="product-inner pr">
                                            <div class="product-image pr oh lazyload">
                                                <a class="d-block" href="product-detail-layout-01.html">
                                                    <div class="pr_lazy_img main-img nt_img_ratio nt_bg_lz lazyload padding-top__127_586"
                                                        data-bgset="assets/images/home-classic/pr-27.jpg"></div>
                                                </a>
                                                <div class="hover_img pa pe_none t__0 l__0 r__0 b__0 op__0">
                                                    <div class="pr_lazy_img back-img pa nt_bg_lz lazyload padding-top__127_586"
                                                        data-bgset="assets/images/home-classic/pr-28.jpg"></div>
                                                </div>
                                                <div class="nt_add_w ts__03 pa ">
                                                    <a href="#" class="wishlistadd cb chp ttip_nt tooltip_right"><span
                                                            class="tt_txt">Add to Wishlist</span><i
                                                            class="facl facl-heart-o"></i></a>
                                                </div>
                                                <div class="hover_button op__0 tc pa flex column ts__03">
                                                    <a class="pr nt_add_qv js_add_qv cd br__40 pl__25 pr__25 bgw tc dib ttip_nt tooltip_top_left"
                                                        href="#"><span class="tt_txt">Quick view</span><i
                                                            class="iccl iccl-eye"></i><span>Quick view</span></a>
                                                    <a href="#"
                                                        class="pr pr_atc cd br__40 bgw tc dib js_addtc cb chp ttip_nt tooltip_top_left"><span
                                                            class="tt_txt">Add to cart</span><i
                                                            class="iccl iccl-cart"></i><span>Add to cart</span></a>
                                                </div>
                                            </div>
                                            <div class="product-info mt__15">
                                                <h3 class="product-title pr fs__14 mg__0 fwm">
                                                    <a class="cd chp" href="product-detail-layout-01.html">City Backpack
                                                        Black</a>
                                                </h3>
                                                <span class="price dib mb__5">$55.00</span>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div
                                        class="col-lg-4 col-md-4 col-6 pr_animated done mt__30 pr_grid_item product nt_pr desgin__1">
                                        <div class="product-inner pr">
                                            <div class="product-image pr oh lazyload">
                                                <a class="d-block" href="product-detail-layout-01.html">
                                                    <div class="pr_lazy_img main-img nt_img_ratio nt_bg_lz lazyload padding-top__127_586"
                                                        data-bgset="assets/images/home-classic/pr-27.jpg"></div>
                                                </a>
                                                <div class="hover_img pa pe_none t__0 l__0 r__0 b__0 op__0">
                                                    <div class="pr_lazy_img back-img pa nt_bg_lz lazyload padding-top__127_586"
                                                        data-bgset="assets/images/home-classic/pr-28.jpg"></div>
                                                </div>
                                                <div class="nt_add_w ts__03 pa ">
                                                    <a href="#" class="wishlistadd cb chp ttip_nt tooltip_right"><span
                                                            class="tt_txt">Add to Wishlist</span><i
                                                            class="facl facl-heart-o"></i></a>
                                                </div>
                                                <div class="hover_button op__0 tc pa flex column ts__03">
                                                    <a class="pr nt_add_qv js_add_qv cd br__40 pl__25 pr__25 bgw tc dib ttip_nt tooltip_top_left"
                                                        href="#"><span class="tt_txt">Quick view</span><i
                                                            class="iccl iccl-eye"></i><span>Quick view</span></a>
                                                    <a href="#"
                                                        class="pr pr_atc cd br__40 bgw tc dib js_addtc cb chp ttip_nt tooltip_top_left"><span
                                                            class="tt_txt">Add to cart</span><i
                                                            class="iccl iccl-cart"></i><span>Add to cart</span></a>
                                                </div>
                                            </div>
                                            <div class="product-info mt__15">
                                                <h3 class="product-title pr fs__14 mg__0 fwm">
                                                    <a class="cd chp" href="product-detail-layout-01.html">City Backpack
                                                        Black</a>
                                                </h3>
                                                <span class="price dib mb__5">$55.00</span>
                                            </div>
                                        </div>
                                    </div>

                                    <div
                                        class="col-lg-4 col-md-4 col-6 pr_animated done mt__30 pr_grid_item product nt_pr desgin__1">
                                        <div class="product-inner pr">
                                            <div class="product-image pr oh lazyload">
                                                <a class="d-block" href="product-detail-layout-01.html">
                                                    <div class="pr_lazy_img main-img nt_img_ratio nt_bg_lz lazyload padding-top__127_586"
                                                        data-bgset="assets/images/home-classic/pr-27.jpg"></div>
                                                </a>
                                                <div class="hover_img pa pe_none t__0 l__0 r__0 b__0 op__0">
                                                    <div class="pr_lazy_img back-img pa nt_bg_lz lazyload padding-top__127_586"
                                                        data-bgset="assets/images/home-classic/pr-28.jpg"></div>
                                                </div>
                                                <div class="nt_add_w ts__03 pa ">
                                                    <a href="#" class="wishlistadd cb chp ttip_nt tooltip_right"><span
                                                            class="tt_txt">Add to Wishlist</span><i
                                                            class="facl facl-heart-o"></i></a>
                                                </div>
                                                <div class="hover_button op__0 tc pa flex column ts__03">
                                                    <a class="pr nt_add_qv js_add_qv cd br__40 pl__25 pr__25 bgw tc dib ttip_nt tooltip_top_left"
                                                        href="#"><span class="tt_txt">Quick view</span><i
                                                            class="iccl iccl-eye"></i><span>Quick view</span></a>
                                                    <a href="#"
                                                        class="pr pr_atc cd br__40 bgw tc dib js_addtc cb chp ttip_nt tooltip_top_left"><span
                                                            class="tt_txt">Add to cart</span><i
                                                            class="iccl iccl-cart"></i><span>Add to cart</span></a>
                                                </div>
                                            </div>
                                            <div class="product-info mt__15">
                                                <h3 class="product-title pr fs__14 mg__0 fwm">
                                                    <a class="cd chp" href="product-detail-layout-01.html">City Backpack
                                                        Black</a>
                                                </h3>
                                                <span class="price dib mb__5">$55.00</span>
                                            </div>
                                        </div>
                                    </div>

                                    
                                </div>
                            </div>
                            <div class="tab_se_element tab-1 lazyload" id="kalles_tab_200">
                                <div
                                    class="products nt_products_holder row fl_center row_pr_1 cdt_des_1 round_cd_false nt_cover ratio_nt position_8 space_30 equal_nt">
                                    <div
                                        class="col-lg-3 col-md-3 col-6 pr_animated done mt__30 pr_grid_item product nt_pr desgin__1">
                                        <div class="product-inner pr">
                                            <div class="product-image pr oh lazyload">
                                                <span class="tc nt_labels pa pe_none cw"><span
                                                        class="nt_label new">New</span></span>
                                                <a class="d-block" href="product-detail-layout-01.html">
                                                    <div class="pr_lazy_img main-img nt_img_ratio nt_bg_lz lazyload padding-top__127_586"
                                                        data-bgset="assets/images/home-classic/pr-01.jpg"></div>
                                                </a>
                                                <div class="hover_img pa pe_none t__0 l__0 r__0 b__0 op__0">
                                                    <div class="pr_lazy_img back-img pa nt_bg_lz lazyload padding-top__127_586"
                                                        data-bgset="assets/images/home-classic/pr-02.jpg"></div>
                                                </div>
                                                <div class="nt_add_w ts__03 pa ">
                                                    <a href="#" class="wishlistadd cb chp ttip_nt tooltip_right"><span
                                                            class="tt_txt">Add to Wishlist</span><i
                                                            class="facl facl-heart-o"></i></a>
                                                </div>
                                                <div class="hover_button op__0 tc pa flex column ts__03">
                                                    <a class="pr nt_add_qv js_add_qv cd br__40 pl__25 pr__25 bgw tc dib ttip_nt tooltip_top_left"
                                                        href="#"><span class="tt_txt">Quick view</span><i
                                                            class="iccl iccl-eye"></i><span>Quick view</span></a>
                                                    <a href="#"
                                                        class="pr pr_atc cd br__40 bgw tc dib js__qs cb chp ttip_nt tooltip_top_left"><span
                                                            class="tt_txt">Quick Shop</span><i
                                                            class="iccl iccl-cart"></i><span>Quick Shop</span></a>
                                                </div>
                                                <div class="product-attr pa ts__03 cw op__0 tc">
                                                    <p class="truncate mg__0 w__100">XS, S, M, L, XL</p>
                                                </div>
                                            </div>
                                            <div class="product-info mt__15">
                                                <h3 class="product-title pr fs__14 mg__0 fwm">
                                                    <a class="cd chp" href="product-detail-layout-01.html">Analogue
                                                        Resin Strap</a>
                                                </h3>
                                                <span class="price dib mb__5">$30.00</span>
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                            <div class="tab_se_element tab-2 lazyload" id="kalles_tab_300">
                                <div
                                    class="products nt_products_holder row fl_center row_pr_1 cdt_des_1 round_cd_false nt_cover ratio_nt position_8 space_30 equal_nt">
                                    <div
                                        class="col-lg-3 col-md-3 col-6 pr_animated done mt__30 pr_grid_item product nt_pr desgin__1">
                                        <div class="product-inner pr">
                                            <div class="product-image pr oh lazyload">
                                                <span class="tc nt_labels pa pe_none cw"><span
                                                        class="nt_label new">New</span></span><a class="d-block"
                                                    href="product-detail-layout-01.html">
                                                    <div class="pr_lazy_img main-img nt_img_ratio nt_bg_lz lazyload padding-top__127_586"
                                                        data-bgset="assets/images/home-classic/pr-01.jpg"></div>
                                                </a>
                                                <div class="hover_img pa pe_none t__0 l__0 r__0 b__0 op__0">
                                                    <div class="pr_lazy_img back-img pa nt_bg_lz lazyload padding-top__127_586"
                                                        data-bgset="assets/images/home-classic/pr-02.jpg"></div>
                                                </div>
                                                <div class="nt_add_w ts__03 pa ">
                                                    <a href="#" class="wishlistadd cb chp ttip_nt tooltip_right"><span
                                                            class="tt_txt">Add to Wishlist</span><i
                                                            class="facl facl-heart-o"></i></a>
                                                </div>
                                                <div class="hover_button op__0 tc pa flex column ts__03">
                                                    <a class="pr nt_add_qv js_add_qv cd br__40 pl__25 pr__25 bgw tc dib ttip_nt tooltip_top_left"
                                                        href="#"><span class="tt_txt">Quick view</span><i
                                                            class="iccl iccl-eye"></i><span>Quick view</span></a>
                                                    <a href="#"
                                                        class="pr pr_atc cd br__40 bgw tc dib js__qs cb chp ttip_nt tooltip_top_left"><span
                                                            class="tt_txt">Quick Shop</span><i
                                                            class="iccl iccl-cart"></i><span>Quick Shop</span></a>
                                                </div>
                                                <div class="product-attr pa ts__03 cw op__0 tc">
                                                    <p class="truncate mg__0 w__100">XS, S, M, L, XL</p>
                                                </div>
                                            </div>
                                            <div class="product-info mt__15">
                                                <h3 class="product-title pr fs__14 mg__0 fwm">
                                                    <a class="cd chp" href="product-detail-layout-01.html">Analogue
                                                        Resin Strap</a>
                                                </h3>
                                                <span class="price dib mb__5">$30.00</span>
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
            <!-- end tab section-->


        </div>

<%@ include file="../common/side.jsp" %>