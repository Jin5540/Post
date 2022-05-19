package com.jslhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.dao.MemberDAO;
import com.jslhrd.dto.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//이미 로그인이 완료된 상태
		String url = "/M24_3/index.jsp";
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null)
		{
			url = "/index.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		/*p486*/
		String url="/login/login.jsp";
		System.out.println("로그인");
		
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(userid,pwd);
		if(result == 1)
		{
			MemberVO mVo = mDao.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			session.setAttribute("id", userid);
			request.setAttribute("message", "로그인에 성공했습니다.");
			url ="/index.jsp";
		} else if(result==0)
		{
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");		
			
		} else if(result == -1){
			request.setAttribute("message", "존재하지 않는 회원입니다.");			
		}
		
		//이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
