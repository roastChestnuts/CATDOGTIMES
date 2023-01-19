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
                                            <a href="/times/admin/dashboard" class="kalles-lbl__nav-sale"><span>대시보드</span></a>
                                        </li>
                                        <li class="menu-item ">
                                            <a href="/times/admin/usermanage" class="icon_search push_side cb chp"><span>사용자관리</span></a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="/times/admin/boardmanage" class="icon_search push_side cb chp"><span>피드관리</span></a>
                                        </li>
                                        <li class="menu-item ">
                                            <a href="/times/admin/routemanage" class="icon_search push_side cb chp"><span>산책루트관리</span></a>
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
             <span style="font-size:30px;font-weight:bold;">대시보드</span><br/>
             <span>멍냥일보 관리자 메인페이지 입니다.</span>
             <br><br>
             <div>
             	<span style="font-weight : bold;">최근 업데이트 : <span id="updateTime"></span></span>
             </div>
             <div class="row" style="padding-top:10px;">
             		<div class="col-xl-2">
                    	<div class="card mb-4">
                            <div class="card-header">
                                가입자 수
                            </div> 
                            <div class="card-body">
                            	<span>${totalList[0].totalMemberCnt}</span><br>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2.5">
                   		<div class="card mb-4">
                           <div class="card-header">
                               등록된 산책경로 수
                           </div> 
                           <div class="card-body">
                           		<span>${totalList[0].totalRouteCnt}</span><br>
                           </div>
                       	</div>
                   	</div>
                    <div class="col-xl-2">
                   		<div class="card mb-4">
                           <div class="card-header">
                               산책 매칭 수
                           </div> 
                           <div class="card-body">
                           		<span>${totalList[0].totalPartyCnt}</span><br>
                           </div>
                       	</div>
                   	</div>
                    <div class="col-xl-2.5">
                   		<div class="card mb-4">
                           <div class="card-header">
                               산책루트 평균 평점
                           </div> 
                           <div class="card-body">
                           		<span>${totalList[0].totalAvgRoute}</span><br>
                           </div>
                       	</div>
                   	</div>
                  	<div class="col-xl-2">
                    	<div class="card mb-4">
	                        <div class="card-header">
	                           피드 수
	                        </div> 
	                        <div class="card-body">
	                       		<span>${totalList[0].totalPostCnt}</span><br>
	                        </div>
                        </div>
                     </div>                 
                        	<div class="col-xl-12">
                            	<div class="card mb-6">
                                    <div class="card-header">
                                        <span>멍냥일보 서비스 월별 차트</span> 
                                        <div style="display: contents;">
                                    		<select class="admin_srchBox" style="width:150px;" id="yearVal">
                                    		</select>
                                    	</div>
                                    </div> 
                                    <div class="card-body">
                                    	<div id="yearlyChartDiv" style="height: 500px;"></div>
                                    </div>
                                </div>
                            </div>
                        	<div class="col-xl-12" style="padding-top:10px;">
                            	<div class="card mb-6">
                                    <div class="card-header">
                                        <span>멍냥일보 서비스 일별 차트</span> 
                                        <div style="display: contents;">
                                    		<select class="admin_srchBox" style="width:150px;" id="periodVal">
                                    			<option value="7">최근 7일</option>
                                    			<option value="15">최근 15일</option>
<!--                                     			<option value="30">최근 30일</option> -->
                                    		</select>
                                    	</div>
                                    </div> 
                                    <div class="card-body">
                                    	<div id="dailyChartDiv" style="height: 500px;"></div>
                                    </div>
                                </div>
                            </div>
                            </div>
<!--                             <div class="row" style="padding-top:20px;">
                        	<div class="col-xl-4">
                            	<div class="card mb-3">
                                    <div class="card-header">
                                       댓글 현황
                                    </div>
                                    <div class="card-body">
                                    <c:forEach var="data" items="${replyList}" varStatus="status"> 
                                    	<div style="font-weight:bold">
                                    		<a href="#">${data.replyContent}</a>
                                    	</div>
                                    	<div class="">
                                    		<a>${data.memberId}</a> 
                                    		<a>${data.replyCreatedDate}</a><br>
                                    	</div>
                                    </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-4">
                            	  <div class="card mb-3">
                                    <div class="card-header">
                                       게시글 현황 
                                    </div> 
                                    <div class="card-body">
                                    <c:forEach var="data" items="${boardList}" varStatus="status"> 
                                    <div style="font-weight:bold">
                                    	<a href="#">${data.postContent}</a></div>
                                    <div class="">	
                                    	<a>${data.memberId}</a> 
                                    	<a>${data.postCreateDate}</a><br>
                                    </div>
                                    </c:forEach>
                                    </div>
                                </div>
                            </div>
                         <div class="col-xl-4">
                            	  <div class="card mb-3">
                                    <div class="card-header">
                                       산책매칭 현황 
                                    </div> 
                                    <div class="card-body">
										<br><br><br><br><br>
										<br><br><br><br><br>
                                    </div>
                                  </div>
                               </div>
                         	</div>
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
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
	    $(document).ready(function(){
	    	
	    	var date = new Date();
	    	var today = dateFormat(date);
	    	$('#updateTime').text(today);
	    	
	    	getBeforeYear(date.getFullYear());
	    	
	    	google.charts.load('current', {'packages':['corechart']});
	   	    google.charts.setOnLoadCallback(yearlyCatDogTimesChart);
	   	    google.charts.setOnLoadCallback(dailyCatDogTimesChart);
	    	
		});
	    
	    // 현재 시간 포맷팅
	 	function dateFormat(date){
	 		  	let month = date.getMonth() + 1;
	 	        let day = date.getDate();
	 	        let hour = date.getHours();
	 	        let minute = date.getMinutes();
	 	        let second = date.getSeconds();

	 	        month = month >= 10 ? month : '0' + month;
	 	        day = day >= 10 ? day : '0' + day;
	 	        hour = hour >= 10 ? hour : '0' + hour;
	 	        minute = minute >= 10 ? minute : '0' + minute;
	 	        second = second >= 10 ? second : '0' + second;
	 	        
	 	        return date.getFullYear() + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
	 	}
	    
	    // 올해 기준 지난 5년 selectbox option 추가 함수
	    function getBeforeYear(year){
	    	
	    	var beforeYear = Number(year)-5;
	    	
	    	for(var i = year ; i > beforeYear ; i --){
	    		$('#yearVal').append("<option value=" + i +">" + i+ "</option>");
	    	}
	    }
	    
	    // 연도 셀렉트 박스 변경 이벤트
	    $('#yearVal').on("change", function(){
	    	yearlyCatDogTimesChart();
	    })
	    
	    // 연도 셀렉트 박스 변경 이벤트
	    $('#periodVal').on("change", function(){
	    	dailyCatDogTimesChart();
	    })
		
	    // 연간 차트 함수
	    function yearlyCatDogTimesChart() {
	    	
	    	var nowYear = $('#yearVal option:selected').val();
	    	
	    	var param =
	    		{
	    			"nowYear":nowYear
	    		}
	    	
	    	$.ajax({
	    		type:'GET',
	    		url:'${ path }/admin/dashboard/monthly',
	    		data:param,
	    		contentType:'application/json',
	    		dataType: 'json',
	    		success: function(data){
	    			// console.log('data ::: ' , data);
	    			var chartData = [['Year/Month', '가입자', '산책경로', '산책매칭', '피드']];
	    			
	    			for(var i = 0 ; i < data.length ; i++){
	    				for(var j = 0 ; j < data[0].length ; j ++)
	    					if(j==0){
	    						var convertStr = data[i][j].toString();
	    						var year = convertStr.substr(0,4);
	    						var month = convertStr.substr(4,2);
	    						data[i][j] = year + "/" + month;
	    					}
	    					chartData.push(data[i]);
	    			}
	    			//console.log('chartData ::: ' , chartData);
	    	        var data = google.visualization.arrayToDataTable(chartData);

	    	        var options = {
	    	          title : '',
	    	          vAxis: {title: ''},
	    	          hAxis: {title: ''},
	    	          seriesType: 'bars',
	    	          series: {5: {type: 'line'}}
	    	        };

	    	        var chart = new google.visualization.ComboChart(document.getElementById('yearlyChartDiv'));
	    	        chart.draw(data, options);
	    		},
	    		error: function(e){
	    			console.log(e);
	    		}
	    	})
	    	
	      }
	      
	      // 일간 차트 함수
	      function dailyCatDogTimesChart() {
	    	  
	    	 var periodVal =  $('#periodVal option:selected').val();
	    	 console.log('period ::: ' , periodVal);
	    	 
	    	 var date = new Date();    	 
	    	 var month = date.getMonth() + 1;
	 	     var day = date.getDate();
	 	     month = month >= 10 ? month : '0' + month;
	 	     day = day >= 10 ? day : '0' + day;
	 	        
	 	     var nowDay = date.getFullYear() + '-' + month + '-' + day;
	    	 // 임시데이터
	    	 
	    	 	var param =
	    		{
	    			"nowDay":nowDay,
	    			"periodVal":periodVal
	    		}
	    	
	    	$.ajax({
	    		type:'GET',
	    		url:'${ path }/admin/dashboard/daily',
	    		data:param,
	    		contentType:'application/json',
	    		dataType: 'json',
	    		success: function(data){
	    			var chartData = [['daily', '가입자', '산책경로', '산책매칭', '피드']];
	    			
	    			for(var i = 0 ; i < data.length ; i++){
	    				for(var j = 0 ; j < data[0].length ; j ++)
	    					if(j==0){
	    						var convertStr = data[i][j].toString();
	    						var year = convertStr.substr(0,4);
	    						var month = convertStr.substr(4,2);
	    						console.log(month);
	    						var day = convertStr.substr(6,2);
	    						data[i][j] = year + "/" + month + "/" + day;
	    					}
	    					chartData.push(data[i]);
	    			}
	    	        var data = google.visualization.arrayToDataTable(chartData);

    	       			var options = {
	    			          title: '',
	    			          curveType: 'function',
	    			          legend: { position: 'bottom' }
	    			        };
	    		        var chart = new google.visualization.LineChart(document.getElementById('dailyChartDiv'));
	    		        chart.draw(data, options);
	    		},
	    		error: function(e){
	    			console.log(e);
	    		}
	    	})
	    	 
	      }
	      
	     
    </script>
</body>

</html>