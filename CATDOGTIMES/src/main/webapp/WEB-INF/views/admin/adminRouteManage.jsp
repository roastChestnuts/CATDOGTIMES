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
    <link rel="stylesheet" href="../css/font-icon.min.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/defined.css">
    <link rel="stylesheet" href="../css/base.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/home-fashion-vertical.css">

    <style>
	/* 전체 레이아웃 */
        .header_7 .header__mid{padding-top: 32px; padding-bottom: 32px;}
        .widget_img_pr, .widget_img_ar {min-width: 64px;  max-width: 64px;}
        .allrank .rank{padding-left: 0;}
	
	/* paging css */
		  .pageInfo{
		   	list-style : none;
		   	display: inline-block;
		  }
		  .pageInfo li{
		    float: left;
		    font-size: 20px;
 		    margin-left: auto; 
		    padding: 7px;
		    font-weight: 500; 
		  }
		  .checked{
		      color: #56cfe1; 
		  }
		  .btshow:hover{
		  	border-color: black;
		    background-color: #fff;
		    color: black;
		  }
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
                                    <a class="dib" href="mypage2.html">멍냥일보</a>
                                </div>
                            </div>
                            
                            <div class="col-12 dn db_lg mt__10 mb__30 tc">
                                <nav id="nav_header7" class="nav_header7 nt_navigation center-xs">
                                    <ul class="nt_mb_menu">
                                        <li id="item_header_7-0" class="menu-item  ">
                                            <a href="#"><span class="nav_link_txt flex al_center">HOME</span></a>
                                        </li>
                                        <li class="menu-item ">
                                            <a href="/times/admin/dashboard" class="icon_search push_side cb chp"><span>대시보드</span></a>
                                        </li>
                                        <li class="menu-item ">
                                            <a href="/times/admin/usermanage" class="icon_search push_side cb chp"><span>사용자관리</span></a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="/times/admin/boardmanage" class="icon_search push_side cb chp"><span>게시글관리</span></a>
                                        </li>
                                        <li class="menu-item ">
                                            <a href="/times/admin/routemanage" class="kalles-lbl__nav-sale"><span>산책루트관리</span></a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
            <div class="d-flex flex-column text-center p-3">
                <a class="button p-3 m-3">관리자페이지</a>
            </div>
        </header>
        <!-- end header -->

       		<div id="nt_content" class="mainContent p-5">
            <!-- 메인 콘텐트 -->
				<span style="font-size:30px;font-weight:bold;">산책루트 관리</span><br/>
            <span>멍냥일보 산책루트관리 페이지 입니다. &nbsp;산책루트에 대한 공개여부처리를 할 수 있습니다.</span>
						<div class="row" style="padding-top:20px;">
                        	<div class="col-xl-12">
                            	<div class="card mb-4">
                                    <div class="card-header">
                                    	<div>
                                    		<select class="admin_srchBox" style="width:150px;" id="searchType">
                                    			<option value="routeNo">산책루트번호</option>
                                    			<option value="routeName">루트명</option>                                			
                                    			<option value="routeDepartures">출발지</option>                                			
                                    			<option value="routeDestination">도착지</option>                                			
                                    			<option value="memberId">아이디</option>
                                    		</select>
                                    		<input id="searchVal"></input>
                                    	</div>
                                    	<div>
                                    		<select class="admin_srchBox" style="width:150px;" id="routePublic">
                                    			<option value="">전체</option>
                                    			<option value="TRUE">공개</option>
                                    			<option value="FALSE">비공개</option>
                                    		</select>
                                    	</div>
                                  		<div style="">
                                  			<button id="searchBtn" style="margin:auto; display:block;" onclick="clickSrchBtn(1)">검색</button>
                                  		</div>
                                 	 </div>
                                  </div>
                                    	<div id="routeTable">
                                    		<table class="">
                                    			<thead>
                                    				<tr>
                                    					<td>산책루트번호</td>
                                    					<td>루트명</td>
                                    					<td>출발지</td>
                                    					<td>도착지</td>
                                    					<td>아이디</td>
                                    					<td>평가 수</td>
                                    					<td>평점평균</td>
                                    				</tr>
                                    			</thead>
                                    			<tbody>
                                    			<c:forEach var="data" items="${boardManageList}">
                                    				<tr>
                                    					<td>${data.postId}</td>
                                    					<td>${data.postContent}</td>
                                    					<td>${data.memberName}</td>
                                    					<td>${data.memberId}</td>
                                    					<td>${data.postCreateDate}</td>
                                    					<td>${data.replyCnt}</td>
                                    					<td>
                                    					<!-- 조건에 따라서 버튼 처리 -->
                                    						${data.postShowYn}
                                    					</td>
                                    				</tr>
                                    			</c:forEach>
                                    			</tbody>
                                    		</table>
                                    	</div>
                                    	<div id="pagingArea">
                                    	</div>
                                    </div>
                                </div>
                            </div>            
                        </div>
                    </div>
                </main>
            </div>    
            <!-- end 메인 콘텐트 -->

        <aside id="ntside" class="ntheader right_side h_icon_iccl p-3">
            <div class="ntheader_wrapper pr z_200">
                <div id="kalles-section-header_7" class="kalles-section sp_header_mid">
                    <div class="header__mid pl__15 pr__15">
                        <div class="row al_center">
                            <div class="col-lg-12 col-6 tc">
                                <div class="branding ts__05 lh__1">
                                    <a class="dib" href="mypage.html">
                                        <img class="w__95 logo_normal dn db_lg rounded-circle " src="../images/photo.jpg"
                                            alt="photo">
                                        <img class="w__100 logo_sticky dn rounded-circle" src="../images/photo.jpg"
                                            alt="photo">
                                        <img class="w__100 logo_mobile dn_lg rounded-circle" src="../images/photo.jpg"
                                            alt="">
                                        <span class="nickname pt-3 d-inline-block">미소천사</span>
                                    </a>
                                    <div class="myranking pt-2">
                                        MyRanking (<span class="cnt">999</span>) 
                                    </div>
                                </div>
                                <div class="profile-btns pt-3">
                                    <a href="#" class="d-inline-block p-3">정보수정</a>
                                    <a href="#" class="d-inline-block p-3">로그아웃</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12 dn db_lg mt__10 mb__30 tc allrank">
                <div class="widget widget_product_list text-left p-3">
                    <h5 class="widget-title pt-5">전체랭킹</h5>
                    <ul class="product_list_widget">
                        <li class="row mb__10 pb__10">
                            <div class="col widget_img_pr">
                                <a class="db pr oh" href="#">
                                    <img src="../images/profile1.jpg"  class="w__100 ls-is-cached lazyloaded" alt="랭킹 1위">
                                </a>
                            </div>
                            <div class="col widget_if_pr">
                                <a class="product-title db" href="#">흰둥이</a><span class="money">@white1004</span>
                            </div>
                            <div class="col rank al_center"><span class="badge badge-info">1위</span></div>
                        </li>
                        <li class="row mb__10 pb__10">
                            <div class="col widget_img_pr">
                                <a class="db pr oh" href="#">
                                    <img src="../images/profile1.jpg"  class="w__100 ls-is-cached lazyloaded" alt="랭킹 1위">
                                </a>
                            </div>
                            <div class="col widget_if_pr">
                                <a class="product-title db" href="#">흰둥이</a><span class="money">@white1004</span>
                            </div>
                            <div class="col rank al_center"><span class="badge badge-info">1위</span></div>
                        </li>
                        <li class="row mb__10 pb__10">
                            <div class="col widget_img_pr">
                                <a class="db pr oh" href="#">
                                    <img src="../images/profile1.jpg"  class="w__100 ls-is-cached lazyloaded" alt="랭킹 1위">
                                </a>
                            </div>
                            <div class="col widget_if_pr">
                                <a class="product-title db" href="#">흰둥이</a><span class="money">@white1004</span>
                            </div>
                            <div class="col rank al_center"><span class="badge badge-info">1위</span></div>
                        </li>
                        <li class="row mb__10 pb__10">
                            <div class="col widget_img_pr">
                                <a class="db pr oh" href="#">
                                    <img src="../images/profile1.jpg"  class="w__100 ls-is-cached lazyloaded" alt="랭킹 1위">
                                </a>
                            </div>
                            <div class="col widget_if_pr">
                                <a class="product-title db" href="#">흰둥이</a><span class="money">@white1004</span>
                            </div>
                            <div class="col rank al_center"><span class="badge badge-info">1위</span></div>
                        </li>
                        <li class="row mb__10 pb__10">
                            <div class="col widget_img_pr">
                                <a class="db pr oh" href="#">
                                    <img src="../images/profile1.jpg"  class="w__100 ls-is-cached lazyloaded" alt="랭킹 1위">
                                </a>
                            </div>
                            <div class="col widget_if_pr">
                                <a class="product-title db" href="#">흰둥이</a><span class="money">@white1004</span>
                            </div>
                            <div class="col rank al_center"><span class="badge badge-info">1위</span></div>
                        </li>
                    </ul>
                </div>
            </div>
        </aside>

        <footer id="ntfooter" class="p-5 text-center">
            copyright 멍냥일보 2023
        </footer>
    </div>

    <!--mask overlay-->
    <div class="mask-overlay ntpf t__0 r__0 l__0 b__0 op__0 pe_none"></div>
    <!--end mask overlay-->


    <!-- search box -->
    <div id="nt_search_canvas" class="nt_fk_canvas dn">
        <div class="nt_mini_cart flex column h__100">
            <div class="mini_cart_header flex fl_between al_center">
                <h3 class="widget-title tu fs__16 mg__0 font-poppins">Search Our Site</h3>
                <i class="close_pp pegk pe-7s-close ts__03 cd"></i>
            </div>
            <div class="mini_cart_wrap">
                <div class="search_header mini_search_frm pr js_frm_search" role="search">

                    <div class="frm_search_input pr oh">
                        <input class="search_header__input js_iput_search placeholder-black" autocomplete="off"
                            type="text" name="q" placeholder="Search for products">
                        <button class="search_header__submit js_btn_search" type="submit">
                            <i class="iccl iccl-search"></i></button>
                    </div>
                    <div class="ld_bar_search"></div>
                </div>
                <div class="search_header__prs fwsb cd">
                    <span class="h_suggest">Need some inspiration?</span><span class="h_result dn">Search
                        Result:</span><span class="h_results dn">Search Results:</span>
                </div>
                <div class="search_header__content mini_cart_content fixcl-scroll widget">
                    <div class="fixcl-scroll-content product_list_widget">
                        <div class="js_prs_search">
                            <div class="row mb__10 pb__10">
                                <div class="col widget_img_pr">
                                    <a class="db pr oh" href="product-detail-layout-01.html"><img
                                            src="data:image/svg+xml,%3Csvg%20viewBox%3D%220%200%201200%201200%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%3E%3C%2Fsvg%3E"
                                            class="w__100 lz_op_ef lazyload" alt="sunlight bell solar lamp"
                                            data-src="../images/mini-cart/product-01.jpg" width="80"
                                            height="80"></a>
                                </div>
                            </div>
                            <a href="#" class="btn fwsb detail_link">View All
                                <i class="las la-arrow-right fs__18"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- mobile menu -->
    <div id="nt_menu_canvas" class="nt_fk_canvas nt_sleft dn lazyload pt-3">
        <i class="close_pp pegk pe-7s-close ts__03 cd"></i>
        <div class="pr mb_nav_ul flex al_center fl_center p-3" >멍냥일보</div>       
    </div>
    <!-- end mobile menu -->

    <!-- back to top button-->
    <a id="nt_backtop" class="pf br__50 z__100 des_bt1" href="#"><span class="tc br__50 db cw"><i
                class="pr pegk pe-7s-angle-up"></i></span></a>

    <script src="../js/jquery-3.5.1.min.js"></script>
    <script src="../js/jarallax.min.js"></script>
    <script src="../js/packery.pkgd.min.js"></script>
    <script src="../js/jquery.hoverIntent.min.js"></script>
    <script src="../js/magnific-popup.min.js"></script>
    <script src="../js/flickity.pkgd.min.js"></script>
    <script src="../js/lazysizes.min.js"></script>
    <script src="../js/js-cookie.min.js"></script>
    <script src="../js/jquery.countdown.min.js"></script>
    <script src="../js/interface.js"></script>
    
    <script type="text/javascript">
    	var routeArrayList = new Array();
    	var nowPage = 1;
    	$(document).ready(function(){
    		// 화면 진입 시 목록 조회 함수 실행
    		clickSrchBtn(1); 
    		
    	});
    	
    	// 검색버튼 클릭 이벤트
    	function clickSrchBtn(pageIdx){
    		
    		var pageIdx = pageIdx;
    		// 페이지 당 출력할 리스트 수
    		var cntPerPage = 5;
    		
	    	// 검색 구분값
	    	var srchType = $('#searchType').val();
	    	
	    	// 검색 입력값
	    	var srchVal = $('#searchVal').val();
	    	
	    	// 산책루트 공개여부 값
	    	var routePublic = $('#routePublic option:selected').val();
	    	
	    	var param = 
	    		{
	    			"srchType"		:	srchType	,
	    			"srchVal" 		:	srchVal 	,
	    			"routePublic"	:	routePublic	,
	    			"cntPerPage"	:   cntPerPage	,
	    			"pageIdx"		:	pageIdx
	    		}
    		
	    	$.ajax({
	    		url:"${ path }/admin/routemanage/routelist",
	    		type:"GET",
	    		contentType:"json",
	    		data:param,
	    		success: function(data){
	    			routeArrayList = data;
	    			$('#routeTable').html("");
	    			$('#pagingArea').html("");
	    			var htmlString = "";
    				htmlString += "<table>";
    				htmlString += "		<thead>";
    			 	htmlString += "		<tr>";
    				htmlString += "			<td>산책루트번호</td>";
    				htmlString += "			<td>루트명</td>";
    				htmlString += "			<td>출발지</td>";
    				htmlString += "			<td>도착지</td>";
    				htmlString += "			<td>아이디</td>";
    				htmlString += "			<td>평가 수</td>";
    				htmlString += "			<td>평점평균</td>";
    				htmlString += "			<td>공개여부</td>";
    				htmlString += "		</tr>";
    				htmlString += "</thead>";
		   				if(data.length > 0)
		    			{
			    				htmlString += "<tbody>";
		    				for(var i = 0 ; i < data.length ; i++){
				    			htmlString += "		<tr>"
			    				htmlString += "			<td>" + data[i].routeNo + "</td>"
			    				htmlString += "			<td>" + data[i].routeName + "</td>"
			    				htmlString += "			<td>" + data[i].routeDepartures + "</td>"
			    				htmlString += "			<td>" + data[i].routeDestination + "</td>"
			    				htmlString += "			<td>" + data[i].memberId + "</td>"
			    				htmlString += "			<td>" + data[i].routeRatingCnt + "</td>"
			    				htmlString += "			<td>" + data[i].routeRatingScoreAvg + "</td>"
				    			htmlString += "			<td>"
				    			if(data[i].routePublic == 'TRUE'){
					    			htmlString += "			<button class='btshow' style='background-color: #fff'>공개</button>"
				    			} else {
					    			htmlString += "			<button class='btshow' style='background-color: #878787'>비공개</button>"
				    			}
				    			htmlString += "			</td>"
				    			htmlString += "		</tr>"
			    			}
			    				htmlString += "</tbody>";
		    					htmlString += "</table'>";
		    					
		    					// 페이징 그리는 영역
		    					var pagingString ="";
				    			pagingString += "<div class='pageInfo_wrap' style='text-align:center;'>";
				    			pagingString += "		<div class='pageInfo_area'>";
				    			pagingString += "			<ul id='pageInfo' class='pageInfo'>";
				    			if(data[0].startPageIdx > 1){
									pagingString += "			<li class='pageInfo_btn previous'><a href='#' onclick='pagingClick("+ ( data[0].startPageIdx - 1 ) +")'>이전</a></li>";
				    			}
								for(var j = data[0].startPageIdx ; j <= data[0].endPageIdx ; j ++){
									if(data[0].pageIdx == j)
									{
										pagingString += "			<li class='pageInfo_btn'><a class='checked' href='#' onclick='pagingClick("+ j +")'>" + j + "</a></li>";
									} 
									else
									{
										pagingString += "			<li class='pageInfo_btn'><a href='#' onclick='pagingClick("+ j +")'>" + j + "</a></li>";
									}
								}
								if(data[0].endPageIdx != data[0].pageCnt){
									pagingString += "			<li class='pageInfo_btn next'><a href='#' onclick='pagingClick("+ ( data[0].endPageIdx + 1 )+")'>다음</a></li>";
								}
								pagingString += "			</ul>";
								pagingString += "		</div>";
								pagingString += "</div>";
		    					
		    			} 
		   				else
		    			{
		    					htmlString += "</table>";
		    					htmlString += "<div style='text-align:center;'><span>검색 값이 없습니다.</span></div>";
		    			}
	    			$('#routeTable').append(htmlString);
	    			$('#pagingArea').append(pagingString);
	    		},
	    		error: function(e){
	    			alert('실패!!');
	    			console.log(e);
	    		}
	    	})
	    	
	    	
		}
    
    
    	//--------------------------------------------------
    	// 페이징 버튼 클릭 이벤트
    	//--------------------------------------------------
    	function pagingClick(pageIdx){
    		nowPage = pageIdx;
    		clickSrchBtn(pageIdx);
    	}
    	
    
    	//--------------------------------------------------
    	// 미노출처리 버튼 클릭 이벤트
    	//--------------------------------------------------
    	$(document).on("click",".btshow",function(e) {
    		
    		// index 가져오기
    		var index = ($(".btshow").index(this));
    		
    		// 활성여부 클릭한 해당 회원의 활성여부 값 가져오고	
    		var routeNo 	 = routeArrayList[index].routeNo;
    		var routePublic  = routeArrayList[index].routePublic; 
    		
    		// postShowYn 가 Y 일때 N, N 일때 Y로 변수에 값 넣고
    		var ckText = "";
    		if( routePublic == 'TRUE') {
    			routePublic = 'FALSE';	
    			ckText = "비공개 처리를 하시겠습니까?";
    		} else {
    			routePublic = 'TRUE';	
    			ckText = "공개 처리를 하시겠습니까?";
    		}
    		var checkVal = confirm(ckText);
    		
    		var param = 
    		{
    				"routeNo"		: 	routeNo		,
    				"routePublic"	: 	routePublic
    		}
    		// confirm 확인 클릭 시 (true)
    		if(checkVal){ 
    			// 3. 해당 값으로 회원 활성여부 수정하는 API 비동기 처리
        		$.ajax({
    	    		type:'POST',
    	    		url:'${ path }/admin/routemanage/route',
    	    		data:JSON.stringify(param),
    	    		contentType:'application/json',
    	    		dataType: 'text',
    	    		success: function(data){
    	    			// 사용자 목록 조회 함수 호출
    	    			clickSrchBtn(nowPage);
    	    		},
    	    		error: function(e){
    	    			console.log(e);
    	    		}
    	    	})
    		} 
    		
    	});
    
    	</script>
</body>
</html>