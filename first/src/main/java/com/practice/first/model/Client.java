package com.practice.first.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CLIENT_ID", nullable = false, updatable = false)
    private Integer id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "FSURNAME", nullable = false)
    private String firstSurname;
    @Column(name = "SSURNAME", nullable = false)
    private String secondSurname;
    @Column(name = "BIRTH", nullable = false)
    private String birth;

}
