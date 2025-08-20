package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

}
