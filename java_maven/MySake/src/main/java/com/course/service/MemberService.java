package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.MemberEntity;
import com.course.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	public MemberEntity addMember(MemberEntity entity) {
		return memberRepository.save(entity);
	}
	
	public void delMember(Integer id) {
		memberRepository.deleteById(id);
	}
	
	
}
