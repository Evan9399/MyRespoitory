package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.MemberEntity;
import com.course.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Operation(summary = "新增會員資料(add)", tags = "JPA 原生方法")
	@PostMapping("/add")
	public MemberEntity addMember(MemberEntity eneity) {
		return memberService.addMember(eneity);
	}
	
	@Operation(summary = "取得會員資料(findAll)", tags = "JPA 原生方法")
	@GetMapping("/findAll")
	public List<MemberEntity> findAll(MemberEntity eneity) {
		return memberService.findAllMember();
	}
}
