package com.elon.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.elon.member.common.JDBCTemplate;
import com.elon.member.model.dao.MemberDAO;
import com.elon.member.model.vo.Member;

public class MemberService {
	
	private JDBCTemplate jdbctemplate;
	private MemberDAO mDao;
	
	public MemberService() {
		jdbctemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}
	
	public int insertMember(Member member) {
		int result = 0;
		try {
			Connection conn = jdbctemplate.getConnection();
			result = mDao.insertMember(member, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteMember(String memberId) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = jdbctemplate.getConnection();
			result = mDao.deleteMember(memberId, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = jdbctemplate.getConnection();
			result = mDao.updateMember(member, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Member searchMember(String memberId) {
		// TODO Auto-generated method stub
		Member member = null;
		try {
			Connection conn = jdbctemplate.getConnection();
			member = mDao.searchMember(memberId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	public List<Member> listMember() {
		List<Member> mList = null;
		
		try {
			Connection conn = jdbctemplate.getConnection();
			mList = mDao.listMember(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}
}
