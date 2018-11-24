package com.test.seminar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.*;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.test.seminar.mapper")
public class SeminarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeminarApplication.class, args);
    }
}
