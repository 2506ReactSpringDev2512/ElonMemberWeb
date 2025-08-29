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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/member/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// index.jsp에서 회원검색 누르면 동작하는거
		request.getRequestDispatcher("/WEB-INF/views/member/search.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// search.jsp에서 검색 버튼을 눌렀을때 동작하는거
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		MemberService mService = new MemberService();
		Member member = mService.searchMember(memberId);
		if(member != null) {
			// 검색 성공
			request.setAttribute("member", member);
			request.getRequestDispatcher("/WEB-INF/views/member/search.jsp")
			.forward(request, response);
		}else {
			// 검색 실패
			request.setAttribute("errorMsg", "해당 회원을 찾을 수 없습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
	}

}
