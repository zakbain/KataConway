package com.zak.ai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Paints the world to give and take life.
 * 
 * ESSENTIALLY, handles console input output to create and display state.
 * 
 * @author Zak Bainazarov
 *
 */
public class WorldPainter {
	// Read from a file and populate the world
	public static void readWorld(CellWorld cellWorld, String fileName) {
		try {
			BufferedReader bubbleReader = new BufferedReader(new FileReader(fileName));
			
			// Read each line as a row of our cell world
			String line = bubbleReader.readLine();
			
			int rowCount = 0;
			while (line != null) {
				readRow(cellWorld, line.toLowerCase(), rowCount);
				line = bubbleReader.readLine();
				rowCount++;
			}
			
		}
		catch(Exception e) {
			System.out.println("Error reading file");
		}
	}
	
	// Print a world to a file
	public static void printWorld(CellWorld cellWorld, String fileName) {
		try {
			BufferedWriter bubbleWriter = new BufferedWriter(new FileWriter(fileName));
			
			// Loop through and print 
			for (int i = 0; i < cellWorld.getHeight(); i++) {
				StringBuilder buildRowStatus = new StringBuilder();
				for (int j = 0; j < cellWorld.getWidth(); j++) {
					if (cellWorld.isCellAlive(i, j)) {
						buildRowStatus.append("o");
					} else {
						buildRowStatus.append("x");
					}
				}
				
				bubbleWriter.write(buildRowStatus.toString());
				bubbleWriter.newLine();
			}

			bubbleWriter.flush();
		} catch (IOException e) {
			System.out.println("Error writing to file");
		}
	}
	
	private static void readRow(CellWorld cellWorld, String row, int rowCount) {
		int width = Integer.min(cellWorld.getWidth(), row.length());

		// Loop through 
		for (int i = 0; i < width; i++) {
			if (row.charAt(i) == 'o') {
				cellWorld.setCellAlive(rowCount, i, true);
			} else {
				cellWorld.setCellAlive(rowCount, i, false);
			}
		}
	}
}
