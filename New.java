import java.util.*;
import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class New {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> computerPositions = new ArrayList<Integer>();
    public static void main(String[] args){
        //GAMEBOARD
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
            {'-', '+', '-', '+', '-'}, 
            {' ', '|', ' ', '|', ' '}, 
            {'-', '+', '-', '+', '-'}, 
            {' ', '|', ' ', '|', ' '}};
        
        printGameBoard(gameBoard);

        
        while(true) { 
            Scanner scan = new Scanner(System.in);
            System.out.println("Mark your spot (1-9):");
            int playerPos = scan.nextInt();
            while(playerPositions.contains(playerPos) || computerPositions.contains(playerPos)) {
                System.out.println("Spot Filled! Try Again!");
                playerPos = scan.nextInt();
            }

            System.out.println(playerPos);
        
            placePiece(gameBoard, playerPos, "player");
            String result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int computerPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(computerPos) || computerPositions.contains(computerPos)) {
                computerPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, computerPos, "computer");
    
            printGameBoard(gameBoard);

            result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }
            
        }
       
    }
    
    public static void printGameBoard(char[][] gameBoard) {
       for(char[]row : gameBoard) {    
            for(char B : row) {
                System.out.print(B);
            }
            System.out.println(); 
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        
        char symbol = ' ';
        
        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(pos);
        } else if(user.equals("computer")){
            symbol = 'O';
            computerPositions.add(pos);
        }
        


        switch(pos) {
            case 1: gameBoard[0][0] = symbol;
                break;
            case 2: gameBoard[0][2] = symbol;
                break;
            case 3: gameBoard[0][4] = symbol;
                break;
            case 4: gameBoard[2][0] = symbol;
                break;
            case 5: gameBoard[2][2] = symbol;
                break;
            case 6: gameBoard[2][4] = symbol;
                break;
            case 7: gameBoard[4][0] = symbol;
                break;
            case 8: gameBoard[4][2] = symbol;
                break;
            case 9: gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    public static String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9); 
        List leftCol = Arrays.asList(1, 4, 7); 
        List midCol = Arrays.asList(2, 5, 8); 
        List rightCol = Arrays.asList(3, 6, 9); 
        List leftDig = Arrays.asList(1, 5, 9); 
        List rightDig = Arrays.asList(3, 5, 7); 

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(leftDig);
        winning.add(rightDig);

        for(List l : winning) {
            if(playerPositions.containsAll(l)){
                return "Congrats! You Won!!";
            }else if(computerPositions.containsAll(l)){
                return "Nice L... CPU wins.";
            } else if(playerPositions.size() + computerPositions.size() == 9){
                return "DRAW!! Better luck next time!";
            }
            
        }




        
        return "";
    }
}






