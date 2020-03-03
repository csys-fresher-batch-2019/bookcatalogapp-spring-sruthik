package com.sruthi.bookcatalogapp.util;

import org.springframework.stereotype.Component;

@Component
public class Logger {
	public static Logger getInstance() {
		Logger logger = new Logger();
		return logger;
	}
	public void getInput(Object message) {
		Logger.getInstance();
	}
	public void debug(Object message) {
		Logger.getInstance();
	}
	public void info(Object message) {
		Logger.getInstance();
	}
	public void error(Object message) {
		Logger.getInstance();
	}

}
