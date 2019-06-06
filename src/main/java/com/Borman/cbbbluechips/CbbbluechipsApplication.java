package com.Borman.cbbbluechips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CbbbluechipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbbbluechipsApplication.class, args);
	}

}
