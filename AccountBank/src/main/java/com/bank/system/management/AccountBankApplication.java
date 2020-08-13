package com.bank.system.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AccountBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountBankApplication.class, args);
	}

}
