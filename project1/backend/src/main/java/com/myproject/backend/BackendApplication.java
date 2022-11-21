package com.myproject.backend;

import com.myproject.backend.service.AccountService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Book API", version = "2.0", description = "Book Information"))

public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
	//@Bean
	CommandLineRunner saveUser(AccountService securityService) {

		return args -> {
			securityService.saveNewUser(1L, "one","one1" ,"one1@gmail.com","123", "123");
			securityService.saveNewUser(2L, "two","two2" ,"two2@gmail.com","123", "123");
			securityService.saveNewUser(3L, "three","three3" ,"three3@gmail.com","123", "123");


			securityService.saveNewRole("USER", "");
			securityService.saveNewRole("ADMIN", "");

			securityService.addRoleToUser("one1", "USER");
			securityService.addRoleToUser("one1", "ADMIN");
			securityService.addRoleToUser("two2", "USER");
			securityService.addRoleToUser("three3", "USER");


		};

	}
}
