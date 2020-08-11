package tictactoe;

import java.util.Scanner;
import java.util.Random;

/**
 * (1, 3) (2, 3) (3, 3) col -> row
 * (1, 2) (2, 2) (3, 2)
 * (1, 1) (2, 1) (3, 1)
 */
public class Main {
    private static Board board;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        board = new Board();
        board.outputBoard();

        gameLoop();
    }

    private static void gameLoop() {
        Piece piece;
        boolean move = false;
        boolean finished = false;

        // start game loop.
        while (!finished) {

            // 'X' plays.  (first)
            piece = Piece.X;
            while (!move) {  // loop until 'X' player enters a legal move.
                System.out.print("Enter the coordinates: ");
                String line = scan.nextLine();
                move = legalXMove(piece, line);
            }

            board.outputBoard();
            move = false;
            finished = isFinished();

            if (!finished) {
                // 'O' plays
                piece = Piece.O;
                board.playEasy(piece);
                board.outputBoard();
                finished = isFinished();
            }
        }
    }
/*
    static char[] getPieceNames() {
        System.out.print("Enter cells: ");
        String line = scan.nextLine();
        return line.toCharArray();
    }
*/
    static boolean legalXMove(Piece piece, String line) {
        if (!line.matches("\\d\\s\\d")) {
            System.out.println("You should enter numbers!");
            return false;
        }

        String[] parts = line.split(" ");

        int col = Integer.parseInt(parts[0]);
        if (col > board.getLEN() || col < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        int row = Integer.parseInt(parts[1]);
        if (row > board.getLEN() || row < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (!board.empty(col, row)) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else  {
            board.put(piece, col, row);
            return true;
        }
    }

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
     * (1, 3) (2, 3) (3, 3)
     * (1, 2) (2, 2) (3, 2)
     * (1, 1) (2, 1) (3, 1)
     * <p>
     * Iterate:
     * for (int row = LEN; row > 0; row--) {
     * for (int col = 1; col <= LEN; col++) {
     * cell = get(col, row);
     * }
     * }
     */
    private final Piece[][] board;
    private static final int LEN = 3;
    private static final Random rand = new Random();

    private static final char[] clear = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    public Board() {
        this(clear);
    }

    public Board(final char[] pieces) {
        board = new Piece[LEN][LEN];
        int count = 0;
        for (int row = LEN; row > 0; row--) {
            for (int col = 1; col <= LEN; col++) {
                char pieceName = pieces[count];
                Piece piece = createPiece(pieceName);
                put(piece, col, row);
                count++;
            }
        }
    }

    public static int getLEN () {
        return LEN;
    }

    //** Convert char to Piece */
    public final Piece createPiece(char name) {
        switch (name) {
            case 'X':
                return Piece.X;
            case 'O':
                return Piece.O;
            case '_':
            case ' ':
            default:
                return Piece.NONE;
        }
    }

    public final Piece get(int col, int row) {
        return board[LEN - row][col - 1];
    }

    public final void put(Piece piece, int col, int row) {
        board[LEN - row][col - 1] = piece;
    }

    public boolean empty(int col, int row) {
        return get(col, row) == Piece.NONE;
    }

    // Easy player.
    public int countEmpty() {
        int count = 0;
        for (int row = LEN; row > 0; row--) {
            for (int col = 1; col <= LEN; col++) {
                if (empty(col, row)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void playEasy(Piece piece) {
        System.out.println("Making move level \"easy\"");
        int numEmpty = countEmpty();
        int indx = rand.nextInt(numEmpty);
        int count = 0;

        // find the empty square to play, then play
        for (int row = LEN; row > 0; row--) {
            for (int col = 1; col <= LEN; col++) {
                if (empty(col, row)) {
                    if (count == indx) {
                        put(piece, col, row);
                        return;
                    }
                    count++;
                }
            }
        }
    }

    public void outputBoard() {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n", get(1, 3).getPiece(), get(2, 3).getPiece(), get(3, 3).getPiece());
        System.out.printf("| %c %c %c |\n", get(1, 2).getPiece(), get(2, 2).getPiece(), get(3, 2).getPiece());
        System.out.printf("| %c %c %c |\n", get(1, 1).getPiece(), get(2, 1).getPiece(), get(3, 1).getPiece());
        System.out.println("---------");
    }

    //// following use board's raw format

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

    public boolean wins(Piece piece) {
        // rows
        if (board[0][0] == piece && board[0][1] == piece && board[0][2] == piece) {
            return true;
        }
        if (board[1][0] == piece && board[1][1] == piece && board[1][2] == piece) {
            return true;
        }
        if (board[2][0] == piece && board[2][1] == piece && board[2][2] == piece) {
            return true;
        }

        // columns
        if (board[0][0] == piece && board[1][0] == piece && board[2][0] == piece) {
            return true;
        }
        if (board[0][1] == piece && board[1][1] == piece && board[2][1] == piece) {
            return true;
        }
        if (board[0][2] == piece && board[1][2] == piece && board[2][2] == piece) {
            return true;
        }

        // diagonals
        if (board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) {
            return true;
        }
        if (board[0][2] == piece && board[1][1] == piece && board[2][0] == piece) {
            return true;
        }

        return false;
    }

    public int countPiece(Piece piece) {
        int num = 0;
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (board[i][j] == piece) {
                    num++;
                }
            }
        }
        return num;
    }
}