package com.example.popo.project.Controller;

import com.example.popo.project.Entity.MemberEntity;
import com.example.popo.project.Service.MemberService;
import com.example.popo.project.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Slf4j
@Controller
@RequiredArgsConstructor //  초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    @GetMapping( "/")
    public String index(){
        return "/layouts/layout1";
    }

    @GetMapping(value = "/new")
    public String member(Model model){
        model.addAttribute("memberForm",new MemberForm());
        return "member/memberForm";
    }

    @PostMapping(value = "/new")
    public String member(@Valid MemberForm memberForm,BindingResult bindingResult,Model model ){
        if(bindingResult.hasErrors()){
            return "member/memberForm";
        }
        try {
            MemberEntity member = MemberEntity.createMember(memberForm,passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage",e.getMessage());
            return "member/memberForm";
        }


        return "redirect:/member/login";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "/login/loginForm";
    }


}
