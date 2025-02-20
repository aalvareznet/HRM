package com.hrm.HRM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class HRM {

	public static void main(String[] args) {
		SpringApplication.run(HRM.class, args);

	}

}
