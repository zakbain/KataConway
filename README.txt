KataConway
Solution by Zak  Bainazarov
==========================

How to Run 
==========================
1. Command line
	a. Navigate to the directory where you extracted the project
	b. Run the command "java -jar Kata.jar x y inFileName.txt outFileName.txt"
		where x is the height and y is the width
		
		A few examples:
			java -jar Kata.jar 6 8 test1.txt output1.txt
			java -jar Kata.jar 4 2 test2.txt output2.txt
			java -jar Kata.jar 8 12 test3.txt output3.txt
			java -jar Kata.jar 1 1 test4.txt output4.txt

2. Open the project KataConway in Eclipse
	a. File > Import
	b. Press General > Existing Projects into Workspace
	c. Navigate to the directory where you put KataConway
	d. Finish
	e. Click the dropdown next to the play or debug button
	f. Press Run Configurations
	g. If a KataConway configuration does not already exist, create one. Make sure
		the project is KataConway and the Main Class is com.zak.ai.KataConway
	h. Press arguments tab. Add the arguments x y inFileName.txt outFileName.txt
		e.g: java -jar Kata.jar 6 8 test1.txt output1.txt
	i. Press the Run (play) button
		
		
Files
==========================
KataConway.java - File with main for running a single conway state 
WorldPainter.java -  Handles reading and writing of files 
CellGrid.java - Implementation of CellWorld as a two dimensional array
CellWorld.java - Interface for holding the state of the game/world and handling 
	advancement
Cell.java - A single cell