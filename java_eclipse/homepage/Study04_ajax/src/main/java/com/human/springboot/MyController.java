package com.human.springboot;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	@Autowired
	private empDAO emp;
	
	@RequestMapping("/")
	public String home(Model model) {
		ArrayList<EmpDTO> edto = emp.list();
		model.addAttribute("worker", edto);
		return "home";
	}
	
	@RequestMapping("/department")
	public String getDepartment(Model model) {
		ArrayList<DepartmentDTO> dpdto = emp.listDepartment();
		model.addAttribute("dp", dpdto);
		return "department";
	}
	
//	@RequestMapping("/insertRT_form")
//	public String doAddRoomType() {
//		return "insertRT_form";
//	}
//	
//	@RequestMapping("/insertRT")
//	public String doInsertRT(HttpServletRequest req, Model model) {
//		String typename = req.getParameter("typename");
//		emp.insertRoomType(typename);
//		
//		return "redirect:/roomtype";
//	}
//	
	
	
//	@RequestMapping("/insertRI_form")
//	public String doAddRoomInfo() {
//		return "insertRI_form";
//	}
//	@RequestMapping("/insertRI")
//	public String doAddRI(HttpServletRequest req, Model model) {
//		String name =req.getParameter("name");
//		int type =Integer.parseInt(req.getParameter("type"));
//		int howmany =Integer.parseInt(req.getParameter("howmany"));
//		int howmuch =Integer.parseInt(req.getParameter("howmuch"));
//		emp.insertRoomInfo(name, type, howmany, howmuch);
//		return "redirect:/insertRI_form";
//	}
	
	
	
	@RequestMapping("/roominfo")
	public String getInfo(Model model) {
		//select  Room Info
		ArrayList<RoomDTO> roomdto = emp.listRoom();
		model.addAttribute("ri", roomdto);
		
		ArrayList<RoomtypeDTO> rdto = emp.listRoomType();
		model.addAttribute("rt", rdto);
		
		return "roominfo";
	}
	@RequestMapping("/controlRoomInfo")
	public String doControlRoomInfo(HttpServletRequest req) {
		if(req.getParameter("optype").equals("delete")){
			int num=Integer.parseInt(req.getParameter("roomnum"));
			emp.deleteRoomInfo(num);
		}	else if(req.getParameter("optype").equals("insert")) {
				String name = req.getParameter("roomname");
				int type = Integer.parseInt(req.getParameter("roomtype"));
				int howmany = Integer.parseInt(req.getParameter("howmany"));
				int howmuch = Integer.parseInt(req.getParameter("howmuch"));
				emp.insertRoomInfo(name, type, howmany, howmuch);
		}	else if(req.getParameter("optype").equals("update")) {
				int num=Integer.parseInt(req.getParameter("roomnum"));
				String name = req.getParameter("roomname");
				int type=Integer.parseInt(req.getParameter("roomtype"));
				int howmany=Integer.parseInt(req.getParameter("howmany"));
				int howmuch=Integer.parseInt(req.getParameter("howmuch"));
				emp.updateRoomInfo(num, name, type, howmany, howmuch);
		}
		return "redirect:/roominfo";
	}
	// select > DAO, XML, DTO, JSP, MyController
	// insert/update/delete > DAO, XML, JSP, MyController
	
	

	
	@RequestMapping("/roomtype")
	public String getList(Model model) {
		ArrayList<RoomtypeDTO> rdto = emp.listRoomType();
		model.addAttribute("rt", rdto);
		return "roomtype";
	}
	
	@RequestMapping("/controlRoomType")
	public String doDeleteType(HttpServletRequest req) {
		if(req.getParameter("optype").equals("delete")){
			int typenum=Integer.parseInt(req.getParameter("typenum"));
//			System.out.println("typenum ["+typenum+"]");
			emp.deleteRoomType(typenum);
		}	else if(req.getParameter("optype").equals("insert")) {
				String typename = req.getParameter("typename");
				emp.insertRoomType(typename);
		}	else if(req.getParameter("optype").equals("update")) {
			String typename = req.getParameter("typename");
			int typenum=Integer.parseInt(req.getParameter("typenum"));
			emp.updateRoomType(typename, typenum);
		}
		return "redirect:/roomtype";
	}
	
	
	@RequestMapping("/ajaxtest")
	public String doAjaxTest() {
		return "ajax";
	}
	@RequestMapping("/doPlus")
	@ResponseBody
	public String doPlus(HttpServletRequest req) {
		System.out.println("doPlus called");
		int one = Integer.parseInt(req.getParameter("first"));
		int two = Integer.parseInt(req.getParameter("second"));
		System.out.println(one);
		System.out.println(two);
		int result=one+two;
//		return String.valueOf(result);
		return Integer.valueOf(result).toString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getEmpList")
	@ResponseBody
	public String doGetEmpList() {
		System.out.println("doGetEmpList");
		ArrayList<EmpDTO> edto = emp.list();
		System.out.println("edtd count ["+edto.size()+"]");
		
		JSONArray ja = new JSONArray();
		for(int i=0;i<edto.size();i++) {
			JSONObject jo = new JSONObject();
			jo.put("eid",edto.get(i).getEmployee_id());
			jo.put("emp_name",edto.get(i).getEmp_name());
			jo.put("salary",edto.get(i).getSalary());
			jo.put("mname",edto.get(i).getManager_name());
			ja.add(jo);			
		}
		
		return ja.toString();
	}
	
	@RequestMapping("/emplist")
	public String showEmpList() {
		return "EmpList";
	}
	
	@RequestMapping("/xroomtype")
	public String viewRoomType() {
		return "ajax_roomtype";
	}
	@RequestMapping("/xroominfo")
	public String viewRoomInfo() {
		return "ajax_roominfo";
	}
	
	@RequestMapping("/getRoomType")
	@ResponseBody
	public String doGetRoomType() {
		ArrayList<RoomtypeDTO> rdto = emp.listRoomType();
		JSONArray ja = new JSONArray();
		for(int i=0;i<rdto.size();i++) {
			JSONObject jo = new JSONObject();
			jo.put("typenum",rdto.get(i).getTypenum());
			jo.put("typename",rdto.get(i).getTypename());
			ja.add(jo);	
		}
		return ja.toString();
	}
	
	
	@RequestMapping("/getRoomInfo")
	@ResponseBody
	public String doGetRoomInfo() {
		ArrayList<RoomDTO> ridto = emp.listRoom();
		JSONArray ja = new JSONArray();
		for(int i=0;i<ridto.size();i++) {
			JSONObject jo = new JSONObject();
			jo.put("roomnum",ridto.get(i).getNum());
			jo.put("roomname",ridto.get(i).getName());
			jo.put("roomtype",ridto.get(i).getType());
			jo.put("howmany",ridto.get(i).getHowmany());
			jo.put("howmuch",ridto.get(i).getHowmuch());
			ja.add(jo);	
		}
		return ja.toString();
	}
	
	
	
	@RequestMapping("/cudRoomType")
	@ResponseBody
	public String doCudRoomType(HttpServletRequest req) {
		if(req.getParameter("optype").equals("delete")){
			int typenum=Integer.parseInt(req.getParameter("typenum"));
//			System.out.println("typenum ["+typenum+"]");
			emp.deleteRoomType(typenum);
		} else if(req.getParameter("optype").equals("insert")) {
			String typename = req.getParameter("typename");
			emp.insertRoomType(typename);
		} else if(req.getParameter("optype").equals("update")) {
			String typename = req.getParameter("typename");
			int typenum=Integer.parseInt(req.getParameter("typenum"));
			emp.updateRoomType(typename, typenum);
		}
		return "OK"; //dummy data
	}
	
	@RequestMapping("/cudRoomInfo")
	@ResponseBody
	public String doCudRoomInfo(HttpServletRequest req) {
		if(req.getParameter("optype").equals("delete")){
			int roomnum=Integer.parseInt(req.getParameter("roomnum"));
			emp.deleteRoomInfo(roomnum);
		} else if(req.getParameter("optype").equals("insert")) {
			String roomname = req.getParameter("roomname");
			int roomtype = Integer.parseInt(req.getParameter("roomtype"));
			int howmany = Integer.parseInt(req.getParameter("howmany"));
			int howmuch = Integer.parseInt(req.getParameter("howmuch"));
			emp.insertRoomInfo(roomname, roomtype, howmany, howmuch);
		} else if(req.getParameter("optype").equals("update")) {
			String roomname = req.getParameter("roomname");
			int roomnum=Integer.parseInt(req.getParameter("roomnum"));
			int roomtype = Integer.parseInt(req.getParameter("roomtype"));
			int howmany = Integer.parseInt(req.getParameter("howmany"));
			int howmuch = Integer.parseInt(req.getParameter("howmuch"));
			emp.updateRoomInfo(roomnum, roomname, roomtype, howmany, howmuch);
		}
		return "OK"; //dummy data
	}
}
