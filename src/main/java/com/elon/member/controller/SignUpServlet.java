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
		request.getRequestDispatcher("/WEB-INF/views/member/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId 	= request.getParameter("memberId");
		String memberPwd 	= request.getParameter("memberPwd");
		String memberName 	= request.getParameter("memberName");
		String gender 		= request.getParameter("gender");
		if(gender != null) {
			System.out.println("--- Gender Debugging ---");
            System.out.println("받은 값 (원본): [" + gender + "]");
            // 받은 값의 실제 바이트 길이를 확인합니다. (오류의 원인 추적)
            System.out.println("받은 값의 바이트 길이: " + gender.getBytes().length);
            
            gender = gender.trim();
            System.out.println("trim() 후 값: [" + gender + "]");
            System.out.println("trim() 후 바이트 길이: " + gender.getBytes().length);
            System.out.println("------------------------");
		}
		int age 			= Integer.parseInt(request.getParameter("age"));
		String email 		= request.getParameter("email");
		String phone 		= request.getParameter("phone");
		String address 		= request.getParameter("address");
		String hobby 		= request.getParameter("hobby");
		Member member = new Member(memberId, memberPwd, memberName, gender, age, email, phone, address, hobby);
		System.out.println(member.toString());
		MemberService mService = new MemberService();
		int result = mService.insertMember(member);
		if(result > 0) {
			response.sendRedirect("/");
		}else {
			request.setAttribute("errorMsg", "회원 가입이 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
	}
}
