package com.example.popo.project.Repository;

import com.example.popo.project.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    MemberEntity findByEmail(String email);
}
