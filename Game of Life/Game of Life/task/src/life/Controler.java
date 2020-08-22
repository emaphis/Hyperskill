package life;

import java.io.IOException;

public class Controler {
    private final Universe universe;

    public Controler(Universe universe, long seed) {
        this.universe = universe;

        // random board.
        universe.generateRandom(seed);
    }

    public void run(int generations) {
        for (int generation = 1; generation <= generations; generation++) {
            clearScreen();
            System.out.println("Generation #" + generation);
            System.out.println("Alive: " + universe.numAlive());
            universe.displayBoard();
            universe.advanceBoard();

            try {
                Thread.sleep(100L);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public void display() {
        universe.displayBoard();
    }

    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}
