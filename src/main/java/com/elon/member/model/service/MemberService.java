package com.elon.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.elon.member.common.JDBCTemplate;

import com.elon.member.model.dao.MemberDAO;
import com.elon.member.model.vo.Member;

public class MemberService {
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDAO;
	
	public MemberService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		mDAO = new MemberDAO();
	}
	
	public int signupMember(Member member) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mDAO.signupMember(member,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Member> selectList() {
		List<Member> mList = null;
		try {
			Connection conn = jdbcTemplate.getConnection();
			mList = mDAO.selectMemberList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}

	public int deleteMember(String memberName, String memberId, String memberPw) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mDAO.deleteMemberInfo(memberName,memberId,memberPw , conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
