import java.util.Scanner;

class Main {
    static int calc(int num) {
        return num / 2 + num % 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int out = calc(num1) + calc(num2) + calc(num3);

        System.out.println(out);
    }
}