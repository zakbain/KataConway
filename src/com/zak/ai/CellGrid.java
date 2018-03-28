package com.zak.ai;

/**
 * Cell Grid model and necessary calculations.
 * 
 * @author Zak Bainazarov
 *
 */
public class CellGrid implements CellWorld {
	private int height;
	private int width;
	private Cell[][] cells;
	private boolean nextStateEvaluated;
	
	public CellGrid(int height, int width) {
		this.height = height;
		this.width = width;
		
		resetCells();
	}
	
	@Override
	public void setCellAlive(int x, int y, boolean alive) {
		if (x < height && y < width) {
			this.cells[x][y] = new Cell(alive);
		}
	}

	@Override
	public boolean isCellAlive(int x, int y) {
		return this.cells[x][y].isAlive();
	}
	
	@Override
	public boolean isCellAliveNext(int x, int y) {
		return this.cells[x][y].isNextAlive();
	}
	
	@Override
	public void evaluateNextState() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int liveNeighbors = countNeighbors(i, j);
				
				evaluateNextAlive(i, j, liveNeighbors);
			}
		}
	}	
	
	@Override
	public boolean advanceState() {
		if (nextStateEvaluated) {
			return false;
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				boolean nextAlive = this.isCellAliveNext(i, j);
				this.setCellAlive(i, j, nextAlive);
			}
		}
		
		return true;
	}
	
	@Override
	public void setHeight(int height) {
		this.height = height;
		this.resetCells();
	}
	
	@Override
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public void setWidth(int width) {
		this.width = width;
		this.resetCells();
	}
	
	@Override
	public int getWidth() {
		return this.width;
	}
	
	// Kill all cells
	private void resetCells() {
		cells = new Cell[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				cells[i][j] = new Cell(false);
			}
		}
		
		nextStateEvaluated = false;
	}
	
	// Evaluate the number of neighbors for each cell
	private int countNeighbors(int x, int y) {
		int liveNeighbors = 0;
		
		// Loop through neighboring cells and check liveliness
		for (int i = x - 1; i <= x + 1; i++) {
			// Check that we're within bounds
			if (i >= 0 && i < height) {
				for (int j = y - 1; j <= y + 1; j++) {
					if (j >= 0 && j < width) {
						if (cells[i][j].isAlive()) {
							liveNeighbors++;
						}
					}
				}
			}
		}
		
		if (cells[x][y].isAlive()) { 
			liveNeighbors--;
		}
		
		cells[x][y].setLiveNeighbors(liveNeighbors);
		return liveNeighbors;
	}
	
	// Evaluate if the cell at position [x, y] will be alive in the next state
	private void evaluateNextAlive(int x, int y, int liveNeighbors) {
		boolean cellAlive = this.isCellAlive(x, y);
		
		if (cellAlive) {
			if (liveNeighbors < 2 || liveNeighbors > 3) {
				this.cells[x][y].setNextAlive(false);
			} else {
				this.cells[x][y].setNextAlive(true);
			}
		} else {
			if (liveNeighbors == 3) {
				this.cells[x][y].setNextAlive(true);
			} else {
				this.cells[x][y].setNextAlive(false);
			}
		}
	}
}
