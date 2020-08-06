import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        if (num3 <= num1 * num2 &&
                (num3 % num1 == 0 || num3 % num2 == 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
