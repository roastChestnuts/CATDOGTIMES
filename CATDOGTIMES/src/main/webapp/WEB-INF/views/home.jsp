<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="${path}/member/login"><div>로그인</div></a>
<a href="${path}/member/scrapTest"><div>등록번호 조회</div></a>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
