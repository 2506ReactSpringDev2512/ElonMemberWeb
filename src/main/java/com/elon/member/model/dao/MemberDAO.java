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

	public int signupMember(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		System.out.print("디버깅 "+member);
		int result =0;
		String query = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT)";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2 , member.getMemberPwd());
		pstmt.setString(3 , member.getMemberName());
		pstmt.setString(4 , String.valueOf(member.getGender()));
		pstmt.setInt(5 , member.getAge());
		pstmt.setString(6 , member.getEmail());
		pstmt.setString(7 , member.getPhone());
		pstmt.setString(8 , member.getPhone());
		pstmt.setString(9 , member.getAddress());
		result = pstmt.executeUpdate();
		conn.close();
		pstmt.close();
		return result;
	}

	public List<Member> selectMemberList(Connection conn) throws SQLException {
		List<Member>mList = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER_TBL ORDER BY MEMBER_NAME";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		while(rset.next()) {
			String memberName = rset.getString("MEMBER_NAME");
			char gender	= rset.getString("GENDER").charAt(0);
			int age = rset.getInt("AGE");
			String hobby = rset.getString("HOBBY");
			Member member = new Member(memberName,gender,age,hobby);
			mList.add(member);
		}
		stmt.close();
		conn.close();
		return mList;
	}

	public int deleteMemberInfo(String memberName, String memberId, String memberPw ,Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_NAME = ? AND MEMBER_ID = ? AND MEMBER_PWD = ? ";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberName);
		pstmt.setString(2 , memberId);
		pstmt.setString(3 , memberPw );
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}

	public int updateMemberInfo(Member member, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		System.out.println(member);
		int result = 0;
		String query = "UPDATE MEMBER_TBL SET EMAIL = ? , PHONE = ? , ADDRESS = ? , HOBBY = ? "
				+ "WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1,member.getEmail());
		pstmt.setString(2,member.getPhone());
		pstmt.setString(3,member.getAddress());
		pstmt.setString(4,member.getHobby());
		pstmt.setString(5,member.getMemberId());
		pstmt.setString(6,member.getMemberPwd());
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}

	public List<Member> searchOnesInfo(String memberId, String memberPwd, Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rset = null;
		List<Member>mList = new ArrayList<Member>();
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = '"+memberId+"' AND MEMBER_PWD = '"+
				memberPwd+"'";
		int result = 0;
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		while(rset.next()) {
			String id = rset.getString("MEMBER_ID");
			String pw = rset.getString("MEMBER_PWD");
			String name = rset.getString("MEMBER_NAME");
			char gender	= rset.getString("GENDER").charAt(0);
			int age = rset.getInt("AGE");
			String email = rset.getString("EMAIL");
			String phone = rset.getString("PHONE");
			String address = rset.getString("ADDRESS");
			String hobby = rset.getString("HOBBY");
			Date enrollDate = rset.getDate("ENROLL_DATE");
			Member member = new Member(id,pw,name,gender,age, email, phone, address, hobby, enrollDate);
			mList.add(member);
		}
		rset.close();
		stmt.close();
		conn.close();
		return mList;
	}


}
