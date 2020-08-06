import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int square = 1;
        int count = 1;

        while (square <= num) {
            System.out.println(square);
            count++;
            square = count * count;
        }
    }
}