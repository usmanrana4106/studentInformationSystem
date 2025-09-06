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
        logger.info("This is the test File, I am going to check second auto build working on jenkins or not. ");
        assertEquals(true, true);
	}

}
