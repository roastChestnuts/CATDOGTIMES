<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- SweetAlert CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<!-- SweetAlert2 JS -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<body>
	<script>
		// 알림메세지를 띄움
		Swal.fire("${ msg }");
	
		// 실행시켜야할 스크립트가 있으면 실행
		if(${ not empty script }) {
			${ script }
		}
		
		// 페이지 이동
		location.replace("${ pageContext.request.contextPath }${ location }");
	</script>
</body>