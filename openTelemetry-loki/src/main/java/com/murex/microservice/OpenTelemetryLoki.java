package com.murex.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenTelemetryLoki {

	public static void main(String[] args) {
		SpringApplication.run(OpenTelemetryLoki.class, args);
	}

}
