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
        Controler controler = new Controler(universe, seed);
        controler.run(generations);
        controler.display();
    }
}

