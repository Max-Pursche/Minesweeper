/*
Max Pursche
CS110B
minesquare
*/
public class MineSquare extends Square {
   
    /**
      uncover(): sets the square element and uncovers 
      @return true
    */    
    @Override
    public boolean uncover() {
        setElement("*");
        setUncovered();
        return true;
    }

    /**
      isMine(): sets the square element and uncovers 
      @return true
    */
    @Override
    public boolean isMine() {
        return true;
    }
}