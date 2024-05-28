package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: HelloMpApplication
 * Package: com.atguigu
 */
@SpringBootApplication
@MapperScan("com.atguigu.mapper")
public class HelloMpApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloMpApplication.class, args);
	}
}
