import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        boolean isX = true;
        while (true) {
            System.out.println("Player " + (isX ? "X" : "O") + "'s turn. Enter row and column (1-3):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = isX ? 'X' : 'O';
                printBoard();

                if (checkForWin()) {
                    System.out.println("Player " + (isX ? "X" : "O") + " wins!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("The game is a draw!");
                    break;
                }

                isX = !isX;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

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

    static boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }

        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

}
