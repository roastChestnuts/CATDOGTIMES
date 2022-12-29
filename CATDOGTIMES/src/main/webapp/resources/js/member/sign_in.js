	  
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
	  
      
  	  
  	  // 유효성 검사(이메일, 패스워드)
	  $(document).ready(function () {		
		
		//패스워드 유효성 검사
		$("#sign_up_pw1").change(function(){
			var p1 = $("#sign_up_pw1");
			let passwordCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{8,25}$/;
				
			if(passwordCheck.test(p1.val())==false){
				$("#pwd_chk1").html("<b>영문자+숫자+특수문자 조합으로 8자리 이상 입력해주세요.</b>");
				$("#pwd_chk1").attr('style', 'visibility:visible; font-size:11px; color:#c4302b;');
			}else if(passwordCheck.test(p1.val())==true){
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


		
		//다음 주소 api
		function execute_daum_address(){
 
    		new daum.Postcode({
        		oncomplete: function(data) {
            		// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분
		            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	 
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	 
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 주소변수 문자열과 참고항목 문자열 합치기
                  		addr += extraAddr;
	                
	                } else {
	                    addr += ' ';
	                }
	 
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                $("[name=zipcode]").val(data.zonecode);    
            		$("[name=address]").val(addr);            
	                // 상세주소 입력란 disabled 속성 변경 및 커서를 상세주소 필드로 이동한다.
		            $("[name=detailAddress]").attr("readonly",false);
            		$("[name=detailAddress]").focus();
 
		        }
    		}).open();    
 
		}
    