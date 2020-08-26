package com.github.km127pl.javaterminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Console {
	static boolean isWindows = System.getProperty("os.name")
			  .toLowerCase().startsWith("windows");
	
	public static void run(String cmd) throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
       
        Console.log("Trying to launch " + cmd);
        if (isWindows) {
        	 processBuilder.command("cmd.exe", "/c", cmd);
		    log("Launching as WINDOWS");
		} else { // linux
			processBuilder.command("sh", "-c", cmd);
		    log("Launching as LINUX");
		}
        
        try {

            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Main.askForCommand();
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
	
	public static void error(String txt) {
		String msg = returnTime() + "[Error!]" + txt;
		System.out.println(msg);
	}

}
