package com.lxyker.mp001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lxyker.mp001.mapper")
@SpringBootApplication
public class Mp001Application {

    public static void main(String[] args) {
        SpringApplication.run(Mp001Application.class, args);
    }

}
