package com.revature.services;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logit {
	static Logger log = LogManager.getLogger();
	

	public static void LogIt(String level, String message) throws IOException{
	
		switch (level) {
		case "debug":
			log.debug(message);
			break;
		case "warn":
			log.warn(message);
			break;
		case "error":
			log.error(message);
			break;
		case "fatal":
			log.fatal(message);
			break;
		case "info":
			log.info(message);
			break;
		case "trace":
			log.trace(message);
			break;
		default:
			System.err.println("utoh");
		}
	
		
	}

}