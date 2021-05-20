
/*
Max Pursche
CS110B
Square
*/

public abstract class Square {

    //fields
    private String element;
    private boolean flagged;
    private boolean uncovered;

    /**
      Base Constructor: sets element to "x"
                        sets flagged to false
                        sets uncovered to false
    */
    public Square() {
        element = "x";
        flagged = false;
        uncovered = false;
    }

    /**
      Constructor
      @param e: shadows element
      @param flag: shadows flagged
      @param uncovered: shadows uncover 
    */
    public Square(String e, boolean flag, boolean uncover) {
        this.element = e;
        this.flagged = flag;
        this.uncovered = uncover;
    }

    /**
      @return: flagged
    */
    public boolean isFlagged() {
        return flagged;
    }

    /**
      @return: uncovered
    */
    public boolean isUncovered() {
        return uncovered;
    }
    
    /**
      checks to see if the square is flagged, 
      sets element to "x" if false
      sets element to "F" if true
    */
    public void flagSquare()
    {
        if(flagged) {
          flagged = false;
          element = "x";
        }
        else {
          element = "F";
          flagged = true;
        }    
    }
    
    /**
      sets uncovered to true
    */
    public void setUncovered() {
        uncovered = true;
    }

    /**
      @param s: Shadows element
    */
    public void setElement(String s) {
        element = s; 
    }

    /**
      toString()
      @return element
    */
    @Override
    public String toString()
    {
          return element;
    }

    public abstract boolean uncover();

    public abstract boolean isMine();
}
