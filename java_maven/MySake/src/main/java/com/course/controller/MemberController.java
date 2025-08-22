package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.course.entity.MemberEntity;
import com.course.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//@Operation(summary = "取得所有待辦事項(findAll)", tags = "JPA 原生方法")
	@PostMapping("/add")
	public MemberEntity addMember(@RequestBody MemberEntity eneity) {
		return memberService.addMember(eneity);
	}
}
