package com.elon.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.elon.member.common.JDBCTemplate;
import com.elon.member.model.dao.MemberDAO;
import com.elon.member.model.vo.Member;

public class MemberService {
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;

	public MemberService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}

	public int signup(Member member) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mDao.signupMember(member, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int delete(String memberId) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mDao.deleteMember(memberId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Member> list() {
		List<Member> mList = null;
		Connection conn = jdbcTemplate.getConnection();
		try {
			mList = mDao.listMember(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}
}
