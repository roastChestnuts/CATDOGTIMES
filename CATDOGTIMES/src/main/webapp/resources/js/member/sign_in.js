	  
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
  	  // 유효성 검사(이메일, 패스워드)
	  $(document).ready(function () {		
		
		//패스워드 유효성 검사
		$("#sign_up_pw1").change(function(){
			var p1 = $("#sign_up_pw1");
				
			if(/^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{8,25}$/.test(p1.val())==false){
				$("#pwd_chk1").html("<b>영문자+숫자+특수문자 조합으로 8자리 이상 입력해주세요.</b>");
				$("#pwd_chk1").attr('style', 'visibility:visible; font-size:11px; color:#c4302b;');
			}else if(/^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{8,25}$/.test(p1.val())==true){
				$("#pwd_chk1").html("");
				$("#pwd_chk1").attr('style', 'visibility:hidden;');
			}
		});
		//비밀번호 일치여부 체크
		$("#sign_up_pw2").change(function(){
			var p1 = $("#sign_up_pw1");
			var p2 = $("#sign_up_pw2");
				
			if(p1.val() != p2.val()){
				$("#pwd_chk2").html("<b>비밀번호가 일치하지 않습니다.</b>");
				$("#pwd_chk2").attr('style', 'visibility:visible; font-size:11px; color:#c4302b;');
			}else{
				$("#pwd_chk2").html("");
				$("#pwd_chk2").attr('style', 'visibility:hidden;');
			}
		});
						
	});

    