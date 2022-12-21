package com.human.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	private DAO dao;
//	
//	HttpSession session;
	
	@RequestMapping("/")
	public String goHome(HttpServletRequest req, Model model) {
		HttpSession session=req.getSession();
		String sess_info = (String)session.getAttribute("gUserid");
		model.addAttribute("userid",sess_info);
		return "home";
	}
	
	@RequestMapping("/login")
	public String doLogin() {
		return "login";
	}
	
	@RequestMapping("/signin")
	public String doSignin() {
		return "signin";
	}
	
	@RequestMapping("/signout")
	public String doSignout(HttpServletRequest req) {
		HttpSession session=req.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/checkuser")
	public String doCheckUser(HttpServletRequest req) {
		String id = req.getParameter("userid");
		String pw = req.getParameter("passcode1");
		
		int cnt = dao.getMemberCount(id,pw);
		if(cnt==1) {
			HttpSession session=req.getSession();
			session.setAttribute("userid", id);
			return "redirect:/";
		}
		else {
			return "redirect:/login";
		}
//		String uid = req.getParameter("userid");
//		String pw = req.getParameter("passcode");
		
		
		
	}
		
	
	@RequestMapping("/viewuser")
	public String doViewUser(HttpServletRequest req) {
		String id = req.getParameter("loginid");
		String pw = req.getParameter("passcode1");
		String name = req.getParameter("name");
		String mobile = req.getParameter("mobile");
		dao.insertMember(id, pw, name, mobile);
		return "/login";
	}
	
//	@RequestMapping("/addMember")
//	public String doAddMember(Person p, Model model) {
//		model.addAttribute("person", p);
//		return "showMember";
//	}
	

}
