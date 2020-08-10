package com.example.demo.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Geonguk Han
 * @since 2020-08-10
 */
@Entity
@Data
public class User {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int age;
}
