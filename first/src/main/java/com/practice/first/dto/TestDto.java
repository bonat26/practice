package com.practice.first.dto;

import lombok.Data;

import java.util.List;

@Data
public class TestDto {

    Integer id;
    String name;
    List<Integer> integers;
    List<String> strings;
    List<FriendDto> friends;


}
