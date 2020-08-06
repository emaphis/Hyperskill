import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int busHeight = scan.nextInt();
        int number = scan.nextInt();
        int i = 1;
        boolean crash = false;
        for (; i <= number; i++) {
            int next = scan.nextInt();
            //System.out.print(i + ":" + next + " ");
            if (next <= busHeight) {
                crash = true;
                break;
            }
        }
        if (crash) {
            System.out.println("Will crash on bridge " + i);
        } else {
            System.out.println("Will not crash");
        }
    }
}