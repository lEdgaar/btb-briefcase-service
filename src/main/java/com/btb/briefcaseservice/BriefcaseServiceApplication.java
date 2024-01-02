package com.btb.briefcaseservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.btb.briefcaseservice.persistence.mapper"})
@SpringBootApplication
public class BriefcaseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BriefcaseServiceApplication.class, args);
	}

}
