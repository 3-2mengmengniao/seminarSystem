package com.test.seminar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author xmr
 * @date 2018/11/28
 */
@SpringBootApplication
@MapperScan("com.test.seminar.mapper")
public class SeminarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeminarApplication.class, args);
    }
}
