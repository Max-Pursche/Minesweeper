import java.util.Scanner;
public class Minesweeper {
  enum State { //type to keep the minesweeper game state
    PLAY, LOSE
  }
  //Level Select Constant Variables
  private final int RL1 = 8;
  private final int CL1 = 8;
  private final int BL1 = 8;
  private final int RL2 = 10;
  private final int CL2 = 12;
  private final int BL2 = 10;
  private final int RL3 = 16;
  private final int CL3 = 20;
  private final int BL3 = 50;
  
  Scanner keyboard = new Scanner(System.in);
  //fields
  private State gameSt;
  private Grid grid;

  /**
    Constructor: Takes an integer and depending on 
    the choice initializes the grid to a defined set of parameters
    @param level
  */
  public Minesweeper(int level) {
      if(level == 1)
         grid = new Grid(RL1, CL1, BL1);
      else if(level == 2)
         grid = new Grid(RL2, CL2, BL2);
      else
         grid = new Grid(RL3, CL3, BL3);
      gameSt = State.PLAY;
  }
   
  /**
    gameStart(): runs the game minesweeper     
  */
  public void gameStart() {
    String[] stri = new String[3];
    String s;
    int r;
    int c;
    String actn;
    Status sT = Status.OK;
    do { //do-while to keep the game continually running while sT == play
      System.out.println(grid);
      do {//input validation
         System.out.println("What next?\nOptions: (U)ncover r c, (F)lag r c, (Q)uit");
         s = userInput(keyboard.nextLine());
         stri = s.split("\\s+");
         actn = stri[0];
      } while(stri[0] == "badInput");
      if (actn.equals("Q")){ //if user wants to quit game
         System.out.println("Come Play Again!");
         return;
      }//must be done before integers are going to be parsed
      r = Integer.parseInt(stri[1]);
      c = Integer.parseInt(stri[2]);
      try {
         if (actn.equals("U")) {
            sT = grid.uncoverSquare(r, c);
         }
         else if (actn.equals("F")) {
            grid.flagSquare(r,c);
         }
      }
      catch (IndexOutOfBoundsException e) {
         System.out.println("Please Enter Valid Coordinates");
      }
      if (sT == Status.MINE) { //lose condition
         gameSt = State.LOSE;
         grid.exposeMines(); 
         System.out.println(grid);  
         System.out.println("Better Luck Next Time!");
      }
      else if (sT == Status.WIN) { //win condition
         gameSt = State.LOSE;
         grid.exposeMines(); 
         System.out.println("Well Played Mine Master!"); 
         System.out.println(grid);
      }
      else {gameSt = State.PLAY; stri = new String[3];} //nicer on one line and winky face ;}
    }while(gameSt == State.PLAY);
  }

  /**
    userInput(): Prompts the user for an input
    @return: a string that either fits the allowed inputs or returns "badInput"   
  */
  public String userInput(String s) {
    if (s.toUpperCase().charAt(0) == 'U' || s.toUpperCase().charAt(0) == 'F'
    ||s.toUpperCase().charAt(0) == 'Q')
    return s;
    return "badInput";
  }
}
