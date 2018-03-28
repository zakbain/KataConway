package com.zak.ai;

public class KataConway {
	public static void main(String[] args) {
		// Validate arguments
		if (args.length < 3) {
			System.out.println("Must have at least two arguments to run this program");
			return;
		}
		
		int width = 0;
		int height = 0;
		String fileName = "";
		
		try {
			height = Integer.parseInt(args[0]);
			width = Integer.parseInt(args[1]);
			fileName = args[2];
		} catch (NumberFormatException e) {
			return;
		}
		
		// Continue if we were able to get greater than 0 integer values for rows and columns
		if (width <= 0 || height <= 0) {
			return;
		}
		
		CellWorld konwayCells = new CellGrid(height, width);
		WorldPainter.readWorld(konwayCells, fileName);
		konwayCells.evaluateNextState();
		konwayCells.advanceState();
		
		WorldPainter.printWorld(konwayCells, "cellSnapshot.txt");
	}
}
