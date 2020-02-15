
import java.util.Random; 

public class TicTacToe implements ITicTacToe {

	// Instance variables
	private static final int ROWS = 3, COLS = 3; // number of rows and columns
	private int[][] board = new int[ROWS][COLS]; // game board in 2D array
	public int symbol; //Hold the symbol the user selected 
	Random rand = new Random(); //Random number generator for computer move
	
	
		public static final int PLAYER = 1;
		public static final int COMP = 2;
	
	/**
	 * clear board and set current player
	 */
	public TicTacToe() {

	}

	@Override
	public void clearBoard() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMove(int player, int location) {
		
		
		if(player ==1) {
			player = CROSS; 
		}
		else if(player ==2) {
			player = NOUGHT;
		}
		else
			player = EMPTY;

		switch (player) {
		case 0:
			symbol = NOUGHT;
			break;
		case 1:
			symbol = CROSS;
			break;
		default:
			symbol = EMPTY;
			break;
		}

		//If the location is inhabited the console prints a message and the user turn is skipped
		switch (location) {
		case 0:
			if(board[0][0]==EMPTY) {
				board[0][0] = symbol;
			}
			break;
		case 1:
			if(board[0][1]==EMPTY) {
			board[0][1] =symbol;
			}
			break;
		case 2:
			if(board[0][2]==EMPTY) {
			board[0][2] = symbol;
			}
			break;
		case 3:
			if(board[1][0]==EMPTY){
			board[1][0] = symbol;
			}
			break;
		case 4:
			if(board[1][1]==EMPTY) {
			board[1][1] = symbol;
			}
			break;
		case 5:
			if(board[1][2]==EMPTY) {
			board[1][2] = symbol;
			}
			break;
		case 6:
			if(board[2][0]==EMPTY) {
			board[2][0] = symbol;
			}
			break;
		case 7:
			if(board[2][1]==EMPTY) {
			board[2][1] = symbol;
			}
			break;
		case 8:
			if(board[2][2]==EMPTY){
			board[2][2] = symbol;
			}
			break;
		default:
			System.out.println("Invalid move, the location you selected has already been occupied or does not exist. Your move is skipped");
			break;
		}
	}

	@Override
	public int getComputerMove() {
//		// TODO Auto-generated method stub
		int compSymbol;	
		
		if(symbol==CROSS) {
			compSymbol=NOUGHT;
		}else 
			compSymbol= CROSS;
			
//		}		
//		//Want computer to take a random empty spot
		//int empty = 0;	
		int move_a = 3;
		int move_b = 3;	
		
//		while(empty==0) {
//			move_a = (int)(Math.random()*3);
//			move_b = (int)(Math.random()*3);
//			if(board[move_a][move_b]==EMPTY) { 
//				empty=1;	
//			}
//		}
//				board[move_a][move_b]=compSymbol
		//int currentState = 0;
		//while(currentState==TicTacToe.PLAYING)
			
		//ROW BLOCKS left to right 	
		if(board[0][0] ==symbol && board[0][1] ==symbol && board[0][2] ==EMPTY ) {
			board[0][2] = compSymbol;	
		}
		else if(board[0][2] == symbol && board[0][1] ==symbol && board[0][0] ==EMPTY ) {
			board[0][0] = compSymbol;	
		}
		//
		else if(board[1][0] == symbol && board[1][1] ==symbol && board[1][2] ==EMPTY ) {
			board[1][2] = compSymbol;	
		}
		else if(board[1][0] == symbol && board[1][1] ==symbol && board[1][0] ==EMPTY ) {
			board[1][0] = compSymbol;	
		}
		//
		else if(board[2][0] ==symbol && board[2][1] ==symbol && board[2][2] ==EMPTY ) {
			board[2][2] = compSymbol;	
		}
		else if(board[2][2] ==symbol && board[2][1] ==symbol && board[2][0] ==EMPTY ) {
			board[2][0] = compSymbol;	
		}
		//COLUMNS left to right 1
		else if(board[0][0] == symbol && board[1][0] ==symbol && board[0][0] ==EMPTY ) {
				board[2][0] = compSymbol;	
			}
		else if(board[2][0] == symbol && board[1][0] ==symbol && board[0][0] ==EMPTY ) {
			board[0][0] = compSymbol;	
		}
		//2
		else if(board[0][1] == symbol && board[1][1] ==symbol && board[2][1] ==EMPTY ) {
			board[2][1] = compSymbol;	
		}
		else if(board[2][1] == symbol && board[1][1] ==symbol && board[0][1] ==EMPTY ) {
			board[0][1] = compSymbol;	
		}
		//3
		else if(board[0][2] == symbol && board[1][2] ==symbol && board[2][2] ==EMPTY ) {
			board[2][2] = compSymbol;	
		}
		else if(board[2][2] == symbol && board[1][2] ==symbol && board[0][2] ==EMPTY ) {
			board[0][2] = compSymbol;	
		}
		
		// Diag left to right 
		else if(board[0][0] == symbol && board[1][1] ==symbol && board[2][2] ==EMPTY ) {
			board[2][2] = compSymbol;	
		}
		else if(board[2][2] == symbol && board[1][1] ==symbol && board[0][0] ==EMPTY ) {
			board[0][0] = compSymbol;	
		}
		//Right Diag right to left 
		else if(board[0][2] == symbol && board[1][1] ==symbol && board[2][0] ==EMPTY ) {
			board[2][0] = compSymbol;	
		}
		else if(board[2][0] == symbol && board[1][1] ==symbol && board[0][2] ==EMPTY ) {
			board[0][2] = compSymbol;	
		}
		else {
			move_a = (int)(Math.random()*2);
		 	move_b = (int)(Math.random()*2);
			board[move_a][move_b]=compSymbol;	
		}
			
		
		//board[0][2] = compSymbol;
		//board[1][2] = compSymbol;
		return 0;		
		
	}

	
	@Override
	public int checkForWinner() {
		// TODO Auto-generated method stub
		int winner=PLAYING;
		//0,1,2
		if(board[0][0]!=EMPTY&& board[0][0] == board[0][1] && board[0][1]==board[0][2]&& board[0][0]==board[0][2]) {
			if(board[0][0]==NOUGHT) {
				winner = NOUGHT_WON;
			}else if (board[0][0]==CROSS) {
				winner = CROSS_WON;
			}
		}
		
		//3,4,5
		if(board[1][0]!=EMPTY&&board[1][0] == board[1][1] && board[1][0]==board[1][2]&& board[1][1]==board[1][2]) {
			if(board[1][0]==NOUGHT) {
				winner = NOUGHT_WON;
			}else if (board[1][0]==CROSS) {
				winner = CROSS_WON;
			}
		}
		
		//6,7,8
		if(board[2][0]!=EMPTY&&board[2][0] == board[2][1] && board[2][0]==board[2][2]&& board[2][1]==board[2][2]) {
			if(board[2][0]==NOUGHT) {
				winner = NOUGHT_WON;
			}else if (board[2][0]==CROSS) {
				winner = CROSS_WON;
			}
		}
		
		//0,3,6
		if(board[0][0]!=EMPTY&&board[0][0] == board[1][0] && board[0][0]==board[2][0]&& board[1][0]==board[2][0]) {
			if(board[0][0]==NOUGHT) {
				winner = NOUGHT_WON;
			}else if (board[0][0]==CROSS) {
				winner = CROSS_WON;
			}
		}
		
		//1,4,7
		if(board[0][1]!=EMPTY&&board[0][1] == board[1][1] && board[0][1]==board[2][1]&& board[1][1]==board[2][1]) {
			if(board[0][1]==NOUGHT) {
				winner = NOUGHT_WON;
			}else if (board[0][1]==CROSS) {
				winner = CROSS_WON;
			}
		}
		
		//2,5,8
		if(board[0][2]!=EMPTY&&board[0][2] == board[1][2] && board[0][2]==board[2][2]&& board[1][2]==board[2][2]) {
			if(board[0][2]==NOUGHT) {
				winner = NOUGHT_WON;
			}else if (board[0][2]==CROSS) {
				winner = CROSS_WON;
			}
		}
		
		//0,4,8
		if(board[0][0]!=EMPTY&&board[0][0] == board[1][1] && board[0][0]==board[2][2]&& board[1][1]==board[2][2]) {
			if(board[0][0]==NOUGHT) {
				winner = NOUGHT_WON;
			}else if (board[0][0]==CROSS) {
				winner = CROSS_WON;
			}
		}
		
		//2,4,6
		if(board[0][2]!=EMPTY&&board[0][2] == board[1][1] && board[0][2]==board[2][0] &&board[1][1]==board[2][0]) {
			if(board[0][2]==NOUGHT) {
				winner = NOUGHT_WON;
			}else if (board[0][2]==CROSS) {
				winner = CROSS_WON;
			}
		}
		
		int full = 0;
		
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++){
				if(board[i][j]!=EMPTY) {
					full++;
				}
			}
		}
		
		if(full==9) {
			winner = TIE;
		}
		
		return winner;
	}

	/**
	 * Given
	 * Print the game board
	 */
	public void printBoard() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				printCell(board[row][col]); // print each of the cells
				if (col != COLS - 1) {
					System.out.print("|"); // print vertical partition
				}
			}
			System.out.println();
			if (row != ROWS - 1) {
				System.out.println("-----------"); // print horizontal partition
			}
		}
		System.out.println();
	}

	/**
	 * Print a cell with the specified "content"
	 * 
	 * @param content
	 *            either CROSS, NOUGHT or EMPTY
	 */
	public void printCell(int content) {
		switch (content) {
		case EMPTY:
			System.out.print("   ");
			break; 
		case NOUGHT:
			System.out.print(" O ");
			break; 
		case CROSS:
			System.out.print(" X ");
			break; 
		}
	}

}
