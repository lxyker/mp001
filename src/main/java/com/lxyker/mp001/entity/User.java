package com.lxyker.mp001.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
public class User {

//    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private Integer age;
    private String email;
}
