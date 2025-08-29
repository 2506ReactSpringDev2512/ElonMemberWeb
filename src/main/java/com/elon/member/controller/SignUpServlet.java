package com.elon.member.controller;

import java.io.IOException;

import com.elon.member.model.service.MemberService;
import com.elon.member.model.vo.Member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		// index.jsp -> signup.jsp로 페이지 이동
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 오류 방지
		
		// 입력한 데이터를 DB에 저장하는 doPost
		String MemberId = request.getParameter("memberId");
		String MemberPwd = request.getParameter("memberPwd");
		String MemberName = request.getParameter("memberName");
		String Gender = request.getParameter("gender");
		int Age = Integer.parseInt(request.getParameter("age"));
		String Email = request.getParameter("email");
		String Phone = request.getParameter("phone");
		String Address = request.getParameter("address");
		String Hobby = request.getParameter("hobby");
		
		Member member = new Member(MemberId, MemberPwd, MemberName, Gender, Age
								, Email, Phone, Address, Hobby);
		
		MemberService mService = new MemberService();
		int result = mService.signUpMember(member);
		if(result > 0) {
			System.out.println("성공");
			response.sendRedirect("/");
		} else {
			System.out.println("실패");
			request.setAttribute("errorMsg", "회원 가입이 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
		
	}

}
