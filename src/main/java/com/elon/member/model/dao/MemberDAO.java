package com.elon.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.elon.member.model.vo.Member;

public class MemberDAO {

	public List<Member> selectList(SqlSession session)  {
		List<Member> mList = session.selectList("MemberMapper.selectList");
		return mList;
	}
	public Member selectOneById(String memberId, SqlSession session)  {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}
	public Member checkLogin(Member member, SqlSession session)  {
		Member mOne = session.selectOne("MemberMapper.checkLogin", member);
		return mOne;
	}
	public int insertMember(Member member, SqlSession session)  {
		int result = session.insert("MemberMapper.insertMember", member);
		return result;
	}
	public int updateMember(Member member, SqlSession session)  {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}
	public int deleteMember(String memberId, SqlSession session)  {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

}
