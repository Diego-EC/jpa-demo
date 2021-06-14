package com.example.jpademo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    String id;

    String name;
    String city;
    int age;
}
