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
	
	public List<Member> selectList() {
		Connection conn = jdbcTemplate.getConnection();
		List<Member> mList = null;
		mList = mDao.selectList(conn);
		
		return mList;
	}

	public int insertMember(Member member) {
		int result = 0;
		Connection conn = jdbcTemplate.getConnection();
		try {
			result = mDao.insertMember(member, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
