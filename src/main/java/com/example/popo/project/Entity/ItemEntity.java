package com.example.popo.project.Entity;


import com.example.popo.project.Constant.ItemSell;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table (name = "item")
@Entity
@ToString
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    // id값
    @Id
    @Column (name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 상품 이름
    @Column
    private String item_name;

    // 상품 가격
    @Column
    private int price;

    // 상품 갯수
    @Column(nullable = false)
    private int stockNum;

    // 상품 상세설명명
    @Lob
    @Column(nullable = false)
    private String itemDetail;


    //품절 유무
    //EnumType.STRING : enum 이름을 DB에 저장
    //EnumType.ORDINAL : enum 순서 값을 DB에 저장
    @Enumerated(EnumType.STRING)
    private ItemSell itemSell;

    // LocalDateTime
    /*
     날짜와 시간 정보 모두가 필요할 때 사용 날짜 와 시간 정보 출력~
      로컬 컴퓨터의 현재 날짜와 시간 정보
    LocalDateTime currentDateTime = LocalDateTime.now();
     결과 : 2019-11-12T16:34:30.388

    LocalDateTime targetDateTime = LocalDateTime.of(2019, 11, 12, 12, 32,22,3333);
     여기도 second,nanoSecond 매개변수는 필수가 아닌 선택입니다.
     결과 : 2019-11-12T12:32:22.000003333
    */

    // 상품 등록시간
    private LocalDateTime regTime;
    // 상품 업데이트 시간
    private LocalDateTime updateTime;



}
