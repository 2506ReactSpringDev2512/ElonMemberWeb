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
//		pstmt.setString(10, "DEFAULT");
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


}
