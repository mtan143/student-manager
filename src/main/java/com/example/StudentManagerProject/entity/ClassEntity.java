package com.example.StudentManagerProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotNull(message = "Class's name cannot be null")
    private String name;

    @Column
    @NotNull(message = "This field required!")
    private Integer year;

    @Column
    private Integer quantity;

    @Column
    private Integer teacherId;

}
