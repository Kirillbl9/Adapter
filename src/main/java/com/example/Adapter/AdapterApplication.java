package com.example.Adapter;

import com.example.Adapter.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdapterApplication {
	private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

	public static void main(String[] args) {
		SpringApplication.run(AdapterApplication.class, args);
		logger.info("Adapter start");
	}
}
