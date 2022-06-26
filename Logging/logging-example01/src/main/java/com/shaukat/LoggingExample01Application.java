package com.shaukat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LoggingExample01Application {

	public static void main(String[] args) {
		SpringApplication.run(LoggingExample01Application.class, args);
		log.info("server is started");

		log.trace("this is trace msg");
		log.debug("this is debug msg");
		log.info("this is info msg");
		log.warn("this is warn msg");
		log.error("this is error msg");
	}

}
