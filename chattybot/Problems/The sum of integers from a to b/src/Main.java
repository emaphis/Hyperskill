import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        var a = scanner.nextInt();
        var b = scanner.nextInt();
        var sum = 0;

        for (int i = a; i <= b; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}