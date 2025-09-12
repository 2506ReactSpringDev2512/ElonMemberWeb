package com.elon.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.elon.member.common.JDBCTemplate;
import com.elon.member.common.SqlSessionTemplate;
import com.elon.member.model.dao.MemberDAO;
import com.elon.member.model.vo.Member;

public class MemberService {
	private JDBCTemplate jdbcTemplate;
	private SqlSession session;
	private MemberDAO mDao;
	
	public MemberService() {
		session = SqlSessionTemplate.getSqlSession();
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}
	
	public int insertMember(Member member) {
		int result = 0;
		result = mDao.insertMember(member, session);
		return result;
	}

	public List<Member> selectList() {
		List<Member> mList = null;
		mList = mDao.selectList(session);
		return mList;
	}

	public int deleteMember(String memberId) {
		int result = 0;
		result = mDao.deleteMember(memberId, session);
		return result;
	}
	
	public int updateMember(Member member) {
		int result = 0;
		result = mDao.updateMember(member, session);
		return result;
	}

	public Member selectOneById(String memberId) {
		Member member = null;
		member = mDao.selectOneById(memberId, session);
		return member;
	}

	public Member checkLogin(Member member) {
		Member mOne = null;
		mOne = mDao.checkLogin(member, session);
		return mOne;
	}

}
