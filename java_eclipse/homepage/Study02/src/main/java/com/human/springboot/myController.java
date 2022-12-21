package com.human.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class myController {
	
//	@Autowired
//	HttpSession session;
	
	@RequestMapping("/")
	public String goHome(HttpServletRequest req, Model model) {
//		HttpSession session=req.getSession();
//		String sess_info = (String)session.getAttribute("gUserid");
//		model.addAttribute("userid",sess_info);
		return "home";
	}
	
	@RequestMapping("/login") public String doLogin() {return "login";}
	@RequestMapping("/signin") public String doSignin() {return "signin";}
	
	@RequestMapping("/signout") 
	public String doSignout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/checkuser")
	public String doCheckUser(HttpServletRequest req, Model model) {
		String uid = req.getParameter("userid");
		String pw = req.getParameter("passcode");
		
		HttpSession session=req.getSession();
		System.out.println("uid="+uid);
		session.setAttribute("gUserid", uid);

		System.out.println(session);
		return "redirect:/";
		
	}
	
	@RequestMapping("/viewuser")
	public String doViewUser(User user, Model model) {
		model.addAttribute("user",user);
		
		return "userinfo";
	}
	
//	@RequestMapping("/addMember")
//	public String doAddMember(Person p, Model model) {
//		model.addAttribute("person", p);
//		return "showMember";
//	}
	

}
