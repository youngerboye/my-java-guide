package com.young.myoauth2server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.young.myoauth2server.mapper")
public class MyOauth2ServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(MyOauth2ServerApplication.class, args);
    }

}
