package com.software.practices.solutions.java8.streams.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private Gender gender;
    private Integer age;
}