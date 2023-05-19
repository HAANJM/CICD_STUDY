package com.ssafy.ssafitlog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.ssafitlog.model.dao")
public class DBConfig {

}
