// package com.induwara.springTest;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class Application {
// 	private static final Logger log = LoggerFactory.getLogger(Application.class);

// 	public static void main(String[] args) {
// 		SpringApplication.run(Application.class, args);

// 		// var welcomeMessage = new WelcomeMessage();
// 		// System.out.println(welcomeMessage.getWelcomeMessage());

// 		log.info("Induwara -> les gooooo");

// 	}

// }
package com.induwara.springTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
