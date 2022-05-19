<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="com.jslhrd.dto.*"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edit</title>
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
    </style>
    
<%@ include file="../common/header.jsp"%>
<body class="bg-light">
<% request.setCharacterEncoding("UTF-8"); %>

    
<div class="container">
  <main>
    <div class="py-5 text-center">
      <n class="medium"><h1>Edit</h1>
      <p class="lead"></p>
    </div>


    

          <form method="post" action="BoardServlet?command=board_update&num=${board.num}" enctype="multipart/form-data">
          <form id="needs-validation" novalidate="">
     
          <input type="hidden" name="command" value="board_write">
          <div class="row g-3">
       

         <div class="col-sm-12">
              <n class="medium"><label for="Name" class="form-label">Title</label>
              <input type="text" class="form-control" name="Title" value="${board.title}" required="">
              <div class="invalid-feedback">
                Valid first title is required.
              </div>
            </div>
         
         

  
              <div class="col-sm-12">
              <n class="medium"><label for="Name" class="form-label">Comment</label>
              <input type="text" class="form-control" name="Comment" value="${board.comment}" required>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>
            
            
            
        
               

  
           <div class="col-sm-12">
              <n class="medium"><label for="picture" class="form-label"></label>
              <input type="file" class="form-control" name="Picture1" id="Picture1">
              <div class="invalid-feedback">
                Please provide a valid University name.
              </div>
            </div>
  
          
          
          
          
           <hr class="my-4">

          <div class="col-12">

          <n class="medium"><button type="submit" class="w-100 btn btn-dark btn-lg" >Submit form</button>
        </form>
      </form>
        
      </div>
    
    
  </main>
  
 <%@ include file="../common/footer.jsp"%>


     
  </body>
</html>