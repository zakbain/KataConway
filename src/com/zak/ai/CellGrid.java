package com.zak.ai;

/**
 * Cell Grid model and necessary calculations.
 * 
 * @author Zak Bainazarov
 *
 */
public class CellGrid implements CellEnvironment {
	private int rows;
	private int columns;
	private Cell[][] cells;
	
	public CellGrid(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		// Initialize all cells as dead
		cells = new Cell[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new Cell(false);
			}
		}
	}
	
	// Set the liveness of a specific cell
	public void setCellAlive(int x, int y, boolean alive) {
		if (x < rows && y < columns) {
			this.cells[x][y] = new Cell(alive);
		}
	}
	
	@Override
	public void evaluateNextState() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				countNeighbors(i, j);
			}
		}
	}
	
	@Override
	public void advanceState() {
		
	}
	
	// Evaluate the number of neighbors for each cell
	private void countNeighbors(int x, int y) {
		int liveNeighbors = 0;
		
		// Loop through neighboring cells and check liveliness
		for (int i = x - 1; i <= x + 1; i++) {
			// Check that we're within bounds
			if (i >= 0 && i < columns) {
				for (int j = y - 1; j <= y + 1; j++) {
					if (j >= 0 && j < rows) {
						if (cells[i][j].isAlive()) {
							liveNeighbors++;
						}
					}
				}
			}
		}
		
		cells[x][y].setLiveNeighbors(liveNeighbors);
	}
}
