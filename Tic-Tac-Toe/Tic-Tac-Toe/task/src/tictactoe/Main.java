package tictactoe;

import java.util.Scanner;

public class Main {
    private static char[][] board;

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        board = initializeBoard();
        outputBoard();

        // Event loop
        boolean move = false;
        boolean finished = false;
        char piece = 'X';  // start with 'X'
        while (!finished) {
            while (!move) {
                System.out.print("Enter the coordinates: ");
                String line = scan.nextLine();
                move = nextMove(piece, line);
            }
            piece = switchPiece(piece);
            move = false;
            finished = evaluateBoard();
        }
    }

    public static char[][] initializeBoard() {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    public static void outputBoard() {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n", get(1,3), get(2,3), get(3,3));
        System.out.printf("| %c %c %c |\n", get(1,2), get(2,2), get(3,2));
        System.out.printf("| %c %c %c |\n", get(1,1), get(2,1), get(3,1));
        System.out.println("---------");
    }

    private static char get(int x, int y) {
        int len = board.length;
        return board[len - y][x - 1];
    }

    private static boolean put(char ch, int x, int y) {
        int len = board.length;
        if (get(x, y) != ' ') {
            return false;
        }
        board[len - y][x - 1] = ch;
        return true;
    }

    private static char switchPiece(char piece) {
        if (piece == 'X') {
            return 'O';
        }
        return 'X';
    }

    // true means move is legal
    private static boolean nextMove(char piece, String line) {
        // https://www.baeldung.com/java-check-string-number
        if (!line.matches("\\d\\s\\d")) {
            System.out.println("You should only use numbers!");
            return false;
        }
        String[] parts = line.split(" ");
        int i = Integer.parseInt(parts[0]);
        if (i > 3 || i < 1) {
            System.out.println("Coordinates should be from 1 to 3");
            return false;
        }
        int j = Integer.parseInt(parts[1]);
        if (j > 3 || j < 1) {
            System.out.println("Coordinates should be from 1 to 3");
            return false;
        }
        if (put(piece, i, j)) {
            outputBoard();
            return true;
        }
        System.out.println("This cell is occupied! Choose another one!");
        return false;
    }

    // true means game is done.
    public static boolean evaluateBoard() {
        boolean xWins = wins('X', board);
        boolean oWins = wins('O', board);

        if (xWins && !oWins) {
            System.out.println("X wins");
            return true;
        }
        if (oWins && !xWins) {
            System.out.println("O wins");
            return true;
        }
        if (!isPossible(board) || (xWins && oWins)) {
            System.out.println("Impossible");
            return true;
        }
        if (scratch(board)) {
            System.out.print("Draw");
            return true;
        }
        return false;
    }

    public static boolean isPossible(char[][] board) {
        int numX = 0;
        int numO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    numX++;
                } else if (board[i][j] == 'O') {
                    numO++;
                }
            }
        }
        return numX == numO + 1 || numO == numX + 1 || numX == numO;
    }

    public static boolean wins(char pc, char[][] board) {
        // rows
        if (board[0][0] == pc && board[0][1] == pc && board[0][2] == pc) return true;
        if (board[1][0] == pc && board[1][1] == pc && board[1][2] == pc) return true;
        if (board[2][0] == pc && board[2][1] == pc && board[2][2] == pc) return true;

        // columns
        if (board[0][0] == pc && board[1][0] == pc && board[2][0] == pc) return true;
        if (board[0][1] == pc && board[1][1] == pc && board[2][1] == pc) return true;
        if (board[0][2] == pc && board[1][2] == pc && board[2][2] == pc) return true;

        // diagonals
        if (board[0][0] == pc && board[1][1] == pc && board[2][2] == pc) return true;
        if (board[0][2] == pc && board[1][1] == pc && board[2][0] == pc) return true;

        return false;
    }

    public static boolean scratch(char[][] board) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_' || board[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count <= 0;  // no '_'
    }
}
