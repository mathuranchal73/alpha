package com.alpha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusReservationServiceApplication {
	
	private static Logger logger = LoggerFactory.getLogger(BusReservationServiceApplication.class);

	public static void main(String[] args) {
		
		logger.debug("### RESERVATION SERVICE STARTED ###");
		SpringApplication.run(BusReservationServiceApplication.class, args);
	}

}
