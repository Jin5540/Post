package com.jslhrd.controller.action;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.dao.BoardDAO;
import com.jslhrd.dto.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteAction implements Action {
	/*
	BoardListAction()
	{
		System.out.println("BoardListAction�샇異�");
	}
	*/
	@Override//�옱�젙�쓽
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//String realPath = "C:\\Users\\당근\\eclipse-workspace\\M24_3\\src\\main\\webapp\\img";
		String realPath = "/var/lib/tomcat9/webapps/M24_3/img";

 	   File dir = new File(realPath);
 	   String[] filenames = dir.list();
 	   
 	
 	//String coment= request.getParameter("Coment");
 		
 	  System.out.println("request getContentType : " + request.getContentType());
		//out.println(realPath);
 	    MultipartRequest mr = new MultipartRequest(request,realPath,10*1024*1024,"utf-8",new DefaultFileRenamePolicy());
		

 	   
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title= mr.getParameter("Title");
		String title1=URLDecoder.decode(title,"utf-8");
		
		System.out.println("title 가져오는 값 "+title1);
		
		HttpSession session = request.getSession();
		session.getAttribute("ID");

		String str =  (String) session.getAttribute("id");


		String comment=mr.getParameter("Comment");
		String comment1=URLDecoder.decode(comment,"utf-8");
		
		
		
		String picture1=mr.getOriginalFileName("Picture1");
		String picture11="";
        picture11=URLDecoder.decode(picture1,"utf-8");
		
		
		
		
		
		String command = mr.getParameter("command");
		
		picture11= picture11.trim();
		
		

		
		
		//System.out.println("comment : "+request.getParameter("Comment"));
		System.out.println("title : "+request.getParameter("Title"));
		System.out.println("title : "+title1);
		System.out.println("id : "+str);
		
		BoardVO vo = new BoardVO();
		
		
		vo.setTitle(title1);

		vo.setComment(comment1);

		vo.setPicture1(picture11);
		
        vo.setId(str);
		
		
		
		
		
		BoardDAO da = new BoardDAO();
		da.getInstance();
		da.insertBoard(vo);
		da.insertBoard2();
		
		//new BoardListAction().execute(request, response);
		response.sendRedirect("BoardServlet?command=board_list");
	}
	}