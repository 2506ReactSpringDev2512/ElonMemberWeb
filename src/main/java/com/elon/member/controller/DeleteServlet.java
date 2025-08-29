package com.elon.member.controller;

import java.io.IOException;

import com.elon.member.model.service.MemberService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		// index.jsp -> delete.jsp 페이지 이동
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/delete.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// delete.jsp에서 삭제 버튼을 눌렀을 때 동작하도록
		String memberId = request.getParameter("memberId");
		// 서블릿에서 getParameter 메소드의 전달값은 form 태그 안 input의 id 값을 적어야함.
		MemberService mService = new MemberService(); 
		int result = mService.deleteMember(memberId);
		if(result > 0) {
			response.sendRedirect("/");
		} else {
			request.setAttribute("errorMsg", "회원 정보가 삭제되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
			
		}
		
	}

}
