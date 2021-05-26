package com.mariworld.bootboard.repository;

import com.mariworld.bootboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
