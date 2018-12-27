package com.practice.first.dto;

import lombok.Data;


@Data
public class ClientDto {

    private Integer id;
    private String name;
    private String firstSurname;
    private String secondSurname;
    private String birth;

}
