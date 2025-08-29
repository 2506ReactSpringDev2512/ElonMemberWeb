package com.elon.member.model.vo;

import java.sql.Date;

public class Member {
	private String MemberId;
	private String MemberPwd;
	private String MemberName;
	private char Gender;
	private int Age;
	private String Email;
	private String Phone;
	private String Address;
	private Date EnrollDate;
	
	public Member(String memberId, String memberPwd, String memberName, char gender, int age, String email,
			String phone, String address, String hobby) {
		super();
		MemberId = memberId;
		MemberPwd = memberPwd;
		MemberName = memberName;
		Gender = gender;
		Age = age;
		Email = email;
		Phone = phone;
		Address = address;
		Hobby = hobby;
	}

	public Member() {};
	
	public Member(String memberId, String memberPwd, String memberName, char gender, int age, String email,
			String phone, String address, String hobby, Date enrollDate) {
		super();
		MemberId = memberId;
		MemberPwd = memberPwd;
		MemberName = memberName;
		Gender = gender;
		Age = age;
		Email = email;
		Phone = phone;
		Address = address;
		Hobby = hobby;
		EnrollDate = enrollDate;
	}


	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	public String getMemberPwd() {
		return MemberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		MemberPwd = memberPwd;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getHobby() {
		return Hobby;
	}
	public void setHobby(String hobby) {
		Hobby = hobby;
	}
	
	
	public Date getEnrollDate() {
		return EnrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		EnrollDate = enrollDate;
	}


	private String Hobby;
	
	@Override
	public String toString() {
		return "Member [MemberId=" + MemberId + ", MemberPwd=" + MemberPwd + ", MemberName=" + MemberName + ", Gender="
				+ Gender + ", Age=" + Age + ", Email=" + Email + ", Phone=" + Phone + ", Address=" + Address
				+ ", Hobby=" + Hobby + "]";
	}
}
