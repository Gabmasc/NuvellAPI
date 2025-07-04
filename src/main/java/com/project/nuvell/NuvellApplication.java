package com.project.nuvell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NuvellApplication {

	public static void main(String[] args) {
		SpringApplication.run(NuvellApplication.class, args);
	}

}
