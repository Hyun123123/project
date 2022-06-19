package com.example.popo.project.Service;

import com.example.popo.project.Entity.MemberEntity;
import com.example.popo.project.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService implements UserDetailsService {


    private final MemberRepository memberRepository;

    public MemberEntity saveMember (MemberEntity memberEntity){
        validationMember(memberEntity);
        log.info(memberEntity.toString());
        return memberRepository.save(memberEntity);
    }

    private void validationMember(MemberEntity memberEntity) {
        MemberEntity member = memberRepository.findByEmail(memberEntity.getEmail());
        if(member != null){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MemberEntity member = memberRepository.findByEmail(email);

        if (member == null){
            throw new UsernameNotFoundException(email);
        }
        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }

}
