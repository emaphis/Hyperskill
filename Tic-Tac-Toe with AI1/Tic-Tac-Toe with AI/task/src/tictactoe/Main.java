package tictactoe;

import java.util.Scanner;
import java.util.Random;

import static tictactoe.Board.LEN;

/**
 * (1, 3) (2, 3) (3, 3) col -> row
 * (1, 2) (2, 2) (3, 2)
 * (1, 1) (2, 1) (3, 1)
 */
public class Main {
    private static Board board;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.print("Input command: ");
            String line = scan.nextLine();
            String[] parts = line.split(" ");

            String command = parts[0];

            if (command.equals("exit")) {
                break;
            } else if (command.equals("start") && parts.length == 3) {
                board = new Board();
                Player playerX = getPlayer(board, Piece.X, parts[1]);
                Player player2 = getPlayer(board, Piece.O, parts[2]);

                if (playerX != null && player2 != null) {
                    board.outputBoard();
                    gameLoop(playerX, player2);
                } else  {
                    System.out.println("Bad parameters!");
                }
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }

    private static void gameLoop(Player playerX, Player playerO) {
        boolean finished = false;

        // start game loop.
        while (!finished) {

            // 'X' plays.  (first)
            finished = makeMove(playerX);

            if (!finished) {
                // 'O' plays
                finished = makeMove(playerO);
            }
        }
    }

    /** Create player given a string */
    static Player getPlayer(Board board, Piece piece, String player) {
        switch (player) {
            case "easy":
                return new EasyPlayer(board, piece);
            case "medium":
                return new MediumPlayer(board, piece);
            case "user":
                return new UserPlayer(board, piece, scan);
            default:
                return null;  // Opps.
        }
    }

    static boolean makeMove(Player player) {
        player.play();
        board.outputBoard();
        return isFinished();
    }

    /** interpret board state */
    static boolean isFinished() {
        GameState state = board.evaluateBoard();

        switch (state) {
            case XWINS:
                System.out.println("X wins");
                return true;
            case OWINS:
                System.out.println("O wins");
                return true;
            case IMPOSSIBLE:
                System.out.println("Impossible");
                return true;
            case SCRATCH:
                System.out.println("Draw");
                return true;
            case NOTFINISHED:
            default:
                return false;
        }
    }
}

// Game states
enum GameState {
    XWINS, OWINS, IMPOSSIBLE, SCRATCH, NOTFINISHED
}

// Represent pieces
enum Piece {
    NONE(' '),
    X('X'),
    O('O');

    private final char piece;

    Piece(char piece) {
        this.piece = piece;
    }

    public char getPiece() {
        return piece;
    }
}

class Board {

    /**
     * Represents a board with a layout of: (col, row)
     * and a dimension of LEN * LEN == 9.
     * <p>
     * (1, 3) (2, 3) (3, 3)
     * (1, 2) (2, 2) (3, 2)
     * (1, 1) (2, 1) (3, 1)
     * <p>
     * Iterate:
     * for (int row = LEN; row > 0; row--) {
     *    for (int col = 1; col <= LEN; col++) {
     *         cell = get(col, row);
     *     }
     * }
     */
    private final Cell[][] board;
    public static final int LEN = 3;

    public Board() {
        this.board = new Cell[LEN][LEN];
        for (int row = LEN; row > 0; row--) {
            for (int col = 1; col <= LEN; col++) {
                put(new Cell(Piece.NONE), col, row);
            }
        }
    }

    public final Cell get(int col, int row) {
        return board[LEN - row][col - 1];
    }

    public final void put(Cell cell, int col, int row) {
        board[LEN - row][col - 1] = cell;
    }

    public boolean isEmpty(int col, int row) {
        return get(col, row).isEmpty();
    }

    // Easy player.
    public int countEmpty() {
        int count = 0;
        for (int row = LEN; row > 0; row--) {
            for (int col = 1; col <= LEN; col++) {
                if (isEmpty(col, row)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void outputBoard() {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n", get(1, 3).getPiece(), get(2, 3).getPiece(), get(3, 3).getPiece());
        System.out.printf("| %c %c %c |\n", get(1, 2).getPiece(), get(2, 2).getPiece(), get(3, 2).getPiece());
        System.out.printf("| %c %c %c |\n", get(1, 1).getPiece(), get(2, 1).getPiece(), get(3, 1).getPiece());
        System.out.println("---------");
    }

    public GameState evaluateBoard() {
        boolean xWins = wins(Piece.X);
        boolean oWins = wins(Piece.O);

        if (xWins && oWins) {
            return GameState.IMPOSSIBLE;
        }

        if (xWins) {
            return GameState.XWINS;
        }

        if (oWins) {
            return GameState.OWINS;
        }

        int numX = countPiece(Piece.X);
        int numO = countPiece(Piece.O);

        if (!(numX == numO + 1 || numO == numX + 1 || numX == numO)) {
            return GameState.IMPOSSIBLE;
        }

        if (numX + numO == LEN * LEN) {
            return GameState.SCRATCH;
        }

        return GameState.NOTFINISHED;
    }

    /** count pieces in a line
     A line is a row, column or diagonal  */
    public int countLine(Piece piece, Cell cell1, Cell cell2, Cell cell3) {
        int count = 0;
        if (cell1.isPiece(piece)) {
            count++;
        }
        if (cell2.isPiece(piece)) {
            count++;
        }
        if (cell3.isPiece(piece)) {
            count++;
        }
        return count;
    }

    public boolean wins(Piece piece) {
        // rows
        if (countLine(piece, get(1, 3), get(2, 3), get(3, 3)) == 3) { return true; }
        if (countLine(piece, get(1, 2), get(2, 2), get(3, 2)) == 3) { return true; }
        if (countLine(piece, get(1, 1), get(2, 1), get(3, 1)) == 3) { return true; }

        // columns
        if (countLine(piece, get(1, 3), get(1, 2), get(1, 1)) == 3) { return true; }
        if (countLine(piece, get(2, 3), get(2, 2), get(2, 1)) == 3) { return true; }
        if (countLine(piece, get(3, 3), get(3, 2), get(3, 1)) == 3) { return true; }

        // diagonals
        if (countLine(piece, get(1, 3), get(2, 2), get(3, 1)) == 3) { return true; }
        if (countLine(piece, get(1, 1), get(2, 2), get(3, 3)) == 3) { return true; }

        return false;
    }

    //// following use board's raw format

    public int countPiece(Piece piece) {
        int count = 0;
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (board[i][j].isPiece(piece)) {
                    count++;
                }
            }
        }
        return count;
    }
}


class Cell {
    private final Piece piece;
    private int score;

    public Cell(Piece piece) {
        this.piece = piece;
        this.score = 0;
    }

    public char getPiece() {
        return piece.getPiece();
    }

    public boolean isEmpty() {
        return piece == Piece.NONE;
    }

    public boolean isPiece(Piece piece) {
        return this.piece == piece;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}


/** Base class for Player types */
abstract class Player {

    protected Piece piece;
    protected Board board;

    public Player(Board board, Piece piece) {
        this.board = board;
        this.piece = piece;
    }

    public abstract void play();
}

class UserPlayer extends Player {
    Scanner scan;

    public UserPlayer(Board board, Piece piece, Scanner scan) {
        super(board, piece);
        this.scan = scan;
    }

    @Override
    public void play() {

        boolean move = false;

        while (!move) {
            System.out.println("Enter the coordinates: ");
            String line = scan.nextLine();
            move = legaUserMove(line);
        }
    }


    private boolean legaUserMove(String line) {
        if (!line.matches("\\d\\s\\d")) {
            System.out.println("You should enter numbers!");
            return false;
        }

        String[] parts = line.split(" ");

        int col = Integer.parseInt(parts[0]);
        if (col > LEN || col < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        int row = Integer.parseInt(parts[1]);
        if (row > LEN || row < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (!board.isEmpty(col, row)) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else {
            board.put(new Cell(piece), col, row);
            return true;
        }
    }
}

class EasyPlayer extends Player {
    Random rand;

    public EasyPlayer(Board board, Piece piece) {
        super(board, piece);
        rand = new Random();
    }

    @Override
    public void play() {
        int numEmpty = board.countEmpty();
        int indx = rand.nextInt(numEmpty);
        int count = 0;

        // find the empty square to play, then play
        for (int row = LEN; row > 0; row--) {
            for (int col = 1; col <= LEN; col++) {
                if (board.isEmpty(col, row)) {
                    if (count == indx) {
                        board.put(new Cell(piece), col, row);
                        return;
                    }
                    count++;
                }
            }
        }
    }
}

class MediumPlayer extends EasyPlayer {

    public MediumPlayer(Board board, Piece piece) {
        super(board, piece);
    }

    @Override
    public void play() {
        // rows
        if (board.countLine(piece, board.get(1, 3), board.get(2, 3), board.get(3, 3)) == 2) {
            placeOnEmpty(1, 3,  2, 3,  3, 3);
            return;
        }
        if (board.countLine(piece, board.get(1, 2), board.get(2, 2), board.get(3, 2)) == 2) {
            placeOnEmpty(1, 2,  2, 2,  3, 2);
            return;
        }
        if (board.countLine(piece, board.get(1, 1), board.get(2, 1), board.get(3, 1)) == 2) {
            placeOnEmpty(1, 1,  2, 1,  3, 1);
            return;
        }

        // columns
        if (board.countLine(piece, board.get(1, 3), board.get(1, 2), board.get(1, 1)) == 2) {
            placeOnEmpty(1, 3,  1, 2,  1, 1);
            return;
        }
        if (board.countLine(piece, board.get(2, 3), board.get(2, 2), board.get(2, 1)) == 2) {
            placeOnEmpty(2, 3,  2, 2,  2, 1);
            return;
        }
        if (board.countLine(piece, board.get(3, 3), board.get(3, 2), board.get(3, 1)) == 2) {
            placeOnEmpty(3, 3,  3, 2,  3, 1);
            return;
        }

        // diagonals
        if (board.countLine(piece, board.get(1, 3), board.get(2, 2), board.get(3, 1)) == 2) {
            placeOnEmpty(1, 3,  2, 2,  3, 1);
            return;
        }
        if (board.countLine(piece, board.get(1, 1), board.get(2, 2), board.get(3, 3)) == 2) {
            placeOnEmpty(1, 1,  2, 2,  3, 3);
            return;
        }

        super.play(); // Play random cell - easy mode.
    }

    private void placeOnEmpty(int col1, int row1, int col2, int row2, int col3, int row3) {
        if (board.get(col1, row1).isEmpty()) {
            board.put(new Cell(piece), col1, row1);
            return;
        }
        if (board.get(col2, row2).isEmpty()) {
            board.put(new Cell(piece), col2, row2);
            return;
        }
        if (board.get(col3, row3).isEmpty()) {
            board.put(new Cell(piece), col3, row3);
        }
    }

}
