import java.util.Random;
import java.util.Scanner;

public class Game5_Battleship_Game {
    int max_row = 10;
    int max_col = 10;
    int min_len = 2;
    int max_len = 5;
    String[] directions = { "North", "East", "South", "West" };
    String[] ship_names = { "Destroyer", "Cruiser", "Battleship", "Aircraft Carrier" };
    String[] ship_icons = { "\uD83D\uDEE5", "\uD83D\uDEA3", "⛴", "\uD83D\uDEF3" };
    boolean[] p_ships = new boolean[4];
    boolean[] c_ships = new boolean[4];
    Game5_Battleship_Board[][] board = new Game5_Battleship_Board[max_row][max_col]; // Array of objects of Board class
                                                                                     // for each cell
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Game5_Battleship_Game ob = new Game5_Battleship_Game();
        ob.generateBoard();
        ob.start();
    }

    public void generateBoard() {
        for (int row = 0; row < max_row; row++) {
            for (int col = 0; col < max_col; col++) {
                Game5_Battleship_Board temp_ob = new Game5_Battleship_Board();
                board[row][col] = temp_ob;
            }
        }
    }

    private void displayBoard(String type) {
        System.out.println(type);
        System.out.print("\t");
        for (int col = 0; col < max_col; col++)
            System.out.print(col + "\t");
        System.out.println();

        for (int row = 0; row < max_row; row++) {
            System.out.print(row + "\t");
            for (int col = 0; col < max_col; col++) {

                if (type.equals("player shots")) {
                    if (board[row][col].isP_hit())
                        System.out.print("\uD83D\uDC80\t");
                    else if (board[row][col].isP_miss())
                        System.out.print("X\t");
                    else
                        System.out.print("-\t");
                }

                if (type.equals("player ships")) {
                    if (board[row][col].isC_hit())
                        System.out.print("\uD83D\uDC80\t");
                    else if (board[row][col].isC_miss())
                        System.out.print("X\t");
                    else if (board[row][col].getP_ship_length() == 0)
                        System.out.print("-\t");
                    else
                        System.out.print(ship_icons[board[row][col].getP_ship_length() - 2] + "\t");
                }

                if (type.equals("comp shots")) {
                    if (board[row][col].isC_hit())
                        System.out.print("\uD83D\uDC80\t");
                    else if (board[row][col].isC_miss())
                        System.out.print("X\t");
                    else
                        System.out.print("-\t");
                }

                if (type.equals("comp ships")) {
                    if (board[row][col].isP_hit())
                        System.out.print("\uD83D\uDC80\t");
                    else if (board[row][col].isP_miss())
                        System.out.print("X\t");
                    else if (board[row][col].getC_ship_length() == 0)
                        System.out.print("-\t");
                    else
                        System.out.print(ship_icons[board[row][col].getC_ship_length() - 2] + "\t");
                }
            }
            System.out.println();
        }
    }

    private void start() {
        for (int len = min_len; len <= max_len; len++) {
            displayBoard("player ships");
            setupC_ships(len); // To generate ships of each length
            setupP_ships(len);
        }
        displayBoard("player ships");
        while (true) {
            // displayBoard("comp ships");
            displayBoard("player shots");
            playerShoot();
            compShoot();
            // displayBoard("comp shots");
            displayBoard("player ships");

            System.out.println("Enter anything to continue:");
            sc.next();

            displayScore();

            if (checkWin("player")) {
                System.out.println("You have won! Congratulations!");
                break;
            } else if (checkWin("comp")) {
                System.out.println("The computer has defeated you! Better luck next time.");
                break;
            }
        }
    }

    private void setupC_ships(int len) {
        while (true) {
            int row = rand.nextInt(max_row); // Random row coordinate
            int col = rand.nextInt(max_col); // Random col coordinate
            if (board[row][col].isC_ship())
                continue;

            int count = 0; // To count total possible directions
            int[] possible_dir = new int[4]; // To store the possible directions
            for (int dir = 0; dir < 4; dir++) {
                // This sends each direction to checkDir and adds it to the array if the
                // direction is safe
                if (checkDir(dir, len, row, col, "comp")) {
                    possible_dir[count] = dir; // Adding that direction to the array
                    count++;
                }
            }

            // If at least one direction is possible
            if (count != 0) {
                int dir = possible_dir[rand.nextInt(count)];
                int drow = get_drow(dir); // Change in row value in that direction
                int dcol = get_dcol(dir); // Change in column value in that direction
                for (int i = 0; i < len; i++) {
                    board[row + i * drow][col + i * dcol].setC_ship(len); // Place the ships
                }
                break;
            }
        }
    }

    private boolean checkDir(int dir, int len, int row, int col, String type) {
        int drow = get_drow(dir); // The value by which the row changes in that direction
        int dcol = get_dcol(dir); // The value by which the column changes in that direction

        for (int i = 1; i < len; i++) {

            // If the ship goes beyond a wall then the direction is not possible
            if ((row + i * drow > 9 || row + i * drow < 0) || (col + i * dcol > 9 || col + i * dcol < 0))
                return false;

            // If the ship goes over another ship then the direction is not possible
            else if (board[row + i * drow][col + i * dcol].isC_ship() && type.equals("comp"))
                return false;

            else if (board[row + i * drow][col + i * dcol].isP_ship() && type.equals("player"))
                return false;
        }

        return true;
    }

    private int get_dcol(int dir) {
        if (dir == 0 || dir == 2)
            return 0; // Column doesn't change in North or South
        if (dir == 1)
            return 1; // Column increases in East
        if (dir == 3)
            return -1; // Column decreases in the West

        return 0; // Default value
    }

    private int get_drow(int dir) {
        if (dir == 1 || dir == 3)
            return 0; // Row doesn't change in East or West
        if (dir == 2)
            return 1; // Row increases in South
        if (dir == 0)
            return -1; // Row decreases in North

        return 0; // Default value
    }

    private void setupP_ships(int len) {
        Outer: while (true) {
            System.out.println("Enter the row for the " + len + " tile long ship:");
            int row = sc.nextInt(); // Inputting the row
            System.out.println("Enter the column for the " + len + " tile long ship:");
            int col = sc.nextInt(); // Inputting the column

            // If there is already a ship on that spot
            if (board[row][col].isP_ship()) {
                System.out.println("This coordinate already has a ship. Please try again!");
                continue;
            }

            // Checking all the directions before letting the user choose
            int count = 0; // To count total possible directions
            int[] possible_dir = { -1, -1, -1, -1 }; // To store the possible directions
            for (int dir = 0; dir < 4; dir++) {
                // This sends each direction to checkDir and adds it to the array if the
                // direction is safe
                if (checkDir(dir, len, row, col, "player")) {
                    possible_dir[count] = dir; // Adding that direction to the array
                    count++;
                }
            }

            // If there is no possible direction from that coordinate
            if (count == 0) {
                System.out.println("The ship cannot be placed here. Please try again!");
            } else {
                while (true) {
                    System.out.println("Enter the direction:");

                    // To check if the entered direction is valid or not
                    for (int i = 0; i < count; i++)
                        System.out.println(possible_dir[i] + " - " + directions[possible_dir[i]]);
                    int dir = sc.nextInt();
                    boolean error = true;
                    for (int i = 0; i < count; i++) {
                        if (dir == possible_dir[i]) {
                            error = false;
                            break;
                        }
                    }

                    // If player enters an invalid direction
                    if (error) {
                        System.out.println(("That direction is not possible. Please enter another direction!"));
                        continue;
                    }

                    int drow = get_drow(dir); // Change in row value in that direction
                    int dcol = get_dcol(dir); // Change in column value in that direction
                    for (int i = 0; i < len; i++) {
                        board[row + i * drow][col + i * dcol].setP_ship(len); // Place the ships
                    }
                    break Outer;
                }
            }
        }
    }

    private void playerShoot() {
        while (true) {
            // Inputting the coordinates
            System.out.println("Enter the row where you want to shoot:");
            int row = sc.nextInt();
            System.out.println("Enter the column where you want to shoot:");
            int col = sc.nextInt();

            // If the coordinates have already been used
            if (board[row][col].isP_miss() || board[row][col].isP_hit()) {
                System.out.println("You've already shot here. Please enter another coordinate!");
                continue;
            }

            // If there is a ship present
            if (board[row][col].isC_ship()) {
                board[row][col].setP_hit(); // Setting Player's hit on Computer's ship
                int len = board[row][col].getC_ship_length(); // Getting the length of the ship
                System.out.println("\nYou hit the computer's " + ship_names[len - 2] + "!");

                if (checkShip(len, "player")) {
                    System.out.println("You destroyed the whole ship! Well done!");
                    c_ships[len - 2] = true;
                } else
                    System.out.println("The ship is " + len + " tiles long");
            }

            // If there is no ship present
            else {
                board[row][col].setP_miss(); // Setting Player's miss on Computer's ship
                System.out.println("\nYou missed!");
            }
            break;
        }
    }

    private void compShoot() {
        while (true) {
            int row = rand.nextInt(max_row); // Random row coordinate
            int col = rand.nextInt(max_col); // Random column coordinate

            // If the coordinates have already been used
            if (board[row][col].isC_miss() || board[row][col].isC_hit()) {
                continue;
            }

            System.out.println("\nThe Computer shot at row " + row + " and column " + col);

            // If there is a ship present
            if (board[row][col].isP_ship()) {
                board[row][col].setC_hit(); // Setting Computer's hit on Player's ship
                System.out.println("The Computer hit your " + ship_names[board[row][col].getP_ship_length() - 2] + "!");

                // If the ship has been destroyed
                if (checkShip(board[row][col].getP_ship_length(), "comp")) {
                    System.out.println("The computer destroyed your whole ship!");
                    p_ships[board[row][col].getP_ship_length() - 2] = true;
                }
            }

            // If there is no ship present
            else {
                board[row][col].setC_miss(); // Setting Computer's miss on Player's ship
                System.out.println("The Computer missed! You are safe for now...");
            }
            break;
        }
    }

    private boolean checkWin(String type) {
        int c = 0; // Counter for total hits
        for (int row = 0; row < max_row; row++) {
            for (int col = 0; col < max_col; col++) {
                // If the ship in the cell is hit
                if (type.equals("player") && board[row][col].isP_hit())
                    c++;
                if (type.endsWith("comp") && board[row][col].isC_hit())
                    c++;
            }
        }

        return (c == 14);
    }

    private boolean checkShip(int len, String type) {
        int c = 0; // Counter for total hits on the ship
        for (int row = 0; row < max_row; row++) {
            for (int col = 0; col < max_col; col++) {

                // If the ship in the cell is the same length as len and its also hit
                if (type.equals("player") && board[row][col].getC_ship_length() == len && board[row][col].isP_hit())
                    c++;
                if (type.endsWith("comp") && board[row][col].getP_ship_length() == len && board[row][col].isC_hit())
                    c++;

            }
        }

        return (c == len);
    }

    private void displayScore() {
        int p_score = 0;
        int c_score = 0;
        for (int i = 0; i < 4; i++) {
            if (p_ships[i])
                c_score++;
            if (c_ships[i])
                p_score++;
        }

        System.out.println("Player: " + p_score + "\t\t\tComputer: " + c_score);
    }
}