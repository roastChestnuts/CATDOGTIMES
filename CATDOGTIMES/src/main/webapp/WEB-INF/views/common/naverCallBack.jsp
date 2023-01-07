<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="path" value="${ pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>

<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script>
	var naverLogin = new naver.LoginWithNaverId({
		clientId: "mxxEZM0mxB_D9crAuaD9", 
		callbackUrl: "{ path }/member/naverLogin", 
		isPopup: false,
		callbackHandle: true
	});
	naverLogin.init();

	window.addEventListener('load', function () {
	naverLogin.getLoginStatus(function (status) {

	if (status) {
		console.log(naverLogin); 
		console.log(naverLogin.user); 
		let snsId = naverLogin.user.getId(); //id => snsid로 사용
		let name = naverLogin.user.getName(); //이름
		let email = naverLogin.user.getEmail(); //이메일
		let nickName = naverLogin.user.getNickName(); //닉네임
		let gender = naverLogin.user.getGender(); //성별
		
		
		$.ajax({
			type: 'post',
			url: '${ path }/member/naverSave',
			data: JSON.stringify({  //json객체를 string으로 변환시켜 controller에서 받을 수 있게
				    'name':name, 
				    'email':email, 
				    'nickName':nickName, 
				    'gender':gender,
				    'snsId':snsId
			}),
			dataType: 'text', //서버에서 리턴받아오는 데이터 타입
			contentType: 'application/json',
			success: function(result) {
				if(result=='ok') {
					console.log('성공')
					location.replace("${ path }/") 
				} else if(result=='no') {
					console.log('실패')
					location.replace("${ path }/member/login")
				}
			},
			error: function(result) {
				console.log('오류 발생')
			}
		})

	} else {
		console.log("callback 처리에 실패하였습니다.");
	}
	});
});
</script>
</body>
</html>