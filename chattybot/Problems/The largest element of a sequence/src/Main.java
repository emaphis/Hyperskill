import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scan = new Scanner(System.in);
        int max = 0;
        int next;
        while ((next = scan.nextInt()) != 0) {
            if (next > max) {
                max = next;
            }
        }
        System.out.println(max);
    }
}