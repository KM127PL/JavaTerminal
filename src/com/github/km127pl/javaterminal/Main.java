package com.github.km127pl.javaterminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	
	static boolean notInterrupted = true;
	
	public static void main(String[] args) throws IOException {
	    askForCommand();
	}
	
	public static void askForCommand() throws IOException {
		Console.log("Enter the command to run: ");
	    BufferedReader lineOfText = new BufferedReader(new InputStreamReader(System.in));
	    String textLine = lineOfText.readLine();

	    Console.run(textLine);
	    
	    lineOfText.close();
	}
}
