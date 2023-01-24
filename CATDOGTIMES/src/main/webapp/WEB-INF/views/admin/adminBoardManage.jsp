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
    <!-- 헤더 -->
	<%@ include file="./adminHeader.jsp"  %> 
       		<div id="nt_content" class="mainContent p-5">
            <!-- 메인 콘텐트 -->
				<span style="font-size:30px;font-weight:bold;">피드 관리</span><br/>
            <span>멍냥일보에 업로드 된 피드내역 입니다. &nbsp;관리자가 위반되는 피드에 대한 미노출처리를 할 수 있습니다.</span>
						<div class="row" style="padding-top:20px;">
                        	<div class="col-xl-12">
                            	<div class="card mb-4">
                                    <div class="card-header">
                                    	<div>
                                    		<select class="admin_srchBox" style="width:150px;" id="searchType">
                                    			<option value="id">아이디</option>
                                    			<option value="name">이름</option>                                			
                                    			<option value="postContent">글내용</option>
                                    		</select>
                                    		<input id="searchVal"></input>
                                    	</div>
                                    	<div>
                                    		<select class="admin_srchBox" style="width:150px;" id="postShowYn">
                                    			<option value="">전체</option>
                                    			<option value="Y">노출</option>
                                    			<option value="N">미노출</option>
                                    		</select>
                                    	</div>
                                  		<div style="">
                                  			<button id="searchBtn" style="margin:auto; display:block;" onclick="clickSrchBtn(1)">검색</button>
                                  		</div>
                                 	 </div>
                                  </div>
                                    	<div id="boardTable">
                                    		<table class="">
                                    			<thead>
                                    				<tr>
                                    					<td>번호</td>
                                    					<td>피드글</td>
                                    					<td>이름</td>
                                    					<td>아이디</td>
                                    					<td>등록일</td>
                                    					<td>댓글수</td>
                                    					<td>미노출처리</td>
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
            <!-- end 메인 콘텐트 -->
	
    <footer id="ntfooter" class="p-5 text-center">
            copyright 멍냥일보 2023
    </footer>

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
    
     <%@ include file="./adminSide.jsp"  %> 
    
    <!-- mobile menu -->
    <div id="nt_menu_canvas" class="nt_fk_canvas nt_sleft dn lazyload pt-3">
        <i class="close_pp pegk pe-7s-close ts__03 cd"></i>
        <div class="pr mb_nav_ul flex al_center fl_center p-3" >멍냥일보</div>      
    </div>
    <!-- end mobile menu -->

    <!-- back to top button-->
    <a id="nt_backtop" class="pf br__50 z__100 des_bt1" href="#"><span class="tc br__50 db cw">
    <i class="pr pegk pe-7s-angle-up"></i></span></a>
    
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
    
    <script type="text/javascript">
    	var boardArrayList = new Array();
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
	    	
	    	// 게시글 노출여부 값
	    	var postShowYn = $('#postShowYn option:selected').val();
	    	
	    	var param = 
	    		{
	    			"srchType"		:	srchType	,
	    			"srchVal" 		:	srchVal 	,
	    			"postShowYn"	:	postShowYn	,
	    			"cntPerPage"	:   cntPerPage	,
	    			"pageIdx"		:	pageIdx
	    		}
    		
	    	$.ajax({
	    		url:"${ path }/admin/boardmanage/boardlist",
	    		type:"GET",
	    		contentType:"json",
	    		data:param,
	    		success: function(data){
	    			boardArrayList = data;
	    			$('#boardTable').html("");
	    			$('#pagingArea').html("");
	    			var htmlString = "";
    				htmlString += "<table>";
    				htmlString += "		<thead>";
    			 	htmlString += "		<tr>";
    				htmlString += "			<td>번호</td>";
    				htmlString += "			<td>피드글</td>";
    				htmlString += "			<td>이름</td>";
    				htmlString += "			<td>아이디</td>";
    				htmlString += "			<td>등록일</td>";
    				htmlString += "			<td>댓글수</td>";
    				htmlString += "			<td>미노출처리</td>";
    				htmlString += "		</tr>";
    				htmlString += "</thead>";
		   				if(data.length > 0)
		    			{
			    				htmlString += "<tbody>";
		    				for(var i = 0 ; i < data.length ; i++){
				    			htmlString += "		<tr>"
			    				htmlString += "			<td>" + data[i].postId + "</td>"
			    				htmlString += "			<td>" + data[i].postContent + "</td>"
			    				htmlString += "			<td>" + data[i].memberName + "</td>"
			    				htmlString += "			<td>" + data[i].memberId + "</td>"
			    				htmlString += "			<td>" + data[i].postCreateDate + "</td>"
			    				htmlString += "			<td>" + data[i].replyCnt + "</td>"
				    			htmlString += "			<td>"
				    			if(data[i].postShowYn == 'Y'){
					    			htmlString += "			<button class='btshow' style='background-color: #fff'>노출</button>"
				    			} else {
					    			htmlString += "			<button class='btshow' style='background-color: #878787'>미노출</button>"
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
	    			$('#boardTable').append(htmlString);
	    			$('#pagingArea').append(pagingString);
	    		},
	    		error: function(e){
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
    		var postId 		= boardArrayList[index].postId;
    		var postShowYn  = boardArrayList[index].postShowYn; 
    		
    		// postShowYn 가 Y 일때 N, N 일때 Y로 변수에 값 넣고
    		var ckText = "";
    		if( postShowYn == 'Y') {
    			postShowYn = 'N';	
    			ckText = "미노출 처리를 하시겠습니까?";
    		} else {
    			ckText = "노출 처리를 하시겠습니까?";
    			postShowYn = 'Y';	
    		}
    		var checkVal = confirm(ckText);
    		
    		var param = 
    		{
    				"postId"		: 	postId		,
    				"postShowYn"	: 	postShowYn
    		}
    		// confirm 확인 클릭 시 (true)
    		if(checkVal){ 
    			// 3. 해당 값으로 회원 활성여부 수정하는 API 비동기 처리
        		$.ajax({
    	    		type:'POST',
    	    		url:'${ path }/admin/boardmanage/post',
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