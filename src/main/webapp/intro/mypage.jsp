<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<%@  include file = "../common/header.jsp" %>
<!-- p488 -->
마이페이지
${loginUser.name}(${loginUser.userid})님 <br>

<!-- p488 -->
<%@  include file = "../common/footer.jsp" %>
</body>
</html>