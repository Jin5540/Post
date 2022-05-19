<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
<link href="/M24_3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="/M24_3/js/js.js"></script>
<form method="post" action="join.do" name="myform">
<table width=100%>
  <tr>
	<td>이름</td>
	<td><input type="text" name="name"></td>
  </tr>
  <tr>
	<td>아이디</td>
	<td>
	<input type="text" name="userid">
	<input type="hidden" name="reid">
	<input type="button" value="중복체크" onclick="idCheck()">
	</td>
  </tr>
  <tr>
	<td>암호</td>
	<td><input type="text" name="pwd"></td>
  </tr>
  <tr>
	<td>암호확인</td>
	<td><input type="text" name="pwd_check"></td>
  </tr>
  <tr>
	<td>이메일</td>
	<td><input type="text" name="email"></td>
  </tr>
  <tr>
	<td>전화번호</td>
	<td><input type="text" name="phone"></td>
  </tr>
  <tr>
	<td>등급</td>
	<td>
	<input type="radio" name="admin" value="0" checked="checked">일반회원
	<input type="radio" name="admin" value="1">관리자	
	</td>
  </tr>
   <tr>
	<td><input type="submit" value="등록"  onclick="return joinCheck()"></td>
	<td><input type="reset" value="취소"></td>
  </tr> 
  </table>
  </form>

<%@  include file="../common/footer.jsp" %>
</body>
</html>