package com.elon.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elon.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER_TBL VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT)";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		pstmt.setString(3, member.getMemberName());
		pstmt.setString(4, member.getGender());
		pstmt.setInt(5, member.getAge());
		pstmt.setString(6, member.getEmail());
		pstmt.setString(7, member.getPhone());
		pstmt.setString(8, member.getAddress());
		pstmt.setString(9, member.getHobby());
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}

	public int deleteMember(String memberName, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_NAME = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberName);
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}

	public List<Member> selectList(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER_TBL";
		pstmt = conn.prepareStatement(query);
		rset = pstmt.executeQuery();
		List<Member> mList = new ArrayList<Member>();
		while(rset.next()) {
			Member member = new Member();
			member.setMemberId(rset.getString("MEMBER_ID"));
			member.setMemberPwd(rset.getString("MEMBER_PWD"));
			member.setMemberName(rset.getString("MEMBER_NAME"));
			member.setGender(rset.getString("GENDER"));
			member.setAge(rset.getInt("AGE"));
			member.setEmail(rset.getString("EMAIL"));
			member.setPhone(rset.getString("PHONE"));
			member.setAdderss(rset.getString("ADDRESS"));
			member.setHobby(rset.getString("HOBBY"));
			member.setEnrollDate(rset.getDate("ENROLL_DATE"));
			mList.add(member);
		}
		return mList;
	}

	public int updateMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER_TBL SET MEMBER_ID = ?, MEMBER_PWD = ?, EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE MEMBER_NAME = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		pstmt.setString(3, member.getEmail());
		pstmt.setString(4, member.getPhone());
		pstmt.setString(5, member.getAddress());
		pstmt.setString(6, member.getHobby());
		pstmt.setString(7, member.getMemberName());		
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}


	public Member selectOneById(String memberId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		rset = pstmt.executeQuery();
		Member member = null;
		String memberPwd = rset.getString("MEMBER_PWD");
		String memberName = rset.getString("MEMBER_NAME");
		String gender = rset.getString("GENDER");
		int age = rset.getInt("AGE");
		String email = rset.getString("EMAIL");
		String phone = rset.getString("PHONE");
		String adderss = rset.getString("ADDRESS");
		String hobby = rset.getString("HOBBY");
		Date enrollDate = rset.getDate("ENROLL_DATE");
		member = new Member(memberId, memberPwd, memberName, gender, age, email, phone, adderss, hobby, enrollDate);
		pstmt.close();
		rset.close();
		return member;
	}


}
