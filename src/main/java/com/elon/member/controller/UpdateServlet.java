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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// update.jsp에서 아이디 입력에 아이디를 입력하면	
		String memberId = request.getParameter("memberId");
		MemberService mService = new MemberService();
		// 입력한 아이디로 DB에 데이터가 존재하는지 확인
		Member member = mService.selectOneById(memberId);
		if(member != null) {
			// update.jsp에서 member를 member키로 사용할 수 있도록
			// request객체에 저장해줌
			request.setAttribute("member", member);
		}
		request.getRequestDispatcher("/WEB-INF/views/member/update.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		Member member = new Member(memberId, memberPwd, email, phone, address, hobby);
		MemberService mService = new MemberService();
		int result = mService.updateMember(member);
		if(result > 0) {
			response.sendRedirect("/");
		}
		else {
			request.setAttribute("errorMsg", "회원정보 수정이 완료되지 않았습니다");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
	}

}
