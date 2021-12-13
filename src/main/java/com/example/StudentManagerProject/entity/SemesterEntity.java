package com.example.StudentManagerProject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "semester")
@Data
public class SemesterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer year;

}
