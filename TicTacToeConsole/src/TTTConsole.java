import java.util.Scanner;
/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 * @author relkharboutly
 * @date 1/5/2017
 */
public class TTTConsole  {
                                                     
      public static Scanner in = new Scanner(System.in); // the input Scanner
 
   public static TicTacToe TTTboard = new TicTacToe();
   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
      
	   int currentState = TicTacToe.PLAYING;
	   String userInput;
	   System.out.println("Choose what symbol you want to be! 1 is 'X' and 0 is 'O'");
	   int userSymb = in.nextInt();
	   //game loop
	   do {
         TTTboard.printBoard();
         // Print message if game-over
         //currentState = TTTboard.checkForWinner();
         
         /**
          * get player input here and call setMove(). user should input a number between 0-8
          */
         System.out.println("Where do you want to play? Location 0 is the upper left corner, location 8 is the lower right corner");
         int moveLoc = in.nextInt();
         TTTboard.setMove(userSymb, moveLoc);
         currentState=TTTboard.checkForWinner();
         
         if(currentState==TicTacToe.PLAYING) {
         TTTboard.getComputerMove();
         currentState=TTTboard.checkForWinner();
         }
      
         
         if (currentState == ITicTacToe.CROSS_WON) {
        	 TTTboard.printBoard();
            System.out.println("'X' won! Bye!");
         } else if (currentState == ITicTacToe.NOUGHT_WON) {
        	 TTTboard.printBoard();
            System.out.println("'O' won! Bye!");
         } else if (currentState == ITicTacToe.TIE) {
        	 TTTboard.printBoard();
            System.out.println("It's a TIE! Bye!");
         }
         //user can break the loop. remove this line when you finish implementation.
         //userInput = in.next();
         
      } while ((currentState == ITicTacToe.PLAYING) /*&& (!userInput.equals("q")) */ ); // repeat if not game-over
   }
 
     
}