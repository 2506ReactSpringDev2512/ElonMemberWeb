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
		// update.jsp 에서 아이디 입력창에 아이디를 입력하면
		String memberId = request.getParameter("memberId");
		MemberService mService = new MemberService();
		// 입력한 아이디로 DB에 데이터가 존재하는지 확인
		Member member = mService.selectOneById(memberId);
		String path = "/WEB-INF/views/member/update.jsp";
		if(member != null) {
			// update.jsp 에서 member를 member키로 사용할 수 있도록
			// request 객체에 저장해줌
			request.setAttribute("member", member);
			path = "/WEB-INF/views/member/update.jsp";
		}/*else {
			request.setAttribute("noDataFound", "데이터가 존재하지 않습니다.");
			//path = "/WEB-INF/views/common/error.jsp";
		}*/
		
		request.getRequestDispatcher(path).forward(request, response);
	
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
