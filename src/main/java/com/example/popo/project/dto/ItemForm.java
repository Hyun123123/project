package com.example.popo.project.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemForm {
    private Long id;
    private String item_name;
    private Integer price;
    private String itemDetail;
    private String itemSell;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;
}
