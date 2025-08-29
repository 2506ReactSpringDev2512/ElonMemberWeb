package com.elon.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elon.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?, DEFAULT)";
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
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}

	public int updateMember(Member member, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER_TBL SET MEMBER_PWD = ?, "
				+ "EMAIL = ?,"
				+ "PHONE = ?,"
				+ "ADDRESS = ?,"
				+ "HOBBY = ? WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberPwd());
		pstmt.setString(2, member.getEmail());
		pstmt.setString(3, member.getPhone());
		pstmt.setString(4, member.getAddress());
		pstmt.setString(5, member.getHobby());
		pstmt.setString(6, member.getMemberId());
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}

	public Member searchMember(String memberId, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			member = MemberList(rset);
		}
		pstmt.close();
		rset.close();
		conn.close();
		return member;
	}

	public List<Member> listMember(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		List<Member> mList = new ArrayList<Member>();
		String query = "SELECT * FROM MEMBER_TBL ORDER BY MEMBER_ID";
		
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		while(rset.next()) {
			Member member = MemberList(rset);
			mList.add(member);
		}
		stmt.close();
		rset.close();
		conn.close();
		return mList;
	}
	
	public Member MemberList(ResultSet rset) throws SQLException {
		String memberId = rset.getString("MEMBER_ID");
		String memberPwd = rset.getString("MEMBER_PWD");
		String memberName = rset.getString("MEMBER_NAME");
		char gender = rset.getString("GENDER").charAt(0);
		int age = rset.getInt("AGE");
		String email = rset.getString("EMAIL");
		String phone = rset.getString("PHONE");
		String addr = rset.getString("ADDRESS");
		String hobby = rset.getString("HOBBY");
		Date enrollDate = rset.getDate("ENROLL_DATE");
		
		Member member = new Member(memberId, memberPwd, memberName, gender, age, email, phone,
				addr, hobby, enrollDate);
		
		return member;
	}
}
