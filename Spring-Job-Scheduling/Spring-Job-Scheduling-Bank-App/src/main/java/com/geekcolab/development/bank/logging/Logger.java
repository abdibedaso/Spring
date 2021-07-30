package com.geekcolab.development.bank.logging;

public class Logger implements ILogger{

	public void log(String logString) {
		java.util.logging.Logger.getLogger("BankLogger").info(logString);
	}

}
