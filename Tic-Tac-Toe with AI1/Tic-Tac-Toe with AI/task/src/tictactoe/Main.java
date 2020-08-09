package tictactoe;

import java.util.Scanner;

/**
 * (1, 3) (2, 3) (3, 3) col -> row
 * (1, 2) (2, 2) (3, 2)
 * (1, 1) (2, 1) (3, 1)
 */
public class Main {
    private static Board board;
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        char[] pieces = getPieceNames();
        board = new Board(pieces);
        board.outputBoard();

        gameLoop();
    }

    private static void gameLoop() {
        boolean move = false;
        Piece piece = board.switchPiece(Piece.NONE);
        while (!move) {
            System.out.print("Enter the coordinates: ");
            String line = scan.nextLine();
            move = nextMove(piece, line);
        }
        board.switchPiece(piece);
        if (!isFinished()) {
            System.out.println("Game not finished");
        }
    }

    static char[] getPieceNames() {
        System.out.print("Enter cells: ");
        String line = scan.nextLine();
        return line.toCharArray();
    }
/*
    static void putPiece(char name, int col, int row) {
        Piece piece = board.createPiece(name);
        if (board.empty(col, row)) {
            board.put(piece, col, row);
        } else {
            board.put(Piece.ERROR, col, row);
        }
    }
*/
    static boolean nextMove(Piece piece, String line) {
        if (!line.matches("\\d\\s\\d")) {
            System.out.println("You should enter numbers!");
            return false;
        }

        String[] parts = line.split(" ");

        int col = Integer.parseInt(parts[0]);
        if (col > 3 || col < 1) {
            System.out.println("Coordinates should be from 1 to 3");
            return false;
        }

        int row = Integer.parseInt(parts[1]);
        if (row > 3 || row < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (board.empty(col, row)) {
            board.put(piece, col, row);
            board.outputBoard();
            return true;
        }

        System.out.println("This cell is occupied! Choose another one!");
        return false;
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
    public static final int LEN = 3;

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

    public Piece switchPiece(Piece piece) {
        int numX = countPiece(Piece.X);
        int numO = countPiece(Piece.O);

        if (numX + numO == 0) {
            piece = Piece.X;
        }

        if (numX > numO) {
            return Piece.O;
        } else if (numO > numX) {
            return Piece.X;
        } else {  // X == O
            if (piece == Piece.X) {
                return Piece.O;
            } else {
                return Piece.X;
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