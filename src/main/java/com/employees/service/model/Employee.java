package com.employees.service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Employee {

    private Integer id;

    private String firstName;

    private String lastName;

    private BigDecimal salary;
}
