import java.util.Scanner;

public class TicTacToe {
    // Representing the board
    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Initialize the board
        initializeBoard();
        // Display the initial board
        printBoard();
        // Variable to keep track of the current player (true for X, false for O)
        boolean isX = true;
        while (true) {
            // אhe current player for their move
            System.out.println("Player " + (isX ? "X" : "O") + "'s turn. Enter row and column (1-3):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            // Check if the move is valid
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                // Update the board with the player's move
                board[row][col] = isX ? 'X' : 'O';
                // Display the updated board
                printBoard();
                // Check for a win
                if (checkForWin()) {
                    System.out.println("Player " + (isX ? "X" : "O") + " wins!");
                    break;
                } else if (isBoardFull()) {
                    // Check for a draw
                    System.out.println("The game is a draw!");
                    break;
                }
                // Switch to the next player
                isX = !isX;
            } else {
                // Invalid move
                System.out.println("Invalid move, try again.");
            }
        }
    }
    // Initialize the board with empty spaces
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    // Display the current state of the board
    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }
    // Check if any player has won the game
    static boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            // Check rows and columns for a win
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        // Check diagonals for a win
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        // No win found
        return false;
  
