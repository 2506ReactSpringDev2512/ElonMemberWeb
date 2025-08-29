package com.elon.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elon.member.model.vo.Member;

public class MemberDAO {

	public int signUpMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER_TBL VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		pstmt.setString(3, member.getMemberName());
		pstmt.setString(4, String.valueOf(member.getGender()));
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

	public int deleteMember(String memberId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	public List<Member> selectList(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER_TBL";
		
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		
		List<Member> mList = new ArrayList<Member>();
		
		while(rset.next()) {
			Member member = new Member();
			member.setMemberId(rset.getString("MEMBER_ID"));
			member.setMemberName(rset.getString("MEMBER_NAME"));
			member.setGender(rset.getString("GENDER").charAt(0));
			member.setAge(rset.getInt("AGE"));
			member.setEmail(rset.getString("EMAIL"));
			member.setPhone(rset.getString("PHONE"));
			member.setAddress(rset.getString("ADDRESS"));
			member.setHobby(rset.getString("HOBBY"));
			member.setEnrollDate(rset.getDate("ENROLL_DATE"));
			mList.add(member);
			
		}
		
		return mList;
	}

}
