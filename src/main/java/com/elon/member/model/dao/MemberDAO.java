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

	public int signupMember(Member member, Connection conn) throws SQLException {
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

	public List<Member> listMember(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rset = null;
		List<Member> mList = new ArrayList<Member>();
		String query = "SELECT * FROM MEMBER_TBL ORDER BY MEMBER_ID";
		
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		while(rset.next()) {
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
			mList.add(member);
		}
		rset.close();
		stmt.close();
		conn.close();
		return mList;
	}

	public int updateMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER_TBL SET MEMBER_PWD = ?, EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE MEMBER_ID = ?";
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

	public List<Member> searchMember(String memberId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> mList = null;
		String query = "SELECT MEMBER_ID, MEMBER_PWD, MEMBER_NAME, EMAIL, PHONE, ADDRESS, HOBBY FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		rset = pstmt.executeQuery();
		mList = new ArrayList<Member>();

		while (rset.next()) {
			String memberPwd = rset.getString("MEMBER_PWD");
			String memberName = rset.getString("MEMBER_NAME");
			String Email = rset.getString("EMAIL");
			String Phone = rset.getString("PHONE");
			String Address = rset.getString("ADDRESS");
			String Hobby = rset.getString("HOBBY");

			Member member = new Member(memberId, memberPwd, memberName, Email, Phone, Address, Hobby);
			mList.add(member);
		}
		return mList;
	}

	public List<Member> loginMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Member> mList = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID=? AND MEMBER_PWD=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		rset = pstmt.executeQuery();
		mList = new ArrayList<Member>();
		
		while(rset.next()) {
			String memberId = rset.getString("MEMBER_ID");
			String memberPwd = rset.getString("MEMBER_PWD");
			String memberName = rset.getString("MEMBER_NAME");
			String gender = rset.getString("GENDER");
			int age = rset.getInt("AGE");
			String email = rset.getString("EMAIL");
			String phone = rset.getString("PHONE");
			String address = rset.getString("ADDRESS");
			String hobby = rset.getString("HOBBY");
			
			Member loginMember = new Member(memberId, memberPwd, memberName, gender, age, email, phone, address, hobby);
			mList.add(loginMember);
		}
		return mList;
	}

}