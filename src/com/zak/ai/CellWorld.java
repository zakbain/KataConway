package com.zak.ai;

/**
 * Cell world and methods for calculating neighbors and state.
 * 
 * 
 * @author Zak Bainazarov
 *
 */
public interface CellWorld {
	// Set the liveness of a specific cell
	public abstract void setCellAlive(int x, int y, boolean alive);
	
	public abstract boolean isCellAlive(int x, int y);
	
	public abstract boolean isCellAliveNext(int x, int y);
	
	// Evaluate and store the next state
	public abstract void evaluateNextState();
	
	// Advance to the next state
	public abstract boolean advanceState();
	
	// Report height
	public abstract int getHeight();
	
	// 
	public abstract void setHeight(int height);
	
	// Report width
	public abstract int getWidth();
	
	public abstract void setWidth(int width);
}
