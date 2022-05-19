package com.jslhrd.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jslhrd.dao.BoardDAO;
import com.jslhrd.dto.BoardVO;

public class BoardDeleteAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
			String num=request.getParameter("num");
			
			BoardDAO dao = new BoardDAO();
			dao.getInstance();
			dao.deleteBoard(num);
			dao.deleteBoard2();
			
			new BoardListAction().execute(request, response);
			
		}
	}


