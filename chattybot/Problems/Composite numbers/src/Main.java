import java.util.Scanner;

public class Main {

    public static boolean isComposite(long number) {
        // write your code here
        long limit = (long) Math.sqrt(number) + 1;
        for (long i = 2; i < limit; i++) {
            if (number % i == 0L) {
                return true;
            }
        }
        return false;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long number = scanner.nextLong();
        System.out.println(isComposite(number));
    }
}