package com.practice.first.dto;

import lombok.Data;

import java.util.List;

@Data
public class FriendDto {

    Integer id;
    String name;
    Double height;
    List<Integer> list;

}
