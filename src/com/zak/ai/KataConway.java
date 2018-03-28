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
		String inFileName = "";
		String outFileName  = "";
		
		try {
			height = Integer.parseInt(args[0]);
			width = Integer.parseInt(args[1]);
			inFileName = args[2];
			outFileName = args[3];
		} catch (NumberFormatException e) {
			return;
		}
		
		// Continue if we were able to get greater than 0 integer values for rows and columns
		if (width <= 0 || height <= 0) {
			return;
		}
		
		CellWorld konwayCells = new CellGrid(height, width);
		WorldPainter.readWorld(konwayCells, inFileName);
		konwayCells.evaluateNextState();
		konwayCells.advanceState();
		
		WorldPainter.printWorld(konwayCells, outFileName);
	}
}
