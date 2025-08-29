package com.elon.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.elon.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/member/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// index.jsp에서 회원정보삭제 누르면동작하는거
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/delete.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// delete.jsp에서 삭제 버튼을 눌렀을때 동작하는거
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId"); // 입력한 값을 받고
		MemberService mService = new MemberService(); // MemberService 객체 생성하고
		int result = mService.deleteMember(memberId); // deleteMember()메소드 호출
		if(result > 0) {
			// 메인페이지로 이동
			response.sendRedirect("/");
		}else {
			// 에러페이지로 이동
			request.setAttribute("errorMsg","회원 정보 삭제가 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
	}

}
