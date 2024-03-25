package com.demoshop.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    MemberRepository MemberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception {

        // given
        Member member = new Member();
        member.setUsername("이성원");

        // when
        Long savedId = MemberRepository.save(member);
        Member foundMember = MemberRepository.find(savedId);

        // then
        Assertions.assertThat(savedId).isEqualTo(foundMember.getId());
    }
}
