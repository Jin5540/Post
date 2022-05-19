<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="/M24_3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<style> 

table {
        width: 40%;
        height:100px;
        margin:auto;

        position: relative;
        left: 0x;
        top: 130px;
        
}

td, th
{
padding: 10px;
}

.footer {
        position: relative;
        left: 0x;
        top: 130px;
}
</style>
</head>
<body>
<%@  include file="../common/header.jsp" %>
<form method="post" action="/M24_3/login/login.do" name="myform">
	<table width=100% >
  <tr>
	<td>아이디</td>
	<td><input type="text" name="userid"></td>
  </tr>
  <tr>
	<td>비밀번호</td>
	<td><input type="password" name="pwd"></td>
  </tr>
   <tr>
	<td colspan=2>
	<input type="submit" value="로그인"  onclick="return loginCheck()">
    <input type="reset" value="취소">
	<input type="button" value="회원가입"  onclick="location.href='join.do'">
	</td>
  </tr> 
</table>
</form>
<%@  include file="../common/footer.jsp" %>
</body>
</html>