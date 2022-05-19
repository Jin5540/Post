<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<c:if test="${empty loginUser}">
<jsp:forward page='/login/login.jsp' />
</c:if>
<!-- p487, p308,p311,p346, p639 커스텀태그 --> 
   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, ÃªÂ·Â¸Ã«Â¦Â¬ÃªÂ³Â  Bootstrap ÃªÂ¸Â°Ã¬Â Â¬Ã¬Â Â Ã«Â Â¤">
    <meta name="generator" content="Hugo 0.87.0">
    <script type="text/javascript" src="/M24_3/js/delete.js"></script>

    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/cover/">

    

    <!-- Bootstrap core CSS -->
<link href="/M24_3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">



    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

 
 
table, td{
border: 1px solid black
}

table{
 
height: 40px;
margin: auto;
text-align: center;
}

      
    </style>

</head>
<body>
<%@  include file = "../common/header.jsp" %>
${loginUser.name}(${loginUser.userid})님 <br>
<!-- p488,p507 -->
<form action="/M24_3/login/LogoutServlet">
<input type="submit" value="로그아웃">
<input type="button" value="정보수정" onclick="location.href='/M24_2/login/MemberUpdateServlet?userid=${loginUser.userid}'">
</form>
<!-- p488 -->
<%@  include file = "../common/footer.jsp" %>
</body>
</html>