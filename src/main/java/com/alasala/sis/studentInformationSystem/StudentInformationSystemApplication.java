package com.alasala.sis.studentInformationSystem;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentInformationSystemApplication {

    public static Logger logger =  LoggerFactory.getLogger(StudentInformationSystemApplication.class);
    @PostConstruct
    public void intt() {
        logger.info("Application Started...");
    }

	public static void main(String[] args) {
		logger.info("Application Executted...");
        SpringApplication.run(StudentInformationSystemApplication.class, args);
	}

}
