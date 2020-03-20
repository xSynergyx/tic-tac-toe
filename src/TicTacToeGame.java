import java.util.Scanner;

public class TicTacToeGame {
	
	static Scanner scan = new Scanner(System.in);
	static Scanner scan2 = new Scanner(System.in);
	//initializing the game board
	static char gameBoard[][] = {{' ', '|', ' ', '|', ' '}, 
							     {'-', '+', '-', '+', '-'},
							     {' ', '|', ' ', '|', ' '},
							     {'-', '+', '-', '+', '-'},
							     {' ', '|', ' ', '|', ' '}};
	
	public static void main(String args[]){
		printGameBoard();
		humanTurn(); //test
		compTurn(); //test
	}
	
	public static void printGameBoard(){
		for (char[] element: gameBoard){
			System.out.println(element);
		}
	}
	
	public static void humanTurn(){
		System.out.println("Please enter a number between 1 and 9 indicating where you would like to place your piece.");
		int move = scan2.nextInt();
		numCases(move, 'X');
		printGameBoard();
		
		/////////////////////////////////////////check win
	}
	
	public static void compTurn(){
		
		System.out.println("\nComputer's turn!");
		int move = (int) (Math.random() * 9) + 1;
		numCases(move, 'O');
		printGameBoard();
		
		/////////////////////////////////////////check win
	}
	
	//converts number input into placement
	public static void numCases(int num, char player){
		//ADD WHAT SHOULD HAPPEN IF SPACE IS ALREADY OCCUPIED
		switch (num){
		case 1:
			if (gameBoard[0][0] == ' ')
				gameBoard[0][0] = player;
			else
				//what happens?
			break;
		case 2:
			gameBoard[0][2] = player;
			break;
		case 3:
			gameBoard[0][4] = player;
			break;
		case 4:
			gameBoard[2][0] = player;
			break;
		case 5:
			gameBoard[2][2] = player;
			break;
		case 6:
			gameBoard[2][4] = player;
			break;
		case 7:
			gameBoard[4][0] = player;
			break;
		case 8:
			gameBoard[4][2] = player;
			break;
		case 9:
			gameBoard[4][4] = player;
			break;
		}
	}//end of numCases
	
	//8 win cases
	public static boolean win(){
		return false;
	}

}
