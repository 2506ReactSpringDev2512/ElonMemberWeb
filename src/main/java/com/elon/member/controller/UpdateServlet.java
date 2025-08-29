package com.elon.member.controller;

import jakarta.servlet.RequestDispatcher;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		System.out.println(memberId);
		if (memberId == null || memberId.trim().isEmpty()) {
	        request.setAttribute("errorMsg", "회원 아이디를 입력하세요.");
	        request.getRequestDispatcher("/WEB-INF/views/member/update.jsp").forward(request, response);
	        return;
	    }
		MemberService mService = new MemberService();
		Member member = mService.selectOneById(memberId);
		
		if(member != null) {
			request.setAttribute("member", member);
		} 
		request.getRequestDispatcher("/WEB-INF/views/member/update.jsp").forward(request, response);
//		else {
//			request.setAttribute("errorMsg", "회원 정보 수정이 완료되지 않았습니다.");
//			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
//			.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String Email = request.getParameter("Email");
		String Phone = request.getParameter("Phone");
		String Address = request.getParameter("Address");
		System.out.println(memberName);
		Member member = new Member(memberId, memberPwd, memberName, Email, Phone, Address);
		MemberService mService = new MemberService();
		int result = mService.modifyMember(member);
		if(result > 0) {
			response.sendRedirect("/");
		}else {
			request.setAttribute("errorMsg", "회원 정보 수정이 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
	}

}
