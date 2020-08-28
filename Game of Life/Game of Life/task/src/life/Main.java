package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        //int size = 10;
        long seed = 4;
        int generations = 10;

        Universe universe = new Universe(size);
        universe.generateRandom(seed);
        GameOfLife game = new GameOfLife(universe);
        //Controler controler = new Controler(universe, seed);
       // controler.run(generations);
        game.run(generations);
        //controler.display();
    }
}

