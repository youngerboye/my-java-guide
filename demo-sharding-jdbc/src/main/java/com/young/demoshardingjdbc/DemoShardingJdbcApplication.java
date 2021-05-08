package com.young.demoshardingjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(value = "com.young.demoshardingjdbc.mapper")
public class DemoShardingJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoShardingJdbcApplication.class, args);
    }

}
