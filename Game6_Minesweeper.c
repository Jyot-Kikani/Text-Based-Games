#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

// All symbols related to the cell content
// NOTE: X here is a placeholder as ASCII symbols cannot be directly assigned in the string so a separate function is created to replace X with the actual symbols
char MINE_SYMBOL[40] = "\033[1;31m   X   \033[0m"; // Red Colored Text
char FLAG_SYMBOL[40] = "\033[1;31mXXXXXXX\033[0m"; // Red Colored Text
char UNOPENED_TILE_SYMBOL[40] = "XXXXXXX";
char OPENED_TILE_SYMBOL[20] = "\t";

// All symbols relating to the borders of the board
enum SYMBOLS
{
    CELL_FILL = 177, // '▒' Symbol to use as the fill in the cells
    MINE = 254, // '■' Symbol to represent the mines
    COLUMN_SYMBOL = 179, // '│' Symbol to represent the general column borders
    ROW_SYMBOL = 196, // '─' Symbol to represent the general row borders
    TOP_LEFT = 218, // '┌' symbol for the top-left corner of the board
    TOP_MIDDLE = 194, // '┬' symbol for the top row of the board
    TOP_RIGHT = 191, // '┐' symbol for the top-right corner of the board
    MIDDLE_LEFT = 195, // '├' symbol for the left column of the board
    MIDDLE_MIDDLE = 197, // '┼' symbol for the general intersection points of the board
    MIDDLE_RIGHT = 180, // '┤' symbol for the right column of the board
    BOTTOM_LEFT = 192, // '└' symbol for the bottom-left corner of the board
    BOTTOM_MIDDLE = 193, // '┴' symbol for the bottom row of the board
    BOTTOM_RIGHT = 217 // '┘' symbol for the bottom-right corner of the board
};

enum game_status
{
    NORMAL = 0, // If the game is still running
    WIN = 1, // If all mines have been flagged
    LOSS_MINE = 2, // If a mine has been opened
    LOSS_TIME = 3, // If the time limit is reached
    LOSS_MOVES = 4 // If the move limit is reached
} status = NORMAL;

// The variables get initialised at run time based on user input
int ROWS; // Number of rows in the board
int COLS; // Number of columns in the board
int MINE_COUNT; // Number of mines on the board
int MOVE_LIMIT; // Maximum number of moves allowed
int TIME_LIMIT; // Maximum time allowed

int flag_count = 0; // Number of flags placed

typedef struct // Structure to represent each cell of the board
{
    int mine; // 0 - Mine not present, 1 - Mine present
    int flag; // 0 - Flag not present, 1 - Flag present
    int opened; // True(1), False(0)
    int nearby_mines; // Number of mines adjacent to this cell (between 0 to 8)
    char display[200]; // Symbols to print
}cell;

cell board[24][24]; // Matrix to store the board

//Prototype Declaration
void initialiseSymbols(); // To add the ASCII symbols into the strings
void initialiseBoard(); // To setup the board with the mines and numbers
void printBoard(); // To Display the current state of the board
void startGame(int); // To start the game in the regular setup
int makeMove(int, int); // To make the chosen move for the corrdinates entered (Returns 0 if coordinates are invalid, 1 if they are valid)
void openTile(int, int); // To set the given tile as open
void checkWin(); // To check whether the win condition has been met or not

//Actual Functions
int main(void)
{
    initialiseSymbols();
    printf("Welcome to Minesweeper!\n");
    printf("Choose the Difficulty Level (Greater the difficulty, larger the board):\n");
    printf("1 - Easy\n");
    printf("2 - Moderate\n");
    printf("3 - Difficult\n");
    int choice;
    scanf("%d", &choice);
    switch(choice)
    {
        case 1: // Easy Setup
            ROWS = 10;
            COLS = 10;
            MINE_COUNT = 10;
            TIME_LIMIT = 5*60;
            MOVE_LIMIT = 45;
            break;
        
        case 2: // Moderate Setup
            ROWS = 16;
            COLS = 16;
            MINE_COUNT = 35;
            TIME_LIMIT = 15*60;
            MOVE_LIMIT = 150;
            break;

        case 3: // Difficult Setup
            ROWS = 24;
            COLS = 24;
            MINE_COUNT = 65;
            TIME_LIMIT = 25*60;
            MOVE_LIMIT = 250;
            break;

        default: // Testing setup
            ROWS = 16;
            COLS = 16;
            MINE_COUNT = 35;
            TIME_LIMIT = 30;
            MOVE_LIMIT = 3;
    }

    printf("Choose the game mode:\n");
    printf("1 - Classic\n");
    printf("2 - Timed\n");  
    printf("3 - Challenge\n");
    scanf("%d", &choice);
    if(choice < 1 || choice > 3)
        printf("Invalid choice! Defaulting to Classic mode\n");
    
    initialiseBoard();
    printBoard();
    
    startGame(choice);
}

void initialiseSymbols()
{
    MINE_SYMBOL[10] = MINE;
    for(int i = 7; i < 14; i++) 
    {
        FLAG_SYMBOL[i] = CELL_FILL;
        UNOPENED_TILE_SYMBOL[i-7] = CELL_FILL;
    }
}

void initialiseBoard()
{
    // Setting up the mines
    srand(time(0));
    for(int i = 0; i < MINE_COUNT; i++)
    {
        int x = rand() % ROWS;
        int y = rand() % COLS;
        
        //Repeating if there is already a mine there
        if(board[x][y].mine == 1)
        {
            i--;
            continue;
        }

        board[x][y].mine = 1;
        strcpy(board[x][y].display, MINE_SYMBOL);
    }
    
    // Calculating the nearby mines for each cell without a mines
    for(int i = 0; i < ROWS; i++)
    {
        for(int j = 0; j < COLS; j++)
        {
            board[i][j].opened = 0;
            board[i][j].flag = 0;
            strcpy(board[i][j].display, UNOPENED_TILE_SYMBOL);
            board[i][j].nearby_mines = 0;

            // Checking nearby cells for mines
            if(board[i][j].mine == 0)
            {
                //Bottom
                if(i < ROWS - 1 && board[i+1][j].mine == 1)
                    board[i][j].nearby_mines++;
                //Top
                if(i > 0 && board[i-1][j].mine == 1)
                    board[i][j].nearby_mines++;
                //Right
                if(j < COLS - 1 && board[i][j+1].mine == 1)
                    board[i][j].nearby_mines++;
                //Left
                if(j > 0 && board[i][j-1].mine == 1)
                    board[i][j].nearby_mines++;

                //Checking Diagonally
                //Top-Left
                if(i != 0 && j != 0 && board[i-1][j-1].mine == 1)
                    board[i][j].nearby_mines++;
                //Top-Right
                if(i != 0 && j != COLS-1 && board[i-1][j+1].mine == 1)
                    board[i][j].nearby_mines++;
                //Bottom-Right
                if(i != ROWS-1 && j != COLS-1 && board[i+1][j+1].mine == 1)
                    board[i][j].nearby_mines++;
                //Bottom-Left
                if(i != ROWS-1 && j != 0 && board[i+1][j-1].mine == 1)
                    board[i][j].nearby_mines++;

                //Assigning the coloured string based on the nearby mine count
                if(board[i][j].nearby_mines == 0)
                    strcpy(board[i][j].display, "\t");
                if(board[i][j].nearby_mines == 1)
                    strcpy(board[i][j].display, "\033[1;34m   1\033[0m");
                if(board[i][j].nearby_mines == 2)
                    strcpy(board[i][j].display, "\033[1;32m   2\033[0m");
                if(board[i][j].nearby_mines >= 3)
                {
                    char str_temp1[40] ="\033[1;31m   ";
                    char str_temp2[40];
                    itoa(board[i][j].nearby_mines, str_temp2, 10);
                    strcat(str_temp2,"\033[0m");
                    strcat(str_temp1, str_temp2);
                    strcpy(board[i][j].display, str_temp1);
                }
            }
        }
    }
}

void printBoard()
{
    // Printing the column numbers
    for(int i = 0; i < COLS; i++)
        printf("\t    %d", i);
    
    printf("\n");

    for(int i = 0; i < ROWS; i++)
    {
        // Printing the first symbol in the row borders
        if(i == 0)
            printf("\t%c", TOP_LEFT);
        else
            printf("\t%c", MIDDLE_LEFT);

        // Printing the remaining Row Borders
        for(int j = 0; j < COLS; j++)
        {
            // Printing the general Row Borders
            for(int k = 0; k < 7; k++)
            {
                printf("%c", ROW_SYMBOL);
            }

            // Printing the Intersection Symbols
            if(i == 0 && j == COLS-1)
                printf("%c", TOP_RIGHT);
            else if(i == 0)
                printf("%c", TOP_MIDDLE);
            else if(j == COLS-1)
                printf("%c", MIDDLE_RIGHT);
            else
                printf("%c", MIDDLE_MIDDLE);
        }
    
        // Printing row numbers
        printf("\n    %2d\t", i);

        // Printing the first column border symbol
        printf("%c", COLUMN_SYMBOL);

        // Printing the rest of the cells along with the column borders
        for(int j = 0; j < COLS; j++)
        {
            // For opened cells with nearby mines
            if(board[i][j].mine == 0 && board[i][j].opened == 1 && board[i][j].nearby_mines != 0)
            {
                printf("%s\t%c", board[i][j].display, COLUMN_SYMBOL);
            }
            // For Unopened Cells
            else if(board[i][j].flag == 0 && board[i][j].opened == 0)
            {
                printf("%s%c", UNOPENED_TILE_SYMBOL, COLUMN_SYMBOL);
            }
            // For the rest of the cases
            else
            {
                printf("%s%c", board[i][j].display, COLUMN_SYMBOL);
            }
        }
        printf("\n");
    }

    // Printing the last row borders
    printf("\t%c", BOTTOM_LEFT);
        for(int j = 0; j < COLS; j++)
        {
            for(int k = 0; k < 7; k++)
            {
                printf("%c", ROW_SYMBOL);
            }
            if(j == COLS-1)
                printf("%c", BOTTOM_RIGHT);
            else
                printf("%c", BOTTOM_MIDDLE);
        }
    printf("\n");
}

void startGame(int mode)
{
    // Initialising the Time and Move variables
    clock_t start;
    double time_elapsed = 0;
    start = clock();
    int move_count = 0;

    // Main game loop
    while(1)
    {
        // Displaying the current data
        printf("Flags remaining: %d", MINE_COUNT - flag_count);
        printf("\nTime: %lf", time_elapsed);
        if (mode == 2) printf("\tTime Left: %lf", TIME_LIMIT - time_elapsed);
        printf("\nMoves: %d", move_count);
        if (mode == 3) printf("\tMoves Left: %d", MOVE_LIMIT - move_count);

        // Inputting the coordinates
        int i_input, j_input;
        printf("\n\nEnter the row number: ");
        scanf("%d", &i_input);
        printf("Enter the column number: ");
        scanf("%d", &j_input);

        // If Input coordinates are out of bounds
        if(i_input >= ROWS || j_input > COLS || i_input < 0 || j_input < 0)
        {
            printf("Invalid Coordinates! Try again!\n");
            continue;
        }
        
        if(makeMove(i_input, j_input) == 0) 
            continue;

        move_count++;
        time_elapsed = (clock()-start)/CLOCKS_PER_SEC;

        /*
            Criteria for the game status are as follows:
            1. Normal (0) - No mine opened, All Mines NOT flagged, Time NOT exceeded, Moves NOT finished
            2. Win (1) - All mines flaggedbefore hitting any mine. It counts as a win even if you ran out of time in that final move.
            3. Hit a Mine (2) - A mine was opened in the last move. It is checked before the time or move criterion.
            4. Time Up (3) - Time elapsed exceeds TIME_LIMIT after the latest move didn't result in a win
            5. Moves Up (4) - Move count exceeds the MOVE_LIMIT after the latest move didn't result in a WIN
        */

        // Checking if the win condition has been achieved or not
        checkWin();

        // Checking for loss conditions for the special modes
        if(status == NORMAL && mode == 2 && time_elapsed >= TIME_LIMIT) status = LOSS_TIME;
        if(status == 0 && mode == 3 && move_count >= MOVE_LIMIT) status = LOSS_MOVES;
        
        // If game has ended in any way then we need to exit the game loop
        if(status != NORMAL) 
            break;
        
        // Displaying the updated board
        printBoard();
    }

    // Opening all mines to display the end result
    for(int i = 0; i < ROWS; i++)
    {
        for(int j = 0; j < COLS; j++)
        {
            if(board[i][j].mine == 1)
            {
                board[i][j].opened = 1;
                strcpy(board[i][j].display, MINE_SYMBOL);
            }
        }
    }

    // Printing the final board
    printBoard();

    // Displaying the end message based on the game status
    if(status == WIN)
    {
        printf("\nCongratulation! You won!\n");
        printf("\nYou took %lf seconds and  %d moves to finish the game!\n", time_elapsed, move_count);
    }
    else if(status == LOSS_MINE) printf("\nYou hit a mine! Better Luck Next Time!\n");
    else if(status == LOSS_TIME) printf("\nYou ran out of time! Better Luck Next Time!\n");
    else if(status == LOSS_MOVES) printf("\nYou ran out of moves! Better Luck Next Time!\n");
}

int makeMove(int i_input, int j_input) 
{
    //Inputting Choice
    printf("Choose the next action:\n");
    printf("1 - Open a Tile\n");
    printf("2 - Place a Flag\n");
    printf("3 - Remove a Flag\n");
    int choice;
    scanf("%d", &choice);

    switch(choice)
    {
        case 1: // Opening a Tile
            // If the cell is already open or has a flag
            if(board[i_input][j_input].opened == 1 || board[i_input][j_input].flag == 1)
            {
                printf("Invalid Location! Try Again\n");
                return 0;
            }
            openTile(i_input, j_input);
            break;
        
        case 2: // Placing a Flag
            // If the cell is already open or has a flag
            if(board[i_input][j_input].opened == 1 || board[i_input][j_input].flag == 1)
            {
                printf("Invalid Flag Location! Try Again\n");
                return 0;
            }
            // If all flags have been placed
            if(flag_count == MINE_COUNT)
            {
                printf("All flags placed already! Remove a flag first!\n");
                return 0;
            }
            
            board[i_input][j_input].flag = 1;
            strcpy(board[i_input][j_input].display, FLAG_SYMBOL);
            flag_count++;
            break;
        
        case 3: // Removing a Flag
            // If there isn't any flag at that cell
            if(board[i_input][j_input].flag == 0)
            {
                printf("Invalid Flag Location! Try Again\n");
                return 0;
            }

            board[i_input][j_input].flag = 0;
            strcpy(board[i_input][j_input].display, UNOPENED_TILE_SYMBOL);
            flag_count--;
            break;

        default:
            printf("Invalid choice! Try Again\n");
            return 0;
    }
    return 1;
}

void openTile(int i, int j)
{
    // Terminating Condition for the recursion
    if(board[i][j].opened == 1)
        return;
    if(board[i][j].mine == 1)
    {
        status = LOSS_MINE;
        return;
    }

    board[i][j].opened = 1;
    
    if(board[i][j].nearby_mines == 0)
    {
        //Opening all 8 nearby tiles
        if(i != 0 && j != 0) 
            openTile(i-1, j-1); // Top-Left
        if(i != 0) 
            openTile(i-1, j); // Top
        if(i != 0 && j != COLS-1) 
            openTile(i-1, j+1); // Top-Right
        if(j != COLS-1) 
            openTile(i, j+1); // Right
        if(i != ROWS-1 && j != COLS-1) 
            openTile(i+1, j+1); // Bottom-Right
        if(i != ROWS-1) 
            openTile(i+1, j); // Bottom
        if(i != ROWS-1 && j != 0) 
            openTile(i+1, j-1); // Bottom-Left
        if(j != 0) 
            openTile(i, j-1); // Left
    }
}

void checkWin()
{
    // A win is obtained when all mines are marked with flags regardless of the blank tiles being opened or not
    for(int i = 0; i < ROWS; i++)
    {
        for(int j = 0; j < COLS; j++)
        {
            // if(board[i][j].opened == 0 && board[i][j].mine == 0)
            //     return;

            if(board[i][j].mine == 1 && board[i][j].flag == 0)
                return;
        }
    }

    status = WIN;
}