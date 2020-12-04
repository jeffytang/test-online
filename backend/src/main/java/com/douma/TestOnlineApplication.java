package com.douma;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.douma.mapper")
public class TestOnlineApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestOnlineApplication.class, args);
    }
}
