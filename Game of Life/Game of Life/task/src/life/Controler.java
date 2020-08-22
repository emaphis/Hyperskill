package life;

public class Controler {
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
