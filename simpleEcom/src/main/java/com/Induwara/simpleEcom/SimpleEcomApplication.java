package com.Induwara.simpleEcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SimpleEcomApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(SimpleEcomApplication.class, args);

		Dev dev = context.getBean(Dev.class);
		dev.build();
	}

}
