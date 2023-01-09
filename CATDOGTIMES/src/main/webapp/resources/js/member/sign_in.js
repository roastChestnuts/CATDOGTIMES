	  
const signup = document.getElementById("sign-up"); //회원가입(앵커)
      signin = document.getElementById("sign-in"); 		 //로그인(앵커)
      findidspan = document.getElementById("find-id-span"); 		 //아이디 찾기(앵커)
      findpwspan = document.getElementById("find-pw-span"); 		 //비밀번호 찾기(앵커)
      //비밀번호 찾기
      loginin = document.getElementById("login-in");     //로그인 폼
      loginup = document.getElementById("login-up");     //회원가입 폼
      findid = document.getElementById("find-id");     //아이디 찾기 폼
      findpw = document.getElementById("find-pw");     //비밀번호 찾기 폼
      
      signup.addEventListener("click", () => {
          loginup.classList.remove("none");
          loginin.classList.remove("block");
		  findid.classList.remove("block");
		  findpw.classList.remove("block");
          
          findid.classList.add("none");   
          findpw.classList.add("none");
          loginin.classList.add("none");   
          loginup.classList.add("block");
      })
      
      signin.addEventListener("click", () => {
          loginin.classList.remove("none");
          loginup.classList.remove("block");
          findid.classList.remove("block");
          findpw.classList.remove("block");
      
          findpw.classList.add("none");
          findid.classList.add("none");
          loginup.classList.add("none");
          loginin.classList.add("block");
      })
      
      findidspan.addEventListener("click", () => {
          findid.classList.remove("none");
          loginin.classList.remove("block");
          loginup.classList.remove("block");
          findpw.classList.remove("block");
      
          findpw.classList.add("none");
          loginup.classList.add("none");
          loginin.classList.add("none");
          findid.classList.add("block");
      })	
      
      findpwspan.addEventListener("click", () => {
          findpw.classList.remove("none");
          loginin.classList.remove("block");
          loginup.classList.remove("block");
          findid.classList.remove("block");
          
          findid.classList.add("none");
          loginup.classList.add("none");
          loginin.classList.add("none");
          findpw.classList.add("block");
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
	  
      //카카오 로그인
      $(document).ready(function(){
	      Kakao.init('16ecd052b98a49fd46f3dd4e10e38c83');
	      Kakao.isInitialized();
	  });
	
	  function loginKakao() {
	      Kakao.Auth.authorize({ 
	      redirectUri: 'http://localhost:8088/times/member/kakaoLogin' 
	      }); // 등록한 리다이렉트uri 입력
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
	   //회원가입 이벤트
	   function sign_up() {
			let memberId = document.getElementById("sign_up_id");
			let memberPassword = document.getElementById("sign_up_pw1");
			let memberPassword2 = document.getElementById("sign_up_pw2");
			let memberName = document.getElementById("sign_up_name");
			let memberNickName = document.getElementById("sign_up_nickName");
			let memberEmail = document.getElementById("sign_up_email");
			let male = document.getElementById("male");
			let emailCheck = document.getElementById("emailCheckValue");//이메일 인증체크여부 변수
			let emailCheckNumber = document.getElementById("sign_up_email_check");
			let memberAddr = document.getElementById("address");
			let privacyCheck = document.getElementById("privacy_check");
			let termconditionsCheck = document.getElementById("termconditions_check");
			
	   		let idCheck2 = /^[a-z]+[a-z0-9]{3,21}$/; //아이디 형식체크 변수		
	   		// 비밀번호 체크
			let passwordCheck2 = /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{8,25}$/;
			// 이메일 형식
			let emailExpression2 = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
			
			//========[id]아이디 체크==============
			if (memberId.value == "") { 
				alert('아이디를 입력하세요.');
				memberId.focus();
				return false;	
			}
			
			if (!idCheck2.test(memberId.value)) {
				alert('아이디는 4~20자 사이 영문자, 숫자로 입력해주세요.');
				memberId.focus();
				return false;	
			}
			
			//중복검사 실시 유무
			if($("[name=idCheckValue]").val() != "1"){
				alert("이미 사용중인 아이디입니다.");
				$("#memberId").focus();
				return false;
			}
			//==================================
			
			//========[pwd]비밀번호 체크==============
			if(memberPassword.value == "") {
				alert('비밀번호를 입력하세요.');
				memberPassword.focus();
				return false;
			}
			
			if (!passwordCheck2.test(memberPassword.value)) {
				alert('비밀번호는 영문자+숫자+특수문자 조합으로 8자리 이상 입력해주세요.');
				memberPassword.focus();
				return false;
			}
			
			if (memberPassword2.value != memberPassword.value) {
				alert('비밀번호가 일치하지 않습니다.');
				memberPassword2.focus();
				return false;
			}
			//==================================
			//========[name]이름 체크==============
			if (memberName.value == "") { 
				alert('이름을 입력하세요.');
				memberName.focus();
				return false;	
			}
			//==================================	
			//========[gender]성별 체크==============	
			if ($("input[name=gender]:radio:checked").length == 0) {
				alert('성별을 선택해 주세요.');
				male.focus();
				return false;
			}
			//==================================
			//========[nickname]닉네임 체크==============	
			if (memberNickName.value == "") {
				alert('닉네임을 입력하세요.');
				memberNickName.focus();
				return false;
			}
						
			if($("[name=nickNameCheckValue]").val() == "0"){
				alert("중복된 닉네임입니다.");
				$("#memberNickname").focus();
				return false;
			}
			//==================================
			//========[email]이메일 체크==============
			if (memberEmail.value == "") {
				alert('이메일주소를 입력하세요.');
				memberEmail.focus();
				return false;
			} 
			
			if (!emailExpression2.test(memberEmail.value)) {
				alert('이메일 형식에 맞게 입력해주세요.');
				memberEmail.focus();
				return false;
			}
			
			if(typeof code !== "undefined" &&  emailCheckNumber.value !== code){
				alert('인증번호가 불일치 합니다. 다시 확인해주세요!');
				emailCheckNumber.focus();
				return false;
			} 
			
			//이메일 인증 실시 유무
			if(emailCheck.value == "0"){
				alert("이메일 인증을 해주세요");
				return false;
			}
			//================================== 
			//========[addr]주소 체크==============
			if (memberAddr.value == "") { 
				alert('주소를 입력하세요.');
				memberAddr.focus();
				return false;	
			}
			//==================================
			//========개인정보수집 동의 체크==============
			if (!privacy_check.checked) {
				Swal.fire('개인정보수집에 동의해주세요.')
				privacy_check.focus();
				return false;
			} 
		
			if (!termconditions_check.checked) {
				Swal.fire('이용약관에 동의해주세요.')
				termconditions_check.focus();
				return false;
			}
			//==================================
	  		document.getElementById('login-up').submit();
	   }
	   
	   
    