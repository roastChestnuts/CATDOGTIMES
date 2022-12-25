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
	<link href="${ path }/resources/css/member/sign_in.css" rel="stylesheet">
	<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
  	<script src="https://code.iconify.design/iconify-icon/1.0.2/iconify-icon.min.js"></script>
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
        
        <!--create account form -->
        <form action="" class="login__create none" id="login-up">
          <h1 class="login__title">회원가입</h1>
          <div class="login__box">
            <i class='bx bx-user login__icon'></i>
            <input type="text" placeholder="ID" class="login__input">
          </div>
          
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="Password" class="login__input">
          </div>

          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="Password" class="login__input">
          </div>

          <div class="login__box">
            <i class='bx bx-at login__icon'></i>
            <input type="text" placeholder="name" class="login__input">
          </div>

          <div class="login__box">
            <i class='bx bx-at login__icon'></i>
            <input type="text" placeholder="nickname" class="login__input">
          </div>

          <div class="login__box">
            <i class='bx bx-at login__icon'></i>
            <input type="text" placeholder="Email" class="login__input">
          </div>
          
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="address" class="login__input">
          </div>

          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="gender" class="login__input">
          </div>
          
          <a href="#" class="login__button">회원가입</a>
          
          <div>
            <span class="login__account login__account--account">이미 계정이 있으신가요?</span>
            <span class="login__signup login__signup--signup" id="sign-in">로그인</span>
          </div>
          
        </form>
      </div>
    </div>
   </div>

   <script type="text/javascript">	
      const signup = document.getElementById("sign-up");
      signin = document.getElementById("sign-in");
      loginin = document.getElementById("login-in");
      loginup = document.getElementById("login-up");
      
      signup.addEventListener("click", () => {
          loginin.classList.remove("block");
          loginup.classList.remove("none");
      
          loginin.classList.add("none");
          loginup.classList.add("block");
      })
      
      signin.addEventListener("click", () => {
          loginin.classList.remove("none");
          loginup.classList.remove("block");
      
          loginin.classList.add("block");
          loginup.classList.add("none");
      })	
 	  //로그인 폼 제출 이벤트     
      function login() {
		if(document.getElementById("id").value==''){
			alert("아이디를 입력해주십시오.");
			return false;
		}
		if(document.getElementById("password").value==''){
			alert("비밀번호를 입력해주십시오.");
			return false;
		}
		document.getElementById('login-in').submit();
	  }
    </script>	
</body>



</html>