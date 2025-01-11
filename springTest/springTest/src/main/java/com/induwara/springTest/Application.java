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

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.induwara.springTest.run.Location;
import com.induwara.springTest.run.Run;
import com.induwara.springTest.run.JDBCClientRunRepository;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	// command line runner(inserting data to the database)
	// @Bean
	// CommandLineRunner runner(RunRespository runRespository) {
	// return args -> {
	// Run run = new Run(3, "First Run", LocalDateTime.now(),
	// LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
	// runRespository.create(run);
	// };
	// }

}
