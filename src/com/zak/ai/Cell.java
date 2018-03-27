package com.zak.ai;

/**
 * A single cell in the game of life.
 * 
 * @author Zak Bainazarov
 *
 */
public class Cell {
	private int liveNeighbors;
	private int totalNeighbors;
	private boolean alive;
	private boolean nextState;
}
