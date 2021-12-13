package com.example.StudentManagerProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

//@MappedSuperclass
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

