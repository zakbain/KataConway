package com.zak.ai;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CellGridTest {
	
	private CellWorld cellWorld;
	
	@Before
	public void init() {
		cellWorld = new CellGrid(3, 3);
	}
	
	@Test
	public void evaluateNextStateNoCells() {
		cellWorld = new  CellGrid(0, 0);
		cellWorld.evaluateNextState();
		
		// Call advanceState to ensure no exceptions
		cellWorld.advanceState();

		Assert.assertEquals("Height must be 0", 0, cellWorld.getHeight());
		Assert.assertEquals("Width must be 0", 0, cellWorld.getWidth());
	}

	@Test
	public void evaluateNextStateDeadThree() {
		cellWorld.setCellAlive(0, 0, true);
		cellWorld.setCellAlive(0, 1, true);
		cellWorld.setCellAlive(0, 2, true);
		
		cellWorld.evaluateNextState();
		Assert.assertTrue("Cell must live because surrounded by 3 live", cellWorld.isCellAliveNext(1, 1));
	}	
	
	@Test
	public void evaluateNextStateDeadNotThree() {
		cellWorld.setCellAlive(0, 0, true);
		cellWorld.setCellAlive(0, 1, true);
		cellWorld.setCellAlive(0, 2, false);
		
		cellWorld.evaluateNextState();
		Assert.assertFalse("Cell stays dead; surrounded only by 2 live", cellWorld.isCellAliveNext(1, 1));
	}	

	@Test
	public void evaluateNextStateLiveTwoOrThree() {
		cellWorld.setCellAlive(0, 0, true);
		cellWorld.setCellAlive(0, 1, true);
		cellWorld.setCellAlive(0, 2, true);
		cellWorld.setCellAlive(1, 0, true);
		cellWorld.setCellAlive(1, 2, true);
		cellWorld.setCellAlive(2, 0, true);
		
		cellWorld.evaluateNextState();
		Assert.assertTrue("Cell stays alive; surrounded by 3", cellWorld.isCellAliveNext(1, 0));
		Assert.assertTrue("Cell stays alive; surrounded by 2", cellWorld.isCellAliveNext(1, 2));
	}
	
	@Test
	public void evaluateNextStateLiveNotTwoOrThree() {
		cellWorld.setCellAlive(0, 0, true);
		cellWorld.evaluateNextState();
		Assert.assertFalse("Cell must die; surrounded by 0 live", cellWorld.isCellAliveNext(0, 0));
		
	}
	
	@Test
	public void advanceNextStateNormal() {
		cellWorld.setCellAlive(0, 0, true);
		cellWorld.setCellAlive(0, 1, true);
		cellWorld.setCellAlive(0, 2, true);
		cellWorld.setCellAlive(1, 0, true);
		cellWorld.setCellAlive(1, 2, true);
		cellWorld.setCellAlive(2, 0, true);
		
		cellWorld.evaluateNextState();
		
		int height = 3;
		boolean nextStates[][] = new boolean[height][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				nextStates[i][j] = cellWorld.isCellAliveNext(i, j);
			}
		}
			
		cellWorld.advanceState();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < height; j++) {
				Assert.assertEquals(cellWorld.isCellAlive(i, j), nextStates[i][j]);
			}
		}
	}
}
