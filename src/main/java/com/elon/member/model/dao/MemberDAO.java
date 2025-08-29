package com.elon.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.elon.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
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

	public int updateMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER_TBL SET MEMBER_PWD = ?, MEMBER_NAME = ?, GENDER = ?, AGE = ?, EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberPwd());
		pstmt.setString(2, member.getMemberName());
		pstmt.setString(3, member.getGender());
		pstmt.setInt(4, member.getAge());
		pstmt.setString(5, member.getEmail());
		pstmt.setString(6, member.getPhone());
		pstmt.setString(7, member.getAddress());
		pstmt.setString(8, member.getHobby());
		pstmt.setString(9, member.getMemberId());
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}

}