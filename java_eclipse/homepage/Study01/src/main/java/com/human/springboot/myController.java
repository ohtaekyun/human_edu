package com.human.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myController {
	
	@RequestMapping("/")
	public String doRoot() {
		return "index";
	}
	
	@RequestMapping("/addMember")
	public String doAddMember(Person p, Model model) {
		model.addAttribute("person", p);
		return "showMember";
	}
	

}
