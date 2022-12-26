	  
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
      //회원가입 이벤트
      function sign_up() {
  		if(document.getElementById("sign_up_id").value==''){
  			alert("아이디를 입력해주십시오.");
  			return false;
  		}
  		if(document.getElementById("sign_up_pw").value==''){
  			alert("비밀번호를 입력해주십시오.");
  			return false;
  		}
  		document.getElementById('login-up').submit();
  	  }

    