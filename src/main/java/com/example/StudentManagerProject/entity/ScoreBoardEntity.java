package com.example.StudentManagerProject.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "scoreBoard")
@Data
public class ScoreBoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer studentId;

    @Column
    private Integer subjectId;

    @Column
    private Integer semesterScoreId;

    @Column
    private Long finalScore;
}
