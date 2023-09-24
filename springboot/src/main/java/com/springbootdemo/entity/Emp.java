package com.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    private String address;

    private Integer deptId;

}

