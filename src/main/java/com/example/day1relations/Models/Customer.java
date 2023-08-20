package com.example.day1relations.Models;

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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String username;

    @OneToOne(cascade = CascadeType.DETACH, mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private Profile profile;
}
