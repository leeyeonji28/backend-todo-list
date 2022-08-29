package com.example.backendtodolist.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String content;

    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean checked;
}
