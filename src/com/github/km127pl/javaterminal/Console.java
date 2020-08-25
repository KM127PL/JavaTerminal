package com.github.km127pl.javaterminal;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Console {
	public static void run(String cmd) {
		
		try {
			Console.log("Trying to launch " + cmd);
			Runtime.getRuntime().exec("cmd.exe "+cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
	
	public static String returnTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return "[" + dtf.format(now) + "] ";
	}
	
	public static void log(String txt) {
		String msg = returnTime() + txt;
		System.out.println(msg);
	}

}
