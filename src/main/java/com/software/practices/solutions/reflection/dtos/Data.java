package com.software.practices.solutions.reflection.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author Sagar Kanojia
 */
@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    private String name;
    private String email;

}
