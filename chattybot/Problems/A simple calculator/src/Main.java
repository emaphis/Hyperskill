import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        long num1 = scan.nextLong();
        String op = scan.next();
        long num2 = scan.nextLong();

        switch (op) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
            case "/":
                if (num2 == 0L) {
                    System.out.println("Division by 0!");
                    break;
                }
                System.out.println(num1 / num2);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }

    }
}