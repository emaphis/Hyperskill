import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);

        int sum = 0;
        int next = -1;

        while (next != 0) {
            next = scan.nextInt();
            sum += next;
            if (sum >= 1000) {
                sum -= 1000;
                break;
            }
        }

        System.out.println(sum);
    }
}