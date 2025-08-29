package com.elon.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.elon.member.model.service.MemberService;
import com.elon.member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/member/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/update.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId 	= request.getParameter("memberId");
		String memberPw		= request.getParameter("memberPw");
		String memberName 	= request.getParameter("memberName");
		String gender 		= request.getParameter("gender");
		if(gender != null) {
			System.out.println("GENDER DUBUGGING");
			System.out.println("받은 값 (원본): [" + gender + "]");
			System.out.println("받은 값의 바이트 길이 : " + gender.getBytes().length);
			
			gender = gender.trim();
			System.out.println("trim() 후 값: [" + gender + "]");
            System.out.println("trim() 후 바이트 길이: " + gender.getBytes().length);
            System.out.println("------------------------");
		}
		int age				= Integer.parseInt(request.getParameter("age"));
		String email		= request.getParameter("email");
		String phone		= request.getParameter("phone");
		String address		= request.getParameter("address");
		String hobby		= request.getParameter("hobby");
		
		Member member = new Member(memberId,memberPw, memberName, gender, age, email, phone,
				 					address, hobby);
		MemberService mService = new MemberService();
		int result = mService.updateMember(member);
		if(result > 0 ) {
			response.sendRedirect("/");
		}else {
			request.setAttribute("errorMsg", "회원 수정이 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
	
	}

}
