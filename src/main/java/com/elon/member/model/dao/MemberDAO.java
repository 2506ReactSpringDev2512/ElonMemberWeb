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
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER_TBL";
		pstmt = conn.prepareStatement(query);
		rset = pstmt.executeQuery();
		List<Member> mList = new ArrayList<Member>();
		
		while(rset.next()) {
			Member member = new Member();
			member.setMemberId(rset.getString("MEMBER_ID"));
			member.setMemberName(rset.getString("MEMBER_NAME"));
			member.setGender(rset.getString("GENDER"));
			member.setAge(rset.getInt("AGE"));
			member.setEmail(rset.getString("EMAIL"));
			member.setPhone(rset.getString("PHONE"));
			member.setAddress(rset.getString("ADDRESS"));
			member.setHobby(rset.getString("HOBBY"));
			java.sql.Date enrollDate = rset.getDate("ENROLL_DATE");
			member.setEnrollDate(enrollDate);
			
			mList.add(member);
		}
		
		return mList;
	}

	/*private Member rsetToMember(ResultSet rset) throws SQLException {
		String memberId   = rset.getString("MEMBER_ID");
		String memberPwd  = rset.getString("MEMBER_PWD");
		String memberName = rset.getString("MEMBER_NAME");
		String gender	  = rset.getString("GENDER");
		int age			  = rset.getInt("AGE");
		String email	  = rset.getString("EMAIL");
		String phone	  = rset.getString("PHONE");
		String address	  = rset.getString("ADDRESS");
		String hobby	  = rset.getString("HOBBY");
		java.sql.Date enrollDate	  = rset.getDate("ENROLL_DATE");
		Member member = new Member(memberId, memberPwd, memberName
				, gender, age, email, phone, address, hobby, enrollDate);
		return member;
	}*/

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

	public Member selectOneById(String memberId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			member = rsetToMember(rset);
		}
		rset.close();
		pstmt.close();
		conn.close();
 		return member;
	}

	private Member rsetToMember(ResultSet rset) throws SQLException {
		String memberId   = rset.getString("MEMBER_ID");
		String memberPwd  = rset.getString("MEMBER_PW");
		String memberName = rset.getString("MEMBER_NAME");
		String gender	  = rset.getString("GENDER");
		int age			  = rset.getInt("AGE");
		String email	  = rset.getString("EMAIL");
		String phone	  = rset.getString("PHONE");
		String address	  = rset.getString("ADDRESS");
		String hobby	  = rset.getString("HOBBY");
		java.sql.Date enrollDate	  = rset.getDate("ENROLL_DATE");
		Member member = new Member(memberId, memberPwd, memberName
				, gender, age, email, phone, address, hobby, enrollDate);
		return member;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
