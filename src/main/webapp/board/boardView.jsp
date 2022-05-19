<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%@ page import ="com.jslhrd.dto.*"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Study</title>
</head>
<body>
<!doctype html>
<html class="h-100">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, ÃªÂ·Â¸Ã«Â¦Â¬ÃªÂ³Â  Bootstrap ÃªÂ¸Â°Ã¬Â Â¬Ã¬Â Â Ã«Â Â¤">
    <meta name="generator" content="Hugo 0.87.0">
    <script type="text/javascript" src="/J1/js/delete.js"></script>

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

table, th{
border: 1px solid black;
padding : 20px 30px

} 

 
table, td{
border: 1px solid black;
padding : 20px 30px
}

table{
 
height: 40px;
margin: auto;
text-align: center;
}

.button {
  background-color:bs-gray-700;
  border-color:gray;
  padding: 0.25rem 0.5rem;
  font-size: 0.875rem;
  border-radius: 0.2rem;
  color:black;
}
      
    </style>


 </head>
  <body>
<div id="wrap" align="center">    
 <%@ include file="/common/header.jsp"%>
 <%@ page import="java.io.File" %>

 <%@ page import="java.util.*" %>

<main>

  <section class="py-5 text-center container">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">POST IT</h1>
        <p class="lead text-muted">The ship is safe when staying at the port, but that's not the reason for the ship's existence.</p>
      </div>
    </div>
  </section>
  
<img style="max-width:100%;height:500px" src="/M24_3/img/${board.picture1}" alt="">   
<br><br>
<table width=70%>
<div id="board">
<tr height="40"> 
<th> date</th><td colspan="3" >${board.date}</td>
</tr>


<tr height="40">
<th>title</th>
<td colspan="3">
${board.title}</td>
</tr>


<tr height="40">
<th>id</th>
<td colspan="3">${board.id}</td>
</tr>


<tr height="40">
<th>comment</th>
<td colspan="3">${board.comment}</td>
</tr>





</div>
</table>
<br><br>
<button class="button" onclick="location.href='BoardServlet?command=board_list'">list</button>

<%
String str =  (String) session.getAttribute("id");
BoardVO vo = (BoardVO) request.getAttribute("board");
if(str!=null){
if(str.equals(vo.getId())){
%>
<button class="button" onclick="location.href='BoardServlet?command=board_update_form&num=${board.num}'">edit</button>
<button class="button" onclick="location.href='BoardServlet?command=board_delete&num=${board.num}'">delete</button>
<%}}%>

</div>
</main>
</body>
</html>


</main>
<%@ include file="../common/footer.jsp"%>   

      

</body>
</html>
