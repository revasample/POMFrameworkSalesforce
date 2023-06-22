package com.automation.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggingTest {
	
	@Test
	public static void login() {
		Logger log=LogManager.getLogger(LoggingTest.class);
		log.info("browser has been launched");
		log.warn("printing warrning messages");
		log.debug("printing debuging messages");
		log.error("printing error");
		log.fatal("printing fatal messages");
		log.info("completed");
	}

}

