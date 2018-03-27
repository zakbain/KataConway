package com.zak.ai;

public class KataConway {
	public static void main(String[] args) {
		// Validate arguments
		if (args.length < 2) {
			System.out.println("Must have at least two arguments to run this program");
			return;
		}
		
		int columns = 0;
		int rows = 0;
		try {
			rows = Integer.parseInt(args[0]);
			columns = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			return;
		}
		
		// Continue if we were able to get greater than 0 integer values for rows and columns
		if (columns <= 0 || rows <= 0) {
			return;
		}
	}
}
