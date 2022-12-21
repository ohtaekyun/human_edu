package com.human.springboot;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DAO {
	ArrayList<MemberDTO> list(); //반환값 메소드명(매개변수들)
	void insertMember(String one, String two, String three, String four);
	void updateMember(String one, String two, String three, String four);
	void deleteMember(String one);
	int getMemberCount(String loginid, String passcode);
}
