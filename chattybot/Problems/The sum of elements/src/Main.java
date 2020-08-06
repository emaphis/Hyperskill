import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int next = -1;
        while ((next = scan.nextInt()) != 0) {
            sum += next;
        }
        System.out.println(sum);
    }
}