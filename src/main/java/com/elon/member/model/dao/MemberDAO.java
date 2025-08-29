package com.elon.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elon.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result =  0;
		String query = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
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
			member.setMemberName(rset.getString("MEMBER_NAME"));
		}
		
		return mList;
	}

	public int updateMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER_TBL SET MEMBER_ID = ?, MEMBER_PW = ? ,AGE=?,GENDER=?,EMAIL=?,PHONE=?,ADDRESS=?,HOBBY=? WHERE MEMBER_NAME = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		pstmt.setString(3, member.getMemberName());
		pstmt.setInt(4, member.getAge());
		pstmt.setString(5, String.valueOf(member.getGender()));
		pstmt.setString(6, member.getEmail());
		pstmt.setString(7, member.getPhone());
		pstmt.setString(8, member.getAddress());
		pstmt.setString(9, member.getHobby());
		
		result = pstmt.executeUpdate();
		
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
