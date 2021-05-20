/*
Max Pursche
CS110B
Minesweeper Driver
*/
import java.util.Scanner;
public class Driver {
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      Minesweeper game;
      int height;
      int width;
      int numberMines;
      int level;
      
      level = levelSelect();
      game = new Minesweeper(level);
      game.gameStart();    
   }
   
   /**
      Prompts user for a level choice
      @return integer value for level
   */
   public static int levelSelect() {
      Scanner input = new Scanner(System.in);
      int level = 0;
      String s = "";
      do {
         System.out.println("Select a level:\n1 for Easy\n2 for Intermediate\n3 for Expert");
         s = input.nextLine();
         try {
            level = Integer.parseInt(s);
            if(1 > level || 3 < level)
               System.out.println("Error: Enter a number between 1 and 3");
         }
         catch (NumberFormatException e) {
            System.out.println("Error: Invalid entry, try again");
         }
      }
      while (1 > level || 3 < level);
      return level;
   }
}
