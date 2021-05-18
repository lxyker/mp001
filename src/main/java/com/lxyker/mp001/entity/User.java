package com.lxyker.mp001.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
