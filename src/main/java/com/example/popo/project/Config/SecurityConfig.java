package com.example.popo.project.Config;

import com.example.popo.project.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.beans.BeanProperty;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MemberService memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.formLogin()
                .loginPage("/login/loginForm")
                .defaultSuccessUrl("/member/")
                .loginProcessingUrl("/member/login")
                .usernameParameter("email")
                .failureUrl("/member/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/")
        ;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auto) throws Exception{
        auto.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }

}

   /*   WebSecurityConfigurerAdapter를 상속받는 클래스에 @EnableWebSecurity 어노테이션을 선언하면 SpringSecurityFilterChain이 자동으로 포함
        메소드 오버라이딩을 통해 보안 설정을 커스터마이징 가능.
        비밀번호를 데이터베이스에 그대로 저장하면 안되기 때문에 해시 함수를 이용해서 비밀번호를 암호화하여 저장*/
