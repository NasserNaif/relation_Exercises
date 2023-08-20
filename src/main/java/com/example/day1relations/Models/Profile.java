package com.example.day1relations.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profile {
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    private String fullName;

    @Column(columnDefinition = "varchar(6) check(gender = 'male' or gender = 'female' )")
    private String gender;

    @Column(columnDefinition = "integer default 15")
    private Integer age;

    @Column(columnDefinition = "varchar(30)")
    private String email;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;
}
