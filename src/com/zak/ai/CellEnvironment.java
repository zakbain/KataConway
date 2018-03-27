package com.zak.ai;

/**
 * Cell environment and methods for calculating neighbors and state.
 * 
 * @author Zak Bainazarov
 *
 */
public interface CellEnvironment {
	// Set the liveness of a specific cell
	public abstract void setCellAlive(int x, int y, boolean alive);
	
	// Evaluate and store the next state
	public abstract void evaluateNextState();
	
	//  Advance to the next state
	public abstract void advanceState();
}
