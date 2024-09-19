import java.util.Scanner;

public class Game4_Connect4 {
    int player; // To decide which player's turn it is
    int max_col = 7; // Height of the board
    int max_row = 6; // Width of the board
    String[] tokens = {"-", "⚪", "⚫"};
    int[][] board = new int[max_col][max_row]; // There are 7 columns and 6 rows
    // Rows and Columns are inverted for the ease of calculations

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Game4_Connect4 ob = new Game4_Connect4();
        ob.startGame(sc);
    }

    void startGame(Scanner sc){
        //Main Game Loop
        int i = 0;
        displayInfo();
        while(checkGame()) {
            displayBoard();
            player = (i % 2) + 1;
            while(true) {
                System.out.println("\nPlayer " + player + ": Enter the column:");
                int col = sc.nextInt(); //Column inputted
                if(col < 0 || col > 6) {
                    System.out.println("Please enter a number between 0 and 6!");
                }
                else if(isColFull(col)) {
                    System.out.println("This column is full. Please enter another column.");
                }
                else {
                    placeToken(col, player);
                    break;
                }
            }
            i++;
        }
    }

    void displayInfo(){
        System.out.println("This is a game of Connect4");
        System.out.println("Each player will take turns placing a token into one of the 7 columns");
        System.out.println("The aim is to create a chain of 4 tokens Horizontally, Vertically, or Diagonally");
    }

    //To check if the column is full
    boolean isColFull(int col) {
        for(int row = 0; row < max_row; row++) {
            if(board[col][row] == 0) return false;
        }
        return true;
    }

    //Placing the token in the specified column
    void placeToken(int col, int player){
        for(int i = 0; i < max_row; i++){
            if(board[col][i] == 0){
                board[col][i] = player;
                break;
            }
        }
    }

    //Checking the game if any player has won or not
    boolean checkGame(){

        //Checking for win
        for(int row = 0; row < max_row; row++)
            for (int col = 0; col < max_col; col++)
            //Directions go from North in Clockwise direction
                for (int direction = 1; direction < 9; direction++)
                    if (board[col][row] != 0)
                        if (checkDirection(row, col, direction, board[col][row])) {
                            System.out.println("Player " + board[col][row] + " has won!");
                            displayBoard();
                            return false;
                        }

        int c = 0; // To count empty spots
        //Checking if the board is full
        for(int row = 0; row < max_row; row++) {
            for(int col = 0; col < max_col; col++) {
                if(board[col][row] == 0)
                    c++;
            }
        }

        //If no spots are empty
        if (c == 0) {
            System.out.println("Looks like nobody wins this round. Better luck next time");
            return false;
        }

        return true;
    }

    //Displaying the Board
    void displayBoard(){
        //Board
        for(int row = max_row - 1; row >= 0; row--){
            for(int col = 0; col < max_col; col++){
                System.out.print(tokens[board[col][row]] + "\t");
            }
            System.out.println();
        }
        //Column Numbers
        for(int j = 0; j < max_col; j++)
            System.out.print(j + "\t");
    }

    //To check each direction for a winning placement
    boolean checkDirection(int row, int col, int direction, int player) {
        //count represents the number of matching pieces
        int count = 1;
        for(int i = 1; i < 4; i++) {

            //North
            if (direction == 1 && row <= 2) {
                if (player == board[col][row + i]) {
                    count++;
                }
            }

            //North-East
            else if (direction == 2 && row <= 2 && col <= 3) {
                if (player == board[col + i][row + i]) {
                    count++;
                }
            }

            //East
            else if (direction == 3 && col <= 3) {
                if (player == board[col + i][row]) {
                    count++;
                }
            }

            //South-East
            else if (direction == 4 && row >= 3 && col <= 3) {
                if (player == board[col + i][row - i]) {
                    count++;
                }
            }

            //South
            else if (direction == 5 && row >= 3) {
                if (player == board[col][row - i]) {
                    count++;
                }
            }

            //South-West
            else if (direction == 6 && row >= 3 && col >= 3) {
                if (player == board[col - i][row - i]) {
                    count++;
                }
            }

            //West
            else if (direction == 7 && col >= 3) {
                if (player == board[col - i][row]) {
                    count++;
                }
            }

            //North-West
            else if (direction == 8 && row <= 2 && col >= 3) {
                if (player == board[col - i][row + i]) {
                    count++;
                }
            }
        }

        //If 4 pieces are present consecutively, it wil return true
        return (count == 4);
    }
}