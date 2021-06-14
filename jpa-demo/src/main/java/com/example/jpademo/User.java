package com.example.jpademo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    String id;

    String name;
    String city;
    int age;
}
