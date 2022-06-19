package com.example.popo.project.Repository;

import com.example.popo.project.Constant.ItemSell;
import com.example.popo.project.Entity.ItemEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("테이블 insert 테스트")
    public void createTeset() {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItem_name("이름");
        itemEntity.setPrice(2000);
        itemEntity.setItemSell(ItemSell.SELL);
        itemEntity.setItemDetail("상세 설명");
        itemEntity.setStockNum(100);
        itemEntity.setRegTime(LocalDateTime.now());
        itemEntity.setUpdateTime(LocalDateTime.now());

        ItemEntity save = itemRepository.save(itemEntity);
        System.out.println(save.toString());
    }



}