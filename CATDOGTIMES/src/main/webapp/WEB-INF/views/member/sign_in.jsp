<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="path" value="${ pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="${ path }/resources/css/member/sign_in.css?after" rel="stylesheet">
	<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
  	<script src="https://code.iconify.design/iconify-icon/1.0.2/iconify-icon.min.js"></script>
  	<!--jQuery-->
  	<script src="${ path }/resources/js/jquery-3.6.0.min.js"></script>
</head>

<body>

  <div class="login">
    <div class="login__content">
      <div class="login__img">
        <img src="https://image.freepik.com/free-vector/code-typing-concept-illustration_114360-3581.jpg" alt="user login">
      </div>
      <div class="login__forms">
        <!--로그인 폼 -->
        <form action="${ path }/member/login" method="POST" class="login__register" id="login-in">
          <h1 class="login__title">멍냥일보</h1>
          <div class="login__box">
            <i class='bx bx-user login__icon'></i>
            <input type="text" placeholder="Username" class="login__input" id="id" name="id">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="Password" class="login__input" id="password" name="password">
          </div>
          <a href="#" class="login__forgot">비밀번호 찾기</a>
          
          <a href="#" class="login__button" onclick="return login()">로그인</a> <!-- return받은 값이 true이면 제출 -->
          
          <div>
            <span class="login__account login__account--account">계정이 없으신가요?</span>
            <span class="login__signin login__signin--signup" id="sign-up">회원가입</span>
          </div>
          <div class="login__social">
          	<a href="#" class="login__social--icon"><iconify-icon icon="ri:kakao-talk-fill" width="32"/></a>
            <a href="#" class="login__social--icon"><iconify-icon icon="simple-icons:naver"/></a>
         </div>
        </form>
        
        <!-- 회원가입 폼 -->
        <form action="${ path }/member/sign_up" method="POST" class="login__create none" id="login-up">
          <h1 class="login__title">회원가입</h1>
          <div class="login__box">
            <i class='bx bx-user login__icon'></i>
            <input type="text" placeholder="아이디" class="login__input" id="sign_up_id" name="id" onchange="checkId()" onfocus="labelUp(this)" onblur="labelDown(this)">
            <input type="hidden" name="idCheckValue" value="0" />
          </div>
          <span class="id_length">4~20자 사이 영문자, 숫자로 입력해주세요.</span>
          <span class="id_ok">사용 가능한 아이디입니다.</span>
		  <span class="id_already">누군가 이 아이디를 사용하고 있어요.</span>
          
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="password" placeholder="비밀번호" class="login__input" id="sign_up_pw1" name="password">
          </div>
		  <span id="pwd_chk1"></span>
		  
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="password" placeholder="비밀번호 확인" class="login__input" id="sign_up_pw2">
          </div>
          <span id="pwd_chk2"></span>

          <div class="login__box">
            <i class='bx bx-at login__icon'></i>
            <input type="text" placeholder="name" class="login__input" id="sign_up_name" name="name" >
          </div>
                    
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <label><input type="radio" name="gender" value="M">남자</label>
            <label><input type="radio" name="gender" value="W">여자</label>
          </div>

          <div class="login__box">
            <i class='bx bx-at login__icon'></i>
            <input type="text" placeholder="nickname" class="login__input" name="nickName">
          </div>

          <div class="login__box">
            <i class='bx bx-at login__icon'></i>
            <input type="text" placeholder="Email" class="login__input" id="sign_up_email" name="email">
            <input type="button" class="form-control" id="btnEmailCheck" value="인증하기">
          </div>
          
          <div class="login__box">
            <i class='bx bx-at login__icon'></i>
            <input type="text" placeholder="인증번호 6자리 입력" class="login__input" id="sign_up_email_check" disabled="disabled" maxlength="6">
            <input type="button" class="form-control" id="btnEmailCheckNum" value="인증번호확인">
          </div>
          <span id="mail-check-warn"></span>
          
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="address" class="login__input" name="address">
          </div>

          
          <a href="#" class="login__button" onclick="return sign_up()">회원가입</a>
          
          <div>
            <span class="login__account login__account--account">이미 계정이 있으신가요?</span>
            <span class="login__signup login__signup--signup" id="sign-in">로그인</span>
          </div>
          
        </form>
      </div>
    </div>
   </div>
   
   <script type="text/javascript" src="${ path }/resources/js/member/sign_in.js?v=<%=System.currentTimeMillis() %>"></script>
   <script type="text/javascript">
	  //아이디 중복체크
	  function checkId(){
	    var id = $('#sign_up_id').val().trim(); //id값이 "sign_up_id"인 입력란의 값을 저장
		var idCheck = /^[a-z]+[a-z0-9]{3,21}$/; //아이디 형식체크 변수
		if(idCheck.test(id)){ //아이디 길이가 알맞을 때
		    $.ajax({
		        url:'${ path }/member/idCheck', //Controller에서 요청 받을 주소
		        type:'post', //POST 방식으로 전달
		        data:{id},
		        async:false, //동기식으로 전환
		        success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
		            if(cnt == 0){ //사용 가능한 아이디
		            	$("[name=idTest]").val("1"); //id체크 ok
		                $('.id_ok').css("display","inline-block"); 
		                $('.id_already').css("display", "none");
		                $('.id_length').css("display", "none");
		            } else { //이미 존재하는 아이디
		            	$("[name=idTest]").val("0");
		                $('.id_already').css("display","inline-block");
		                $('.id_ok').css("display", "none");
		                $('.id_length').css("display", "none");
		                alert("아이디를 다시 입력해주세요");
		                $('#sign_up_id').val('');
		            }
		        },
		        error:function(){
		            alert("에러입니다");
		        }
		    });
		}else{
			$("[name=idTest]").val("0");
			$('.id_length').css("display","inline-block");
			$('.id_already').css("display", "none");
			$('.id_ok').css("display", "none");
			sign_up_id.focus();
			return false;	
		}};
		//이메일 인증
		$('#btnEmailCheck').click(function() {
			const email = $('#sign_up_email').val(); // 이메일 주소값
			const checkInput = $('#sign_up_email_check'); // 인증번호 입력칸 
			
			$.ajax({
				url:'${ path }/member/mailCheck',
				type:'post',
				data:{email},
				success : function (data) {
					checkInput.attr('disabled',false);
					code=data;
					alert('인증번호가 전송되었습니다.')
				}}); 
		 }); 

   </script>   
</body>



</html>