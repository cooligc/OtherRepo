package com.skc.log4j;

import org.apache.log4j.Logger;

public class PropertiesLogger {
	final static Logger  LOGGER = Logger.getLogger(PropertiesLogger.class);
	
	
	public static void main(String[] args) {
		LOGGER.info("Hello This is an Information");
		LOGGER.error("Hello This is an Error");
		LOGGER.fatal("Hello This is an Fetal info");
		LOGGER.trace("Hello This is an trace Information");
		LOGGER.debug("Hello This is an Debug Information");
		
	}
}
