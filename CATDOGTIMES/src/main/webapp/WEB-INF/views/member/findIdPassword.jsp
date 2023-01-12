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
      <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
      <!--jQuery-->
      <script src="${ path }/resources/js/common/jquery-3.6.0.min.js"></script>
      <!-- bootstrap JS -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
      <!-- SweetAlert CSS -->
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
</head>

<body>
    <!-- ID search form -->
    <form id="id-search-form" class="form-inline">
      <label for="id-search-input" class="sr-only">Enter your email address:</label>
      <input type="text" id="id-search-input" name="email" class="form-control mr-sm-2" placeholder="Enter your email address">
      <button type="submit" class="btn btn-primary my-2 my-sm-0">Find ID</button>
    </form> 
    
    <!-- Password search form -->
    <form id="password-search-form" class="form-inline">
      <label for="password-search-input" class="sr-only">Enter your ID:</label>
      <input type="text" id="password-search-input" name="id" class="form-control mr-sm-2" placeholder="Enter your ID">
      <button type="submit" class="btn btn-primary my-2 my-sm-0">Find Password</button>
    </form> 
   
   
  
   <!-- SweetAlert2 JS -->
   <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
</body>


</html>