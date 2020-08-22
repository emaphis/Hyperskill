package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        long seed = scan.nextInt();
        int iter = scan.nextInt();

        Controler controler = new Controler(size, seed);
        controler.run(iter);
        controler.display();
    }
}

class Board {
    private final int SIZE;
    private Cell[][] carray;

    Board(int size) {
        this.SIZE = size;
        this.carray = new Cell[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                this.carray[row][col] = new Cell(false);
            }
        }
    }

    public int getSize() {
        return SIZE;
    }

    public Cell getCell(int row, int col) {
        return carray[row][col];
    }

    public int countNeighbors(int row, int col) {
        int count = 0;

        // use integer math the calculate ranges
        int rowPlus = (row + 1) % SIZE;
        int rowMinus = (((row - 1) % SIZE) + SIZE) % SIZE;
        int colPlus = (col + 1) % SIZE;
        int colMinus = (((col - 1) % SIZE) + SIZE) % SIZE;

        // NW:  -1, -1
        Cell cell0 = carray[rowMinus][colMinus];
        if (cell0.isAlive()) {
            count++;
        }

        // N:   -1, 0
        Cell cell1 = carray[rowMinus][col];
        if (cell1.isAlive()) {
            count++;
        }

        // NE:  -1 +1
        Cell cell2 = carray[rowMinus][colPlus];
        if (cell2.isAlive()) {
            count++;
        }

        // W:  0, -1
        Cell cell3 = carray[row][colMinus];
        if (cell3.isAlive()) {
            count++;
        }

        // E:  0, +1
        Cell cell4 = carray[row][colPlus];
        if (cell4.isAlive()) {
            count++;
        }

        // SW:  +1, -1
        Cell cell5 = carray[rowPlus][colMinus];
        if (cell5.isAlive()) {
            count++;
        }

        // S:  +1, 0
        Cell cell6 = carray[rowPlus][col];
        if (cell6.isAlive()) {
            count++;
        }

        // SE:  +1. +1;
        Cell cell7 = carray[rowPlus][colPlus];
        if (cell7.isAlive()) {
            count++;
        }

        return count;
    }

    /**
     * need to keep old board to calculate new board
     */
    public void advanceBoard() {
        Cell[][] newArray = new Cell[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int count = countNeighbors(row, col);
                Cell cell = carray[row][col];
                Cell newCell = new Cell();
                // Live cells
                if (cell.isAlive()) {
                    if (count == 2 || count == 3) {  // Cell stays alive
                        newCell.setAlive(true);
                    } else {
                        newCell.setAlive(false);
                    }
                }
                // Dead cells
                else  {
                    if (count == 3) {  // Cell is born.
                        newCell.setAlive(true);
                    } else {
                        newCell.setAlive(false);
                    }
                }
                newArray[row][col] = newCell;
            }
        }
        this.carray = newArray.clone();
    }


    public void generateRandom(long seed) {
        Random rand = new Random(seed);
        for (Cell[] cells : carray) {
            for (Cell cell : cells) {
                cell.setAlive(rand.nextBoolean());
            }
        }
    }

    public void displayBoard() {
        for (Cell[] cells : carray) {
            for (Cell cell : cells) {
                String glyph = cell.isAlive() ? "O" : " ";
                System.out.print(glyph);
            }
            System.out.println();
        }
    }
}

class Controler {
    private final Board board;

    public Controler(int size, long seed) {
        this.board = new Board(size);

        // random board.
        board.generateRandom(seed);
    }

    public void run(int iter) {
        for (int i = 0; i < iter; i++) {
            board.advanceBoard();
        }
    }

    public void display() {
        board.displayBoard();
    }
}

/**
 * Represents a cell on the Board
 * Can be either live or not.
 */
class Cell {
    private boolean alive;

    public Cell() {
        this(false);
    }

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}

