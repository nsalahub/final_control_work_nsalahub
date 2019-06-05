package com.gmail.nikolay.salahub.springbootmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = {"com.gmail.nikolay.salahub.springbootmodule"})
@EntityScan("com.gmail.salahub.nikolay.springbootmodule.repository.model")
public class FinalControlWorkApp {
	public static void main(String[] args) {
		SpringApplication.run(FinalControlWorkApp.class, args);
	}

}
