/*
Max Pursche
CS110B
Grid
*/

import java.util.Random;
import java.util.ArrayList;
public class Grid {
   
    //fields
    private Random randNum = new Random();
    private int randX;
    private int randY;
    private int mineInc;
    private Square[][] grid;
    private int width;
    private int height;
    private int numMines;
    private int numSquaresUncovered;
    
   
    /**
    Constructor: initializes the grid with randomly inserted minesquares
    filled with numsquares to a defined size
    @param w: shadows width
    @param h: shadows height
    @param nM: shadows numMines
    */
    public Grid(int w, int h, int nM) {
        this.numMines = nM;
        this.height = h;
        this.width = w;
        grid = new Square[width][height];
        while (mineInc != numMines) {
            randX = randNum.nextInt(width);  
            randY = randNum.nextInt(height);
            if (grid[randX][randY] == null) {
              grid[randX][randY] = new MineSquare();
              mineInc++;
            }            
        }
        for(int r = 0; r < width; r++) {
          for(int c = 0; c < height; c++) {
            if (grid[r][c] == null)
              grid[r][c] = new NumberSquare(getNeighbors(r,c), r, c);
          }
        }
    }
    
    /**
      getNeighbors(): Checks for the neighbors of the selected square in the array
      @param r: the row
      @param c: the column
    */
    public int getNeighbors(int r, int c) {
       //initiate a count variable and an array list of Squares
       int mineCount = 0;
       ArrayList<Square> neighborList = new ArrayList<Square>();
       //nested for loops to iterate through all adjacent squares
       for(int i = r-1; i <= r+1; i++)
        {
            for(int j= c-1; j <= c+1; j++)
            {
             if(!(i >= width || j >= height || i < 0 || j < 0)) //if value goes out of bounds
             {
                neighborList.add(grid[i][j]);
             }
            }
        }
        
       //enhanced for loop to check all neighbors, and increment mineCount
       for(Square neighbor : neighborList)
       {
          if(!(neighbor == null)) {
          if(neighbor.isMine())  
             mineCount++; 
         }    
       }
       return mineCount;
    }

    /**
      uncoverSquare(): uncovers squares in either a 3X3 or a 5X5
      depending on if it is a square or a mine 
      @param r: the row
      @param c: the column
      @return The status depending on if the square checked was a mine or not
    */
    public Status uncoverSquare(int r, int c){
         //if square is a mine, return Status.MINE
         if(grid[r][c].isMine())
            return Status.MINE;
         else{ //5X5
          int numNeighbors = getNeighbors(r,c);
          if(numNeighbors == 0){
             for(int i = r-2; i <= r+2; i++) {
                for(int j= c-2; j <= c+2; j++) {
                  if(!(i >= width || j >= height || i < 0 || j < 0)) {
                     if(!grid[i][j].isMine()) {
                        if(!(grid[i][j].isUncovered()))
                               numSquaresUncovered++; 
                        grid[i][j].uncover(); 
                     }
                  }
                }
             }
          }
          else if(numNeighbors == 1){ //3X3
             for(int i = r-1; i <= r+1; i++){
                for(int j= c-1; j <= c+1; j++){
                  if(!(i >= width || j >= height || i < 0 || j < 0)) {
                     if(!grid[i][j].isMine()) {
                        if(!(grid[i][j].isUncovered()))
                           numSquaresUncovered++; 
                        grid[i][j].uncover(); 
                     }
                  }
                }
             }
          }
          else{
             grid[r][c].uncover();
             numSquaresUncovered++;
          }
          if(numSquaresUncovered == ((width * height) - numMines)) //checks for win condition
             return Status.WIN;
          else
             return Status.OK; //if you dont win or hit a mine Status.OK
         }
    }
    
    /**
      exposeMines(): uncovers all minesquares on the board 
    */
    public void exposeMines() {
       for(Square[] row : grid) {
            for(Square s : row) {
             if(s.isMine())
                s.uncover();
            }
       }
       
    }

    /**
      flagSquare(): uncovers all minesquares on the board
    */
    public void flagSquare(int r, int c) {
        grid[r][c].flagSquare(); 
    }

    /**
      toString()
      @return a formatted string of a grid
    */
    @Override
    public String toString() {
      String gridString = "   ";
      for(int i = 0; i < height ; i++){
         if (i < 9)
            gridString += i + "  ";
         else
            gridString += i + " ";
      }
      for(int t = 0; t < width; t++) {
         if (t >= 10)
            gridString += "\n" + t + " ";
         else
            gridString += "\n" + t + "  ";
         for(int j = 0; j < height; j++) {
               gridString += grid[t][j].toString() + "  ";
         }
      }
      return gridString;
    }
}
