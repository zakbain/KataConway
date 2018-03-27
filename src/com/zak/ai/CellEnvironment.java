package com.zak.ai;

/**
 * Cell environment and methods for calculating neighbors and state.
 * 
 * @author Zak Bainazarov
 *
 */
public interface CellEnvironment {
	// Evaluate and store the next state
	public abstract void evaluateNextState();
	
	//  Advance to the next state
	public abstract void advanceState();
}
