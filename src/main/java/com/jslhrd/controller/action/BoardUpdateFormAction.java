package com.jslhrd.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.BoardDAO;
import com.jslhrd.dto.BoardVO;

public class BoardUpdateFormAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String url = "/board/boardUpdate.jsp";
		//String url2 = "/board/boardList.jsp";		
		String num= request.getParameter("num");
		//System.out.println(num);
		
		BoardDAO dao = new BoardDAO();
		dao.getInstance();
		
		dao.updateReadCount(num);
		
		try {
			BoardVO vo = dao.selectOneBoardByNum(num);
			
			request.setAttribute("board", vo);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	}