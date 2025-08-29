package com.elon.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.elon.member.model.service.MemberService;
import com.elon.member.model.vo.Member;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/member/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUpServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId 		= request.getParameter("memberId");
		String memberPw 		= request.getParameter("memberPw");
		String memberName 		= request.getParameter("memberName");
		String gender 			= request.getParameter("gender");
		int age 				= Integer.parseInt(request.getParameter("age"));
		String email 			= request.getParameter("email");
		String phone 			= request.getParameter("phone");
		String address 			= request.getParameter("address");
		String hobby 			= request.getParameter("hobby");
		Member member = new Member(memberId, memberPw, memberName, gender, age, email, phone, address, hobby);
		MemberService mService = new MemberService();
		int result = 0;
		result = mService.insertMember(member);
		if(result > 0) {
			response.sendRedirect("/");
		}else {
			request.setAttribute("errorMsg", "회원가입이 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
	}

}
