package com.github.km127pl.javaterminal;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter the command to run: ");

	    String cmd = scanner.next();

	    System.out.println("Running: " + cmd);


	    Runtime.getRuntime().exec(cmd);
	    scanner.close();
	}
}
