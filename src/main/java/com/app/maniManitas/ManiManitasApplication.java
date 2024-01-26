package com.app.maniManitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude={SecurityAutoConfiguration.class}) // En ReparacionesApplication
public class ManiManitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManiManitasApplication.class, args);
	}

}
