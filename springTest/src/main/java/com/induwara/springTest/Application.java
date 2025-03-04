package com.induwara.springTest;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.induwara.springTest.user.User;
import com.induwara.springTest.user.UserHttpClient;
import com.induwara.springTest.user.UserRestClient;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	UserHttpClient userHttpClient() {
	    RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
	    HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
	    return factory.createClient(UserHttpClient.class);
	}

	// command line runner
	@Bean
	CommandLineRunner runner(UserRestClient client) {
		return args -> {
			List<User> users = client.findAll();
			System.out.println("users = " + users);

			client.findById(1);
		};
	}

}
