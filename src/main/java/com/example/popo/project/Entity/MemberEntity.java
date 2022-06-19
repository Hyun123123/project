package com.example.popo.project.Entity;

import com.example.popo.project.Constant.Role;
import com.example.popo.project.dto.MemberForm;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity implements UserDetails  {
    @Id
    @Column (name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //이메일
    @Column(unique = true)
    private String email;
    // 이름
    private String name;
    // 비밀번호
    private String password;
    // 주소
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role; // 권한


    public static MemberEntity createMember(MemberForm memberForm, PasswordEncoder passwordEncoder) {
        MemberEntity member =  new MemberEntity();
        member.setName(memberForm.getName());
        member.setEmail(memberForm.getEmail());
        member.setAddress(memberForm.getAddress());
        String password = passwordEncoder.encode(memberForm.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER);
        return member;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
