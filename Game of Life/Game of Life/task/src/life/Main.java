package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        long seed = scan.nextInt();
        Board board = new Board(size);

        // random board.
        board.generateRandom(seed);
        board.displayBoard();
    }
}

class Board {
    private final int size;
    private final Cell[][] board;

    Board(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = new Cell();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void generateRandom(long seed) {
        Random rand = new Random(seed);
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                cell.setAlive(rand.nextBoolean());
            }
        }
    }

    public void displayBoard() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                String glyph = cell.isAlive() ?  "O" : " ";
                System.out.print(glyph);
            }
            System.out.println();
        }
    }
}

/** Represents a cell on the Board
 * Can be either live or not.
 */
class Cell {
    private boolean alive;

    public Cell() {
        this.alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}