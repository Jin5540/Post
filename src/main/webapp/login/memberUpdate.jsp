<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>
<%@  include file="../common/header.jsp" %>
회원수정페이지<br>
*은 반드시 입력해주세요! <br>
<form method="post" action="memberUpdate.do">
<table width=100% border=1>
  <tr>
	<td>이름</td>
	<td><input type="text" name="name" value="${mVo.name}" readonly>*</td>
  </tr>
  <tr>
	<td>아이디</td>
	<td>
	<input type="text" name="userid" value="${mVo.userid}" readonly>*
	</td>
  </tr>
  <tr>
	<td>암호</td>
	<td><input type="text" name="pwd" >*</td>
  </tr>
  <tr>
	<td>암호확인</td>
	<td><input type="text" name="pwd_check">*</td>
  </tr>
  <tr>
	<td>이메일</td>
	<td><input type="text" name="email" value="${mVo.email}"></td>
  </tr>
  <tr>
	<td>전화번호</td>
	<td><input type="text" name="phone" value="${mVo.phone}"></td>
  </tr>
  <tr>
	<td>등급</td>
	<td>
	<c:choose>
		<c:when test="${mVo.admin==0}}" >
			<input type="radio" name="admin" value="0" checked="checked">일반회원
			<input type="radio" name="admin" value="1">관리자	
		</c:when>
		<c:otherwise>
			<input type="radio" name="admin" value="0">일반회원
			<input type="radio" name="admin" value="1" checked="checked">관리자		
		</c:otherwise>	
	</c:choose>
	</td>
  </tr>
   <tr>
	<td><input type="submit" value="수정"  onclick="return joinCheck()"></td>
	<td><input type="reset" value="취소"></td>
  </tr> 
  </table>
  </form>

<%@  include file="../common/footer.jsp" %>
</body>
</html>