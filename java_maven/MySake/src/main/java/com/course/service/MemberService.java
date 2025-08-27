package com.course.service;

import java.lang.reflect.Member;
import java.util.List;

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
	
	public List<MemberEntity> findAllMember(){
		return memberRepository.findAll();
	}
	
}
