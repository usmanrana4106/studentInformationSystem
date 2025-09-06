package com.alasala.sis.studentInformationSystem;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentInformationSystemApplicationTests {

    public static Logger logger = LoggerFactory.getLogger(StudentInformationSystemApplicationTests.class);
	@Test
	void contextLoads() {
        logger.info("This is the test File, Test Case Executing");
        logger.info("I have change this line to check the CI/CD pipeline ");
        assertEquals(true, true);
	}

}
