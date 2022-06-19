package com.example.popo.project.Sevice;

import com.example.popo.project.Entity.MemberEntity;
import com.example.popo.project.Repository.MemberRepository;
import com.example.popo.project.Service.MemberService;
import com.example.popo.project.dto.MemberForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceTest {
/*
    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public MemberEntity createMember(){
        MemberForm memberFormDto = new MemberForm();
        memberFormDto.setEmail("test@email.com");
        memberFormDto.setName("홍길동1");
        memberFormDto.setAddress("서울시 마포구 합정동");
        memberFormDto.setPassword("1234");
        return MemberEntity.createMember(memberFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest(){
        MemberEntity member = createMember();
        MemberEntity savedMember = memberService.saveMember(member);
        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getAddress(), savedMember.getAddress());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getRole(), savedMember.getRole());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateMemberTest(){
        MemberEntity member1 = createMember();
        MemberEntity member2 = createMember();
        memberService.saveMember(member1);
        Throwable e = assertThrows(IllegalStateException.class, () -> {
            memberService.saveMember(member2);});
        assertEquals("이미 존재하는 회원입니다", e.getMessage());
*/

}
