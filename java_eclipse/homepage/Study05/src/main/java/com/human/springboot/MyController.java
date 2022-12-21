package com.human.springboot;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	private memberDAO mdao;
	@Autowired
	private postDAO pdao;
	
	@RequestMapping("/") 
	public String home(Model model) {
		
		ArrayList<PostingDTO> pdto = pdao.listPosting();
		model.addAttribute("postlist", pdto);
		// DAO 호출, model.Attribute() 추가
		return "home";
		}
	@RequestMapping("/signin") public String doSignin() {return "signin";}
	@RequestMapping("/login") public String doLogin() {return "login";}
	@RequestMapping("/write") public String doWrite() {return "write";}
	
	@RequestMapping("/checkDup")
	@ResponseBody
	public String doCheckDup(HttpServletRequest req) {
		int n = mdao.checkDup(req.getParameter("loginid"));
		return Integer.valueOf(n).toString();
	}
	
	@RequestMapping("/viewuser")
	@ResponseBody
	public String doViewUser(HttpServletRequest req) {
		String retval="";
		try {
			String loginid=req.getParameter("loginid");
			String pass1=req.getParameter("passcode1");
			String name=req.getParameter("name");
			String mobile=req.getParameter("mobile");
			mdao.addMember(loginid, pass1, name, mobile);
			retval="ok";
		} catch(Exception e) {
			retval="fail";
		}
		
		return retval;
	}
	
	@RequestMapping("/checkuser")
	@ResponseBody
	public String doCheckUser(HttpServletRequest req) {
		String retval="";
		try {
			String uid=req.getParameter("userid");
			String pw=req.getParameter("passcode");
			int n = mdao.getMemberCount(uid, pw);
			
			if(n==1) {
				HttpSession session=req.getSession();
				session.setAttribute("gUserid", uid);
				return "ok";
			}
			else {
				retval="fail";
			}
			
		} catch(Exception e) {
			retval="fail";
		}	
		return retval;
	}
	
	@RequestMapping("/logincheck")
	@ResponseBody
	public String doLoginCheck(HttpServletRequest req) {
		String str="";
		HttpSession session=req.getSession();
		String userid=(String) session.getAttribute("gUserid");
		if(userid==null||userid.equals("")) {
			str="";
		} else {
			str=userid;
		}
		return str;
	}

	@RequestMapping("/signout")
	@ResponseBody 
	public String doSignout(HttpServletRequest req) {
		String retval="";
		try {
			HttpSession session=req.getSession();
			session.invalidate();
			retval="ok";			
		} catch(Exception e) {
			retval="fail";			
		}
		return retval;		
	}
	
	@RequestMapping("/insert")
	public String doInsert(HttpServletRequest req) {
		HttpSession s = req.getSession();
		String currentUser=(String)s.getAttribute("gUserid");
		if(currentUser==null) {
			return "redirect:/";
		}
		try {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer=(String) s.getAttribute("gUserid");
			pdao.insertPosting(title, content, writer);
		} catch(Exception e){
			System.out.println("오류");
		}
		
		return "redirect:/";		
	}
	
	@RequestMapping("/view")
	public String doView(HttpServletRequest req, Model model) {
		int post_id = Integer.parseInt(req.getParameter("post_id"));
		PostingDTO pdto=pdao.getPost(post_id);//pdao.method호출
		model.addAttribute("getview", pdto);//host결과값 > model에 담아서 view.jsp전달
		return "view";
		
	}
	@RequestMapping("/delete")
	public String doDelete(HttpServletRequest req) {
		HttpSession s = req.getSession();
		String currentUser=(String)s.getAttribute("gUserid");
		if(currentUser==null) {
			return "redirect:/";
		}
			
		int num=Integer.parseInt(req.getParameter("post_id"));
		pdao.deletePosting(num);
		return "redirect:/";
	}
	@RequestMapping("/update")
	public String doUpdate(HttpServletRequest req, Model model) {
		int num=Integer.parseInt(req.getParameter("post_id"));
		PostingDTO pdto=pdao.updatePosting(num);
		model.addAttribute("getupdate", pdto);
		return "updatepage";
	}
	@RequestMapping("/modify")
	public String doModify(HttpServletRequest req, Model model) {
		HttpSession s = req.getSession();
		String currentUser=(String)s.getAttribute("gUserid");
		if(currentUser==null) {
			return "redirect:/";
		}
		int num=Integer.parseInt(req.getParameter("post_id"));
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		pdao.modifyPosting(num, title, content);
		
		return "redirect:/";
	}

			
//	@RequestMapping("/listposting")
//	public String getList(Model model) {
//		ArrayList<PostingDTO> pdto = pdao.listPosting();
//		model.addAttribute("post", pdto);
//		return "redirect:/";
//	}

}
