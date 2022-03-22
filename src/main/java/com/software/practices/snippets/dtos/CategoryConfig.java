package com.software.practices.snippets.dtos;

import lombok.Data;

/**
 * @author Sagar Kanojia
 */
@Data
public class CategoryConfig {

    private Integer order;
    private String type;
    private Boolean active;
}
