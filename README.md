# Minesweeper
Max Pursche/n
Object Oriented Minesweeper Project:/n
grid.java is where a lot of the game functionality occurs, uncovering, flagging, and placing mineSquare objects randomly all happen in this
while minesweeper.java is just making the game play and keeping track of wether the player loses or not,
Square.java is the abstract for MineSquare and NumberSquare,
MineSquare has two methods, the abstract ismine() that returns true, and another that sets the String element equal to "*" (the notaion I used for printing a bomb)
Numbersquare Returns itself as a string depending on what is happening on the game, 
("F" for flagged, _ if uncovered and no mines around it, or "1" "2" or "3" depending on how many bombs are nearby that square in the grid)
Still working on it, read checklist below for more faetures I want to add

The Checklist:
To run use the driver, 
Level select is going to be updated so that it can run in minesweeper.java,
Going to be making the uncover() method of grid recursive,
Making it impossible to hit a mine on the first choice,
