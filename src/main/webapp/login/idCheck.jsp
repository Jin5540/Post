<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<script src="../js/js.js"></script>
</head>
<body>
<h2>아이디 중복확인</h2>
<form action="/M24_3/login/idCheck.do" method="get" name="myform">

아이디 <input type="text" name="userid" value="${userid}">
<input type="submit" value="중복체크">
<br>
<c:if test="${result == 1}">
사용중인 아이디입니다.
</c:if>
<c:if test="${result == -1}">
사용가능한 아이디입니다.<br>
<input type="button" value="사용" class="cancel" onclick="idok()">
</c:if>	
</form>
</body>
</html>