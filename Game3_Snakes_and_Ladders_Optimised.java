import java.util.Scanner;

/**
 * The Game3_Snakes_and_Ladders_Optimised class represents a Java implementation of the Snakes and Ladders game.
 * It allows four players to play the game on a 10x10 board containing snakes and ladders.
 * The players take turns rolling a six-sided die and move their positions accordingly.
 * The game continues until one player reaches the position 100 and wins the game.
 * 
 * This class provides methods to play the game, display the introduction and rules, get player names, play rounds, declare winners, and display the game board.
 * It also contains inner classes for the Board, BoardPosition, and Player.
 */
public class Game3_Snakes_and_Ladders_Optimised {

    public static void main(String[] args) {
        Game3_Snakes_and_Ladders_Optimised sl = new Game3_Snakes_and_Ladders_Optimised();
        sl.playGame();
    }

    public void playGame() {
        Board board = new Board();
        Scanner sc = new Scanner(System.in);

        char retry = 'y';
        do {
            displayIntroduction();
            Player[] players = getPlayers(sc);
            boolean isGameActive = true;
            while (isGameActive) {
                waitForDisplay(sc);
                displayPlayers(players);
                displayBoard(board, players);
                isGameActive = playRound(sc,
                        board, players);
            }
            retry = getPlayAgainResponse(sc);
        } while (retry == 'y');

        System.out.println();
        System.out.println("Thank you for playing.");
        sc.close();
    }

    private void displayIntroduction() {
        System.out.println("-----------------------"
                + "----------");
        System.out.println("Welcome to Java Snakes "
                + "& Ladders!");
        System.out.println("------------------------"
                + "---------\n");
        System.out.println("Rules:");
        System.out.println("--> This is similar to the "
                + "Snakes & Ladders game played by many "
                + "people.");
        System.out.println("--> This is a four-player "
                + "game.\n");
        System.out.println("--> There will be a 10x10 "
                + "board containing some snakes and "
                + "ladders.\n");
        System.out.println("--> The players will take "
                + "turns rolling one six-sided die.");
        System.out.println("--> The player will move "
                + "ahead according to the "
                + "number rolled.\n");
        System.out.println("--> If a player lands on "
                + "a ladder, he will be able to climb "
                + "it and go ahead!!");
        System.out.println("--> But if a player lands "
                + "on a snake, he will have to go back!!\n");
        System.out.println("--> The players start at 0.");
        System.out.println("--> The game continues "
                + "until one player reaches 100.\n");
    }

    private Player[] getPlayers(Scanner sc) {
        int numberOfPlayers = 4;
        Player[] players = new Player[numberOfPlayers];
        String[] markers = { "\u2460", "\u2461",
                "\u2462", "\u2463" };

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter Player ");
            System.out.print(i + 1);
            System.out.print("'s name: ");
            String name = sc.nextLine().trim();
            Player player = new Player(name, markers[i]);
            players[i] = player;
        }

        return players;
    }

    private boolean playRound(Scanner sc, Board board,
            Player[] players) {
        for (int turn = 0; turn < players.length; turn++) {
            Player player = players[turn];
            int die = getDieRoll(sc, player, turn);

            int position = player.getBoardPosition();
            position += die;

            int finalPosition = board.getCellCount();
            if (position == finalPosition) {
                declareWinner(player);
                return false;
            } else if (position > finalPosition) {
                displayOvershoot();
            } else {
                movePlayer(board, player, position);
            }
        }
        return true;
    }

    private void declareWinner(Player player) {
        System.out.println("==================");
        System.out.println(player.getName() + " Won!!");
        System.out.println("==================");
        System.out.println("It was a great game!!");
        System.out.println();
    }

    private void displayOvershoot() {
        System.out.println("You rolled more than "
                + "you require to reach 100!!");
        System.out.println("You can't move ahead!!");
    }

    private void movePlayer(Board board, Player player,
            int position) {
        BoardPosition[] squares = board.getBoard();
        BoardPosition square = squares[position - 1];
        if (square.isSnake()) {
            displayPosition(position);
            displaySnakePosition(square);
            player.setBoardPosition(
                    square.getSnakePosition());
        } else if (square.isLadder()) {
            displayPosition(position);
            displayLadderPosition(square);
            player.setBoardPosition(
                    square.getLadderPosition());
        } else {
            displayPosition(position);
            player.setBoardPosition(position);
        }
    }

    private void displaySnakePosition(BoardPosition square) {
        System.out.println("Oh no. You landed "
                + "on a snake!!!");
        System.out.print("You slip to ");
        System.out.print(square.getSnakePosition());
        System.out.println("!!");
    }

    private void displayLadderPosition(BoardPosition square) {
        System.out.println("Wow! You landed "
                + "on a ladder!!!");
        System.out.print("You climb to ");
        System.out.print(square.getLadderPosition());
        System.out.println("!!");
    }

    private void displayPosition(int position) {
        System.out.print("You landed on square ");
        System.out.print(position);
        System.out.println(".");
    }

    private int getDieRoll(Scanner sc, Player player,
            int turn) {
        System.out.println();
        System.out.print("It is ");
        System.out.print(addApostrophe(player.getName()));
        System.out.println(" turn.");
        System.out.print("Press Enter to "
                + "roll the dice:");
        sc.nextLine();

        // Generate a number between 1 & 6
        int die = (int) (Math.random() * 6 + 1);
        System.out.println("You rolled a " + die + ".");
        return die;
    }

    private char getPlayAgainResponse(Scanner sc) {
        char retry;
        System.out.println();
        System.out.println("Enter y to replay game.");
        System.out.println("Enter any other character "
                + "to exit.");
        retry = sc.nextLine().charAt(0);
        return Character.toLowerCase(retry);
    }

    private void waitForDisplay(Scanner sc) {
        System.out.println();
        System.out.print("Press Enter to display board: ");
        sc.nextLine();
    }

    private void displayPlayers(Player[] players) {
        System.out.println();
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            String marker = player.getMarker();
            String name = player.getName();
            System.out.println("Player " + marker
                    + " --> " + name);
        }
    }

    private void displayBoard(Board board,
            Player[] players) {
        int cellWidth = 16;
        int cellCount = board.getCellCount();
        int cells = (int) Math.sqrt(cellCount);
        displayDashLine(cellWidth, cells);

        for (int i = 0; i < cells; i += 2) {
            cellCount = displayCells(board, players,
                    cells, cellWidth, cellCount, -1);
            displayDashLine(cellWidth, cells);
            cellCount = displayCells(board, players,
                    cells, cellWidth, cellCount, +1);
            displayDashLine(cellWidth, cells);
        }
    }

    private void displayDashLine(int cellWidth, int cells) {
        int width = cellWidth * cells + 1;
        for (int dash = 1; dash <= width; dash++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private int displayCells(Board board, Player[] players,
            int cells, int cellWidth, int cellCount,
            int increment) {
        int temp = calculateStartingCell(cells,
                cellCount, increment);
        displayPositionNumber(board, cells, cellWidth,
                increment, temp);

        temp = calculateStartingCell(cells,
                cellCount, increment);
        displayPositionText(board, cells, cellWidth,
                increment, temp);

        temp = calculateStartingCell(cells,
                cellCount, increment);
        displayPositionPlayer(board, players, cells,
                cellWidth, increment, temp);

        return cellCount - cells;
    }

    private void displayPositionNumber(Board board,
            int cells, int cellWidth, int increment,
            int temp) {
        for (int i = 0; i < cells; i++) {
            temp += increment;
            BoardPosition boardPosition = board.getBoard()[temp];

            if (i == 0) {
                System.out.print("|");
            }

            int position = boardPosition.getPosition();
            String text = Integer.toString(position);
            String s = generateTextLine(text, cellWidth);
            System.out.print(s);
        }
        System.out.println();
    }

    private void displayPositionText(Board board,
            int cells, int cellWidth, int increment,
            int temp) {
        for (int i = 0; i < cells; i++) {
            temp += increment;
            BoardPosition boardPosition = board.getBoard()[temp];

            if (i == 0) {
                System.out.print("|");
            }

            String text = "";
            if (boardPosition.isSnake()) {
                text = boardPosition.getSnakePositionText();
            } else if (boardPosition.isLadder()) {
                text = boardPosition.getLadderPositionText();
            }
            String s = generateTextLine(text, cellWidth);
            System.out.print(s);
        }
        System.out.println();
    }

    private void displayPositionPlayer(Board board,
            Player[] players, int cells,
            int cellWidth, int increment, int temp) {
        for (int i = 0; i < cells; i++) {
            temp += increment;

            if (i == 0) {
                System.out.print("|");
            }

            String text = "";
            for (int j = 0; j < players.length; j++) {
                Player player = players[j];
                if (player.getBoardPosition() == (temp + 1)) {
                    text += player.getMarker() + "  ";
                }
            }
            text = text.trim();
            String s = generateTextLine(text, cellWidth);
            System.out.print(s);
        }
        System.out.println();
    }

    private int calculateStartingCell(int cells,
            int cellCount, int increment) {
        int temp = cellCount;
        if (increment > 0) {
            temp -= cells + 1;
        }
        return temp;
    }

    private String generateTextLine(String text, int cellWidth) {
        String output = "";

        int spaces = (cellWidth - text.length()) / 2;
        output += createBlankString(spaces);

        output += text;

        int width = cellWidth - spaces - text.length() - 1;
        output += createBlankString(width);

        output += "|";
        return output;
    }

    private String createBlankString(int width) {
        String output = "";
        for (int i = 0; i < width; i++) {
            output += " ";
        }
        return output;
    }

    private String addApostrophe(String name) {
        char last = name.charAt(name.length() - 1);
        if (last == 's') {
            return name + "'";
        } else {
            return name + "'s";
        }
    }

    class Board {

        private int cellCount;

        private BoardPosition[] board;

        public Board() {
            this.cellCount = 100;
            board = new BoardPosition[cellCount];
            generateBoard();
        }

        private void generateBoard() {
            initalizeBoard();
            setupSnakes();
            setupLadders();
        }

        private void initalizeBoard() {
            for (int i = 0; i < cellCount; i++) {
                BoardPosition boardPosition = new BoardPosition(i + 1);
                board[i] = boardPosition;
            }
        }

        private void setupSnakes() {
            int[] position = { 99, 91, 87, 51, 49, 37, 17 };
            int[] snakePosition = { 2, 75, 24, 47, 23, 29, 3 };

            for (int i = 0; i < position.length; i++) {
                BoardPosition boardPosition = board[position[i] - 1];
                boardPosition.setSnakePosition(
                        snakePosition[i]);
            }
        }

        private void setupLadders() {
            int[] position = { 82, 55, 33, 19, 16, 9, 4 };
            int[] ladderPosition = { 97, 63, 83, 80, 25, 39, 14 };

            for (int i = 0; i < position.length; i++) {
                BoardPosition boardPosition = board[position[i] - 1];
                boardPosition.setLadderPosition(
                        ladderPosition[i]);
            }
        }

        public BoardPosition[] getBoard() {
            return board;
        }

        public int getCellCount() {
            return cellCount;
        }
    }

    class BoardPosition {

        private final int position;

        private int ladderPosition;
        private int snakePosition;

        public BoardPosition(int position) {
            this.position = position;
            this.ladderPosition = 0;
            this.snakePosition = 0;
        }

        public int getLadderPosition() {
            return ladderPosition;
        }

        public String getLadderPositionText() {
            return "Climb to " + ladderPosition;
        }

        public void setLadderPosition(int ladderPosition) {
            this.ladderPosition = ladderPosition;
        }

        public int getSnakePosition() {
            return snakePosition;
        }

        public String getSnakePositionText() {
            return "Slip to " + snakePosition;
        }

        public void setSnakePosition(int snakePosition) {
            this.snakePosition = snakePosition;
        }

        public boolean isLadder() {
            return ladderPosition > 0;
        }

        public boolean isSnake() {
            return snakePosition > 0;
        }

        public int getPosition() {
            return position;
        }
    }

    class Player {

        private int boardPosition;

        private final String name;
        private final String marker;

        public Player(String name, String marker) {
            this.name = name;
            this.marker = marker;
            this.boardPosition = 0;
        }

        public int getBoardPosition() {
            return boardPosition;
        }

        public void setBoardPosition(int boardPosition) {
            this.boardPosition = boardPosition;
        }

        public String getName() {
            return name;
        }

        public String getMarker() {
            return marker;
        }
    }
}