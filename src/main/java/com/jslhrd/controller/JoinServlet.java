package com.jslhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jslhrd.dto.MemberVO;
import com.jslhrd.dao.MemberDAO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/login/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String url="/login/join.jsp";
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/login/login.jsp";
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("회원가입");
		request.setCharacterEncoding("UTF-8");
		String name= request.getParameter("name");
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String admin=request.getParameter("admin");	
		//doGet(request, response);
		
		//mVo
		MemberVO mVo = new MemberVO();
		mVo.setName(name);
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setAdmin(Integer.parseInt(admin));	
		//mDao
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertMember(mVo); //1,0
		HttpSession session = request.getSession();
		if(result == 1)
		{
			session.setAttribute("userid",mVo.getUserid());
			request.setAttribute("message", "회원가입에 성공했습니다.");
			//System.out.print("회원가입성공");
		
		} else {
			//System.out.print("회원가입실패");		
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		//이동 
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
