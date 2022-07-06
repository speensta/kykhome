package com.example.kykhome.repository;

import com.example.kykhome.domain.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberid(@Param("memberid") String memberid);

}
