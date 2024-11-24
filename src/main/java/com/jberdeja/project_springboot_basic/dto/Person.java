package com.jberdeja.project_springboot_basic.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Person {

    @NotNull
    private String name;
    @NotNull
    private String lastname;
    @NotNull
    private Integer age;
    @NotNull
    private Long dni;

}
