package com.example.StudentManagerProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity{

    @Column
    private Integer classId;

    @Column
    private Integer scoreBoardId;

    @Column
    @Min(value = 1000, message = "Fee must greater than 1")
    private Integer fees;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @Column
    @NotNull(message = "Username cannot be null")
    private String username;

    @Column
    @Email(message = "Email should be valid")
    private String email;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String dateOfBirth;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    @NotNull(message = "First name cannot be null")
    private String firstName;

    @Column
    @Enumerated(EnumType.STRING)
    private Role roles;
}
