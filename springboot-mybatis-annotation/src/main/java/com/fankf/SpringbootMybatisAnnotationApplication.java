package com.fankf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.fankf.dao")
public class SpringbootMybatisAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisAnnotationApplication.class, args);
    }

}
