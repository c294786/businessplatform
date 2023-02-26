package com.czk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.czk.*.mapper")
public class Business2Application {

    public static void main(String[] args) {
        SpringApplication.run(Business2Application.class, args);
    }

}
