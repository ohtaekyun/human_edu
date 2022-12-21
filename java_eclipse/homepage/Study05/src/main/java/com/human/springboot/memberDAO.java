package com.human.springboot;

import org.apache.ibatis.annotations.Mapper;
	@Mapper
	public interface memberDAO {
	void addMember(String one, String two, String three, String four);
	int getMemberCount(String loginid, String passcode);
	int checkDup(String loginid);
	

}
