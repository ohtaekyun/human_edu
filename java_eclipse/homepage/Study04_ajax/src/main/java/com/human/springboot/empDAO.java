package com.human.springboot;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface empDAO {
	ArrayList<EmpDTO> list(); //반환값 메소드명(매개변수들)
	ArrayList<DepartmentDTO> listDepartment();
	
	
	ArrayList<RoomtypeDTO> listRoomType();
	void insertRoomType(String typename);
	void updateRoomType(String tname, int tnum);   // 변수명은 상관x, 타입만 맞추면 된다
	void deleteRoomType(int typenum);
	

	ArrayList<RoomDTO> listRoom();
	void insertRoomInfo(String one, int two, int three, int four);
	void updateRoomInfo(int num, String one, int two, int three, int four);
	void deleteRoomInfo(int num);
	
	
	int getMemberCount(String loginid, String passcode);
}
