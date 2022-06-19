package com.example.popo.project.Repository;

import com.example.popo.project.Entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
}
