package life;

/**
 * Represents a cell on the Board
 * Can be either live or not.
 */
public class Cell {
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
