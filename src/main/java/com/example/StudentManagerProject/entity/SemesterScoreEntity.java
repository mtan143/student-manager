package com.example.StudentManagerProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "semesterScore")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer semesterId;

    @Column
    private double fifteenScore;

    @Column
    private double fortyFiveScore;

    @Column
    private double midSemesterScore;

    @Column
    private double endSemesterScore;
}
