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

