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

	public int insertMember(Member member) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mDao.insertStudent(member, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteMember(String memberId) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mDao.deleteMember(memberId, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Member> selectList() {
		List<Member> mList = null;
		try {
			Connection conn = jdbcTemplate.getConnection();
			mList = mDao.selectList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
		
	}

}
