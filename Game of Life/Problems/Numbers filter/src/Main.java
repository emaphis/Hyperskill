import java.util.Scanner;

class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        // implement this method
        int num;
        while ((num = scanner.nextInt()) != 0) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
    }
}
