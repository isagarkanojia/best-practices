package com.software.practices.snippets.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Sagar Kanojia
 */
@Data
@AllArgsConstructor
public class CategoryConfig {

    private Integer order;
    private String type;
    private Boolean active;
}
