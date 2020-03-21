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
	
	//main is crowded, try to clear it up
	public static void main(String args[]){
		
		boolean playing = true;
		System.out.println("Let's play Tic Tac Toe! Your move is first, you'll always be X. The computer is O. ");
		
		do {
			printGameBoard();
			boolean human = false;
			boolean comp = false;
			int tieCount = 0;
		
			while (!human && !comp){
				tieCount +=2;
				human = humanTurn();
				
				//check if human already won to skip computer's turn
				if (human){
					break;
				}
				//check if no more possible moves. exit loop
				else if(tieCount > 9){
					System.out.println("It's a tie!");
					break;
				}
				comp = compTurn();
			}
			
			System.out.println("Would you like to keep playing? Please enter yes or no.");
			String answer = scan.next();
			if (answer.toLowerCase().equals("no")){
				playing = false;
			}
			else if (answer.toLowerCase().equals("yes")){
				playing = true;
				//clearing game board to continue playing
				gameBoard[0][0] = ' ';
				gameBoard[0][2] = ' ';
				gameBoard[0][4] = ' ';
				gameBoard[2][0] = ' ';
				gameBoard[2][2] = ' ';
				gameBoard[2][4] = ' ';
				gameBoard[4][0] = ' ';
				gameBoard[4][2] = ' ';
				gameBoard[4][4] = ' ';
			}
			else{
				System.out.println("Sorry, I didn't understand what you said. Ending the game now.");
				playing = false;
			}
		}
		while (playing);
		
		System.out.println("\nThank you for playing!!! Bye!");
	}
	
	//iterator to print gameBoard
	public static void printGameBoard(){
		for (char[] element: gameBoard){
			System.out.println(element);
		}
	}
	
	//humanTurn and compTurn are almost the same. try to consolidate
	public static boolean humanTurn(){
		
		boolean valid = false;
		char piece = 'X';
		
		while (!valid){
		System.out.println("Please enter a number between 1 and 9 indicating where you would like to place your piece.");
		int move = scan2.nextInt();
		valid = numCases(move, 'X');
		}
		//check win after every game
		if (win(piece)){
			printGameBoard();
			System.out.println("\n\nYou won! Congratulations!");
			return true;
		}
		printGameBoard();
		return false;
	}
	
	public static boolean compTurn(){
		
		boolean valid = false;
		char piece = 'O';
		
		while (!valid){
		System.out.println("\nComputer's turn!");
		int move = (int) (Math.random() * 9) + 1;
		valid = numCases(move, piece);
		}
		
		if (win(piece)){
			printGameBoard();
			System.out.println("\n\nComputer wins this round! ");
			return true;
		}
		
		printGameBoard();
		return false;
	}
	
	//converts number input into piece placement
	//checks if spot is occupied
	public static boolean numCases(int num, char player){
		
		switch (num){
		case 1:
			if (gameBoard[0][0] == ' '){
				gameBoard[0][0] = player;
				return true;
			}
			else{
				System.out.println("Invalid move! Try again.");
				return false;
			}
		case 2:
			if (gameBoard[0][2] == ' '){
				gameBoard[0][2] = player;
				return true;
			}
			else{
				System.out.println("Invalid move! Try again.");
				return false;
			}
		case 3:
			if (gameBoard[0][4] == ' '){
				gameBoard[0][4] = player;
				return true;
			}
			else{
				System.out.println("Invalid move! Try again.");
				return false;
			}
		case 4:
			if (gameBoard[2][0] == ' '){
				gameBoard[2][0] = player;
				return true;
			}
			else{
				System.out.println("Invalid move! Try again.");
				return false;
			}
		case 5:
			if (gameBoard[2][2] == ' '){
				gameBoard[2][2] = player;
				return true;
			}
			else{
				System.out.println("Invalid move! Try again.");
				return false;
			}
		case 6:
			if (gameBoard[2][4] == ' '){
				gameBoard[2][4] = player;
				return true;
			}
			else{
				System.out.println("Invalid move! Try again.");
				return false;
			}
		case 7:
			if (gameBoard[4][0] == ' '){
				gameBoard[4][0] = player;
				return true;
			}
			else{
				System.out.println("Invalid move! Try again.");
				return false;
			}
		case 8:
			if (gameBoard[4][2] == ' '){
				gameBoard[4][2] = player;
				return true;
			}
			else{
				System.out.println("Invalid move! Try again.");
				return false;
			}
		case 9:
			if (gameBoard[4][4] == ' '){
				gameBoard[4][4] = player;
				return true;
			}
			else{
				System.out.println("Invalid move! Try again.");
				return false;
			}
		}
		return false;
	}//end of numCases
	
	public static boolean win(char piece){
		
		//horizontal wins
		if (gameBoard[0][0] == piece && gameBoard[0][2] == piece && gameBoard[0][4] == piece)
			return true;
		if (gameBoard[2][0] == piece && gameBoard[2][2] == piece && gameBoard[2][4] == piece)
			return true;
		if (gameBoard[4][0] == piece && gameBoard[4][2] == piece && gameBoard[4][4] == piece)
			return true;
		
		//vertical wins
		if (gameBoard[0][0] == piece && gameBoard[2][0] == piece && gameBoard[4][0] == piece)
			return true;
		if (gameBoard[0][2] == piece && gameBoard[2][2] == piece && gameBoard[4][2] == piece)
			return true;
		if (gameBoard[0][4] == piece && gameBoard[2][4] == piece && gameBoard[4][4] == piece)
			return true;
		
		//cross wins
		if (gameBoard[0][0] == piece && gameBoard[2][2] == piece && gameBoard[4][4] == piece)
			return true;
		if (gameBoard[0][4] == piece && gameBoard[2][2] == piece && gameBoard[4][0] == piece)
			return true;
		
		return false;
	}

}
