// Max Simmer, Ohene Yeboah, and Chongwoo Chang
// imports
import java.util.Scanner; /* user input, scanners are created for each method to avoid having to pass
                          scanner through */
import java.util.Random; // random generation for AI
import java.util.*;

public class Project {
    static String board[] = new String[9];
    static String turn;
    // main method which begins our program
    public static void main(String[] args)throws ClassNotFoundException{  
        selection(); // call game selection first
    }
    // gameboard for threeInARow / tic tac toe
    public static void printBoard(){ 
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | "
						+ board[1] + " | " + board[2]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | "
						+ board[4] + " | " + board[5]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | "
						+ board[7] + " | " + board[8]
						+ " |");
		System.out.println("|---|---|---|");
	}
    public static String checkWinner(){ // method to check winner of tic tac toe
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			//For X winner
			if (line.equals("XXX")) {
				return "X";
			}
			
			// For O winner
			else if (line.equals("OOO")) {
				return "O";
			}
		}
		
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
				break;
			} else if (a == 8) {
				return "draw";
			}
		}

	// To enter the X Or O at the exact place on board.
		System.out.println(
			turn + "'s turn; enter a slot number to place "
			+ turn + " in:");
		return null;
	}
    
    // method for game threeInARow
    public static void threeInARow() {
        Scanner in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;

		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a + 1);
		}

		System.out.println("Welcome to 3x3 Tic Tac Toe.");
		printBoard();

		System.out.println(
			"X will play first. Enter a slot number to place X in:");

		while (winner == null) {
			int numInput;
			
		// Exception handling.
		// numInput will take input from user like from 1 to 9.
		// If it is not in range from 1 to 9.
		// then it will show you an error "Invalid input."
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println(
						"Invalid input; re-enter slot number:");
					continue;
				}
			}
			catch (InputMismatchException e) {
				System.out.println(
					"Invalid input; re-enter slot number:");
				continue;
			}
			
			// This game has two player x and O.
			// Here is the logic to decide the turn.
			if (board[numInput - 1].equals(
					String.valueOf(numInput))) {
				board[numInput - 1] = turn;

				if (turn.equals("X")) {
					turn = "O";
				}
				else {
					turn = "X";
				}

				printBoard();
				winner = checkWinner();
			}
			else {
				System.out.println(
					"Slot already taken; re-enter slot number:");
			}
		}
		
		// If no one win or lose from both player x and O.
		// then here is the logic to print "draw".
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println(
				"It's a draw! Thanks for playing.");
		}
		
		// For winner -to display Congratulations! message.
		else {
			System.out.println(
				"Congratulations! " + winner
				+ "'s have won! Thanks for playing.");
		}
        // initalize players X and O. X is the user, Y is the AI.
        //char X;
        //char O;
        //Chongwoos Code

        /* |-1-|-2-|-3-|
           |-4-|-5-|-6-|        
           |-7-|-8-|-9-| */ // 3x3 table using an array

        // table creation

        // user input to decide on their position (1-9)

        // ai input

        // if 3x/y in a row, win, else lose?
        
           
    }
    // method for game RPS
    public static void RPS() {
        System.out.println("The rules are simple. Paper beats rock, rock beats scissors, and scissors beats rock.");
        System.out.println("This game IS case-sensitive.");
        // scans input for Rock, Paper, or Scissors
        Scanner rpsInput = new Scanner(System.in);
        System.out.print("Please enter a weapon (Rock, Paper, or Scissors), or 'quit' to quit: "); 
        String rpsChoice = rpsInput.nextLine(); // read users weapon choice
    
        // rock = 1, paper = 2, scissors = 3
        while(!rpsChoice.equals("quit")){ // IF INPUT IS NOT QUIT DO THIS
            int userChoiceToNumber = 0;
            if (rpsChoice.equals("rock")){
                userChoiceToNumber = 1;
                               
            } else if (rpsChoice.equals("paper")){
                userChoiceToNumber = 2;
                
            } else if (rpsChoice.equals("scissors")){
                userChoiceToNumber = 3;
                
            } else { // if it is NOT a valid weapon
                
                while(userChoiceToNumber == 0){ 
                    
                    System.out.print("Incorrect Input, Please Try Again: ");              
                    rpsChoice = rpsInput.nextLine();
                    // try again
                    if (rpsChoice.equals("rock")){
                        userChoiceToNumber = 1;
                        
                    } else if (rpsChoice.equals("paper")){
                        userChoiceToNumber = 2;
                        
                    } else if (rpsChoice.equals("scissors")){
                        userChoiceToNumber = 3;
                        
                    } else if (rpsChoice.equals("quit")){ // if quit, quit the game
                        System.exit(0);
                    }
                }
            }
        
        // ai random generation
        Random cpuGenerator = new Random();
        int cpu = cpuGenerator.nextInt(3)+1; // AI choice is randomly chosen
        if (cpu == 1){
            System.out.print("\nAI Picked Rock");
        } else if (cpu == 2) {
            System.out.print("\nAI Picked Paper");
        } else if (cpu == 3){
            System.out.print("\nAI Picked Scissors");
        }
            // rock > scissors, scissors > paper, paper > rock
            
        if (userChoiceToNumber == cpu){
            System.out.println("\nDraw!");
        } else if (userChoiceToNumber == 1 && cpu == 2){ // rock v paper, paper wins
            System.out.println("\nAI Wins!");
        } else if (userChoiceToNumber == 2 && cpu == 3){ // paper vs scissors, scissor wins
            System.out.println("\nAI Wins!");
        } else if (userChoiceToNumber == 3 && cpu == 1){ // scissors vs rock, rock wins
            System.out.println("\nAI Wins!");
        } else {
            System.out.println("\nYou Win!");
        }
        // reset the AI selection
        selection(); // after the game ends, choose another game

        if(rpsChoice.equals("quit")){
                System.exit(0);
            }
            // selection();
        }     
        rpsInput.close(); 
        // selection();          
    }   

    
    // method for game Pong
    public static void Pong() {
        /* somehow figure out how to create a UI and shapes for pong.
        playerRectangle;
        userRectangle;
        pongBall;
        */

        // click detection
        // if uparrow = move up, else if downarrow = move down, else do nothing.


        // ball movement

        // AI movement

        // score
    }
    /* selction will allow the user to input their specific game type and
    depending on what they enter will determine the game they are brought to. 
    if the user enters a game not featured, it will ask for user input again. */
    public static void selection() {
        // intialize scanner for user input 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a game type: threeInARow, Pong, or RPS. Type 'quit' to quit: ");

        // initalize variable choice to read user input
        String choice = input.next();

        /* if user inputs this game, call the method for that specific game. 
        else repeat */
        if (choice.equals("threeInARow")) { // if threeInARow, call that method
            threeInARow();
        } else if (choice.equals("RPS")) {  // if Pong, call that method
            RPS();
        } else if (choice.equals("PONG")) {   // if RPS call that method
            Pong();
        } else if (choice.equals("quit")){ // if quit, then quit
            System.exit(0);
        } else { // else incorrect input, recall selection to reloop
            System.out.println("Incorrect Input, Please Try Again: ");
            selection();
        }
    
        input.close();
    }
}






