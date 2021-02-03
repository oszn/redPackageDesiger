package com.example.demo.liuyi;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.demo.liuyi"})
@MapperScan({"com.example.demo.liuyi.dao"})
public class RbpApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbpApplication.class, args);
	}

}
