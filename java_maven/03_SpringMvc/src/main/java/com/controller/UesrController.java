package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Component

@Controller
public class UesrController {
	
	
	@RequestMapping("/login")
	public String login(@RequestParam("u1") String username,@RequestParam("p1") String password) {
		// "/WEB-INF/views/login.jsp"
		if("aaa".equals(username) && "111".equals(password)) {
			return "loginSuccess";
		}else {
			return "loginFail";
		}
		
		
	}
}
