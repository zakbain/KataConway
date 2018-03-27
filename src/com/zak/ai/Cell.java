package com.zak.ai;

/**
 * A single cell in the game of life.
 * 
 * @author Zak Bainazarov
 *
 */
public class Cell {
	private int liveNeighbors;
	private boolean alive;
	private boolean nextAlive;
	
	public Cell(boolean alive) {
		this.alive = alive;
		this.nextAlive = false;
		this.liveNeighbors = 0;
	}

	// Is it awkward to ask a dead thing if it is dead?
	public boolean isAlive() {
		return this.alive;
	}
	
	// Godlike ability to give or take life
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public void setNextAlive(boolean nextAlive) {
		this.nextAlive = nextAlive;
	}

	public boolean isNextAlive() {
		return this.nextAlive;
	}
	
	// Maybe we should give them the possibility to move if too many dead neighbors
	public void setLiveNeighbors(int liveNeighbors) {
		this.liveNeighbors = liveNeighbors;
	}
	
	public int getLiveNeighbors() {
		return this.liveNeighbors;
	}
}
