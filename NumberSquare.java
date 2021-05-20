
/*
Max Pursche
CS110B
numbersquare
*/

public class NumberSquare extends Square {
    
    //fields
    private int neigborMines;
    private int myRow;
    private int myCol;
    
    /**
      Constructor
      @param nM: shadows neigborMines
      @param mR: shadows myRow
      @param mC: shadows myCol     
    */
    public NumberSquare(int nM, int mR, int mC) {
        this.neigborMines = nM;
        this.myRow = mR;
        this.myCol = mC;
    }

    /**
      @return: neigborMines     
    */
    public int getNeighborMines() {
        return neigborMines;
    }
    
    /**
      checks the number of neighbormines, assigns element a string depending on the number
      @return: true
    */
    @Override
    public boolean uncover() {
        if (neigborMines == 0) setElement("_");
        else if (neigborMines >= 0) setElement("" + neigborMines);
        return true;
    }
    
    /**
      @return: false
    */
    @Override
    public boolean isMine() {
        return false;
    }
}
