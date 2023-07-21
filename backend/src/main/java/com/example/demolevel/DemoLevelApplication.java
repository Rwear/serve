package com.example.demolevel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demolevel.mapper")
public class DemoLevelApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoLevelApplication.class, args);

    }

}
